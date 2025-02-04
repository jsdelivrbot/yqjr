import {demoList} from "../mock/demo";

export const page404 = {
    path: '/*',
    name: 'error-404',
    meta: {
        title: '404-页面不存在'
    },
    component: () => import('@/views/error-page/404.vue')
};

export const page403 = {
    path: '/403',
    meta: {
        title: '403-权限不足'
    },
    name: 'error-403',
    component: () => import('@//views/error-page/403.vue')
};

export const page500 = {
    path: '/500',
    meta: {
        title: '500-服务端错误'
    },
    name: 'error-500',
    component: () => import('@/views/error-page/500.vue')
};

export const appRouter = [{
    path: '/demoList',
    meta: {
        title: '列表'
    },
    name: 'demoList',
    component: () => import('@/views/demo/demoList.vue')
},{
    path: '/demoAdd',
        meta: {
        title: '添加'
    },
    name: 'demoAdd',
        component: () => import('@/views/demo/demoAdd.vue')
}];


export const personRouter = [{
    path: '/personList',
    meta: {
        title: '销售人员维护列表'
    },
    name: 'personList',
    component: () => import('@/views/sale-person/person-maintenance/personMaintenanceList.vue')
},{
        path: '/personMainTenanceView',
        meta: {
            title: '销售人员查看'
        },
        name: 'personMainTenanceView',
        component: () => import('@/views/sale-person/person-maintenance/personMainTenanceView.vue')
},{
        path: '/personMainTenanceAdd',
        meta: {
            title: '销售人员新增'
        },
        name: 'personMainTenanceAdd',
        component: () => import('@/views/sale-person/person-maintenance/personMainTenanceAdd.vue')
},{
    path: '/personMainTenanceEdit',
    meta: {
        title: '销售人员修改'
    },
    name: 'personMainTenanceEdit',
    component: () => import('@/views/sale-person/person-maintenance/personMainTenanceEdit.vue')
}]

export const personEventRouter = [{
    path: '/personEventList',
    meta: {
        title: '销售人员重大事项列表'
    },
    name: 'personEventList',
    component: () => import('@/views/sale-person/person-event/personEventList.vue')
},{
    path: '/personEventAdd',
    meta: {
        title: '销售人员重大事项新增'
    },
    name: 'personEventAdd',
    component: () => import('@/views/sale-person/person-event/personEventAdd.vue')
},{
    path: '/personEventEdit',
    meta: {
        title: '销售人员重大事项修改'
    },
    name: 'personEventEdit',
    component: () => import('@/views/sale-person/person-event/personEventEdit.vue')
},{
    path: '/personEventView',
    meta: {
        title: '销售人员重大事项查看'
    },
    name: 'personEventView',
    component: () => import('@/views/sale-person/person-event/personEventView.vue')
}
]

export const personMainRouter = [{
    path: '/personMainQueryList',
    meta: {
        title: '销售人员综合信息列表'
    },
    name: 'personMainQueryList',
    component: () => import('@/views/sale-person/person-main-query/personMainQueryList.vue')
},{
    path: '/personMainQueryTabList',
    meta: {
        title: '销售人员综合信息列表查看'
    },
    name: 'personMainQueryTabList',
    component: () => import('@/views/sale-person/person-main-query/personMainQueryTabList.vue')
},{
    path: '/personMainQueryTabView',
    meta: {
        title: '销售人员基本信息变更轨迹明细'
    },
    name: 'personMainQueryTabView',
    component: () => import('@/views/sale-person/person-main-query/personMainQueryTabView.vue')
},{
    path: '/personMainQueryTabEvent',
    meta: {
        title: '销售人员重大事项记录明细'
    },
    name: 'personMainQueryTabEvent',
    component: () => import('@/views/sale-person/person-main-query/personMainQueryTabEvent.vue')
}]
export const personPlanTrackRouter = [
    {
        path: '/personPlanTrackList',
        meta: {
            title: '销售人员预算任务和计划跟踪'
        },
        name: 'personPlanTrackList',
        component: () => import('@/views/sale-person/person-plan-track/personPlanTrackList.vue')
    }
]


export const personReviewRouter = [{
    path: '/personReviewList',
    meta: {
        title: '销售人员审核列表'
    },
    name: 'personReviewList',
    component: () => import('@/views/sale-person/person-review/personReviewList.vue')
}, {
    path: '/personReviewView',
    meta: {
        title: '销售人员审核查看'
    },
    name: 'personReviewView',
    component: () => import('@/views/sale-person/person-review/personReviewView.vue')
}, {
    path: '/personReviewEdit',
    meta: {
        title: '销售人员审核修改'
    },
    name: 'personReviewEdit',
    component: () => import('@/views/sale-person/person-review/personReviewEdit.vue')
}]

