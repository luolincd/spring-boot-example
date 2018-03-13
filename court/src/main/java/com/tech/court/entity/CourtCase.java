package com.tech.court.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class CourtCase implements Serializable {
    private Integer id;

    /**
     * 期限
     */
    private Integer deadline;

    private String status;

    private String type;

    /**
     * 案由
     */
    private String reason;

    /**
     * 收案日期
     */
    private Date acceptDate;

    /**
     * 立案日期
     */
    private Date registerDate;

    /**
     * 立案人
     */
    private String registerUser;

    /**
     * 承办部门
     */
    private String undertakeDepartment;

    /**
     * 承办人
     */
    private String undertakeUser;

    /**
     * 开庭日期
     */
    private Date openDate;

    /**
     * 应结案日期
     */
    private Date endDate;

    /**
     * 报结日期
     */
    private Date reportEndDate;

    /**
     * 实际结案日期
     */
    private Date actualEndDate;

    /**
     * 结案方式
     */
    private String endMethod;

    /**
     * 立案标的
     */
    private BigDecimal registerAmount;

    /**
     * 结案标的
     */
    private BigDecimal endAmount;

    /**
     * 实际到位标的
     */
    private BigDecimal actualAmount;

    /**
     * 放弃标的
     */
    private BigDecimal abandonAmount;

    /**
     * 案件名称
     */
    private String name;

    /**
     * 案件涉及
     */
    private String caseInvolved;

    /**
     * 审判长
     */
    private String chiefJudge;

    /**
     * 案件程序
     */
    private String program;

    /**
     * 审理天数
     */
    private Integer judgeDays;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(String registerUser) {
        this.registerUser = registerUser;
    }

    public String getUndertakeDepartment() {
        return undertakeDepartment;
    }

    public void setUndertakeDepartment(String undertakeDepartment) {
        this.undertakeDepartment = undertakeDepartment;
    }

    public String getUndertakeUser() {
        return undertakeUser;
    }

    public void setUndertakeUser(String undertakeUser) {
        this.undertakeUser = undertakeUser;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getReportEndDate() {
        return reportEndDate;
    }

    public void setReportEndDate(Date reportEndDate) {
        this.reportEndDate = reportEndDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public String getEndMethod() {
        return endMethod;
    }

    public void setEndMethod(String endMethod) {
        this.endMethod = endMethod;
    }

    public BigDecimal getRegisterAmount() {
        return registerAmount;
    }

    public void setRegisterAmount(BigDecimal registerAmount) {
        this.registerAmount = registerAmount;
    }

    public BigDecimal getEndAmount() {
        return endAmount;
    }

    public void setEndAmount(BigDecimal endAmount) {
        this.endAmount = endAmount;
    }

    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    public BigDecimal getAbandonAmount() {
        return abandonAmount;
    }

    public void setAbandonAmount(BigDecimal abandonAmount) {
        this.abandonAmount = abandonAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaseInvolved() {
        return caseInvolved;
    }

    public void setCaseInvolved(String caseInvolved) {
        this.caseInvolved = caseInvolved;
    }

    public String getChiefJudge() {
        return chiefJudge;
    }

    public void setChiefJudge(String chiefJudge) {
        this.chiefJudge = chiefJudge;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Integer getJudgeDays() {
        return judgeDays;
    }

    public void setJudgeDays(Integer judgeDays) {
        this.judgeDays = judgeDays;
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
        CourtCase other = (CourtCase) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeadline() == null ? other.getDeadline() == null : this.getDeadline().equals(other.getDeadline()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getAcceptDate() == null ? other.getAcceptDate() == null : this.getAcceptDate().equals(other.getAcceptDate()))
            && (this.getRegisterDate() == null ? other.getRegisterDate() == null : this.getRegisterDate().equals(other.getRegisterDate()))
            && (this.getRegisterUser() == null ? other.getRegisterUser() == null : this.getRegisterUser().equals(other.getRegisterUser()))
            && (this.getUndertakeDepartment() == null ? other.getUndertakeDepartment() == null : this.getUndertakeDepartment().equals(other.getUndertakeDepartment()))
            && (this.getUndertakeUser() == null ? other.getUndertakeUser() == null : this.getUndertakeUser().equals(other.getUndertakeUser()))
            && (this.getOpenDate() == null ? other.getOpenDate() == null : this.getOpenDate().equals(other.getOpenDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getReportEndDate() == null ? other.getReportEndDate() == null : this.getReportEndDate().equals(other.getReportEndDate()))
            && (this.getActualEndDate() == null ? other.getActualEndDate() == null : this.getActualEndDate().equals(other.getActualEndDate()))
            && (this.getEndMethod() == null ? other.getEndMethod() == null : this.getEndMethod().equals(other.getEndMethod()))
            && (this.getRegisterAmount() == null ? other.getRegisterAmount() == null : this.getRegisterAmount().equals(other.getRegisterAmount()))
            && (this.getEndAmount() == null ? other.getEndAmount() == null : this.getEndAmount().equals(other.getEndAmount()))
            && (this.getActualAmount() == null ? other.getActualAmount() == null : this.getActualAmount().equals(other.getActualAmount()))
            && (this.getAbandonAmount() == null ? other.getAbandonAmount() == null : this.getAbandonAmount().equals(other.getAbandonAmount()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCaseInvolved() == null ? other.getCaseInvolved() == null : this.getCaseInvolved().equals(other.getCaseInvolved()))
            && (this.getChiefJudge() == null ? other.getChiefJudge() == null : this.getChiefJudge().equals(other.getChiefJudge()))
            && (this.getProgram() == null ? other.getProgram() == null : this.getProgram().equals(other.getProgram()))
            && (this.getJudgeDays() == null ? other.getJudgeDays() == null : this.getJudgeDays().equals(other.getJudgeDays()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeadline() == null) ? 0 : getDeadline().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getAcceptDate() == null) ? 0 : getAcceptDate().hashCode());
        result = prime * result + ((getRegisterDate() == null) ? 0 : getRegisterDate().hashCode());
        result = prime * result + ((getRegisterUser() == null) ? 0 : getRegisterUser().hashCode());
        result = prime * result + ((getUndertakeDepartment() == null) ? 0 : getUndertakeDepartment().hashCode());
        result = prime * result + ((getUndertakeUser() == null) ? 0 : getUndertakeUser().hashCode());
        result = prime * result + ((getOpenDate() == null) ? 0 : getOpenDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getReportEndDate() == null) ? 0 : getReportEndDate().hashCode());
        result = prime * result + ((getActualEndDate() == null) ? 0 : getActualEndDate().hashCode());
        result = prime * result + ((getEndMethod() == null) ? 0 : getEndMethod().hashCode());
        result = prime * result + ((getRegisterAmount() == null) ? 0 : getRegisterAmount().hashCode());
        result = prime * result + ((getEndAmount() == null) ? 0 : getEndAmount().hashCode());
        result = prime * result + ((getActualAmount() == null) ? 0 : getActualAmount().hashCode());
        result = prime * result + ((getAbandonAmount() == null) ? 0 : getAbandonAmount().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCaseInvolved() == null) ? 0 : getCaseInvolved().hashCode());
        result = prime * result + ((getChiefJudge() == null) ? 0 : getChiefJudge().hashCode());
        result = prime * result + ((getProgram() == null) ? 0 : getProgram().hashCode());
        result = prime * result + ((getJudgeDays() == null) ? 0 : getJudgeDays().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deadline=").append(deadline);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append(", reason=").append(reason);
        sb.append(", acceptDate=").append(acceptDate);
        sb.append(", registerDate=").append(registerDate);
        sb.append(", registerUser=").append(registerUser);
        sb.append(", undertakeDepartment=").append(undertakeDepartment);
        sb.append(", undertakeUser=").append(undertakeUser);
        sb.append(", openDate=").append(openDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", reportEndDate=").append(reportEndDate);
        sb.append(", actualEndDate=").append(actualEndDate);
        sb.append(", endMethod=").append(endMethod);
        sb.append(", registerAmount=").append(registerAmount);
        sb.append(", endAmount=").append(endAmount);
        sb.append(", actualAmount=").append(actualAmount);
        sb.append(", abandonAmount=").append(abandonAmount);
        sb.append(", name=").append(name);
        sb.append(", caseInvolved=").append(caseInvolved);
        sb.append(", chiefJudge=").append(chiefJudge);
        sb.append(", program=").append(program);
        sb.append(", judgeDays=").append(judgeDays);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}