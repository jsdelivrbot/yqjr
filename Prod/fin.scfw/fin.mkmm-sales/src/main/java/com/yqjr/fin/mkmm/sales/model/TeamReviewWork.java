package com.yqjr.fin.mkmm.sales.model;

import com.yqjr.fin.mkmm.sales.entity.TeamReview;

/**
 * Created by zhouchong on 2018/5/17.
 */
public class TeamReviewWork extends TeamReview{
   private String workId;
   private String reviewLevel;
   private String opinion;
   private String modifierName;

   public String getModifierName() {
      return modifierName;
   }

   public void setModifierName(String modifierName) {
      this.modifierName = modifierName;
   }

   public String getOpinion() {
      return opinion;
   }

   public void setOpinion(String opinion) {
      this.opinion = opinion;
   }

   public String getWorkId() {
      return workId;
   }

   public void setWorkId(String workId) {
      this.workId = workId;
   }

   public String getReviewLevel() {
      return reviewLevel;
   }

   public void setReviewLevel(String reviewLevel) {
      this.reviewLevel = reviewLevel;
   }
}
