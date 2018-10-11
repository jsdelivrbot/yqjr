import {
    apiQueryFeeReviewByCode,
    apiFeeReviewProvinceList,
    apiFeeReviewCityList,
    apiFeeReviewAreaList,
    apiFeeReviewBrandsList,
    apiFeeReviewSeriesList,
    apiFeeReviewModerList,
    apiFeeReviewAllProductList,
    apiQueryFeeReviewViewWork
} from '../../../../api/sale-fee/fee-review/feeReviewApi';
import config from '@/config';

const feeReviewView = {
    state: {
        feeReviewViewData: {},
        feeReviewViewMainData: {},
        feeReviewViewCarData: {},
        feeReviewViewResult: [],
        feeReviewViewAreaListData: [],
        feeReviewViewProvinceListData: [],
        feeReviewViewCityListData: [],
        feeReviewViewBrandsListData: [],
        feeReviewViewSeriesListData: [],
        feeReviewViewModerListData: [],
        feeReviewViewAllProductListData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelQueryFeeReviewByCode ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryFeeReviewByCode(formQueryData).then(res => {
                    commit('setQueryFeeReviewByCode', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProvinceList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProvinceList().then(res => {
                    commit('setFeeReviewProvinceList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewCityList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewCityList(formQueryData).then(res => {
                    commit('setFeeReviewCityList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewAreaList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewAreaList().then(res => {
                    commit('setFeeReviewAreaList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewBrandsList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewBrandsList().then(res => {
                    commit('setFeeReviewBrandsList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewSeriesList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewSeriesList(formQueryData).then(res => {
                    commit('setFeeReviewSeriesList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewModerList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewModerList(formQueryData).then(res => {
                    commit('setFeeReviewModerList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewAllProductList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewAllProductList().then(res => {
                    commit('setFeeReviewAllProductList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelQueryFeeReviewViewWork ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryFeeReviewViewWork(formQueryData).then(res => {
                    commit('setQueryFeeReviewViewWork', res);
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
        setQueryFeeReviewByCode (state, data) {
            state.feeReviewViewData = data.result;
            state.feeReviewViewMainData = state.feeReviewViewData.activeMain;
            state.feeReviewViewCarData = state.feeReviewViewData.activeCar;
            console.log(state.feeReviewViewData);
        },
        setFeeReviewAreaList (state, data) {
            state.feeReviewViewAreaListData = data.result;
        },
        setFeeReviewProvinceList (state, data) {
            // console.log(data)
            state.feeReviewViewProvinceListData = data.result;
        },
        setFeeReviewCityList (state, data) {
            // console.log(data)
            state.feeReviewViewCityListData = data.result;
        },
        setFeeReviewBrandsList (state, data) {
            // console.log(data)
            state.feeReviewViewBrandsListData = data.result;
        },
        setFeeReviewSeriesList (state, data) {
            // console.log(data)
            state.feeReviewViewSeriesListData = data.result;
        },
        setFeeReviewModerList (state, data) {
            // console.log(data)
            state.feeReviewViewModerListData = data.result;
        },
        setFeeReviewAllProductList (state, data) {
            // console.log(data)
            state.feeReviewViewAllProductListData = data.result;
        },
        setQueryFeeReviewViewWork (state, data) {
            // console.log(data)
            state.feeReviewViewResult = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default feeReviewView;
