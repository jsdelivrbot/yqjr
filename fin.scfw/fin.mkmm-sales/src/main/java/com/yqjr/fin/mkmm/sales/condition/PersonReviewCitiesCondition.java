package com.yqjr.fin.mkmm.sales.condition;

/**
 * Created by yaoxin on 2018/6/1.
 */
public class PersonReviewCitiesCondition {
    private String cityCode;
    private String cityName;

    public PersonReviewCitiesCondition() {
    }

    public PersonReviewCitiesCondition(String cityCode, String cityName) {
        this.cityCode = cityCode;
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