export const personReviewProgressRouter = [{
    path: '/personReviewProgressList',
    meta: {
        title: '销售人员审核进度列表'
    },
    name: 'personReviewProgressList',
    component: () => import('@/views/sale-person/person-review-progress/personReviewProgressList.vue')
},{
    path: '/personReviewProgressEdit',
    meta: {
        title: '销售人员审核进度修改'
    },
    name: 'personReviewProgressEdit',
    component: () => import('@/views/sale-person/person-review-progress/personReviewProgressEdit.vue')
}]

export const teamRouter = [{
    path: '/teamMainTenanceList',
    meta: {
        title: '销售团队列表'
    },
    name: 'teamMainTenanceList',
    component: () => import('@/views/sale-team/team-maintenance/teamMainTenanceList.vue')
},{
    path: '/teamMainTenanceAdd',
    meta: {
        title: '销售团队新增'
    },
    name: 'teamMainTenanceAdd',
    component: () => import('@/views/sale-team/team-maintenance/teamMainTenanceAdd.vue')
},{
    path: '/teamMainTenanceEdit',
    meta: {
        title: '销售团队修改'
    },
    name: 'teamMainTenanceEdit',
    component: () => import('@/views/sale-team/team-maintenance/teamMainTenanceEdit.vue')
},{
    path: '/teamMainTenanceView',
    meta: {
        title: '销售团队查看'
    },
    name: 'teamMainTenanceView',
    component: () => import('@/views/sale-team/team-maintenance/teamMainTenanceView.vue')
}]

export const teamEventRouter = [{
    path: '/teamEventList',
    meta: {
        title: '销售团队列表'
    },
    name: 'teamEventList',
    component: () => import('@/views/sale-team/team-event/teamEventList.vue')
},{
    path: '/teamEventAdd',
    meta: {
        title: '销售团队新增'
    },
    name: 'teamEventAdd',
    component: () => import('@/views/sale-team/team-event/teamEventAdd.vue')
},{
    path: '/teamEventEdit',
    meta: {
        title: '销售团队修改'
    },
    name: 'teamEventEdit',
    component: () => import('@/views/sale-team/team-event/teamEventEdit.vue')
},{
    path: '/teamEventView',
    meta: {
        title: '销售团队查看'
    },
    name: 'teamEventView',
    component: () => import('@/views/sale-team/team-event/teamEventView.vue')
}]

export const teamMainRouter = [{
    path: '/teamMainQueryList',
    meta: {
        title: '销售团队综合信息列表'
    },
    name: 'teamMainQueryList',
    component: () => import('@/views/sale-team/team-main-query/teamMainQueryList.vue')
},{
    path: '/teamMainQueryTabList',
    meta: {
        title: '销售团队综合信息列表查看'
    },
    name: 'teamMainQueryTabList',
    component: () => import('@/views/sale-team/team-main-query/teamMainQueryTabList.vue')
},{
    path: '/teamMainQueryTabView',
    meta: {
        title: '销售团队综合信息变更轨迹明细'
    },
    name: 'teamMainQueryTabView',
    component: () => import('@/views/sale-team/team-main-query/teamMainQueryTabView.vue')
},{
    path: '/teamMainQueryTabEvent',
    meta: {
        title: '销售团队综合信息变更轨迹明细'
    },
    name: 'teamMainQueryTabEvent',
    component: () => import('@/views/sale-team/team-main-query/teamMainQueryTabEvent.vue')
}]

export const teamPlanRouter = [{
    path: '/teamPlanTrackList',
    meta: {
        title: '销售团队综合信息列表'
    },
    name: 'teamPlanTrackList',
    component: () => import('@/views/sale-team/team-plan-track/teamPlanTrackList.vue')
}]

export const teamReviewRouter = [{
    path: '/teamReviewList',
    meta: {
        title: '销售团队审核'
    },
    name: 'teamReviewList',
    component: () => import('@/views/sale-team/team-review/teamReviewList.vue')
}, {
    path: '/teamReviewView',
    meta: {
        title: '销售团队审核'
    },
    name: 'teamReviewView',
    component: () => import('@/views/sale-team/team-review/teamReviewView.vue')
}, {
    path: '/teamReviewEdit',
    meta: {
        title: '销售团队审核'
    },
    name: 'teamReviewEdit',
    component: () => import('@/views/sale-team/team-review/teamReviewEdit.vue')
}]

