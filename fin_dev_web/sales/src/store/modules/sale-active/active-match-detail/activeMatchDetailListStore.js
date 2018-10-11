import config from '@/config';
import {apiActiveSearchDate, apiSearchSelectBrandsCodeList, apiSearchSeriesCodeList, apiSearchCarBrandTypeList, apiSearchActiveCodeListforActive} from '../../../../api/sale-active/active-match-detail/activeMatchDetailListApi';
const activeMatchDetailList = {
    state: {
        activeMatchVoDate: [],
        total: 0, // 总页数
        records: 0, // 总记录数
        loading: false,
        brandsCodeList: [],
        seriesCodeList: [],
        carBrandTypeList: [],
        isSuccess: false,
        pageNo: 1,
        pageSize: config.pageSize,
        activeCodeList: [],
        msg: '',
        code: '',
        page: '' // 当前页码
    },
    actions: {
        handleSearchDate ({commit}, queryList) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveSearchDate(queryList).then(res => {
                    commit('setDate', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        selectBrandsCodeList ({commit}) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSearchSelectBrandsCodeList().then(res => {
                    commit('setBrandsCodeList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        searchSeriesCodeList ({commit}, data) {
            return new Promise((resolve, reject) => {
                var isUpCode;
                if (data === '00') {
                    isUpCode = 0;
                } else {
                    isUpCode = 1;
                }
                apiSearchSeriesCodeList(data, isUpCode).then(res => {
                    commit('setSeriesCodeList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        searchCarBrandList ({commit}, data) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                var isUpCode;
                if (data === '00') {
                    isUpCode = 0;
                } else {
                    isUpCode = 1;
                }
                apiSearchCarBrandTypeList(data, isUpCode).then(res => {
                    commit('setCarBrandList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        searchActiveCodeList ({commit}, data) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSearchActiveCodeListforActive(data).then(res => {
                    commit('setActiveCode', res);
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
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        },
        setDate (state, res) {
            state.pageNo = res.page;
            state.records = res.records;
            state.total = res.total;
            state.activeMatchVoDate = res.rows;
        },
        setBrandsCodeList (state, res) {
            state.brandsCodeList = res.result;
            state.isSuccess = res.isSuccess;
            state.code = res.code;
            state.msg = res.msg;
        },
        setSeriesCodeList (state, res) {
            state.seriesCodeList = res.result;
            state.isSuccess = res.isSuccess;
            state.code = res.code;
            state.msg = res.msg;
        },
        setCarBrandList (state, data) {
            state.carBrandTypeList = data.result;
            state.isSuccess = data.isSuccess;
            state.code = data.code;
            state.msg = data.msg;
        },
        setActiveCode (state, data) {
            if (data.isSuccess) {
                state.activeCodeList = data.result;
                state.isSuccess = data.isSuccess;
                state.code = data.code;
                state.msg = data.msg;
            }
        }
    }
};
export default activeMatchDetailList;
