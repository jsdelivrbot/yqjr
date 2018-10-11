package com.yqjr.fin.mkmm.sales.rest.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoxin on 2018/6/8.
 */
public class SelectProductCodeVo {
    private List<SelectCodeVo> marketingCodes = new ArrayList<SelectCodeVo>();
    private List<SelectCodeVo> financeCodes = new ArrayList<SelectCodeVo>();
    private List<SelectCodeVo> businessCodes = new ArrayList<SelectCodeVo>();
    private List<SelectCodeVo> creditCodes = new ArrayList<SelectCodeVo>();
    private List<SelectCodeVo> additionalCodes = new ArrayList<SelectCodeVo>();

    public List<SelectCodeVo> getMarketingCodes() {
        return marketingCodes;
    }

    public void setMarketingCodes(List<SelectCodeVo> marketingCodes) {
        this.marketingCodes = marketingCodes;
    }

    public List<SelectCodeVo> getFinanceCodes() {
        return financeCodes;
    }

    public void setFinanceCodes(List<SelectCodeVo> financeCodes) {
        this.financeCodes = financeCodes;
    }

    public List<SelectCodeVo> getBusinessCodes() {
        return businessCodes;
    }

    public void setBusinessCodes(List<SelectCodeVo> businessCodes) {
        this.businessCodes = businessCodes;
    }

    public List<SelectCodeVo> getCreditCodes() {
        return creditCodes;
    }

    public void setCreditCodes(List<SelectCodeVo> creditCodes) {
        this.creditCodes = creditCodes;
    }

    public List<SelectCodeVo> getAdditionalCodes() {
        return additionalCodes;
    }

    public void setAdditionalCodes(List<SelectCodeVo> additionalCodes) {
        this.additionalCodes = additionalCodes;
    }
}