export const teamReviewProgressRouter = [{
    path: '/teamReviewProgressList',
    meta: {
        title: '销售团队审核进度'
    },
    name: 'teamReviewProgressList',
    component: () => import('@/views/sale-team/team-review-progress/teamReviewProgressList.vue')
}, {
    path: '/teamReviewProgressView',
    meta: {
        title: '销售团队审核进度查看'
    },
    name: 'teamReviewProgressView',
    component: () => import('@/views/sale-team/team-review-progress/teamReviewProgressView.vue')
}, {
    path: '/teamReviewProgressEdit',
    meta: {
        title: '销售团队审核进度修改'
    },
    name: 'teamReviewProgressEdit',
    component: () => import('@/views/sale-team/team-review-progress/teamReviewProgressEdit.vue')
}]

export const feeMainRouter = [{
    path: '/feeDoPayList',
    meta: {
        title: '活动费用动支'
    },
    name: 'feeDoPayList',
    component: () => import('@/views/sale-fee/fee-main/feeDoPayList.vue')
}, {
    path: '/activeDetailsView',
    meta: {
        title: '业务明细查看'
    },
    name: 'activeDetailsView',
    component: () => import('@/views/sale-fee/fee-main/activeDetailsView.vue')
}, {
    path: '/feeDoPayEdit',
    meta: {
        title: '发起动支'
    },
    name: 'feeDoPayEdit',
    component: () => import('@/views/sale-fee/fee-main/feeDoPayEdit.vue')
}]

export const feeReviewRouter = [{
        path: '/feeReviewList',
        meta: {
            title: '活动费用审核列表'
        },
        name: 'feeReviewList',
        component: () => import('@/views/sale-fee/fee-review/feeReviewList.vue')
}, {
    path: '/feeReviewView',
    meta: {
        title: '活动费用审核查看'
    },
    name: 'feeReviewView',
    component: () => import('@/views/sale-fee/fee-review/feeReviewView.vue')
}, {
    path: '/feeReviewEdit',
    meta: {
        title: '活动费用审核'
    },
    name: 'feeReviewEdit',
    component: () => import('@/views/sale-fee/fee-review/feeReviewEdit.vue')
}]

export const feeReviewProgressRouter = [{
    path: '/feeReviewProgressList',
    meta: {
        title: '活动费用审核进度列表'
    },
    name: 'feeReviewProgressList',
    component: () => import('@/views/sale-fee/fee-review-progress/feeReviewProgressList.vue')
}, {
    path: '/feeReviewProgressView',
    meta: {
        title: '活动费用审核进度查看'
    },
    name: 'feeReviewProgressView',
    component: () => import('@/views/sale-fee/fee-review-progress/feeReviewProgressView.vue')
}, {
    path: '/feeReviewProgressEdit',
    meta: {
        title: '活动费用审核进度修改'
    },
    name: 'feeReviewProgressEdit',
    component: () => import('@/views/sale-fee/fee-review-progress/feeReviewProgressEdit.vue')
}]

export const activeMainRouter = [{
    path: '/activeMainList',
    meta: {
        title: '促销活动制定'
    },
    name: 'activeMainList',
    component: () => import('@/views/sale-active/active-main/activeMainList.vue')
},{
    path: '/activeMainView',
    meta: {
        title: '促销活动查看'
    },
    name: 'activeMainView',
    component: () => import('@/views/sale-active/active-main/activeMainView.vue')
},{
    path: '/activeMainAdd',
    meta: {
        title: '促销活动新增'
    },
    name: 'activeMainAdd',
    component: () => import('@/views/sale-active/active-main/activeMainAdd.vue')
}]

