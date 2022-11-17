package org.example.bank;

import cn.hutool.core.util.XmlUtil;
import org.example.pojo.dto.AccountDetailsDto;
import org.example.pojo.entity.AccountDetails;
import org.example.pojo.entity.BankRecord;
import org.example.pojo.entity.BulkPay;
import org.w3c.dom.Document;

import javax.xml.xpath.XPathConstants;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author PuTongjiao
 * @Date 2022/11/16 15:51
 */
public class BankParam {

    /**
     * 将AccountDetails对象转换成Xml格式输出
     * @param details
     * @return
     */
    private static String accountDetailsToXml(AccountDetails details) {
        StringBuffer buffer = new StringBuffer("<ap>");
        buffer.append("\n\t<body>");
        buffer.append("\n\t\t<acno>" + details.getAcno() + "</acno>");
        buffer.append("\n\t\t<cur_code>" + details.getCurCode() + "</cur_code>");
        buffer.append("\n\t\t<start_date>" + new SimpleDateFormat("yyyyMMdd").format(details.getStartDate()) + "</start_date>");
        buffer.append("\n\t\t<end_date>" + new SimpleDateFormat("yyyyMMdd").format(details.getEndDate()) + "</end_date>");
        buffer.append("\n\t</body>");
        buffer.append("\n</ap>");
        return buffer.toString();
    }

    /**
     * 将BulkPay对象转换成Xml格式输出
     * @param bulkPay
     * @return
     */
    private static String bulkPayToXml(BulkPay bulkPay) {
        StringBuffer buffer = new StringBuffer("<ap>");
        buffer.append("\n\t<body>");
        buffer.append("\n\t\t<batch_no>" + bulkPay.getBatchNo() + "</batch_no>");
        buffer.append("\n\t\t<pay_acno>" + bulkPay.getPayAcno() + "</pay_acno>");
        buffer.append("\n\t\t<pay_cur_code>" + bulkPay.getPayCurCode() + "</pay_cur_code>");
        buffer.append("\n\t\t<pay_acname>" + bulkPay.getPayAcname() + "</pay_acname>");
        buffer.append("\n\t\t<amt>" + bulkPay.getAmt() + "</amt>");
        buffer.append("\n\t\t<count>" + bulkPay.getCount() + "</count>");
        buffer.append("\n\t\t<purpose>" + bulkPay.getPurpose() + "</purpose>");
        buffer.append("\n\t\t<postscript>" + bulkPay.getPostscript() + "</postscript>");
        buffer.append("\n\t\t<file_name>" + bulkPay.getFileName() + "</file_name>");
        buffer.append("\n\t</body>");
        buffer.append("\n</ap>");
        return buffer.toString();
    }

    /**
     * 将string转化为AccountDetailsDto对象输出
     * @param accountXml
     * @return
     */
    public static AccountDetailsDto stringToObj(String accountXml){
        Document document= XmlUtil.parseXml(accountXml);
        String details = (String) XmlUtil.getByXPath("//ap/body/serial_record", document, XPathConstants.STRING);
        System.out.println(details);

        //解析出serial_record中的数据
        String[] split = details.split("\\|");
        System.out.println(split);
        AccountDetailsDto accountDetailsDto = new AccountDetailsDto();
        //账户
        accountDetailsDto.setAcno(split[1]);
        //交易日期
        accountDetailsDto.setTr_acdt(split[3]);
        //交易日期时间
        accountDetailsDto.setTr_time(split[4]);
        //TODO 交易时间

        //币种（货币码）
        accountDetailsDto.setCur_code(split[2]);
        //会计流水（被冲销流水号）
        accountDetailsDto.setOld_serial_no(split[20]);
        //企业端流水号（主机流水号）
        accountDetailsDto.setHost_serial_no(split[5]);
        //交易类别
        accountDetailsDto.setTr_type(split[13]);
        //交易金额
        accountDetailsDto.setAmt(split[24]);
        //对方账号
        accountDetailsDto.setOpp_acno(split[8]);
        //对方账户名称
        accountDetailsDto.setOpp_acname(split[10]);
        //对方开户行
        accountDetailsDto.setOpp_bankname(split[11]);
        //余额
        accountDetailsDto.setBalance(split[25]);
        //摘要
        accountDetailsDto.setPurpose(split[34]);
        //附言
        accountDetailsDto.setPostscript(split[35]);
        //凭证种类
        accountDetailsDto.setCert_type(split[28]);
        //备注1
        accountDetailsDto.setReserved1(split[37]);
        //备注2
        accountDetailsDto.setReserved2(split[38]);
        return accountDetailsDto;
    }

