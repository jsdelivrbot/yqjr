/* eslint-disable quotes */
import Vue from 'vue';
import Vuex from 'vuex';

import app from './modules/app';
import user from './modules/user';
import demo from './modules/demo';
import personList from './modules/sale-person/person-maintenance/personMaintenanceListStore';
import personView from './modules/sale-person/person-maintenance/personMainTenanceViewStore';
import personAdd from './modules/sale-person/person-maintenance/personMainTenanceAddStore';
import personEdit from './modules/sale-person/person-maintenance/personMainTenanceEditStore';
import personEventList from './modules/sale-person/person-event/personEventListStore';
import personEventView from './modules/sale-person/person-event/personEventViewStore';
import personEventEdit from './modules/sale-person/person-event/personEventEditStore';
import personEventAdd from './modules/sale-person/person-event/personEventAddStore';
import personMainList from './modules/sale-person/person-main-query/personMainQueryListStore';
import personMainTabList from './modules/sale-person/person-main-query/personMainQueryTabListStore';
import personReviewList from './modules/sale-person/person-review/personReviewListStore';
import personReviewView from './modules/sale-person/person-review/personReviewViewStore';
import personReviewEdit from './modules/sale-person/person-review/personReviewEditStore';
import personReviewProgressList from './modules/sale-person/person-review-progress/personReviewProgressListStore';
import personReviewProgressEdit from './modules/sale-person/person-review-progress/personReviewProgressEditStore';

import teamList from './modules/sale-team/team-maintenance/teamMainTenanceListStore';
import teamView from './modules/sale-team/team-maintenance/teamMainTenanceViewStore';
import teamEdit from './modules/sale-team/team-maintenance/teamMainTenanceEditStore';
import teamAdd from './modules/sale-team/team-maintenance/teamMainTenanceAddStore';
import teamEventList from './modules/sale-team/team-event/teamEventListStore';
import teamEventView from './modules/sale-team/team-event/teamEventViewStore';
import teamEventEdit from './modules/sale-team/team-event/teamEventEditStore';
import teamEventAdd from './modules/sale-team/team-event/teamEventAddStore';
import teamMainList from './modules/sale-team/team-main-query/teamMainQueryListStore';
import teamMainTabList from './modules/sale-team/team-main-query/teamMainQueryTabListStore';
import teamPlanTrackList from './modules/sale-team/team-plan-track/teamPlanTrackListStore';
import teamReviewList from './modules/sale-team/team-review/teamReviewListStore';
import teamReviewEdit from './modules/sale-team/team-review/teamReviewEditStore';
import teamReviewView from './modules/sale-team/team-review/teamReviewViewStore';
import teamReviewProList from './modules/sale-team/team-review-progress/teamReviewProgressListStore';
import teamReviewProView from './modules/sale-team/team-review-progress/teamReviewProgressViewStore';
import teamReviewProEdit from './modules/sale-team/team-review-progress/teamReviewProgressEditStore';
import feeDoPayList from './modules/sale-fee/fee-main/feeDoPayListStore';
import feeDoPayEdit from './modules/sale-fee/fee-main/feeDoPayEditStore';
import activeDetailsList from "./modules/sale-fee/fee-main/activeDetailsViewStore";
import personPlanTrackList from './modules/sale-person/person-plan-track/personPlanTrackListStore';
import feeReviewList from "./modules/sale-fee/fee-review/feeReviewListStore";
import feeReviewView from "./modules/sale-fee/fee-review/feeReviewViewStore";
import feeReviewEdit from "./modules/sale-fee/fee-review/feeReviewEditStore";
import feeReviewProgressList from "./modules/sale-fee/fee-review-progress/feeReviewProgressListStore";
import feeReviewProView from "./modules/sale-fee/fee-review-progress/feeReviewProgressViewStore";
import feeReviewProEdit from "./modules/sale-fee/fee-review-progress/feeReviewProgressEditStore";
import activeMainList from "./modules/sale-active/active-main/activeMainList";
import activeMainQueryList from "./modules/sale-active/active-main-query/activeMainQueryListStore";
import activeMatchDetailList from "./modules/sale-active/active-match-detail/activeMatchDetailListStore";
import activeReviewList from "./modules/sale-active/active-review/activeReviewListStore";
import activeReviewEdit from "./modules/sale-active/active-review/activeReviewEditStore";
import activeReviewProList from "./modules/sale-active/active-review-progress/activeReviewProgressListStore";
import activeReviewProView from "./modules/sale-active/active-review-progress/activeReviewProgressViewStore";
import activeReviewProEdit from "./modules/sale-active/active-review-progress/activeReviewProgressEditStore";
import activeMainAdd from "./modules/sale-active/active-main/activeMainAdd";
import activeMainView from "./modules/sale-active/active-main/activeMainView";
import activeReviewView from "./modules/sale-active/active-review/activeReviewViewStore";
import salePlanSearchList from "./modules/sale-plan/sale-plan-search/salePlanSearchListStore";
import salePlanUploadAdd from "./modules/sale-plan/sale-plan-upload/salePlanUploadAddStore";
import salePlanTrackList from "./modules/sale-plan/sale-plan-track/salePlanTrackListStore";
import materialMaintenanceList from "./modules/material-management/material-maintenance/materialMaintenanceListStore";
import projectMaintenanceList from "./modules/material-management/material-maintenance/projectMaintenanceListStore";
import matterMaintenanceList from "./modules/matter-management/matter-maintenance/matterMaintenanceListStore";
import materialAcceptanceList from "./modules/material-management/material-acceptance/materialAcceptanceListStore";

Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
        //
    },
    mutations: {
        //
    },
    actions: {

    },
    modules: {
        app,
        user,
        demo,
        personList, // 销售人员维护
        personView, // 销售人员查看
        personAdd, // 销售人员添加
        personEdit, // 销售人员添加
        personEventList, // 销售人员重大事项维护
        personEventView, // 销售人员重大事项查看
        personEventEdit, // 销售人员重大事项修改
        personEventAdd, // 销售人员重大事项添加
        personPlanTrackList, // 销售人员计划跟踪和预算任务
        personMainList, // 销售人员综合信息查询
        personMainTabList, // 销售人员个人信息查看
        personReviewList, // 销售人员维护
        personReviewView, // 销售人员维护
        personReviewEdit, // 销售人员审核
        personReviewProgressList, // 销售人员审核进度列表
        personReviewProgressEdit, // 销售人员审核进度修改
        teamList, // 销售团队维护
        teamView,
        teamAdd,
        teamEdit,
        teamEventList,
        teamEventView,
        teamEventEdit,
        teamEventAdd,
        teamMainList,
        teamMainTabList,
        teamPlanTrackList,
        teamReviewList,
        teamReviewEdit,
        teamReviewView,
        teamReviewProList,
        teamReviewProEdit,
        teamReviewProView,
        feeDoPayList,
        feeDoPayEdit,
        activeDetailsList,
        activeMatchDetailList,
        activeReviewList,
        feeReviewList,
        feeReviewEdit,
        feeReviewView,
        feeReviewProgressList,
        feeReviewProView,
        feeReviewProEdit,
        activeMainList,
        activeReviewProList,
        activeReviewProView,
        activeReviewEdit,
        activeReviewView,
        activeReviewProEdit,
        activeMainQueryList, // 活动综合信息查询
        activeMainAdd,
        activeMainView,
        salePlanSearchList,
        salePlanUploadAdd,
        salePlanTrackList,
        materialMaintenanceList,
        projectMaintenanceList,
        matterMaintenanceList,
        materialAcceptanceList
    }
});

export default store;
