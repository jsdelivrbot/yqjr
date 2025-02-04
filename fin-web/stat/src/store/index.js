/* eslint-disable quotes */
import Vue from 'vue';
import Vuex from 'vuex';
import warningList from "./modules/stat-warning/warning-targettype/warningTargettypeListStore";
import warningAdd from "./modules/stat-warning/warning-targettype/warningTargettypeAddStore";
import warningEdit from "./modules/stat-warning/warning-targettype/warningTargettypeEditStore";
import comwarningList from "./modules/stat-warning/warning-comwarning/warningComwarningListStore";
import comwarningTabList from "./modules/stat-warning/warning-comwarning/warningComwarningTabListStore";
import interventionList from "./modules/stat-warning/warning-intervention/warningInterventionListStore";
import indicatorsList from "./modules/stat-warning/warning-indicators/indicatorsListStore";
import indicatorAdd from "./modules/stat-warning/warning-indicators/indicatorAddStore";
import indicatorEdit from "./modules/stat-warning/warning-indicators/indicatorEditStore";
import indicatorView from "./modules/stat-warning/warning-indicators/indicatorViewStore";
import indicatorRangesList from "./modules/stat-warning/warning-indicatorRanges/indicatorRangesStore";
import indicatorRangesAdd from "./modules/stat-warning/warning-indicatorRanges/indicatorRangesAddStore";
import indicatorRangesEdit from "./modules/stat-warning/warning-indicatorRanges/indicatorRangesEditStore";
import indicatorRangesView from "./modules/stat-warning/warning-indicatorRanges/indicatorRangesViewStore";
import warningAuditingList from "./modules/stat-warning/warning-warningAuditing/warningAuditingStore";
import warningAuditingTabList from "./modules/stat-warning/warning-warningAuditing/warningAuditingTabListStore";
import warningInterveneNewsList from "./modules/stat-warning/warning-warningInterveneNewsList/warningInterveneNewsListStore";
import timeSettingList from "./modules/stat-systemManagement/time-Setting/timeSettingListStore";
import timeSettingAdd from "./modules/stat-systemManagement/time-Setting/timeSettingAddStore";
import timeSettingEdit from "./modules/stat-systemManagement/time-Setting/timeSettingEditStore";
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
        warningList,
        warningAdd,
        warningEdit,
        comwarningList,
        comwarningTabList,
        interventionList,
        indicatorsList,
        indicatorAdd,
        indicatorEdit,
        indicatorView,
        indicatorRangesList,
        indicatorRangesAdd,
        indicatorRangesEdit,
        indicatorRangesView,
        warningAuditingList,
        warningAuditingTabList,
        warningInterveneNewsList,
        timeSettingList,
        timeSettingAdd,
        timeSettingEdit
    }
});

export default store;
