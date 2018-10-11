import { apiTeamEventList, apiDelTeamEventList, apiIndicatorTypes2 } from '../../../../api/stat-warning/warning-indicatorRanges/indicatorRangesApi.js';
import config from '@/config';

const indicatorRangesList = {
    state: {
        teamEventListData: [],
        indicatorTypes: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleTeamEventList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiTeamEventList(formQueryData).then(res => {
                    commit('setTeamEventList', res);
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
        handleIndicatorTypes3 ({ commit }, data) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiIndicatorTypes2(data).then(res => {
                    commit('setIndicatorTypes', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleDelTeamEventList ({ commit }, delTeamEventData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiDelTeamEventList(delTeamEventData).then(res => {
                    // commit('setTeamEventDel', res);
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
        setIndicatorTypes (state, data) {
            state.indicatorTypes = data.rows;
        },
        setTeamEventList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.teamEventListData = data.rows;
        },
        setTeamEventDel (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.teamEventListData = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default indicatorRangesList;
