import { apiTeamAddToReview, apiValidateTeamName } from '../../../../api/sale-team/team-maintenance/teamMainTenanceApi';
import config from '@/config';

const teamAdd = {
    state: {
        teamAddData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize:
        config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0, // 总页数
        isSuccess: true
    },
    actions: {
        handleTeamAddToRev ({ commit }, formQueryData) {
            commit('sendin');
            console.log(formQueryData.startTime)
            return new Promise((resolve, reject) => {
                apiTeamAddToReview(formQueryData).then(res => {
                    commit('setTeamAddData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleValidateTeamName ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiValidateTeamName(formQueryData).then(res => {
                    commit('setValidateTeamName', res);
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
        setTeamAddData (state, data) {
            state.teamAddData = data.msg;
            state.isSuccess = data.isSuccess;
        },
        setValidateTeamName (state, data) {
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
export default teamAdd;