export const activeMainQueryRouter = [{
    path: '/activeMainQueryList',
    meta: {
        title: '促销活动综合查询列表'
    },
    name: 'activeMainQueryList',
    component: () => import('@/views/sale-active/active-main-query/activeMainQueryList.vue')
}]
export const activeMainQueryViewRouter = [{
    path: '/activeMainQueryView',
    meta: {
        title: '促销活动综合查询详情'
    },
    name: 'activeMainQueryView',
    component: () => import('@/views/sale-active/active-main-query/activeMainQueryView.vue')
}]
export const activeMatchDetailRouter = [{
    path: '/activeMatchDetailList',
    meta: {
        title: '促销活动业务明细查询'
    },
    name: 'activeMatchDetailList',
    component: () => import('@/views/sale-active/active-match-detail/activeMatchDetailList.vue')
}]
export const activeReviewRouter = [{
    path: '/activeReviewList',
    mate: {
        title: '促销活动审核'
    },
    name: 'activeReviewList',
    component: ()=> import('@/views/sale-active/active-review/activeReviewList.vue')
}, {
    path: '/activeReviewEdit',
    mate: {
        title: '促销活动审核查看'
    },
    name: 'activeReviewEdit',
    component: ()=> import('@/views/sale-active/active-review/activeReviewEdit.vue')
}, {
    path: '/activeReviewView',
    mate: {
        title: '促销活动审核查看'
    },
    name: 'activeReviewView',
    component: ()=> import('@/views/sale-active/active-review/activeReviewView.vue')
}
]

export const activeReviewProgressRouter = [{
    path: '/activeReviewProgressList',
    meta: {
        title: '促销活动审核进度列表'
    },
    name: 'activeReviewProgressList',
    component: () => import('@/views/sale-active/active-review-progress/activeReviewProgressList.vue')
}, {
    path: '/activeReviewProgressView',
    meta: {
        title: '促销活动审核进度查看'
    },
    name: 'activeReviewProgressView',
    component: () => import('@/views/sale-active/active-review-progress/activeReviewProgressView.vue')
}, {
    path: '/activeReviewProgressEdit',
    meta: {
        title: '促销活动审核进度查看'
    },
    name: 'activeReviewProgressEdit',
    component: () => import('@/views/sale-active/active-review-progress/activeReviewProgressEdit.vue')
}]

export const salePlanRouter = [{
    path: '/salePlanSearchList',
    meta: {
        title: '销售计划管理'
    },
    name: 'salePlanSearchList',
    component: () => import('@/views/sale-plan/sale-plan-search/salePlanSearchList.vue')
},{
    path: '/salePlanTrackList',
    meta: {
        title: '销售计划跟踪'
    },
    name: 'salePlanTrackList',
    component: () => import('@/views/sale-plan/sale-plan-track/salePlanTrackList.vue')
},{
    path: '/salePlanUploadAdd',
    meta: {
        title: '销售计划上传'
    },
    name: 'salePlanUploadAdd',
    component: () => import('@/views/sale-plan/sale-plan-upload/salePlanUploadAdd.vue')
}
]
// 物料维护
export const materialMaintenanceRouter = [{
    path: '/materialMaintenanceList',
    meta: {
        title: '基本信息维护'
    },
    name: 'materialMaintenanceList',
    component: () => import('@/views/material-management/material-maintenance/materialMaintenanceList.vue')
}
]
// 物料验收
export const materialAcceptanceRouter = [{
    path: '/materialAcceptanceList',
    meta: {
        title: '物料验收'
    },
    name: 'materialAcceptanceList',
    component: () => import('@/views/material-management/material-acceptance/materialAcceptanceList.vue')
},{
    path: '/materialAcceptanceRegister',
    meta: {
        title: '物料验收登记'
    },
    name: 'materialAcceptanceRegister',
    component: () => import('@/views/material-management/material-acceptance/materialAcceptanceRegister.vue')
}
]
// 素材维护
export const matterMaintenanceRouter = [{
    path: '/matterMaintenanceList',
    meta: {
        title: '基本信息维护'
    },
    name: 'matterMaintenanceList',
    component: () => import('@/views/matter-management/matter-maintenance/matterMaintenanceList.vue')
}
]
// 所有上面定义的路由都要写在下面的routers里
export const routers = [
        ...personRouter,
        ...personEventRouter,
        ...personMainRouter,
        ...personReviewRouter,
        ...personReviewProgressRouter,
        ...appRouter,
        ...teamRouter,
        ...teamEventRouter,
        ...teamMainRouter,
        ...teamPlanRouter,
        ...teamReviewRouter,
        ...teamReviewProgressRouter,
        ...feeMainRouter,
        ...personPlanTrackRouter,
        ...feeReviewRouter,
        ...feeReviewProgressRouter,
        ...activeMainRouter,
        ...activeMatchDetailRouter,
        ...activeReviewRouter,
        ...activeReviewProgressRouter,
        ...activeMainQueryRouter,
        ...activeMainQueryViewRouter,
        ...salePlanRouter,
        ...materialMaintenanceRouter,
        ...matterMaintenanceRouter,
        ...materialAcceptanceRouter,
           page500,
           page403,
           page404,
];
