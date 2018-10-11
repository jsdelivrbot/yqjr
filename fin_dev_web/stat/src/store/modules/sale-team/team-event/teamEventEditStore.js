import { apiQueryTeamEventById, apiTeamEventEditSubToRev } from '../../../../api/sale-team/team-event/teamEventApi';
import config from '@/config';

const teamEventEdit = {
    state: {
        teamEventEditData: {},
        teamEventEditMsg: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        isSuccess: true,
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelQueryTeamEventById ({ commit }, queryTeamEventEdit) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamEventById(queryTeamEventEdit).then(res => {
                    commit('setTeamEventEdit', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleTeamEventEditSubToRev ({ commit }, subTeamEventEdit) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiTeamEventEditSubToRev(subTeamEventEdit).then(res => {
                    commit('setTeamEventMsg', res);
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
        setTeamEventEdit (state, data) {
            state.teamEventEditData = data.rows[0];
            state.teamEventEditMsg = data.msg;
        },
        setTeamEventMsg (state, data) {
            state.teamEventEditMsg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default teamEventEdit;
