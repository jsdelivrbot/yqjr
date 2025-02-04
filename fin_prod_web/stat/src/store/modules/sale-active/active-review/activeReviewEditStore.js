import {apiSearchActiveReviewDate, apiActiveReviewProvinceList, apiActiveReviewAreaList, apiSearchCityByProvince,
    apiSearchBrandsList, apiSearchSeriessList, apiSearchModerList, apiActiveReviewAllProductList, apiSendReviewAction, apiChangeStatus} from '../../../../api/sale-active/active-review/activeReviewListApi';

const activeReviewEdit = {
    state: {
        activeReviewViewDataResult: {
            ativeMain: {}
        },
        activeReviewCheckDate: {},
        activeReviewViewData: {},
        activeReviewViewMainData: {},
        activeReviewViewCarData: {},
        activeReviewViewResult: [],
        activeReviewViewAreaListData: [], // 所有area集合
        activeReviewViewProvinceListData: [], // 所有省份集合
        activeReviewViewCityListData: [],
        activeReviewViewBrandsListData: [],
        activeReviewViewSeriesListData: [],
        activeReviewViewModerListData: [],
        activeReviewViewAllProductListData: [],
        loading: false,
        code: '',
        msg: '',
        isSuccess: false
    },
    actions: {
        handleSearchDateById ({commit}, data) {
            return new Promise((resolve, reject) => {
                commit('sendin');
                apiSearchActiveReviewDate(data).then(res => {
                    console.log(111111111);
                    console.log(res);
                    commit('setData', res);
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
                apiActiveReviewAreaList().then(res => {
                    commit('setActiveReviewAreaList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        /**
         * 加载所有省份信息
         * @param commit
         * @returns {Promise<any>}
         */
        handleSearchProvinceList ({commit}) {
            return new Promise((resolve, reject) => {
                commit('sendin');
                apiActiveReviewProvinceList().then(res => {
                    commit('setProvinceList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        /**
         * 查找区域
         * @param commit
         * @returns {Promise<any>}
         */
        handelActiveReviewAreaList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewAreaList().then(res => {
                    commit('setActiveReviewAreaList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        /**
         * 根据省份加载城市
         */
        handleSearchCityList ({commit}, data) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSearchCityByProvince(data).then(res => {
                    commit('setCityList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        /**
         * 根据活动品牌加载子品牌
         */
        handleSearchSeriesList ({commit}, data) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSearchSeriessList(data).then(res => {
                    commit('setSeriessList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        /**
         * 加载所有品牌
         */
        handleSearchBrandsList ({commit}) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSearchBrandsList().then(res => {
                    commit('setBrandsList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleSearchModerCode ({commit}, data) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSearchModerList(data).then(res => {
                    console.log('全部车型');
                    console.log(res);
                    console.log('全部车型');
                    commit('setModerList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        /**
         * 加载所有产品信息
         * @param commit
         * @returns {Promise<any>}
         */
        handelActiveReviewAllProductList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewAllProductList().then(res => {
                    console.log(res);
                    commit('setActiveReviewAllProductList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        /**
         * 审核
         * */
        handleSendReviewAction ({ commit }, data) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                console.log('进入审核流程');
                console.log(222222);
                console.log(data);
                apiSendReviewAction(data).then(res => {
                    console.log('审核成功');
                    commit('setMsg', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        /**
         * 修改状态
         * */
        handleChangeStatus ({ commit }, data) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiChangeStatus(data).then(res => {
                    commit('setChangeStatus', res);
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
        setData (state, res) {
            state.activeReviewViewDataResult = res.result;
            state.activeReviewCheckDate.opinion = '';
            state.activeReviewCheckDate.reviewStatus = '';
            state.activeReviewCheckDate.id = res.result.workFlow.id;
            state.activeReviewCheckDate.modifierName = '';
            state.activeReviewCheckDate.reviewLevel = res.result.workFlow.reviewLevel;
            state.activeReviewCheckDate.reviewId = res.result.ativeMain.activeCode;
            // state.activeReviewCheckDate.loanAmtBegin = res.result.ativeMain.loanAmtBegin + '';
            // state.activeReviewCheckDate.loanAmtEnd = res.result.ativeMain.loanAmtEnd + '';
            // state.activeReviewCheckDate.loanTermBegin = res.result.ativeMain.loanTermBegin + '';
            // state.activeReviewCheckDate.loanTermEnd = res.result.ativeMain.loanTermEnd + '';
            state.activeReviewCheckDate.opinion = '同意';
            state.code = res.code;
            state.msg = res.msg;
            state.isSuccess = res.isSuccess;
        },
        setProvinceList (state, res) {
            state.activeReviewViewProvinceListData = res.result;
        },
        setActiveReviewAreaList (state, data) {
            state.activeReviewViewAreaListData = data.result;
        },
        setCityList (state, data) {
            state.activeReviewViewCityListData = data.result;
        },
        setBrandsList (state, data) {
            state.activeReviewViewBrandsListData = data.result;
        },
        setSeriessList (state, data) {
            state.activeReviewViewSeriesListData = data.result;
        },
        setModerList (state, data) {
            state.activeReviewViewModerListData = data.result;
        },
        setActiveReviewAllProductList (state, data) {
            state.activeReviewViewAllProductListData = data.result;
        },
        setMsg (state, data) {
            state.code = data.code;
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
            state.loading = true;
        },
        setChangeStatus (state, data) {
            state.msg = data.msg;
            state.code = data.code;
            state.isSuccess = data.isSuccess;
        }
    }
};
export default activeReviewEdit;
