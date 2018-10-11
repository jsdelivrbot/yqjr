package com.yqjr.fin.mkmm.sales.rest.vo.fee;

import com.yqjr.fin.mkmm.sales.entity.FeeMainReview;

/**
 * Created by fanna on 2018/6/3.
 */
public class FeeMainReviewQueryVo extends FeeMainReview{
    //区域
    private String areaName;
    //品牌
    private String brandsName;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getBrandsName() {
        return brandsName;
    }

    public void setBrandsName(String brandsName) {
        this.brandsName = brandsName;
    }
}

