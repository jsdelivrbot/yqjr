package com.yqjr.fin.mkmm.sales.rest.vo;

import com.yqjr.fin.mkmm.sales.entity.ActiveAreaReview;
import com.yqjr.fin.mkmm.sales.entity.ActiveCarReview;
import com.yqjr.fin.mkmm.sales.entity.ActiveMainReview;
import com.yqjr.fin.mkmm.sales.entity.WorkFlow;

/**
 * 活动审核进度返回类
 * Created by yaoxin on 2018/6/4.
 */
public class ActiveMainProcessReviewVo extends ActiveMainReview {
    private ActiveCarReview activeCarReview;
    private ActiveAreaReview activeAreaReview;
    private WorkFlow workFlow;

    public WorkFlow getWorkFlow() {
        return workFlow;
    }

    public void setWorkFlow(WorkFlow workFlow) {
        this.workFlow = workFlow;
    }

    public ActiveCarReview getActiveCarReview() {
        return activeCarReview;
    }

    public void setActiveCarReview(ActiveCarReview activeCarReview) {
        this.activeCarReview = activeCarReview;
    }

    public ActiveAreaReview getActiveAreaReview() {
        return activeAreaReview;
    }

    public void setActiveAreaReview(ActiveAreaReview activeAreaReview) {
        this.activeAreaReview = activeAreaReview;
    }
}
