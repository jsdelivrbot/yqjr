package com.yqjr.fin.mkmm.sales.rest.vo;

import com.yqjr.fin.mkmm.sales.entity.WorkFlow;
import com.yqjr.fin.mkmm.sales.model.ActiveReview;

/**
 * Created by yaoxin on 2018/6/9.
 */
public class ActiveReviewVo extends ActiveReview {
    private WorkFlow workFlow;

    public WorkFlow getWorkFlow() {
        return workFlow;
    }

    public void setWorkFlow(WorkFlow workFlow) {
        this.workFlow = workFlow;
    }
}
