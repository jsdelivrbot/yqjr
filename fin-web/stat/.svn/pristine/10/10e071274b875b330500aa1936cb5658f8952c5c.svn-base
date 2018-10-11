import {
    apiAddM,
    apiQueryBySearchTeam,
    apiQueryTeamEvent, apiIT, apiNames, apiCode, apiData, apiIntId
} from '../../../../api/stat-warning/warning-indicatorRanges/indicatorRangesApi.js';
import config from '@/config';

const indicatorRangesAdd = {
    state: {
        teamEAddData: [],
        tData: [],
        tData1: [],
        iCodes: [],
        iTypes: [],
        iNames: [],
        searchTeamData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        isSuccess: true,
        msg: '',
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelselNames  ({ commit }, f) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiNames(f).then(res => {
                    commit('setNames', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelselCode  ({ commit }, kd) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiCode(kd).then(res => {
                    commit('setCode', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelIntId ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiIntId(formQueryData).then(res => {
                    commit('setIntId', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleAdd1 ({ commit }, fData) {
            commit('sendin');
            // formQueryData.startTime = formatDate(formQueryData.startTime, 'yyyy-MM-dd');
            // console.log(formQueryData.startTime)
            return new Promise((resolve, reject) => {
                apiAddM(fData).then(res => {
                    commit('setAData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelQueryTeamEvent ({ commit }, f) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamEvent(f).then(res => {
                    commit('setTView', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelData ({ commit }, f) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiData(f).then(res => {
                    commit('setTView1', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleIT ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiIT().then(res => {
                    commit('setITypes', res);
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
        setCode (state, data) {
            state.iCodes = data;
        },
        setNames (state, data) {
            state.iNames = data;
        },
        setITypes (state, data) {
            state.iTypes = data;
        },
        setTView (state, data) {
            state.tData = data.result;
        },
        setTView1 (state, data) {
            state.tData1 = data.result;
        },
        setAData (state, data) {
            state.teamEAddData = data.msg;
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
        },
        setIntId (state, data) {
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
        }
    }
};
export default indicatorRangesAdd;
