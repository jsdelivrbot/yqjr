import {apiQueryActiveReviewProById, apiActiveReviewProProvinceList,
    apiActiveReviewProCityList, apiActiveReviewProBrandsList,
    apiActiveReviewProAreaList, apiActiveReviewProSeriesList,
    apiActiveReviewProModerList, apiActiveReviewProAllProductList,
    apiQueryActiveReviewProViewWork} from '../../../../api/sale-active/active-review-progress/activeReviewProgressApi';
import config from '@/config';

const activeReviewProView = {
    state: {
        activeReviewProViewData: {},
        activeReviewProViewMainData: {},
        activeReviewProViewCarData: {},
        activeReviewProViewResult: [],
        activeReviewProViewAreaListData: [],
        activeReviewProViewProvinceListData: [],
        activeReviewProViewCityListData: [],
        activeReviewProViewBrandsListData: [],
        activeReviewProViewSeriesListData: [],
        activeReviewProViewModerListData: [],
        activeReviewProViewAllProductListData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: 100, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelQueryActiveReviewProById ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryActiveReviewProById(formQueryData).then(res => {
                    commit('setQueryActiveReviewProByCode', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProProvinceList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProProvinceList().then(res => {
                    commit('setActiveReviewProProvinceList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProCityList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProCityList(formQueryData).then(res => {
                    commit('setActiveReviewProCityList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProAreaList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProAreaList().then(res => {
                    commit('setActiveReviewProAreaList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProBrandsList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProBrandsList().then(res => {
                    commit('setActiveReviewProBrandsList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProSeriesList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProSeriesList(formQueryData).then(res => {
                    commit('setActiveReviewProSeriesList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProModerList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProModerList(formQueryData).then(res => {
                    commit('setActiveReviewProModerList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProAllProductList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProAllProductList().then(res => {
                    commit('setActiveReviewProAllProductList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelQueryActiveReviewProViewWork ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryActiveReviewProViewWork(formQueryData).then(res => {
                    commit('setQueryActiveReviewProViewWork', res);
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
        setQueryActiveReviewProByCode (state, data) {
            state.activeReviewProViewData = data.result;
            state.activeReviewProViewMainData = state.activeReviewProViewData.ativeMain;
            state.activeReviewProViewCarData = state.activeReviewProViewData.activeCar;
            console.log(state.activeReviewProViewData);
        },
        setActiveReviewProAreaList (state, data) {
            state.activeReviewProViewAreaListData = data.result;
        },
        setActiveReviewProProvinceList (state, data) {
            // console.log(data)
            state.activeReviewProViewProvinceListData = data.result;
        },
        setActiveReviewProCityList (state, data) {
            // console.log(data)
            state.activeReviewProViewCityListData = data.result;
        },
        setActiveReviewProBrandsList (state, data) {
            // console.log(data)
            state.activeReviewProViewBrandsListData = data.result;
        },
        setActiveReviewProSeriesList (state, data) {
            state.activeReviewProViewSeriesListData = data.result;
        },
        setActiveReviewProModerList (state, data) {
            // console.log(data)
            state.activeReviewProViewModerListData = data.result;
        },
        setActiveReviewProAllProductList (state, data) {
            // console.log(data)
            state.activeReviewProViewAllProductListData = data.result;
        },
        setQueryActiveReviewProViewWork (state, data) {
            // console.log(data)
            state.activeReviewProViewResult = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default activeReviewProView;
