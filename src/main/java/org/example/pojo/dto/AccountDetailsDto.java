package org.example.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author PuTongjiao
 * @Date 2022/11/16 16:00
 */
@Data
@ToString
public class AccountDetailsDto implements Serializable {
    //平台流水号（C20）
    private String serial_no;
    //账号（C35）
    private String acno;
    //货币码（C2）
    private String cur_code;
    //交易日期（C8）
    private String tr_acdt;
    //交易时间交易日期（C6）
    private String tr_time;
    //主机流水号（C20）
    private String host_serial_no;
    //交易行号(C12)
    private String tr_bankno;
    //户名(C70)
    private String acname;
    //对方账号(C35)
    private String opp_acno;
    //对方货币码(C2)
    private String opp_cur_code;
    //对方账号户名(C70)
    private String opp_acname;
    //对方账号开户行(C60)
    private String opp_bankname;
    //对方行号(C12)
    private String opp_bankno;
    //交易类别(C1)
    private String tr_type;
    //钞汇标志(C1)
    private String csh_dra_flag;
    //他行标志(C1)
    private String bank_flag;
    //同城异地标志(C1)
    private String area_flag;
    //手续费(N16.2)
    private String fee_amt;
    //交易来源(C1)
    private String tr_from;
    //发生额标志(C1)
    private String trans_flag;
    //被冲销流水号(C12)
    private String old_serial_no;
    //原交易日期(C8)
    private String old_acdt;
    //现转标志(C1)
    private String cash_flag;
    //借贷标志(C1)
    private String crdr_flag;
    //交易金额(N16.2)
    private String amt;
    //余额(N16.2)
    private String balance;
    //上笔余额(N16.2)
    private String last_bal;
    //冻结金额(N16.2)
    private String freeze_amt;
    //凭证种类(C20)
    private String cert_type;
    //凭证批次号(C20)
    private String cert_batchno;
    //凭证号码(C20)
    private String cert_no;
    //交易码(C6)
    private String tr_code;
    //柜员号(C10)
    private String user_no;
    //传票号(C20)
    private String sub_no;
    //摘要(C30)
    private String purpose;
    //附言(C60)
    private String postscript;
    //交易时间戳
    private String tr_timestamp;
    //备注字段一(C60)
    private String reserved1;
    //备注字段二(C60)
    private String reserved2;
    //交易行名(C70)
    private String tr_bankname;
    //支付金额(N16.2)
    private String payamt;
    //收入金额(N16.2)
    private String rcvamt;
}
