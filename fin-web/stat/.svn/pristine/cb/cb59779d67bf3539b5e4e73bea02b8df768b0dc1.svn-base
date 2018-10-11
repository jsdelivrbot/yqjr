import { apiTeamEventAddSub, apiQueryBySearchTeam } from '../../../../api/sale-team/team-event/teamEventApi';
import config from '@/config';

const teamEventAdd = {
    state: {
        teamEventAddData: [],
        searchTeamData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        isSuccess: true,
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleTeamEventAddSub ({ commit }, addTeamEventAdd) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiTeamEventAddSub(addTeamEventAdd).then(res => {
                    commit('setTeamEventAdd', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleQueryBySearchTeam ({ commit }, addTeamEventAddSearchData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryBySearchTeam(addTeamEventAddSearchData).then(res => {
                    commit('setTeamEventAddSeachData', res);
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
        setTeamEventAdd (state, data) {
            state.teamEventAddData = data.msg;
            state.isSuccess = data.isSuccess;
        },
        setTeamEventAddSeachData (state, data) {
            state.searchTeamData = data.result;
            state.isSuccess = data.isSuccess;
            state.teamEventAddData = data.msg;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default teamEventAdd;
