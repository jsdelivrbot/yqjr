import {apiActiveMainAdd} from '../../../../api/sale-active/active-main/activeMainApi';
import {apiOptionArea, apiOptionProvince, apiOptionCity} from '../../../../api/sale-option/option-area/optionAreaApi';
import {apiOptionBrand, apiOptionSubBrand, apiOptionCarModel} from '../../../../api/sale-option/option-brand/optionBrandApi';
import {apiOptionProductAll} from '../../../../api/sale-option/option-product/optionProductApi';

const activeMainAdd = {
    state: {
        activeMainData: {
            ativeMain: {
                areaCode: '',
                areaName: '',
                company: '',
                activeName: '',
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
                additionalId: '',
                additionAmtBegin: '',
                additionAmtEnd: ''
            },
            ativeDealeList: [],
            activeArea: {
                areaCode: '',
                provinceCode: '',
                cityCode: ''
            },
            activeCar: {
                brandsCode: '',
                brandsName: '',
                seriesCode: '',
                moderCode: ''
            },
            activeProdList: [{
                prodCode: '',
                prodType: '01'
            }, {
                prodCode: '',
                prodType: '02'
            }],
            activeBusiness: {
                businessCode: ''
            },
            activeMarketing: {
                marketingCode: ''
            },
            activeAdditional: {
                additionalCode: ''
            }
        },
        relateList: {
            relateAreaCode: [],
            relateProvinceCode: [],
            relateCityCode: [],
            relateSeriesCode: [],
            relateModerCode: [],
            relateFinanceProdCode: [],
            relateCreditProdCode: [],
            relateBusinessCode: [],
            relateMarketingCode: [],
            relateAdditionalCode: []
        },
        areaList: [],
        provinceList: [],
        cityList: [],
        brandList: [],
        seriesList: [],
        modelList: [],
        additionalCodes: [],
        businessCodes: [],
        creditCodes: [],
        financeCodes: [],
        marketingCodes: [],
        submitResult: {
            isSuccess: true,
            msg: ''
        }
    },
    actions: {
        getProductAll ({ commit }) {
            return new Promise((resolve, reject) => {
                apiOptionProductAll().then(res => {
                    commit('setProductOptions', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        },
        getOptionArea ({ commit }) {
            return new Promise((resolve, reject) => {
                apiOptionArea().then(res => {
                    commit('setAreaOptions', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        },
        getOptionProvince ({ commit }) {
            return new Promise((resolve, reject) => {
                apiOptionProvince().then(res => {
                    commit('setProvinceOptions', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        },
        getOptionCity ({ commit }, provinceData) {
            return new Promise((resolve, reject) => {
                apiOptionCity(provinceData).then(res => {
                    commit('setCityOptions', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        },
        getOptionBrand ({ commit }) {
            return new Promise((resolve, reject) => {
                apiOptionBrand().then(res => {
                    commit('setBrandOptions', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        },
        getOptionSubBrand ({ commit }, data) {
            return new Promise((resolve, reject) => {
                apiOptionSubBrand(data.value).then(res => {
                    commit('setSubBrandOptions', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        },
        getOptionCarModel ({ commit }, data) {
            return new Promise((resolve, reject) => {
                apiOptionCarModel(data).then(res => {
                    commit('setCarModelOptions', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        },
        handleActiveMainAdd ({ commit }, data) {
            return new Promise((resolve, reject) => {
                apiActiveMainAdd(data).then(res => {
                    commit('setSubmitResult', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        },
        handleResetActiveMainData ({ commit }) {
            commit('setActiveMainDataDefault');
        }
    },
    mutations: {
        setProductOptions: function (state, data) {
            if (data.isSuccess) {
                state.financeCodes = data.result.financeCodes;
                state.businessCodes = data.result.businessCodes;
                state.creditCodes = data.result.creditCodes;
                state.marketingCodes = data.result.marketingCodes;
                state.additionalCodes = data.result.additionalCodes;
            }
        },
        setAreaOptions: function (state, data) {
            if (data.isSuccess) {
                state.areaList = data.result;
            }
        },
        setProvinceOptions: function (state, data) {
            if (data.isSuccess) {
                state.provinceList = data.result;
            }
        },
        setCityOptions: function (state, data) {
            if (data.isSuccess) {
                state.cityList = data.result;
            }
        },
        setBrandOptions: function (state, data) {
            if (data.isSuccess) {
                state.brandList = data.result;
            }
        },
        setSubBrandOptions: function (state, data) {
            if (data.isSuccess) {
                state.seriesList = data.result;
            }
        },
        setCarModelOptions: function (state, data) {
            if (data.isSuccess) {
                state.modelList = data.result;
            }
        },
        setActiveMainDataDefault: function (state) {
            state.activeMainData = {
                ativeMain: {
                    areaCode: '',
                    areaName: '',
                    company: '',
                    activeName: '',
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
                    additionalId: '',
                    additionAmtBegin: '',
                    additionAmtEnd: ''
                },
                ativeDealeList: [],
                activeArea: {
                    areaCode: '',
                    provinceCode: '',
                    cityCode: ''
                },
                activeCar: {
                    brandsCode: '',
                    brandsName: '',
                    seriesCode: '',
                    moderCode: ''
                },
                activeProdList: [{
                    prodCode: '',
                    prodType: '01'
                }, {
                    prodCode: '',
                    prodType: '02'
                }],
                activeBusiness: {
                    businessCode: ''
                },
                activeMarketing: {
                    marketingCode: ''
                },
                activeAdditional: {
                    additionalCode: ''
                }
            };
            state.relateList = {
                relateAreaCode: [],
                relateProvinceCode: [],
                relateCityCode: [],
                relateSeriesCode: [],
                relateModerCode: [],
                relateFinanceProdCode: [],
                relateCreditProdCode: [],
                relateBusinessCode: [],
                relateMarketingCode: [],
                relateAdditionalCode: []
            };
            state.relateList = {
                relateAreaCode: [],
                relateProvinceCode: [],
                relateCityCode: [],
                relateSeriesCode: [],
                relateModerCode: [],
                relateFinanceProdCode: [],
                relateCreditProdCode: [],
                relateBusinessCode: [],
                relateMarketingCode: [],
                relateAdditionalCode: []
            };
            state.cityList = [];
            state.seriesList = [];
            state.modelList = [];
        },
        setSubmitResult: function (state, data) {
            state.submitResult.isSuccess = data.isSuccess;
            state.submitResult.msg = data.msg;
        }
    }
};
export default activeMainAdd;
