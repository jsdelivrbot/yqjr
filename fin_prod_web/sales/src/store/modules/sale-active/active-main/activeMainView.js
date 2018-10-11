import {apiActiveMainView} from '../../../../api/sale-active/active-main/activeMainApi';
import {apiOptionProductAll} from '../../../../api/sale-option/option-product/optionProductApi';
import {
    apiActiveReviewAreaList, apiActiveReviewProvinceList,
    apiSearchBrandsList, apiSearchCityByProvince, apiSearchSeriessList, apiSearchModerList
} from '../../../../api/sale-active/active-review/activeReviewListApi';
import {isEmpty} from '@/libs/util.js';

const activeMainView = {
    state: {
        activeViewAreaListData: [],
        activeViewProvinceListData: [], // 所有省份集合
        activeViewCityListData: [],
        activeViewBrandsListData: [],
        activeViewSeriesListData: [],
        activeViewModerListData: [],
        areaList: {
            areaCodeList: [],
            provinceCodesList: [],
            cityCodeList: [],
            brandsNameList: [],
            seriesCodeList: [],
            moderCodeList: []
        },
        activeMainViewData: {
            areaMainName: '',
            activeName: '',
            activeCode: '',
            patmentBegin: '',
            patmentEnd: '',
            loanAmtBegin: '',
            loanAmtEnd: '',
            loanTermBegin: '',
            loanTermEnd: '',
            activeStartime: '',
            activeEndtime: '',
            loanStartime: '',
            loanEndtime: '',
            carReg: '00',
            avtiveCriterion: '',
            expectedCount: '',
            inputDeale: '1',
            inputArea: '1',
            remark: '',
            additionFlag: '0',
            additionFlagName: '否',
            additionalId: '',
            additionAmtBegin: '',
            additionAmtEnd: '',
            activeDealeList: [],
            areaCode: '',
            areaName: '',
            provinceCode: '',
            provinceName: '',
            cityCode: '',
            cityName: '',
            brandsCode: '',
            seriesCode: '',
            seriesName: '',
            moderCode: '',
            moderName: '',
            financeProdCode: [],
            creditProdCode: [],
            businessCode: [],
            marketingCode: [],
            additionalCode: [],
            actualCount: '',
            reachRate: ''
        },
        financeCodes: [],
        businessCodes: [],
        creditCodes: [],
        marketingCodes: [],
        additionalCodes: []
    },
    actions: {
        getProductList ({ commit }) {
            return new Promise((resolve, reject) => {
                apiOptionProductAll().then(res => {
                    commit('setProductOptions', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        },
        /**
         * 根据省份加载城市
         */
        handleSearchCitList ({commit}, data) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSearchCityByProvince(data).then(res => {
                    commit('setCitysList', res);
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
        handelActiveAreaList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewAreaList().then(res => {
                    commit('setActiveAreaList', res);
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
        handleSearchProvinList ({commit}) {
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
         * 加载所有品牌
         */
        handleSearchBrandList ({commit}) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSearchBrandsList().then(res => {
                    commit('setBrandsListView', res);
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
        handleSearchSerieList ({commit}, data) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSearchSeriessList(data).then(res => {
                    commit('setSeriessCodeList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleSearchModerCod ({commit}, data) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSearchModerList(data).then(res => {
                    commit('setModerList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        getActiveMainViewData ({ commit }, data) {
            return new Promise((resolve, reject) => {
                apiActiveMainView(data).then(res => {
                    commit('setActiveMainViewData', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        }
    },
    mutations: {
        setProvinceList (state, res) {
            state.activeViewProvinceListData = res.result;
        },
        setActiveAreaList (state, data) {
            state.activeViewAreaListData = data.result;
        },
        setProductOptions: function (state, data) {
            if (data.isSuccess) {
                state.financeCodes = data.result.financeCodes;
                state.businessCodes = data.result.businessCodes;
                state.creditCodes = data.result.creditCodes;
                state.marketingCodes = data.result.marketingCodes;
                state.additionalCodes = data.result.additionalCodes;
            }
        },
        setModerList (state, data) {
            state.activeViewModerListData = data.result;
        },
        setSeriessCodeList (state, data) {
            state.activeViewSeriesListData = data.result;
        },
        setBrandsListView (state, data) {
            state.activeViewBrandsListData = data.result;
        },
        setCitysList (state, data) {
            state.activeViewCityListData = data.result;
        },
        setActiveMainViewData: function (state, data) {
            if (data.isSuccess) {
                state.activeMainViewData.activeDealeList = [];
                state.activeMainViewData.financeProdCode = [];
                state.activeMainViewData.creditProdCode = [];
                state.activeMainViewData.businessCode = [];
                state.activeMainViewData.marketingCode = [];
                state.activeMainViewData.additionalCode = [];
                state.activeMainViewData.areaMainName = data.result.activeMain.areaName;
                state.activeMainViewData.activeName = data.result.activeMain.activeName;
                state.activeMainViewData.activeCode = data.result.activeMain.activeCode;
                state.activeMainViewData.patmentBegin = data.result.activeMain.patmentBegin;
                state.activeMainViewData.patmentEnd = data.result.activeMain.patmentEnd;
                state.activeMainViewData.loanAmtBegin = data.result.activeMain.loanAmtBegin;
                state.activeMainViewData.loanAmtEnd = data.result.activeMain.loanAmtEnd;
                state.activeMainViewData.loanTermBegin = data.result.activeMain.loanTermBegin;
                state.activeMainViewData.loanTermEnd = data.result.activeMain.loanTermEnd;
                state.activeMainViewData.activeStartime = data.result.activeMain.activeStartime;
                state.activeMainViewData.activeEndtime = data.result.activeMain.activeEndtime;
                state.activeMainViewData.loanStartime = data.result.activeMain.loanStartime;
                state.activeMainViewData.loanEndtime = data.result.activeMain.loanEndtime;
                state.activeMainViewData.carReg = data.result.activeMain.carReg === '01' ? '法人' : data.result.activeMain.carReg === '02' ? '自然人' : '全部';
                state.activeMainViewData.avtiveCriterion = data.result.activeMain.avtiveCriterion;
                state.activeMainViewData.expectedCount = data.result.activeMain.expectedCount;
                state.activeMainViewData.inputDeale = data.result.activeMain.inputDeale;
                state.activeMainViewData.inputArea = data.result.activeMain.inputArea;
                state.activeMainViewData.remark = data.result.activeMain.remark;
                state.activeMainViewData.additionFlag = data.result.activeMain.additionFlag;
                state.activeMainViewData.additionFlagName = data.result.activeMain.additionFlag === '1' ? '是' : '否';
                state.activeMainViewData.additionalId = data.result.activeMain.additionalId;
                state.activeMainViewData.brandsCode = data.result.activeCar.brandsCode;
                state.activeMainViewData.seriesCode = data.result.activeCar.seriesCode;
                state.activeMainViewData.moderCode = data.result.activeCar.moderCode;
                state.activeMainViewData.actualCount = data.result.actualTurnoverCount;
                state.activeMainViewData.reachRate = data.result.reachRate;
                if (data.result.activeProdList.length > 0) {
                    for (var i = 0; i < data.result.activeProdList.length; i++) {
                        if (data.result.activeProdList[i].prodType === '01') {
                            const financeTemp = data.result.activeProdList[i].prodCode.split(',');
                            financeTemp.forEach(function (value, index, array) {
                                state.activeMainViewData.financeProdCode.push(value);
                            });
                        } else if (data.result.activeProdList[i].prodType === '02') {
                            const creditTemp = data.result.activeProdList[i].prodCode.split(',');
                            creditTemp.forEach(function (value, index, array) {
                                state.activeMainViewData.creditProdCode.push(value);
                            });
                        }
                    }
                }
                const marketingTemp = data.result.activeMarketing.marketingCode.split(',');
                marketingTemp.forEach(function (value, index, array) {
                    state.activeMainViewData.marketingCode.push(value);
                });
                const businessTemp = data.result.activeBusiness.businessCode.split(',');
                businessTemp.forEach(function (value, index, array) {
                    state.activeMainViewData.businessCode.push(value);
                });
                if (data.result.activeAdditional) {
                    const additionalTemp = data.result.activeAdditional.additionalCode.split(',');
                    additionalTemp.forEach(function (value, index, array) {
                        state.activeMainViewData.additionalCode.push(value);
                        state.activeMainViewData.additionAmtBegin = data.result.activeMain.additionAmtBegin;
                        state.activeMainViewData.additionAmtEnd = data.result.activeMain.additionAmtEnd;
                    });
                };
                if (!isEmpty(data.result.activeArea) && !isEmpty(data.result.activeArea.areaCode) && data.result.activeArea.areaCode.indexOf(',') > 0) {
                    state.areaList.areaCodeList = data.result.activeArea.areaCode.split(',');
                } else if (!isEmpty(data.result.activeArea) && !isEmpty(data.result.activeArea.areaCode) && data.result.activeArea.areaCode.indexOf(',') < 0) {
                    var areaCode = [];
                    areaCode.push(data.result.activeArea.areaCode);
                    state.areaList.areaCodeList = areaCode;
                };
                if (!isEmpty(data.result.activeArea) && !isEmpty(data.result.activeArea.provinceCode) && data.result.activeArea.provinceCode.indexOf(',') > 0) {
                    state.areaList.provinceCodesList = data.result.activeArea.provinceCode.split(',');
                } else if (!isEmpty(data.result.activeArea) && !isEmpty(data.result.activeArea.provinceCode) && data.result.activeArea.provinceCode.indexOf(',') < 0) {
                    var provinceArr = [];
                    provinceArr.push(data.result.activeArea.provinceCode);
                    state.areaList.provinceCodesList = provinceArr;
                };
                if (!isEmpty(data.result.activeArea) && !isEmpty(data.result.activeArea.cityCode) && data.result.activeArea.cityCode.indexOf(',') > 0) {
                    state.areaList.cityCodeList = data.result.activeArea.cityCode.split(',');
                } else if (!isEmpty(data.result.activeArea) && !isEmpty(data.result.activeArea.cityCode) && data.result.activeArea.cityCode.indexOf(',') < 0) {
                    var cityCode = [];
                    cityCode.push(data.result.activeArea.cityCode)
                    state.areaList.cityCodeList = cityCode;
                };
                if (!isEmpty(data.result.activeDealeList)) {
                    state.activeMainViewData.activeDealeList = data.result.activeDealeList;
                };
                if (!isEmpty(data.result.activeCar) && !isEmpty(data.result.activeCar.brandsCode)) {
                    state.areaList.brandsNameList = data.result.activeCar.brandsCode;
                };
                if (data.result.activeCar.seriesCode.indexOf(',') > 0) {
                    state.areaList.seriesCodeList = data.result.activeCar.seriesCode.split(',');
                } else if (data.result.activeCar.seriesCode.indexOf(',') < 0) {
                    var seriesCode = [];
                    seriesCode.push(data.result.activeCar.seriesCode);
                    state.areaList.seriesCodeList = seriesCode;
                };
                if (data.result.activeCar.moderCode.indexOf(',') > 0) {
                    state.areaList.moderCodeList = data.result.activeCar.moderCode.split(',');
                } else if (data.result.activeCar.moderCode.indexOf(',') < 0) {
                    var moderCode = [];
                    moderCode.push(data.result.activeCar.moderCode);
                    state.areaList.moderCodeList = moderCode;
                }
            }
        }
    }
};
export default activeMainView;
