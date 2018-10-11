import { apiTeamEventList, apiDelTeamEventList } from '../../../../api/sale-team/team-event/teamEventApi';
import config from '@/config';
import {formatDate} from '@/libs/util.js';

const teamEventList = {
    state: {
        teamEventListData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleTeamEventList ({ commit }, queryTeamEventData) {
            commit('sendin');
            queryTeamEventData.eventYear = formatDate(queryTeamEventData.eventYear, 'yyyy');
            return new Promise((resolve, reject) => {
                apiTeamEventList(queryTeamEventData).then(res => {
                    commit('setTeamEventList', res);
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
export default teamEventList;
