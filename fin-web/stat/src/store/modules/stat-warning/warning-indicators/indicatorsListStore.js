import {
    apiTeamList,
    apiDelTeamList,
    apiIndicatorTypes,
    apiIndLevel,
    apiCom2
} from '../../../../api/stat-warning/warning-indicators/indicatorsApi.js';
import config from '@/config';

const indicatorsList = {
    state: {
        teamList: [],
        indLevel: [],
        com2: [],
        indicatorTypes: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelCom2 ({ commit }, f) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiCom2(f).then(res => {
                    commit('setCom2', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleTeamList({commit}, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiTeamList(formQueryData).then(res => {
                    commit('setTeamList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleIndLevel({commit}) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiIndLevel().then(res => {
                    commit('setIndLevel', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        /**
         * 点击查询按钮执行查询指标类型名
         */
        handleIndicatorTypes({commit}, data) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiIndicatorTypes(data).then(res => {
                    commit('setIndicatorTypes', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleDelTeamList({commit}, delTeamEventData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiDelTeamList(delTeamEventData).then(res => {
                    commit('setTeamEventDel', res);
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
        setCom2 (state, data) {
            state.com2 = data.result;
        },
        setIndLevel (state, data) {
            state.indLevel = data;
        },
        setIndicatorTypes (state, data) {
            state.indicatorTypes = data.rows;
        },
        setTeamList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.teamList = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default indicatorsList;
