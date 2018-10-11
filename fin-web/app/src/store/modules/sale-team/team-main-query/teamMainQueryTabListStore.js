import {apiQueryTeamMainById, apiTeamMainQueryPerson, apiTeamMainQueryHis,
            apiTeamMainQueryHisByid, apiTeamMainQueryEvent, apiTeamMainQueryEventById} from '../../../../api/sale-team/team-main-query/teamMainQueryApi';
import config from '@/config';

const teamMainTabList = {
    state: {
        teamMainQueryViewList: [],
        teamMainQueryPersonList: [],
        teamMainQueryHisList: [],
        teamMainQueryHisResult: [],
        teamMainQueryEventList: [],
        teamMainQueryEventResult: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleTeamMainQueryMainList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamMainById(formQueryData).then(res => {
                    commit('setTeamMainQueryViewList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleTeamMainQueryPerson ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiTeamMainQueryPerson(formQueryData).then(res => {
                    commit('setTeamMainQueryPersonList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleTeamMainQueryHis ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiTeamMainQueryHis(formQueryData).then(res => {
                    commit('setTeamMainQueryHisList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },

        handleTeamMainQueryHisByid ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiTeamMainQueryHisByid(formQueryData).then(res => {
                    commit('setTeamMainQueryHis', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },

        handleTeamMainQueryEvent ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiTeamMainQueryEvent(formQueryData).then(res => {
                    commit('setTeamMainQueryEventList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },

        handleTeamMainQueryEventById ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiTeamMainQueryEventById(formQueryData).then(res => {
                    commit('setTeamMainQueryEvent', res);
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
        setTeamMainQueryViewList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.teamMainQueryViewList = data.rows[0];
        },
        setTeamMainQueryPersonList (state, data) {
            state.teamMainQueryPersonList = data.result;
        },
        setTeamMainQueryHisList (state, data) {
            state.teamMainQueryHisList = data.result;
        },
        setTeamMainQueryHis (state, data) {
            state.teamMainQueryHisResult = data.result;
        },
        setTeamMainQueryEventList (state, data) {
            state.teamMainQueryEventList = data.result;
        },
        setTeamMainQueryEvent (state, data) {
            state.teamMainQueryEventResult = data.result;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }

};
export default teamMainTabList;
