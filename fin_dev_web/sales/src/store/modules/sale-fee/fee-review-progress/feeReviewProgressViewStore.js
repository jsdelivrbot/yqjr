import {
    apiQueryFeeReviewProByCode,
    apiFeeReviewProProvinceList,
    apiFeeReviewProCityList,
    apiFeeReviewProAreaList,
    apiFeeReviewProBrandsList,
    apiFeeReviewProSeriesList,
    apiFeeReviewProModerList,
    apiFeeReviewProAllProductList,
    apiQueryFeeReviewProViewWork
} from '../../../../api/sale-fee/fee-review-progress/feeReviewProgressApi';
import config from '@/config';

const feeReviewProView = {
    state: {
        feeReviewProViewData: {},
        feeReviewProViewMainData: {},
        feeReviewProViewCarData: {},
        feeReviewProViewResult: [],
        feeReviewProViewAreaListData: [],
        feeReviewProViewProvinceListData: [],
        feeReviewProViewCityListData: [],
        feeReviewProViewBrandsListData: [],
        feeReviewProViewSeriesListData: [],
        feeReviewProViewModerListData: [],
        feeReviewProViewAllProductListData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelQueryFeeReviewProByCode ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryFeeReviewProByCode(formQueryData).then(res => {
                    commit('setQueryFeeReviewProByCode', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProProvinceList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProProvinceList().then(res => {
                    commit('setFeeReviewProProvinceList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProCityList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProCityList(formQueryData).then(res => {
                    commit('setFeeReviewProCityList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProAreaList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProAreaList().then(res => {
                    commit('setFeeReviewProAreaList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProBrandsList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProBrandsList().then(res => {
                    commit('setFeeReviewProBrandsList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProSeriesList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProSeriesList(formQueryData).then(res => {
                    commit('setFeeReviewProSeriesList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProModerList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProModerList(formQueryData).then(res => {
                    commit('setFeeReviewProModerList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeReviewProAllProductList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeReviewProAllProductList().then(res => {
                    commit('setFeeReviewProAllProductList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelQueryFeeReviewProViewWork ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryFeeReviewProViewWork(formQueryData).then(res => {
                    commit('setQueryFeeReviewProViewWork', res);
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
        setQueryFeeReviewProByCode (state, data) {
            state.feeReviewProViewData = data.result;
            state.feeReviewProViewMainData = state.feeReviewProViewData.activeMain;
            state.feeReviewProViewCarData = state.feeReviewProViewData.activeCar;
            console.log(state.feeReviewProViewData);
        },
        setFeeReviewProAreaList (state, data) {
            state.feeReviewProViewAreaListData = data.result;
        },
        setFeeReviewProProvinceList (state, data) {
            // console.log(data)
            state.feeReviewProViewProvinceListData = data.result;
        },
        setFeeReviewProCityList (state, data) {
            // console.log(data)
            state.feeReviewProViewCityListData = data.result;
        },
        setFeeReviewProBrandsList (state, data) {
            // console.log(data)
            state.feeReviewProViewBrandsListData = data.result;
        },
        setFeeReviewProSeriesList (state, data) {
            state.feeReviewProViewSeriesListData = data.result;
            console.log(state.feeReviewProViewSeriesListData)
        },
        setFeeReviewProModerList (state, data) {
            // console.log(data)
            state.feeReviewProViewModerListData = data.result;
        },
        setFeeReviewProAllProductList (state, data) {
            // console.log(data)
            state.feeReviewProViewAllProductListData = data.result;
        },
        setQueryFeeReviewProViewWork (state, data) {
            // console.log(data)
            state.feeReviewProViewResult = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default feeReviewProView;
