import {apiQueryPersonMainById, apiPersonGradingHistoryQueryList, apiPersonMainChangeTrackQueryList, apiPersonMainChangeTrackQueryById,
    apiPersonMainQueryEvent, apiPersonMainQueryEventById} from '../../../../api/sale-person/person-main-query/personMainQueryApi';
import config from '@/config';
import {isEmpty, formatDate, compare} from '@/libs/util.js';
const personMainTabList = {
    state: {
        loading: false,
        personMainQueryViewData: {
            personTeam: '',
            teamMain: '',
            personCity: {
                provinceCode: [],
                cityCode: []
            },
            personBrand: {
                brandCode: []
            }
        },
        personMainQueryHisList: [],
        personMainQueryChangeList: [],
        personMainQueryChangeResultData: {
            personTeam: '',
            teamMain: '',
            personCity: {
                provinceCode: [],
                cityCode: []
            },
            personBrand: {
                brandCode: []
            }
        },
        personMainQueryEventList: [],
        personMainQueryEventResultData: {},
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0, // 总页数,
        isSuccess: '',
        msg: ''
    },
    actions: {
        handlePersonMainQueryMainList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryPersonMainById(formQueryData).then(res => {
                    commit('setpersonMainQueryViewData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        // 定级历史信息
        handlePersonMainQueryGradingHistory ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiPersonGradingHistoryQueryList(formQueryData).then(res => {
                    commit('setPersonQueryGradingHistoryList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        // 变更轨迹
        handlePersonMainQueryChangeTrack ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiPersonMainChangeTrackQueryList(formQueryData).then(res => {
                    commit('setPersonMainQueryChangeTrackList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        // 变更轨迹结果
        handlePersonMainQueryChangeTrackById ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiPersonMainChangeTrackQueryById(formQueryData).then(res => {
                    commit('setPersonMainQueryChangeTrack', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        // 重大事项记录
        handlePersonMainQueryEvent ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiPersonMainQueryEvent(formQueryData).then(res => {
                    commit('setPersonMainQueryEventList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        // 重大事项结果
        handlePersonMainQueryEventById ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiPersonMainQueryEventById(formQueryData).then(res => {
                    commit('setPersonMainQueryEvent', res);
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
        // tab1
        setpersonMainQueryViewData (state, data) {
            if (data.isSuccess) {
                state.isSuccess = true;
                state.msg = '查询成功';
                for (var item in data.result) {
                    state.personMainQueryViewData[item] = data.result[item];
                }
                state.personMainQueryViewData.personBirth = formatDate(new Date(state.personMainQueryViewData.personBirth), 'yyyy-MM-dd');
                state.personMainQueryViewData.personFirstworktime = formatDate(new Date(state.personMainQueryViewData.personFirstworktime), 'yyyy-MM-dd');
                state.personMainQueryViewData.personTeam.personCheckStart = formatDate(new Date(state.personMainQueryViewData.personTeam.personCheckStart), 'yyyy-MM-dd');
                state.personMainQueryViewData.personTeam.personCorrectime = formatDate(new Date(state.personMainQueryViewData.personTeam.personCorrectime), 'yyyy-MM-dd');
                state.personMainQueryViewData.personTeam.personJointime = formatDate(new Date(state.personMainQueryViewData.personTeam.personJointime), 'yyyy-MM-dd');
                state.personMainQueryViewData.personTeam.createTime = formatDate(new Date(state.personMainQueryViewData.personTeam.createTime), 'yyyy-MM-dd');
                state.personMainQueryViewData.personTeam.modifyTime = formatDate(new Date(state.personMainQueryViewData.personTeam.modifyTime), 'yyyy-MM-dd');
                state.personMainQueryViewData.personTeam.personTryEndtime = formatDate(new Date(state.personMainQueryViewData.personTeam.personTryEndtime), 'yyyy-MM-dd');
                state.personMainQueryViewData.personTeam.personTryStartime = formatDate(new Date(state.personMainQueryViewData.personTeam.personTryStartime), 'yyyy-MM-dd');
                state.personMainQueryViewData.personTeam.personUptime = formatDate(new Date(state.personMainQueryViewData.personTeam.personUptime), 'yyyy-MM-dd');
                if (!isEmpty(data.result.personBrand) && !isEmpty(data.result.personBrand.brandCode)) {
                    state.personMainQueryViewData.personBrand.brandCode = data.result.personBrand.brandCode.split(',');
                } else {
                    state.personMainQueryViewData.personBrand.brandCode = [];
                }
                if (!isEmpty(data.result.personCity) && !isEmpty(data.result.personCity.cityCode)) {
                    state.personMainQueryViewData.personCity.cityCode = data.result.personCity.cityCode.split(',');
                } else {
                    state.personMainQueryViewData.personCity.cityCode = [];
                }
                if (!isEmpty(data.result.personCity) && !isEmpty(data.result.personCity.provinceCode)) {
                    state.personMainQueryViewData.personCity.provinceCode = data.result.personCity.provinceCode.split(',');
                } else {
                    state.personMainQueryViewData.personCity.provinceCode = [];
                }
            } else {
                state.isSuccess = false;
                state.msg = '查询失败';
            }
        },
        // tab2
        setPersonQueryGradingHistoryList (state, data) {
            state.personMainQueryHisList = data.rows;
            for (var i = 0; i < state.personMainQueryHisList.length; i++) {
                state.personMainQueryHisList[i] = state.personMainQueryHisList[i].personTeam;
                state.personMainQueryHisList[i].createTime = formatDate(new Date(state.personMainQueryHisList[i].createTime), 'yyyy');
            }
        },
        // tab3
        setPersonMainQueryChangeTrackList (state, data) {
            if (data.isSuccess) {
                state.isSuccess = true;
                state.msg = '查询成功';
                state.personMainQueryChangeList = data.result;
                // 通过对createTime排序 找出最小的 即为新增
                var creatTimeArr = [];
                for (var k = 0; k < state.personMainQueryChangeList.length; k++) {
                    creatTimeArr.push(state.personMainQueryChangeList[k].createTime);
                }
                var newArr = creatTimeArr.sort(compare);
                for (var j = 0; j < state.personMainQueryChangeList.length; j++) {
                    if (state.personMainQueryChangeList[j].createTime === newArr[0]) {
                        state.personMainQueryChangeList[j].reviewFlag = 0;
                    }
                }
                // 判断当没有modifyTime时 为新增 并且把createTime的值赋给modifyTime
                for (var i = 0; i < state.personMainQueryChangeList.length; i++) {
                    if (isEmpty(state.personMainQueryChangeList[i].modifyTime)) {
                        state.personMainQueryChangeList[i].modifyTime = formatDate(new Date(state.personMainQueryChangeList[i].createTime), 'yyyy-MM-dd hh:mm:ss');
                        state.personMainQueryChangeList[i].reviewFlag = 0;
                    } else {
                        state.personMainQueryChangeList[i].modifyTime = formatDate(new Date(state.personMainQueryChangeList[i].modifyTime), 'yyyy-MM-dd hh:mm:ss');
                    }
                    state.personMainQueryChangeList[i].startTime = formatDate(new Date(state.personMainQueryChangeList[i].startTime), 'yyyy-MM-dd');
                }
            } else {
                state.isSuccess = false;
                state.msg = '查询失败';
            }
        },
        // tab3-details
        setPersonMainQueryChangeTrack (state, data) {
            for (var item in data.result) {
                state.personMainQueryChangeResultData[item] = data.result[item];
            }
            state.personMainQueryChangeResultData.personBirth = formatDate(new Date(state.personMainQueryChangeResultData.personBirth), 'yyyy-MM-dd');
            state.personMainQueryChangeResultData.personFirstworktime = formatDate(new Date(state.personMainQueryChangeResultData.personFirstworktime), 'yyyy-MM-dd');
            state.personMainQueryChangeResultData.personTeam.personCheckStart = formatDate(new Date(state.personMainQueryChangeResultData.personTeam.personCheckStart), 'yyyy-MM-dd');
            state.personMainQueryChangeResultData.personTeam.personCorrectime = formatDate(new Date(state.personMainQueryChangeResultData.personTeam.personCorrectime), 'yyyy-MM-dd');
            state.personMainQueryChangeResultData.personTeam.personJointime = formatDate(new Date(state.personMainQueryChangeResultData.personTeam.personJointime), 'yyyy-MM-dd');
            state.personMainQueryChangeResultData.personTeam.createTime = formatDate(new Date(state.personMainQueryChangeResultData.personTeam.createTime), 'yyyy-MM-dd');
            state.personMainQueryChangeResultData.personTeam.modifyTime = formatDate(new Date(state.personMainQueryChangeResultData.personTeam.modifyTime), 'yyyy-MM-dd');
            state.personMainQueryChangeResultData.personTeam.personTryEndtime = formatDate(new Date(state.personMainQueryChangeResultData.personTeam.personTryEndtime), 'yyyy-MM-dd');
            state.personMainQueryChangeResultData.personTeam.personTryStartime = formatDate(new Date(state.personMainQueryChangeResultData.personTeam.personTryStartime), 'yyyy-MM-dd');
            state.personMainQueryChangeResultData.personTeam.personUptime = formatDate(new Date(state.personMainQueryChangeResultData.personTeam.personUptime), 'yyyy-MM-dd');
            if (!isEmpty(data.result.personBrand) && !isEmpty(data.result.personBrand.brandCode)) {
                state.personMainQueryChangeResultData.personBrand.brandCode = data.result.personBrand.brandCode.split(',');
            } else {
                state.personMainQueryChangeResultData.personBrand.brandCode = [];
            }
            if (!isEmpty(data.result.personCity) && !isEmpty(data.result.personCity.cityCode)) {
                state.personMainQueryChangeResultData.personCity.cityCode = data.result.personCity.cityCode.split(',');
            } else {
                state.personMainQueryChangeResultData.personCity.cityCode = [];
            }
            if (!isEmpty(data.result.personCity) && !isEmpty(data.result.personCity.provinceCode)) {
                state.personMainQueryChangeResultData.personCity.provinceCode = data.result.personCity.provinceCode.split(',');
            } else {
                state.personMainQueryChangeResultData.personCity.provinceCode = [];
            }
        },
        // tab4
        setPersonMainQueryEventList (state, data) {
            state.personMainQueryEventList = data.rows;
            for (var i = 0; i < state.personMainQueryEventList.length; i++) {
                state.personMainQueryEventList[i].createTime = formatDate(new Date(state.personMainQueryEventList[i].createTime), 'yyyy-MM-dd');
                state.personMainQueryEventList[i].modifyTime = formatDate(new Date(state.personMainQueryEventList[i].modifyTime), 'yyyy-MM-dd');
                state.personMainQueryEventList[i].eventYear = formatDate(new Date(state.personMainQueryEventList[i].eventYear), 'yyyy');
            }
        },
        // tab4-details
        setPersonMainQueryEvent (state, data) {
            state.personMainQueryEventResultData = data.result;
            state.personMainQueryEventResultData.createTime = formatDate(new Date(state.personMainQueryEventResultData.createTime), 'yyyy-MM-dd');
            state.personMainQueryEventResultData.modifyTime = formatDate(new Date(state.personMainQueryEventResultData.modifyTime), 'yyyy-MM-dd');
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }

};
export default personMainTabList;
