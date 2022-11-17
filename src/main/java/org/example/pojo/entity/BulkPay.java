package org.example.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author PuTongjiao
 * @Date 2022/11/16 16:33
 */
@Data
public class BulkPay implements Serializable {
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 付款账号
     */
    private String payAcno;
    /**
     * 付款币种
     */
    private String payCurCode;
    /**
     * 付款户名
     */
    private String payAcname;
    /**
     * 总交易金额
     */
    private BigDecimal amt;
    /**
     * 总笔数
     */
    private Long count;
    /**
     * 用途
     */
    private String purpose;
    /**
     * 附言
     */
    private String postscript;
    /**
     * 文件名
     */
    private String fileName;
}
