export const page404 = {
    path: '/*',
    name: 'error-404',
    meta: {
        title: '404-页面不存在'
    },
    component: resolve => { require(['@/views/error-page/404.vue'], resolve); }
};

export const page403 = {
    path: '/403',
    meta: {
        title: '403-权限不足'
    },
    name: 'error-403',
    component: resolve => { require(['@//views/error-page/403.vue'], resolve); }
};

export const page500 = {
    path: '/500',
    meta: {
        title: '500-服务端错误'
    },
    name: 'error-500',
    component: resolve => { require(['@/views/error-page/500.vue'], resolve); }
};

export const warningRouter = [{
    path: '/warningTargettypeList',
    meta: {
        title: '指标类型列表'
    },
    name: 'warningTargettypeList',
    component: resolve => { require(['@/views/stat-warning/warning-targettype/warningTargettypeList.vue'], resolve); }
}, {
    path: '/warningTargettypeAdd',
    meta: {
        title: '销售团队新增'
    },
    name: 'warningTargettypeAdd',
    component: resolve => { require(['@/views/stat-warning/warning-targettype/warningTargettypeAdd.vue'], resolve); }
}, {
    path: '/warningTargettypeEdit',
    meta: {
        title: '销售团队修改'
    },
    name: 'warningTargettypeEdit',
    component: resolve => { require(['@/views/stat-warning/warning-targettype/warningTargettypeEdit.vue'], resolve); }
}];

export const comwarningRouter = [{
    path: '/warningComwarningList',
    meta: {
        title: '预警审查列表'
    },
    name: 'warningComwarningList',
    component: resolve => { require(['@/views/stat-warning/warning-comwarning/warningComwarningList.vue'], resolve); }
}, {
    path: '/warningComwarningTabList',
    meta: {
        title: '信号灯查看'
    },
    name: 'warningComwarningTabList',
    component: resolve => { require(['@/views/stat-warning/warning-comwarning/warningComwarningTabList.vue'], resolve); }
}];
export const interventionRouter = [{
    path: '/warningInterventionList',
    meta: {
        title: '预警干预列表'
    },
    name: 'warningInterventionList',
    component: resolve => { require(['@/views/stat-warning/warning-intervention/warningInterventionList.vue'], resolve); }
}, {
    path: '/warningInterventionTabList',
    meta: {
        title: '点击信号灯'
    },
    name: 'warningInterventionTabList',
    component: resolve => { require(['@/views/stat-warning/warning-intervention/warningInterventionTabList.vue'], resolve); }
}
];

