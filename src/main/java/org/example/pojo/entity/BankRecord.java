package org.example.pojo.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
    * 返回银行-流水
    */
@Data
@Accessors(chain = true)
@ToString
public class BankRecord {
    private Long id;

    /**
     * 平台对公账户
     */
    private String mutualAccount;

    /**
     * 交易日期
     */
    private String transactionDate;

    /**
     * 交易时间
     */
    private String transactionTime;

    /**
     * 交易日期时间
     */
    private Date transactionDateTime;

    /**
     * 币种
     */
    private String currency;

    /**
     * 会计流水
     */
    private String accountingFlow;

    /**
     * 借贷标记(出帐:1、入账:2)
     */
    private Integer borrowingMark;

    /**
     * 交易金额
     */
    private BigDecimal transactionAmount;

    /**
     * 对方账号
     */
    private String oppositeAccount;

    /**
     * 对方账户名
     */
    private String oppositeAccountName;

    /**
     * 对方开户行
     */
    private String oppositeBank;

    /**
     * 账户余额
     */
    private BigDecimal accountBalance;

    /**
     * 摘要
     */
    private String information;

    /**
     * 附言
     */
    private String postscript;

    /**
     * 凭证种类
     */
    private String vouchertype;

    /**
     * 企业端流水号
     */
    private String enterpriseNumber;

    /**
     * 备注1
     */
    private String note1;

    /**
     * 备注2
     */
    private String note2;

    /**
     * 备注3
     */
    private String note3;

    /**
     * 是否对账 0否 1系统自动入账  2入账异常 3人工已入账
     */
    private Integer isVerify;


    /**
     * 入账用户
     */
    private Long entryUserId;


    /**
     * 入账时间
     */
    private Date entryTime;

    /**
     * 入账原因
     */
    private String entryReason;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

}