package com.yqjr.fin.mkmm.sales.model;

import com.yqjr.fin.mkmm.sales.entity.FeeMainReview;

import java.math.BigDecimal;

/**
 * Created by fannna on 2018/5/17.
 */
public class FeeReviewWork extends FeeMainReview{
    private String workId;
    private String reviewLevel;
    private String opinion;
    private String remark2;

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getOpinion() {
      return opinion;
   }

   public void setOpinion(String opinion) {
      this.opinion = opinion;
   }

    public String getReviewLevel() {
      return reviewLevel;
   }

   public void setReviewLevel(String reviewLevel) {
      this.reviewLevel = reviewLevel;
   }



    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }
}
