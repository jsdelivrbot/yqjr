import {apiTeamPlanQueryBrandsList, apiQueryTeamPlanTrackList, apiQueryTeamPlanTrackName, apiCheckTeamCodeExist, apiSearchTeamName} from '../../../../api/sale-team/team-plan-track/teamPlanTrackApi';
import {isEmpty} from '@/libs/util.js';
const teamPlanTrackList = {
    state: {
        teamPlanTrackBrandsList: [],
        queryTeamPlanTrackList: [],
        QueryTeamPlanTrackExit: [],
        teamNameList: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: 20, // 每页记录数
        total: 0, // 总记录数
        pages: 0, // 总页数
        msg: '成功',
        name: '',
        isSuccess: true
    },
    actions: {
        handleCheckTeamCodeExist ({commit}, teamCode) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiCheckTeamCodeExist(teamCode).then(res => {
                    commit('setIsSucess', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleTeamPlanQueryBrandsList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiTeamPlanQueryBrandsList().then(res => {
                    commit('setTeamPlanQueryBrandsList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleQueryTeamPlanTrackList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamPlanTrackList(formQueryData).then(res => {
                    commit('setQueryTeamPlanTrackList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleQueryTeamPlanTrackName ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamPlanTrackName(formQueryData).then(res => {
                    commit('setQueryTeamPlanTrackName', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        /**
         * 模糊查询
         */
        handelSearchTeamName ({commit}, data) {
            console.log('join stort');
            console.log(data);
            return new Promise((resolve, reject) => {
                commit('sendin');
                apiSearchTeamName(data).then(res => {
                    commit('setTeamDatas', res);
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
        setTeamPlanQueryBrandsList (state, data) {
            if (!isEmpty(data.result)) {
                data.result.unshift({
                    'headLetter': '',
                    'label': ' 全部',
                    'value': ''
                });
                // console.log(data.result);
                state.teamPlanTrackBrandsList = data.result;
            } else {
                state.teamPlanTrackBrandsList = [];
            }
            state.isSuccess = data.isSuccess;
        },
        setQueryTeamPlanTrackList (state, data) {
            // console.log(data.rows);
            if (!isEmpty(data.rows)) {
                state.queryTeamPlanTrackList = data.rows;
                state.total = data.records;
                state.pages = data.total;
            } else {
                state.queryTeamPlanTrackList = [];
            }
            state.isSuccess = data.isSuccess;
        },
        setQueryTeamPlanTrackName (state, data) {
            if (data !== '') {
                state.name = data;
            } else {
                state.name = '';
            }
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        },
        setIsSucess (state, res) {
            state.isSuccess = res.isSuccess;
        },
        setTeamDatas (state, data) {
            state.teamNameList = data.result;
            state.isSuccess = data.isSuccess;
            state.code = data.code;
        }
    }
};
export default teamPlanTrackList;
