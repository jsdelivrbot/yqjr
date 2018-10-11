package com.yqjr.fin.mkmm.sales.condition;

import java.util.Date;
import java.util.List;

/**
 * Created by yaoxin on 2018/5/31.
 */
public class PersonMainAndTeamReviewCondition {
    private Long personReviewId;
    private Long personTeamId;
    private String personCode;
    private String createName;
    private String teamCode;
    private String teamName;
    private String personNature;
    private String personLevel;
    private String personStatus;
    private Date personCheckStart;
    private Date personUptime;
    private Date personCorrectime;
    private Date personTryStartime;
    private Date personTryEndtime;
    private Date personJointime;
    private String personAddress;
    private String personHomephone;
    private String personPhone;
    private String personWorkphone;
    private String personEmail;
    private String reviewType;
    private String remark;
    private String areaCode;
    private Boolean cityChanged;
    private Boolean brandChanged;
    private Date startTime;
    private List<PersonReviewCitiesCondition> cities;
    private List<PersonReviewBrandsCondition> brands;

    public PersonMainAndTeamReviewCondition() {
    }

    public PersonMainAndTeamReviewCondition(Long personReviewId, Long personTeamId, String personCode, String teamCode, String personNature, String personLevel, String personStatus, Date personCheckStart, Date personUptime, Date personCorrectime, Date personTryStartime, Date personTryEndtime, Date personJointime, String personAddress, String personHomephone, String personPhone, String personWorkphone, String personEmail, String reviewType, String remark, String areaCode, Boolean cityChanged, Boolean brandChanged, List<PersonReviewCitiesCondition> cities, List<PersonReviewBrandsCondition> brands) {
        this.personReviewId = personReviewId;
        this.personTeamId = personTeamId;
        this.personCode = personCode;
        this.teamCode = teamCode;
        this.personNature = personNature;
        this.personLevel = personLevel;
        this.personStatus = personStatus;
        this.personCheckStart = personCheckStart;
        this.personUptime = personUptime;
        this.personCorrectime = personCorrectime;
        this.personTryStartime = personTryStartime;
        this.personTryEndtime = personTryEndtime;
        this.personJointime = personJointime;
        this.personAddress = personAddress;
        this.personHomephone = personHomephone;
        this.personPhone = personPhone;
        this.personWorkphone = personWorkphone;
        this.personEmail = personEmail;
        this.reviewType = reviewType;
        this.remark = remark;
        this.areaCode = areaCode;
        this.cityChanged = cityChanged;
        this.brandChanged = brandChanged;
        this.cities = cities;
        this.brands = brands;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getReviewType() {
        return reviewType;
    }

    public void setReviewType(String reviewType) {
        this.reviewType = reviewType;
    }

    public Long getPersonReviewId() {
        return personReviewId;
    }

    public void setPersonReviewId(Long personReviewId) {
        this.personReviewId = personReviewId;
    }

    public Long getPersonTeamId() {
        return personTeamId;
    }

    public void setPersonTeamId(Long personTeamId) {
        this.personTeamId = personTeamId;
    }

    public Boolean getCityChanged() {
        return cityChanged;
    }

    public void setCityChanged(Boolean cityChanged) {
        this.cityChanged = cityChanged;
    }

    public Boolean getBrandChanged() {
        return brandChanged;
    }

    public void setBrandChanged(Boolean brandChanged) {
        this.brandChanged = brandChanged;
    }

    public List<PersonReviewCitiesCondition> getCities() {
        return cities;
    }

    public void setCities(List<PersonReviewCitiesCondition> cities) {
        this.cities = cities;
    }

    public List<PersonReviewBrandsCondition> getBrands() {
        return brands;
    }

    public void setBrands(List<PersonReviewBrandsCondition> brands) {
        this.brands = brands;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getPersonNature() {
        return personNature;
    }

    public void setPersonNature(String personNature) {
        this.personNature = personNature;
    }

    public String getPersonLevel() {
        return personLevel;
    }

    public void setPersonLevel(String personLevel) {
        this.personLevel = personLevel;
    }

    public String getPersonStatus() {
        return personStatus;
    }

    public void setPersonStatus(String personStatus) {
        this.personStatus = personStatus;
    }

    public Date getPersonCheckStart() {
        return personCheckStart;
    }

    public void setPersonCheckStart(Date personCheckStart) {
        this.personCheckStart = personCheckStart;
    }

    public Date getPersonUptime() {
        return personUptime;
    }

    public void setPersonUptime(Date personUptime) {
        this.personUptime = personUptime;
    }

    public Date getPersonCorrectime() {
        return personCorrectime;
    }

    public void setPersonCorrectime(Date personCorrectime) {
        this.personCorrectime = personCorrectime;
    }

    public Date getPersonTryStartime() {
        return personTryStartime;
    }

    public void setPersonTryStartime(Date personTryStartime) {
        this.personTryStartime = personTryStartime;
    }

    public Date getPersonTryEndtime() {
        return personTryEndtime;
    }

    public void setPersonTryEndtime(Date personTryEndtime) {
        this.personTryEndtime = personTryEndtime;
    }

    public Date getPersonJointime() {
        return personJointime;
    }

    public void setPersonJointime(Date personJointime) {
        this.personJointime = personJointime;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public String getPersonHomephone() {
        return personHomephone;
    }

    public void setPersonHomephone(String personHomephone) {
        this.personHomephone = personHomephone;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getPersonWorkphone() {
        return personWorkphone;
    }

    public void setPersonWorkphone(String personWorkphone) {
        this.personWorkphone = personWorkphone;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
