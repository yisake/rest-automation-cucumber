package com.ppdai.jiechu.pojo.mysqlserver1;

import java.math.BigDecimal;
import java.util.Date;

public class PpdaiBidPojo {
	
    private Integer bidid;

    private Integer listingid;

    private Integer lenderid;

    private BigDecimal amount;

    private BigDecimal participationamount;

    private Double bidrate;

    private Integer statusid;

    private Date creationdate;

    private Integer ruleid;

    private Byte joinrisktask;

    private Boolean isinsurance;

    private String ip;

    private Integer finalresultid;

    private Date finalresultdate;

    private Double autobidsetrate;

    private BigDecimal lockedbalance;

    private BigDecimal couponamount;

    private Integer source;

    private Integer portfoliorecordid;

    private Date inserttime;

    private Date updatetime;

    private Boolean isactive;

    private Integer autobidruleid;

    private Integer couponsystemuserid;

    private String lendername;

    private BigDecimal funding;

    private Integer autobidsourceid;

    private Long bidno;

    public Integer getBidid() {
        return bidid;
    }

    public void setBidid(Integer bidid) {
        this.bidid = bidid;
    }

    public Integer getListingid() {
        return listingid;
    }

    public void setListingid(Integer listingid) {
        this.listingid = listingid;
    }

    public Integer getLenderid() {
        return lenderid;
    }

    public void setLenderid(Integer lenderid) {
        this.lenderid = lenderid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getParticipationamount() {
        return participationamount;
    }

    public void setParticipationamount(BigDecimal participationamount) {
        this.participationamount = participationamount;
    }

    public Double getBidrate() {
        return bidrate;
    }

    public void setBidrate(Double bidrate) {
        this.bidrate = bidrate;
    }

    public Integer getStatusid() {
        return statusid;
    }

    public void setStatusid(Integer statusid) {
        this.statusid = statusid;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Integer getRuleid() {
        return ruleid;
    }

    public void setRuleid(Integer ruleid) {
        this.ruleid = ruleid;
    }

    public Byte getJoinrisktask() {
        return joinrisktask;
    }

    public void setJoinrisktask(Byte joinrisktask) {
        this.joinrisktask = joinrisktask;
    }

    public Boolean getIsinsurance() {
        return isinsurance;
    }

    public void setIsinsurance(Boolean isinsurance) {
        this.isinsurance = isinsurance;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getFinalresultid() {
        return finalresultid;
    }

    public void setFinalresultid(Integer finalresultid) {
        this.finalresultid = finalresultid;
    }

    public Date getFinalresultdate() {
        return finalresultdate;
    }

    public void setFinalresultdate(Date finalresultdate) {
        this.finalresultdate = finalresultdate;
    }

    public Double getAutobidsetrate() {
        return autobidsetrate;
    }

    public void setAutobidsetrate(Double autobidsetrate) {
        this.autobidsetrate = autobidsetrate;
    }

    public BigDecimal getLockedbalance() {
        return lockedbalance;
    }

    public void setLockedbalance(BigDecimal lockedbalance) {
        this.lockedbalance = lockedbalance;
    }

    public BigDecimal getCouponamount() {
        return couponamount;
    }

    public void setCouponamount(BigDecimal couponamount) {
        this.couponamount = couponamount;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getPortfoliorecordid() {
        return portfoliorecordid;
    }

    public void setPortfoliorecordid(Integer portfoliorecordid) {
        this.portfoliorecordid = portfoliorecordid;
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    public Integer getAutobidruleid() {
        return autobidruleid;
    }

    public void setAutobidruleid(Integer autobidruleid) {
        this.autobidruleid = autobidruleid;
    }

    public Integer getCouponsystemuserid() {
        return couponsystemuserid;
    }

    public void setCouponsystemuserid(Integer couponsystemuserid) {
        this.couponsystemuserid = couponsystemuserid;
    }

    public String getLendername() {
        return lendername;
    }

    public void setLendername(String lendername) {
        this.lendername = lendername == null ? null : lendername.trim();
    }

    public BigDecimal getFunding() {
        return funding;
    }

    public void setFunding(BigDecimal funding) {
        this.funding = funding;
    }

    public Integer getAutobidsourceid() {
        return autobidsourceid;
    }

    public void setAutobidsourceid(Integer autobidsourceid) {
        this.autobidsourceid = autobidsourceid;
    }

    public Long getBidno() {
        return bidno;
    }

    public void setBidno(Long bidno) {
        this.bidno = bidno;
    }
}