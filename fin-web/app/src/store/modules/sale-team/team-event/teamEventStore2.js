import {apiTeamList2, apiDelTeamList2, apiIndicatorTypes2} from '../../../../api/sale-team/team-event/teamEVentApi2.js';
import config from '@/config';

const teamList = {
    state: {
        teamList: [],
        indicatorTypes: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleTeamList2 ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiTeamList2(formQueryData).then(res => {
                    commit('setTeamList', res);
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
        handleIndicatorTypes2 ({ commit }, data) {
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
        handleDelTeamList2 ({ commit }, delTeamEventData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiDelTeamList2(delTeamEventData).then(res => {
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
        setIndicatorTypes (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
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

export default teamList;
