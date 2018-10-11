import {
    apiQueryActiveReviewProEditById, apiActiveReviewProProvinceList,
    apiActiveReviewProCityList, apiActiveReviewProSeriesList,
    apiActiveReviewProAllProductList, apiActiveReviewProModerList,
    apiActiveReviewProBrandsList, apiActiveReviewProAreaList,
    apiActiveReviewToSubmit
} from '../../../../api/sale-active/active-review-progress/activeReviewProgressApi';
import {apiOptionSubBrand, apiOptionCarModel} from '../../../../api/sale-option/option-brand/optionBrandApi';
import config from '@/config';
import {isEmpty} from '../../../../libs/util';

const activeReviewProEdit = {
    state: {
        activeReviewProEditData: {},
        activeReviewProEditMainData: {},
        activeReviewProEditCarData: {},
        activeReviewProEditAddData: {},
        activeReviewProEditAreaListData: [],
        activeReviewProEditProvinceListData: [],
        activeReviewProEditCityListData: [],
        activeReviewProEditBrandsListData: [],
        activeReviewProEditSeriesListData: [],
        activeReviewProEditModerListData: [],
        activeReviewProEditAllProductListData: [],
        activeReviewProEditMsg: {},
        seriesList: [],
        modelList: [],
        isSuccess: false,
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelQueryActiveReviewProEditById ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryActiveReviewProEditById(formQueryData).then(res => {
                    commit('setActiveReviewProEdit', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProEditProvinceList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProProvinceList().then(res => {
                    commit('setActiveReviewProEditProvinceList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProEditCityList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProCityList(formQueryData).then(res => {
                    commit('setActiveReviewProEditCityList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProEditAreaList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProAreaList().then(res => {
                    commit('setActiveReviewProEditAreaList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProEditBrandsList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProBrandsList().then(res => {
                    commit('setActiveReviewProEditBrandsList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProEditSeriesList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProSeriesList(formQueryData).then(res => {
                    commit('setActiveReviewProEditSeriesList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProEditModerList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProModerList(formQueryData).then(res => {
                    commit('setActiveReviewProEditModerList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProEditAllProductList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProAllProductList().then(res => {
                    commit('setActiveReviewProEditAllProductList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewToSubmit ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewToSubmit(formQueryData).then(res => {
                    commit('setActiveReviewToSubmit', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelQuerySubBrands ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiOptionSubBrand(formQueryData).then(res => {
                    commit('setQuerySubBrands', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelQueryCarModel ({ commit }, data) {
            return new Promise((resolve, reject) => {
                apiOptionCarModel(data).then(res => {
                    commit('setCarModelOptions', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        }
    },
    mutations: {
        setActiveReviewProEdit (state, data) {
            state.activeReviewProEditData = data.result;
            state.activeReviewProEditMainData = state.activeReviewProEditData.ativeMain;
            state.activeReviewProEditCarData = state.activeReviewProEditData.activeCar;
            state.activeReviewProEditAddData = state.activeReviewProEditData.activeAdditional;
            console.log(state.activeReviewProEditData);
            // console.log(state.activeReviewProEditMainData)
        },
        setActiveReviewProEditAreaList (state, data) {
            state.activeReviewProEditAreaListData = data.result;
        },
        setActiveReviewProEditProvinceList (state, data) {
            // console.log(data)
            state.activeReviewProEditProvinceListData = data.result;
        },
        setActiveReviewProEditCityList (state, data) {
            // console.log(data)
            state.activeReviewProEditCityListData = data.result;
        },
        setActiveReviewProEditBrandsList (state, data) {
            state.activeReviewProEditBrandsListData = data.result;
            // console.log(state.ActiveReviewProEditBrandsListData)
        },
        setActiveReviewProEditSeriesList (state, data) {
            // console.log(data)
            state.activeReviewProEditSeriesListData = data.result;
        },
        setActiveReviewProEditModerList (state, data) {
            // console.log(data)
            state.activeReviewProEditModerListData = data.result;
        },
        setActiveReviewProEditAllProductList (state, data) {
            // console.log(data)
            state.activeReviewProEditAllProductListData = data.result;
        },
        setActiveReviewToSubmit (state, data) {
            // console.log(data)
            state.activeReviewProEditMsg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        setQuerySubBrands (state, data) {
            state.seriesList = data.result;
        },
        setCarModelOptions (state, data) {
            state.modelList = data.result;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default activeReviewProEdit;
