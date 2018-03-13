package com.tech.court.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * @author 
 */
public class JudgeStatistics implements Serializable {
    private Integer id;

    private String name;

    private BigDecimal agreeRate;

    private BigDecimal endRate;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAgreeRate() {
        return agreeRate;
    }

    public void setAgreeRate(BigDecimal agreeRate) {
        this.agreeRate = agreeRate;
    }

    public BigDecimal getEndRate() {
        return endRate;
    }

    public void setEndRate(BigDecimal endRate) {
        this.endRate = endRate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}