import {
    apiFeeReviewAreaList, apiUpdateReviewStatus,
    apiFeeReviewBrandsList, apiFeeReviewCityList,
    apiFeeReviewModerList, apiFeeReviewProvinceList,
    apiFeeReviewSeriesList, apiQueryFeeReviewByCode,
    apiFeeReviewAllProductList, apiFeeReviewToSubmit
} from '../../../../api/sale-fee/fee-review/feeReviewApi';
import config from '@/config';

const feeReviewEdit = {
    state: {
        feeReviewEditData: {},
        feeReviewEditMainData: {},
        feeReviewEditCarData: {},
        feeReviewEditAreaListData: [],
        feeReviewEditProvinceListData: [],
        feeReviewEditCityListData: [],
        feeReviewEditBrandsListData: [],
        feeReviewEditSeriesListData: [],
        feeReviewEditModerListData: [],
        feeReviewEditAllProductListData: [],
        feeReviewEditMsg: {},
        isSuccess: false,
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelQueryFeeReviewEditByCode ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryFeeReviewByCode(formQueryData).then(res => {
                    commit('setFeeReviewEditData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelUpdateReviewStatus ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiUpdateReviewStatus(formQueryData).then(res => {
                    commit('setUpdateReviewStatus', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewEditProvinceList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProvinceList().then(res => {
                    commit('setFeeReviewEditProvinceList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewEditCityList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewCityList(formQueryData).then(res => {
                    commit('setFeeReviewEditCityList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewEditAreaList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewAreaList().then(res => {
                    commit('setFeeReviewEditAreaList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewEditBrandsList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewBrandsList().then(res => {
                    commit('setFeeReviewEditBrandsList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewEditSeriesList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewSeriesList(formQueryData).then(res => {
                    commit('setFeeReviewEditSeriesList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewEditModerList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewModerList(formQueryData).then(res => {
                    commit('setFeeReviewEditModerList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewEditAllProductList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewAllProductList().then(res => {
                    commit('setFeeReviewEditAllProductList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewToSubmit ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewToSubmit(formQueryData).then(res => {
                    commit('setFeeReviewToSubmit', res);
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
        setFeeReviewEditData (state, data) {
            state.feeReviewEditData = data.result;
            state.feeReviewEditMainData = state.feeReviewEditData.activeMain;
            state.feeReviewEditCarData = state.feeReviewEditData.activeCar;
            state.feeReviewEditData.reviewStatus = '04';
            state.feeReviewEditData.opinion = '同意';
        },
        setUpdateReviewStatus (state, data) {
            if (!data.isSuccess) {
                state.isSuccess = false;
                state.feeReviewEditMsg = data.msg;
            } else {
                state.isSuccess = true;
            }
        },
        setFeeReviewEditAreaList (state, data) {
            state.feeReviewEditAreaListData = data.result;
        },
        setFeeReviewEditProvinceList (state, data) {
            // console.log(data)
            state.feeReviewEditProvinceListData = data.result;
        },
        setFeeReviewEditCityList (state, data) {
            // console.log(data)
            state.feeReviewEditCityListData = data.result;
        },
        setFeeReviewEditBrandsList (state, data) {
            // console.log(data)
            state.feeReviewEditBrandsListData = data.result;
        },
        setFeeReviewEditSeriesList (state, data) {
            // console.log(data)
            state.feeReviewEditSeriesListData = data.result;
        },
        setFeeReviewEditModerList (state, data) {
            // console.log(data)
            state.feeReviewEditModerListData = data.result;
        },
        setFeeReviewEditAllProductList (state, data) {
            // console.log(data)
            state.feeReviewEditAllProductListData = data.result;
        },
        setFeeReviewToSubmit (state, data) {
            // console.log(data)
            state.feeReviewEditMsg = data.msg;
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
export default feeReviewEdit;
