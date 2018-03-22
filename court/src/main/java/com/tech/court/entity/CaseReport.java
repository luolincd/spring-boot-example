package com.tech.court.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 
 */
public class CaseReport implements Serializable {
    private Integer id;

    private Integer year;

    private Integer quarter;

    private Integer month;

    private Integer registerNumber;

    private Integer endNumber;

    private Integer noneEndNumber;

    private BigDecimal endRate;

    private BigDecimal judgeDays;

    private BigDecimal enforceEndRate;

    private BigDecimal limitEndRate;

    private BigDecimal agreeRate;

    private Integer enforceRegisterNumber;

    private Integer enforceEndNumber;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(Integer registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Integer getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(Integer endNumber) {
        this.endNumber = endNumber;
    }

    public Integer getNoneEndNumber() {
        return noneEndNumber;
    }

    public void setNoneEndNumber(Integer noneEndNumber) {
        this.noneEndNumber = noneEndNumber;
    }

    public BigDecimal getEndRate() {
        return endRate;
    }

    public void setEndRate(BigDecimal endRate) {
        this.endRate = endRate;
    }

    public BigDecimal getJudgeDays() {
        return judgeDays;
    }

    public void setJudgeDays(BigDecimal judgeDays) {
        this.judgeDays = judgeDays;
    }

    public BigDecimal getEnforceEndRate() {
        return enforceEndRate;
    }

    public void setEnforceEndRate(BigDecimal enforceEndRate) {
        this.enforceEndRate = enforceEndRate;
    }

    public BigDecimal getLimitEndRate() {
        return limitEndRate;
    }

    public void setLimitEndRate(BigDecimal limitEndRate) {
        this.limitEndRate = limitEndRate;
    }

    public BigDecimal getAgreeRate() {
        return agreeRate;
    }

    public void setAgreeRate(BigDecimal agreeRate) {
        this.agreeRate = agreeRate;
    }

    public Integer getEnforceRegisterNumber() {
        return enforceRegisterNumber;
    }

    public void setEnforceRegisterNumber(Integer enforceRegisterNumber) {
        this.enforceRegisterNumber = enforceRegisterNumber;
    }

    public Integer getEnforceEndNumber() {
        return enforceEndNumber;
    }

    public void setEnforceEndNumber(Integer enforceEndNumber) {
        this.enforceEndNumber = enforceEndNumber;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CaseReport other = (CaseReport) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getQuarter() == null ? other.getQuarter() == null : this.getQuarter().equals(other.getQuarter()))
            && (this.getMonth() == null ? other.getMonth() == null : this.getMonth().equals(other.getMonth()))
            && (this.getRegisterNumber() == null ? other.getRegisterNumber() == null : this.getRegisterNumber().equals(other.getRegisterNumber()))
            && (this.getEndNumber() == null ? other.getEndNumber() == null : this.getEndNumber().equals(other.getEndNumber()))
            && (this.getNoneEndNumber() == null ? other.getNoneEndNumber() == null : this.getNoneEndNumber().equals(other.getNoneEndNumber()))
            && (this.getEndRate() == null ? other.getEndRate() == null : this.getEndRate().equals(other.getEndRate()))
            && (this.getJudgeDays() == null ? other.getJudgeDays() == null : this.getJudgeDays().equals(other.getJudgeDays()))
            && (this.getEnforceEndRate() == null ? other.getEnforceEndRate() == null : this.getEnforceEndRate().equals(other.getEnforceEndRate()))
            && (this.getLimitEndRate() == null ? other.getLimitEndRate() == null : this.getLimitEndRate().equals(other.getLimitEndRate()))
            && (this.getAgreeRate() == null ? other.getAgreeRate() == null : this.getAgreeRate().equals(other.getAgreeRate()))
            && (this.getEnforceRegisterNumber() == null ? other.getEnforceRegisterNumber() == null : this.getEnforceRegisterNumber().equals(other.getEnforceRegisterNumber()))
            && (this.getEnforceEndNumber() == null ? other.getEnforceEndNumber() == null : this.getEnforceEndNumber().equals(other.getEnforceEndNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getQuarter() == null) ? 0 : getQuarter().hashCode());
        result = prime * result + ((getMonth() == null) ? 0 : getMonth().hashCode());
        result = prime * result + ((getRegisterNumber() == null) ? 0 : getRegisterNumber().hashCode());
        result = prime * result + ((getEndNumber() == null) ? 0 : getEndNumber().hashCode());
        result = prime * result + ((getNoneEndNumber() == null) ? 0 : getNoneEndNumber().hashCode());
        result = prime * result + ((getEndRate() == null) ? 0 : getEndRate().hashCode());
        result = prime * result + ((getJudgeDays() == null) ? 0 : getJudgeDays().hashCode());
        result = prime * result + ((getEnforceEndRate() == null) ? 0 : getEnforceEndRate().hashCode());
        result = prime * result + ((getLimitEndRate() == null) ? 0 : getLimitEndRate().hashCode());
        result = prime * result + ((getAgreeRate() == null) ? 0 : getAgreeRate().hashCode());
        result = prime * result + ((getEnforceRegisterNumber() == null) ? 0 : getEnforceRegisterNumber().hashCode());
        result = prime * result + ((getEnforceEndNumber() == null) ? 0 : getEnforceEndNumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", year=").append(year);
        sb.append(", quarter=").append(quarter);
        sb.append(", month=").append(month);
        sb.append(", registerNumber=").append(registerNumber);
        sb.append(", endNumber=").append(endNumber);
        sb.append(", noneEndNumber=").append(noneEndNumber);
        sb.append(", endRate=").append(endRate);
        sb.append(", judgeDays=").append(judgeDays);
        sb.append(", enforceEndRate=").append(enforceEndRate);
        sb.append(", limitEndRate=").append(limitEndRate);
        sb.append(", agreeRate=").append(agreeRate);
        sb.append(", enforceRegisterNumber=").append(enforceRegisterNumber);
        sb.append(", enforceEndNumber=").append(enforceEndNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}