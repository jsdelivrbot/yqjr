package com.yqjr.fin.mkmm.sales.rest.vo;

import com.yqjr.fin.mkmm.sales.entity.ActiveMainReview;
import com.yqjr.fin.mkmm.sales.entity.WorkFlow;

/**
 * Created by yaoxin on 2018/6/4.
 */
public class ActiveMainReviewVo extends ActiveMainReview {

    private WorkFlow workFlow;

    public WorkFlow getWorkFlow() {
        return workFlow;
    }

    public void setWorkFlow(WorkFlow workFlow) {
        this.workFlow = workFlow;
    }
}
