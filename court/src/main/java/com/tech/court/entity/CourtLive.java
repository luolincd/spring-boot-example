package com.tech.court.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class CourtLive implements Serializable {
    private String ftsyid;

    private String ajbs;

    private String ajlxbs;

    private String ajlx;

    private String spcxbs;

    private String spcx;

    /**
     * 案由标示；隔开
     */
    private String aybs;

    /**
     * 案由名称；隔开
     */
    private String aymc;

    private String aq;

    private Integer nian;

    private String fyjc;

    private String ajbh;

    private String spzhbs;

    private String spzh;

    private String ah;

    private String larq;

    private String cbsptbs;

    private String cbspt;

    private String cbrbs;

    private String cbr;

    private Integer sych;

    private Integer sfgk;

    private String dwid;

    private Integer ztbs;

    private String dsr;

    private Integer ajcs;

    private Integer ftyt;

    private Integer tc;

    private String ksrq;

    private String kssj;

    private String jsrq;

    private String jssj;

    private String ftid;

    private String ftmc;

    private Integer gkkt;

    private Integer zt;

    private Integer ktlx;

    private Integer szftcs;

    private Integer sfcsz;

    private Integer sfkl;

    private Integer sfzb;

    private Integer tsms;

    /**
     * 审判长标示
     */
    private String spzbs;

    /**
     * 审判长名称
     */
    private String spzmc;

    private String sjybs;

    private String sjymc;

    /**
     * 审判员标示；隔开
     */
    private String spybs;

    /**
     * 审判员名称；隔开
     */
    private String spymc;

    /**
     * 人民陪审员
     */
    private String rmpsy;

    /**
     * 排期类型普通连案并案
     */
    private Integer pqlx;

    /**
     * 是否最后点播排期
     */
    private Integer sfzhdb;

    /**
     * 自定义排序
     */
    private Integer zdypx;

    /**
     * 案件参与人员实体标示；隔开
     */
    private String brcystbs;

    private Integer btdb;

    private Integer xbtdb;

    private static final long serialVersionUID = 1L;

    public String getFtsyid() {
        return ftsyid;
    }

    public void setFtsyid(String ftsyid) {
        this.ftsyid = ftsyid;
    }

    public String getAjbs() {
        return ajbs;
    }

    public void setAjbs(String ajbs) {
        this.ajbs = ajbs;
    }

    public String getAjlxbs() {
        return ajlxbs;
    }

    public void setAjlxbs(String ajlxbs) {
        this.ajlxbs = ajlxbs;
    }

    public String getAjlx() {
        return ajlx;
    }

    public void setAjlx(String ajlx) {
        this.ajlx = ajlx;
    }

    public String getSpcxbs() {
        return spcxbs;
    }

    public void setSpcxbs(String spcxbs) {
        this.spcxbs = spcxbs;
    }

    public String getSpcx() {
        return spcx;
    }

    public void setSpcx(String spcx) {
        this.spcx = spcx;
    }

    public String getAybs() {
        return aybs;
    }

    public void setAybs(String aybs) {
        this.aybs = aybs;
    }

    public String getAymc() {
        return aymc;
    }

    public void setAymc(String aymc) {
        this.aymc = aymc;
    }

    public String getAq() {
        return aq;
    }

    public void setAq(String aq) {
        this.aq = aq;
    }

    public Integer getNian() {
        return nian;
    }

    public void setNian(Integer nian) {
        this.nian = nian;
    }

    public String getFyjc() {
        return fyjc;
    }

    public void setFyjc(String fyjc) {
        this.fyjc = fyjc;
    }

    public String getAjbh() {
        return ajbh;
    }

    public void setAjbh(String ajbh) {
        this.ajbh = ajbh;
    }

    public String getSpzhbs() {
        return spzhbs;
    }

    public void setSpzhbs(String spzhbs) {
        this.spzhbs = spzhbs;
    }

    public String getSpzh() {
        return spzh;
    }

    public void setSpzh(String spzh) {
        this.spzh = spzh;
    }

    public String getAh() {
        return ah;
    }

    public void setAh(String ah) {
        this.ah = ah;
    }

    public String getLarq() {
        return larq;
    }

    public void setLarq(String larq) {
        this.larq = larq;
    }

    public String getCbsptbs() {
        return cbsptbs;
    }

    public void setCbsptbs(String cbsptbs) {
        this.cbsptbs = cbsptbs;
    }

    public String getCbspt() {
        return cbspt;
    }

    public void setCbspt(String cbspt) {
        this.cbspt = cbspt;
    }

    public String getCbrbs() {
        return cbrbs;
    }

    public void setCbrbs(String cbrbs) {
        this.cbrbs = cbrbs;
    }

    public String getCbr() {
        return cbr;
    }

    public void setCbr(String cbr) {
        this.cbr = cbr;
    }

    public Integer getSych() {
        return sych;
    }

    public void setSych(Integer sych) {
        this.sych = sych;
    }

    public Integer getSfgk() {
        return sfgk;
    }

    public void setSfgk(Integer sfgk) {
        this.sfgk = sfgk;
    }

    public String getDwid() {
        return dwid;
    }

    public void setDwid(String dwid) {
        this.dwid = dwid;
    }

    public Integer getZtbs() {
        return ztbs;
    }

    public void setZtbs(Integer ztbs) {
        this.ztbs = ztbs;
    }

    public String getDsr() {
        return dsr;
    }

    public void setDsr(String dsr) {
        this.dsr = dsr;
    }

    public Integer getAjcs() {
        return ajcs;
    }

    public void setAjcs(Integer ajcs) {
        this.ajcs = ajcs;
    }

    public Integer getFtyt() {
        return ftyt;
    }

    public void setFtyt(Integer ftyt) {
        this.ftyt = ftyt;
    }

    public Integer getTc() {
        return tc;
    }

    public void setTc(Integer tc) {
        this.tc = tc;
    }

    public String getKsrq() {
        return ksrq;
    }

    public void setKsrq(String ksrq) {
        this.ksrq = ksrq;
    }

    public String getKssj() {
        return kssj;
    }

    public void setKssj(String kssj) {
        this.kssj = kssj;
    }

    public String getJsrq() {
        return jsrq;
    }

    public void setJsrq(String jsrq) {
        this.jsrq = jsrq;
    }

    public String getJssj() {
        return jssj;
    }

    public void setJssj(String jssj) {
        this.jssj = jssj;
    }

    public String getFtid() {
        return ftid;
    }

    public void setFtid(String ftid) {
        this.ftid = ftid;
    }

    public String getFtmc() {
        return ftmc;
    }

    public void setFtmc(String ftmc) {
        this.ftmc = ftmc;
    }

    public Integer getGkkt() {
        return gkkt;
    }

    public void setGkkt(Integer gkkt) {
        this.gkkt = gkkt;
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    public Integer getKtlx() {
        return ktlx;
    }

    public void setKtlx(Integer ktlx) {
        this.ktlx = ktlx;
    }

    public Integer getSzftcs() {
        return szftcs;
    }

    public void setSzftcs(Integer szftcs) {
        this.szftcs = szftcs;
    }

    public Integer getSfcsz() {
        return sfcsz;
    }

    public void setSfcsz(Integer sfcsz) {
        this.sfcsz = sfcsz;
    }

    public Integer getSfkl() {
        return sfkl;
    }

    public void setSfkl(Integer sfkl) {
        this.sfkl = sfkl;
    }

    public Integer getSfzb() {
        return sfzb;
    }

    public void setSfzb(Integer sfzb) {
        this.sfzb = sfzb;
    }

    public Integer getTsms() {
        return tsms;
    }

    public void setTsms(Integer tsms) {
        this.tsms = tsms;
    }

    public String getSpzbs() {
        return spzbs;
    }

    public void setSpzbs(String spzbs) {
        this.spzbs = spzbs;
    }

    public String getSpzmc() {
        return spzmc;
    }

    public void setSpzmc(String spzmc) {
        this.spzmc = spzmc;
    }

    public String getSjybs() {
        return sjybs;
    }

    public void setSjybs(String sjybs) {
        this.sjybs = sjybs;
    }

    public String getSjymc() {
        return sjymc;
    }

    public void setSjymc(String sjymc) {
        this.sjymc = sjymc;
    }

    public String getSpybs() {
        return spybs;
    }

    public void setSpybs(String spybs) {
        this.spybs = spybs;
    }

    public String getSpymc() {
        return spymc;
    }

    public void setSpymc(String spymc) {
        this.spymc = spymc;
    }

    public String getRmpsy() {
        return rmpsy;
    }

    public void setRmpsy(String rmpsy) {
        this.rmpsy = rmpsy;
    }

    public Integer getPqlx() {
        return pqlx;
    }

    public void setPqlx(Integer pqlx) {
        this.pqlx = pqlx;
    }

    public Integer getSfzhdb() {
        return sfzhdb;
    }

    public void setSfzhdb(Integer sfzhdb) {
        this.sfzhdb = sfzhdb;
    }

    public Integer getZdypx() {
        return zdypx;
    }

    public void setZdypx(Integer zdypx) {
        this.zdypx = zdypx;
    }

    public String getBrcystbs() {
        return brcystbs;
    }

    public void setBrcystbs(String brcystbs) {
        this.brcystbs = brcystbs;
    }

    public Integer getBtdb() {
        return btdb;
    }

    public void setBtdb(Integer btdb) {
        this.btdb = btdb;
    }

    public Integer getXbtdb() {
        return xbtdb;
    }

    public void setXbtdb(Integer xbtdb) {
        this.xbtdb = xbtdb;
    }
}