    public BankRecord accountDetailsDtoToBankRecord(AccountDetailsDto accountDetailsDto){
        BankRecord bankRecord = new BankRecord();
        bankRecord.setMutualAccount(accountDetailsDto.getAcno());
        bankRecord.setTransactionDate(accountDetailsDto.getTr_acdt());
        bankRecord.setTransactionDateTime(new Date(accountDetailsDto.getTr_time()));
//        bankRecord.setTransactionTime();
        bankRecord.setCurrency(accountDetailsDto.getCur_code());
        bankRecord.setAccountingFlow(accountDetailsDto.getOld_serial_no());
//        bankRecord.setBorrowingMark()
        bankRecord.setTransactionAmount(BigDecimal.valueOf(Long.parseLong(accountDetailsDto.getAmt())));
        bankRecord.setOppositeAccount(accountDetailsDto.getOpp_acno());
        bankRecord.setOppositeAccountName(accountDetailsDto.getOpp_acname());
        bankRecord.setOppositeBank(accountDetailsDto.getOpp_bankname());
        bankRecord.setAccountBalance(BigDecimal.valueOf(Long.parseLong(accountDetailsDto.getBalance())));
        bankRecord.setInformation(accountDetailsDto.getPurpose());
        bankRecord.setPostscript(accountDetailsDto.getPostscript());
        bankRecord.setVouchertype(accountDetailsDto.getCert_type());
        bankRecord.setEnterpriseNumber(accountDetailsDto.getCert_type());
        bankRecord.setNote1(accountDetailsDto.getReserved1());
        bankRecord.setNote2(accountDetailsDto.getReserved2());
//        bankRecord.setNote3()
//        bankRecord.setIsVerify();
        return bankRecord;
    }

    public static void main(String[] args) {
        AccountDetails details = new AccountDetails("账号", "币种", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
        System.out.println(accountDetailsToXml(details));
        String accountXml = "<ap>\n" +
                "<body>\n" +
                "<record_num>1</record_num>\n" +
                "<field_num>12</field_num>\n" +
                "<serial_record>SERIAL_NO|ACNO|CUR_CODE|TR_ACDT|TR_TIME|HOST_SERIAL_NO|TR_BANKNO|ACNAME|OPP_ACNO|OPP_CUR_CODE|OPP_ACNAME|OPP_BANKNAME|OPP_BANKNO|TR_TYPE|CSH_DRA_FLAG|BANK_FLAG|AREA_FLAG|FEE_AMT|TR_FROM|TRANS_FLAG|OLD_SERIAL_NO|OLD_ACDT|CASH_FLAG|CRDR_FLAG|AMT|BALANCE|LAST_BAL|FREEZE_AMT|CERT_TYPE|CERT_BATCHNO|CERT_NO|TR_CODE|USER_NO|SUB_NO|PURPOSE|POSTSCRIPT|TR_TIMESTAMP|RESERVED1|RESERVED2|TR_BANKNAME|PAYAMT|RCVAMT|</serial_record>\n" +
                "<file_name></file_name>\n" +
                "</body>\n" +
                "</ap>\n";
        AccountDetailsDto accountDetailsDto = stringToObj(accountXml);

        System.out.println(accountDetailsDto);
    }

}
