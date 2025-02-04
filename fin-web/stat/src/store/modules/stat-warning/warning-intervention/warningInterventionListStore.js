/* eslint-disable no-console */
import {apihandlestateQueryList, apichaXunQuHua, apiupdateHandlestate, apichaXunZhiBiao, chaXun} from '../../../../api/stat-warning/warning-intervention/warningInterventionApi.js';
import config from '@/config';

const interventionList = {
    state: {
        interventionList: [],
        zhiBiaoQueryList: [],
        quHuaQueryList: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        interventionQueryList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apihandlestateQueryList(formQueryData).then(res => {
                    commit('setTeamMainQueryList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        interventionhandlestateQueryList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apihandlestateQueryList(formQueryData).then(res => {
                    commit('setTeamMainQueryList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        chaXunZhiBiao ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apichaXunZhiBiao(formQueryData).then(res => {
                    commit('setZhiBiaoNameList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        updateHandlestate ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiupdateHandlestate(formQueryData).then(res => {
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        chaXunQuHuaSto ({ commit }, formQueryData) {
            return new Promise((resolve, reject) => {
                apichaXunQuHua(formQueryData).then(res => {
                    commit('setQuHuaNameList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        chaXunGanYu ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                chaXun(formQueryData).then(res => {
                    commit('setTeamMainQueryList', res);
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
        setTeamMainQueryList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            console.log(data.rows);
            state.interventionList = data.rows;
        },
        setZhiBiaoNameList (state, data) {
            state.zhiBiaoQueryList = data;
        },
        setQuHuaNameList (state, data) {
            state.quHuaQueryList = data.result;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default interventionList;
