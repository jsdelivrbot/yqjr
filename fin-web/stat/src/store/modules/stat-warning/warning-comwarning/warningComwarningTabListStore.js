import {apiquerycomwarningByEventid, apiupdateIndicatorLogss, apicomwarningIndicatorLogss, apiqueryIndicatorLogsByEventid} from '../../../../api/stat-warning/warning-comwarning/warningComwarningApi.js';
import config from '@/config';

const comwarningTabList = {
    state: {
        comwarningTabList: [],
        IndicatorLogsTabList: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        querycomwarningByEventidSto ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiquerycomwarningByEventid(formQueryData).then(res => {
                    commit('setTeamMainQueryPersonList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        queryIndicatorLogsByEventidSto ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiqueryIndicatorLogsByEventid(formQueryData).then(res => {
                    commit('setIndicatorLogsList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        comwarningIndicatorLogss ({ commit }, indicatorLogss) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apicomwarningIndicatorLogss(indicatorLogss).then(res => {
                    commit('setTeamMainQueryPersonList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        updateIndicatorLogss ({ commit }, indicatorLogss) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiupdateIndicatorLogss(indicatorLogss).then(res => {
                    commit('setTeamMainQueryPersonList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        }
    },
    mutations: {
        setTeamMainQueryPersonList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.comwarningTabList = data.rows;
        },
        setIndicatorLogsList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.IndicatorLogsTabList = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }

};
export default comwarningTabList;
