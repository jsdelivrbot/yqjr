import {apiTeamList} from '../../../../api/sale-team/team-maintenance/teamMainTenanceApi';
import config from '@/config';

const teamList = {
    state: {
        teamList: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleTeamList ({ commit }, formQueryData) {
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
        }
    },
    mutations: {
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
