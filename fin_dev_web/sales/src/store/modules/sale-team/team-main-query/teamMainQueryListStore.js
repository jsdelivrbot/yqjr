import {apiTeamMainQueryList} from '../../../../api/sale-team/team-main-query/teamMainQueryApi';
import config from '@/config';

const teamMainList = {
    state: {
        teamMainQueryList: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
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
        }
    },
    mutations: {
        setTeamMainQueryList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.teamMainQueryList = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default teamMainList;
