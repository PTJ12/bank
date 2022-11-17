package org.example.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author PuTongjiao
 * @Date 2022/11/16 16:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetails implements Serializable {

    /**
     * 账号
     */
    private String acno;

    /**
     * 币种
     */
    private String curCode;

    /**
     * 起始时间
     */
    private Date startDate;

    /**
     * 终止时间
     */
    private Date endDate;
}