export const indicatorsRouter = [{
    path: '/indicatorList',
    meta: {
        title: '指标列表'
    },
    name: 'indicatorList',
    component: resolve => { require(['@/views/stat-warning/warning-indicators/indicatorList.vue'], resolve); }
}, {
    path: '/indicatorAdd',
    meta: {
        title: '指标添加列表'
    },
    name: 'indicatorAdd',
    component: resolve => { require(['@/views/stat-warning/warning-indicators/indicatorAdd.vue'], resolve); }
}, {
    path: '/indicatorEdit',
    meta: {
        title: '指标编辑列表'
    },
    name: 'indicatorEdit',
    component: resolve => { require(['@/views/stat-warning/warning-indicators/indicatorEdit.vue'], resolve); }
}, {
    path: '/indicatorView',
    meta: {
        title: '指标查看列表'
    },
    name: 'indicatorView',
    component: resolve => { require(['@/views/stat-warning/warning-indicators/indicatorView.vue'], resolve); }
}
];
export const indicatorRangesRouter = [{
    path: '/indicatorRangesList',
    meta: {
        title: '指标预警列表'
    },
    name: 'indicatorRangesList',
    component: resolve => { require(['@/views/stat-warning/warning-indicatorRanges/indicatorRangesList.vue'], resolve); }
},
    {
        path: '/indicatorRangesAdd',
        meta: {
            title: '指标预警添加列表'
        },
        name: 'indicatorRangesAdd',
        component: resolve => { require(['@/views/stat-warning/warning-indicatorRanges/indicatorRangesAdd.vue'], resolve); }
    },
    {
        path: '/indicatorRangesEdit',
        meta: {
            title: '指标预警编辑列表'
        },
        name: 'indicatorRangesEdit',
        component: resolve => { require(['@/views/stat-warning/warning-indicatorRanges/indicatorRangesEdit.vue'], resolve); }
    },
    {
        path: '/indicatorRangesView',
        meta: {
            title: '指标预警查看列表'
        },
        name: 'indicatorRangesView',
        component: resolve => { require(['@/views/stat-warning/warning-indicatorRanges/indicatorRangesView.vue'], resolve); }
    }
];
export const warningAuditingListRouter = [{
    path: '/warningAuditingList',
    meta: {
        title: '预警审核列表'
    },
    name: 'warningAuditingList',
    component: resolve => { require(['@/views/stat-warning/warning-warningAuditing/warningAuditingList.vue'], resolve); }
},
    {
        path: '/warningAuditingTabList',
        meta: {
            title: '预警审核查看列表'
        },
        name: 'warningAuditingTabList',
        component: resolve => { require(['@/views/stat-warning/warning-warningAuditing/warningAuditingTabList.vue'], resolve); }
    }
];
export const warningInterveneNewsListRouter = [{
    path: '/warningInterveneNewsList',
    meta: {
        title: '预警干预查询菜单列表'
    },
    name: 'warningInterveneNewsList',
    component: resolve => { require(['@/views/stat-warning/warning-warningInterveneNewsList/warningInterveneNewsList.vue'], resolve); }
},
    {
        path: '/warningInterveneNewsTabList',
        meta: {
            title: '预警干预查询任务明细列表'
        },
        name: 'warningInterveneNewsTabList',
        component: resolve => { require(['@/views/stat-warning/warning-warningInterveneNewsList/warningInterveneNewsTabList.vue'], resolve); }
    }
];
export const systemManagement = [{
    path: '/timeSettingList',
    meta: {
        title: '自动任务查询'
    },
    name: 'timeSettingList',
    component: resolve => { require(['@/views/stat-systemManagement/time-Setting/timeSettingList.vue'], resolve); }
},
    {
        path: '/timeSettingAdd',
        meta: {
            title: '自动任务增加'
        },
        name: 'timeSettingAdd',
        component: resolve => { require(['@/views/stat-systemManagement/time-Setting/timeSettingAdd.vue'], resolve); }
    },
    {
        path: '/timeSettingEdit',
        meta: {
            title: '自动任务修改'
        },
        name: 'timeSettingEdit',
        component: resolve => { require(['@/views/stat-systemManagement/time-Setting/timeSettingEdit.vue'], resolve); }
    }
];
export const financialComWarningRouter = [{
    path: '/financialWarningComWarningList',
    meta: {
        title: '预警审查列表'
    },
    name: 'financialWarningComWarningList',
    component: resolve => { require(['@/views/stat-financialWarning/warning-comwarning/warningComwarningList.vue'], resolve); }
}, {
    path: '/financialWarningComWarningTabList',
    meta: {
        title: '信号灯查看'
    },
    name: 'financialWarningComWarningTabList',
    component: resolve => { require(['@/views/stat-financialWarning/warning-comwarning/warningComwarningTabList.vue'], resolve); }
}];
export const financialInterventionRouter = [{
    path: '/financialWarningInterventionList',
    meta: {
        title: '预警干预列表'
    },
    name: 'financialWarningInterventionList',
    component: resolve => { require(['@/views/stat-financialWarning/warning-intervention/warningInterventionList.vue'], resolve); }
}, {
    path: '/financialWarningInterventionTabList',
    meta: {
        title: '点击信号灯'
    },
    name: 'financialWarningInterventionTabList',
    component: resolve => { require(['@/views/stat-financialWarning/warning-intervention/warningInterventionTabList.vue'], resolve); }
}];
export const financialWarningAuditingListRouter = [{
    path: '/financialWarningAuditingList',
    meta: {
        title: '预警审核列表'
    },
    name: 'financialWarningAuditingList',
    component: resolve => { require(['@/views/stat-financialWarning/warning-warningAuditing/warningAuditingList.vue'], resolve); }
},
    {
        path: '/financialWarningAuditingTabList',
        meta: {
            title: '预警审核查看列表'
        },
        name: 'financialWarningAuditingTabList',
        component: resolve => { require(['@/views/stat-financialWarning/warning-warningAuditing/warningAuditingTabList.vue'], resolve); }
    }
];
export const financialWarningInterveneNewsListRouter = [{
    path: '/financialWarningInterveneNewsList',
    meta: {
        title: '预警干预查询菜单列表'
    },
    name: 'financialWarningInterveneNewsList',
    component: resolve => { require(['@/views/stat-financialWarning/warning-warningInterveneNewsList/warningInterveneNewsList.vue'], resolve); }
},
    {
        path: '/financialWarningInterveneNewsTabList',
        meta: {
            title: '预警干预查询任务明细列表'
        },
        name: 'financialWarningInterveneNewsTabList',
        component: resolve => { require(['@/views/stat-financialWarning/warning-warningInterveneNewsList/warningInterveneNewsTabList.vue'], resolve); }
    }
];

