import {apiFeeQueryActiveByCode,
    apiFeeQueryProvinceList,
    apiFeeQueryAreaList,
    apiFeeQueryCityList,
    apiFeeQuerySeriesList,
    apiFeeQueryModerList,
    apiFeeQueryAllProductList,
    apiFeeQueryBrandsList,
    apiFeeEditSubToRev
} from '../../../../api/sale-fee/fee-main/feeMainApi';
import config from '@/config';

const feeDoPayEdit = {
    state: {
        feeDoPayEditData: {},
        feeDoPayEditMainData: {},
        feeDoPayEditCarData: {},
        feeDoPayEditAreaListData: [],
        feeDoPayEditProvinceListData: [],
        feeDoPayEditCityListData: [],
        feeDoPayEditBrandsListData: [],
        feeDoPayEditSeriesListData: [],
        feeDoPayEditModerListData: [],
        feeDoPayEditAllProductListData: [],
        feeDoPayEditMsg: {},
        isSuccess: true,
        loading: false,
        pageNo: 1, // 当前页码
        pageSize:
        config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelFeeQueryActiveByCode ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeQueryActiveByCode(formQueryData).then(res => {
                    commit('setFeeQueryActiveByCode', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeQueryProvinceList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeQueryProvinceList().then(res => {
                    commit('setFeeQueryProvinceList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeQueryCityList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeQueryCityList(formQueryData).then(res => {
                    commit('setFeeQueryCityList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeQueryAreaList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeQueryAreaList().then(res => {
                    commit('setFeeQueryAreaList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeQueryBrandsList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeQueryBrandsList().then(res => {
                    commit('setFeeQueryBrandsList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeQuerySeriesList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeQuerySeriesList(formQueryData).then(res => {
                    commit('setFeeQuerySeriesList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeQueryModerList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeQueryModerList(formQueryData).then(res => {
                    commit('setFeeQueryModerList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelFeeQueryAllProductList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeQueryAllProductList().then(res => {
                    commit('setFeeQueryAllProductList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleFeeEditSubToRev ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFeeEditSubToRev(formQueryData).then(res => {
                    commit('setFeeEditSubToRev', res);
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
        setFeeQueryActiveByCode (state, data) {
            state.feeDoPayEditData = data.result;
            state.feeDoPayEditMainData = state.feeDoPayEditData.activeMain;
            state.feeDoPayEditCarData = state.feeDoPayEditData.activeCar;
        },
        setFeeQueryAreaList (state, data) {
            state.feeDoPayEditAreaListData = data.result;
        },
        setFeeQueryProvinceList (state, data) {
            // console.log(data)
            state.feeDoPayEditProvinceListData = data.result;
        },
        setFeeQueryCityList (state, data) {
            // console.log(data)
            state.feeDoPayEditCityListData = data.result;
        },
        setFeeQueryBrandsList (state, data) {
            // console.log(data)
            state.feeDoPayEditBrandsListData = data.result;
        },
        setFeeQuerySeriesList (state, data) {
            // data.result.push({
            //     'label': ' 全部',
            //     'value': '00'
            // });
            // console.log(data)
            state.feeDoPayEditSeriesListData = data.result;
        },
        setFeeQueryModerList (state, data) {
            // console.log(data)
            state.feeDoPayEditModerListData = data.result;
        },
        setFeeQueryAllProductList (state, data) {
            // console.log(data)
            state.feeDoPayEditAllProductListData = data.result;
        },
        setFeeEditSubToRev (state, data) {
            // console.log(data)
            state.feeDoPayEditMsg = data.msg;
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
export default feeDoPayEdit;
