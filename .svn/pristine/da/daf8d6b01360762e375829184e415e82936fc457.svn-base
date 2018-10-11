import {
    apiFeeReviewProAreaList, apiFeeReviewProBrandsList,
    apiFeeReviewProCityList, apiFeeReviewProModerList,
    apiFeeReviewProProvinceList, apiFeeReviewProSeriesList,
    apiQueryFeeReviewProByCode, apiFeeReviewProAllProductList,
    apiFeeReviewProToSubmit
} from '../../../../api/sale-fee/fee-review-progress/feeReviewProgressApi';
import config from '@/config';

const feeReviewProEdit = {
    state: {
        feeReviewProEditData: {},
        feeReviewProEditMainData: {},
        feeReviewProEditCarData: {},
        feeReviewProEditAreaListData: [],
        feeReviewProEditProvinceListData: [],
        feeReviewProEditCityListData: [],
        feeReviewProEditBrandsListData: [],
        feeReviewProEditSeriesListData: [],
        feeReviewProEditModerListData: [],
        feeReviewProEditAllProductListData: [],
        feeReviewProEditMsg: {},
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0, // 总页数
        isSuccess: true
    },
    actions: {
        handelQueryFeeReviewProEditByCode ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryFeeReviewProByCode(formQueryData).then(res => {
                    commit('setReviewProEditData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProEditProvinceList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProProvinceList().then(res => {
                    commit('setFeeReviewProEditProvinceList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProEditCityList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProCityList(formQueryData).then(res => {
                    commit('setFeeReviewProEditCityList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProEditAreaList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProAreaList().then(res => {
                    commit('setFeeReviewProEditAreaList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProEditBrandsList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProBrandsList().then(res => {
                    commit('setFeeReviewProEditBrandsList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProEditSeriesList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProSeriesList(formQueryData).then(res => {
                    commit('setFeeReviewProEditSeriesList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProEditModerList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProModerList(formQueryData).then(res => {
                    commit('setFeeReviewProEditModerList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProEditAllProductList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProAllProductList().then(res => {
                    commit('setFeeReviewProEditAllProductList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProToSubmit ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProToSubmit(formQueryData).then(res => {
                    commit('setFeeReviewProToSubmit', res);
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
        setReviewProEditData (state, data) {
            state.feeReviewProEditData = data.result;
            state.feeReviewProEditMainData = state.feeReviewProEditData.activeMain;
            state.feeReviewProEditCarData = state.feeReviewProEditData.activeCar;
            state.feeReviewProEditData.reviewStatus = '04';
            state.feeReviewProEditData.billFee = '';
            state.feeReviewProEditData.remark2 = '';
            state.isSuccess = data.isSuccess;
        },
        setFeeReviewProEditAreaList (state, data) {
            state.feeReviewProEditAreaListData = data.result;
            state.isSuccess = data.isSuccess;
        },
        setFeeReviewProEditProvinceList (state, data) {
            // console.log(data)
            state.feeReviewProEditProvinceListData = data.result;
            state.isSuccess = data.isSuccess;
        },
        setFeeReviewProEditCityList (state, data) {
            // console.log(data)
            state.feeReviewProEditCityListData = data.result;
            state.isSuccess = data.isSuccess;
        },
        setFeeReviewProEditBrandsList (state, data) {
            // console.log(data)
            state.feeReviewProEditBrandsListData = data.result;
            state.isSuccess = data.isSuccess;
        },
        setFeeReviewProEditSeriesList (state, data) {
            // console.log(data)
            state.feeReviewProEditSeriesListData = data.result;
            state.isSuccess = data.isSuccess;
        },
        setFeeReviewProEditModerList (state, data) {
            // console.log(data)
            state.feeReviewProEditModerListData = data.result;
            state.isSuccess = data.isSuccess;
        },
        setFeeReviewProEditAllProductList (state, data) {
            // console.log(data)
            state.feeReviewProEditAllProductListData = data.result;
            state.isSuccess = data.isSuccess;
        },
        setFeeReviewProToSubmit (state, data) {
            // console.log(data)
            state.feeReviewProEditMsg = data.code;
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
export default feeReviewProEdit;
