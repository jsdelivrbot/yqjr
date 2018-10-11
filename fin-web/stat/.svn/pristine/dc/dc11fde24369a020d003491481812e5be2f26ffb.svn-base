import { apiQueryTeamEventById } from '../../../../api/sale-team/team-event/teamEventApi';
import config from '@/config';

const teamEventView = {
    state: {
        teamEventViewData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize:
        config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelQueryTeamEventById ({ commit }, queryTeamEventView) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamEventById(queryTeamEventView).then(res => {
                    commit('setTeamEventView', res);
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
        setTeamEventView (state, data) {
            state.teamEventViewData = data.rows[0];
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default teamEventView;
