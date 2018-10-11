import {apiTeamMainQueryList, genJuZhiBiaoChaMingZiLuJing, chaXun, apiIName, apiMany, apiExcel} from '../../../../api/stat-warning/warning-warningInterveneNewsList/warningInterveneNewsListApi.js';
import config from '@/config';

const warningInterveneNewsListStore = {
    state: {
        teamMainQueryList: [],
        zhiBiaoQueryList: [],
        manyData: [],
        iName: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleIName ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiIName().then(res => {
                    commit('setName', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleMany ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiMany().then(res => {
                    commit('setMany', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleTeamMainQueryList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiTeamMainQueryList(formQueryData).then(res => {
                    commit('setTeamMainQueryList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleExcel ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiExcel().then(res => {
                    // commit('setMany', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        genJuZhiBiaoChaMingZi ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                genJuZhiBiaoChaMingZiLuJing(formQueryData).then(res => {
                    commit('setZhiBiaoList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        chaXunButten ({ commit }, formQueryData) {
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
        setName (state, data) {
            state.iName = data;
        },
        setMany (state, data) {
            state.manyData = data;
        },
        setTeamMainQueryList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.teamMainQueryList = data.rows;
        },
        setZhiBiaoList (state, data) {
            state.zhiBiaoQueryList = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default warningInterveneNewsListStore;