export const leaseholdLegalPersonComWarningRouter = [{
    path: '/leaseholdLegalPersonWarningComWarningList',
    meta: {
        title: '预警审查列表'
    },
    name: 'leaseholdLegalPersonWarningComWarningList',
    component: resolve => { require(['@/views/stat-leaseholdLegalPersonWarning/warning-comwarning/warningComwarningList.vue'], resolve); }
}, {
    path: '/leaseholdLegalPersonWarningComWarningTabList',
    meta: {
        title: '信号灯查看'
    },
    name: 'leaseholdLegalPersonWarningComWarningTabList',
    component: resolve => { require(['@/views/stat-leaseholdLegalPersonWarning/warning-comwarning/warningComwarningTabList.vue'], resolve); }
}];
export const leaseholdLegalPersonInterventionRouter = [{
    path: '/leaseholdLegalPersonWarningInterventionList',
    meta: {
        title: '预警干预列表'
    },
    name: 'leaseholdLegalPersonWarningInterventionList',
    component: resolve => { require(['@/views/stat-leaseholdLegalPersonWarning/warning-intervention/warningInterventionList.vue'], resolve); }
}, {
    path: '/leaseholdLegalPersonWarningInterventionTabList',
    meta: {
        title: '点击信号灯'
    },
    name: 'leaseholdLegalPersonWarningInterventionTabList',
    component: resolve => { require(['@/views/stat-leaseholdLegalPersonWarning/warning-intervention/warningInterventionTabList.vue'], resolve); }
}];
export const leaseholdLegalPersonWarningAuditingListRouter = [{
    path: '/leaseholdLegalPersonWarningAuditingList',
    meta: {
        title: '预警审核列表'
    },
    name: 'leaseholdLegalPersonWarningAuditingList',
    component: resolve => { require(['@/views/stat-leaseholdLegalPersonWarning/warning-warningAuditing/warningAuditingList.vue'], resolve); }
},
    {
        path: '/leaseholdLegalPersonWarningAuditingTabList',
        meta: {
            title: '预警审核查看列表'
        },
        name: 'leaseholdLegalPersonWarningAuditingTabList',
        component: resolve => { require(['@/views/stat-leaseholdLegalPersonWarning/warning-warningAuditing/warningAuditingTabList.vue'], resolve); }
    }
];
export const leaseholdLegalPersonWarningInterveneNewsListRouter = [{
    path: '/leaseholdLegalPersonWarningInterveneNewsList',
    meta: {
        title: '预警干预查询菜单列表'
    },
    name: 'leaseholdLegalPersonWarningInterveneNewsList',
    component: resolve => { require(['@/views/stat-leaseholdLegalPersonWarning/warning-warningInterveneNewsList/warningInterveneNewsList.vue'], resolve); }
},
    {
        path: '/leaseholdLegalPersonWarningInterveneNewsTabList',
        meta: {
            title: '预警干预查询任务明细列表'
        },
        name: 'leaseholdLegalPersonWarningInterveneNewsTabList',
        component: resolve => { require(['@/views/stat-leaseholdLegalPersonWarning/warning-warningInterveneNewsList/warningInterveneNewsTabList.vue'], resolve); }
    }
];
// 所有上面定义的路由都要写在下面的routers里
export const routers = [
    ...warningRouter,
    ...comwarningRouter,
    ...interventionRouter,
    ...indicatorsRouter,
    ...indicatorRangesRouter,
    ...warningAuditingListRouter,
    ...warningInterveneNewsListRouter,
    ...systemManagement,
    ...financialComWarningRouter,
    ...financialInterventionRouter,
    ...financialWarningAuditingListRouter,
    ...financialWarningInterveneNewsListRouter,
    ...leaseholdLegalPersonComWarningRouter,
    ...leaseholdLegalPersonInterventionRouter,
    ...leaseholdLegalPersonWarningAuditingListRouter,
    ...leaseholdLegalPersonWarningInterveneNewsListRouter,
    page500,
    page403,
    page404
];
