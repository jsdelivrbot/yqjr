import {apiPersonPlanTrackList, apiPersonPlanTrackSearchName, apiCheckPersonCodeExist, apiSearchName} from '../../../../api/sale-person/person-plan-track/personPlanTrackApi';
import config from '@/config';
import {isEmpty} from '@/libs/util.js';
import {apiTeamPlanQueryBrandsList} from '../../../../api/sale-team/team-plan-track/teamPlanTrackApi';
const personPlanTrackList = {
    state: {
        personPlanTrackData: [],
        personPlanTrackBrandsList: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0, // 总页数
        msg: '成功',
        name: '',
        isSuccess: true,
        code: '',
        searchMes: []
    },
    actions: {
        handleCheckPersonCodeExist ({commit}, personCode) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                // console.log(111)
                apiCheckPersonCodeExist(personCode).then(res => {
                    // console.log(222)
                    commit('setIsSucess', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handlePersonPlanTrackName ({commit}, code) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiPersonPlanTrackSearchName(code).then(res => {
                    commit('setName', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handlePersonPlanQueryBrandsList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiTeamPlanQueryBrandsList().then(res => {
                    commit('setPersonPlanQueryBrandsList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handlePersonPlanTrack ({commit}, queryDate) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiPersonPlanTrackList(queryDate).then(res => {
                    commit('setPersonPlanTrackDate', res);
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
        handelSearchPerosnName ({commit}, data) {
            console.log('join stort');
            console.log(data);
            return new Promise((resolve, reject) => {
                commit('sendin');
                apiSearchName(data).then(res => {
                    console.log('join api');
                    commit('setDatas', res);
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
        setPersonPlanQueryBrandsList (state, data) {
            if (!isEmpty(data.result)) {
                data.result.unshift({
                    'headLetter': '',
                    'label': ' 全部',
                    'value': ''
                });
                // console.log(data.result);
                state.personPlanTrackBrandsList = data.result;
            } else {
                state.personPlanTrackBrandsList = [];
            }
            state.isSuccess = data.isSuccess;
        },
        sendin (state) {
            state.loading = true;
        },
        setPersonPlanTrackDate (state, data) {
            state.personPlanTrackData = data.rows;
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
        },
        success (state) {
            state.loading = false;
        },
        setName (state, res) {
            if (res !== '') {
                state.name = res;
            } else {
                state.name = '';
            }
        },
        setIsSucess (state, res) {
            state.isSuccess = res.isSuccess;
        },
        setDatas (state, data) {
            state.searchMes = data.result;
            state.isSuccess = data.isSuccess;
            state.code = data.code;
        }
    }
};
export default personPlanTrackList;
