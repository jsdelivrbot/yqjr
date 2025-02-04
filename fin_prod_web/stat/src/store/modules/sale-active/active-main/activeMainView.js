import {apiActiveMainView} from '../../../../api/sale-active/active-main/activeMainApi';
import {apiOptionProductAll} from '../../../../api/sale-option/option-product/optionProductApi';
import {apiOptionTranslate} from '../../../../api/sale-option/option-translate/optionTranslateApi';

const activeMainView = {
    state: {
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
            brandsName: '',
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
        getActiveMainViewData ({ commit }, data) {
            return new Promise((resolve, reject) => {
                apiActiveMainView(data).then(res => {
                    commit('setActiveMainViewData', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        },
        translateAreaCode ({ commit }, data) {
            return new Promise((resolve, reject) => {
                apiOptionTranslate(data).then(res => {
                    commit('setAreaName', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        },
        translateProvinceCode ({ commit }, data) {
            return new Promise((resolve, reject) => {
                apiOptionTranslate(data).then(res => {
                    commit('setProvinceName', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        },
        translateCityCode ({ commit }, data) {
            return new Promise((resolve, reject) => {
                apiOptionTranslate(data).then(res => {
                    commit('setCityName', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        },
        translateSeriesCode ({ commit }, data) {
            return new Promise((resolve, reject) => {
                apiOptionTranslate(data).then(res => {
                    commit('setSeriesName', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        },
        translateModelCode ({ commit }, data) {
            return new Promise((resolve, reject) => {
                apiOptionTranslate(data).then(res => {
                    commit('setModelName', res);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
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
                state.activeMainViewData.brandsName = data.result.activeCar.brandsName;
                state.activeMainViewData.seriesCode = data.result.activeCar.seriesCode;
                state.activeMainViewData.moderCode = data.result.activeCar.moderCode;
                state.activeMainViewData.actualCount = data.result.actualTurnoverCount;
                state.activeMainViewData.reachRate = data.result.reachRate;
                if (data.result.activeMain.inputDeale === '1') {
                    state.activeMainViewData.activeDealeList = data.result.activeDealeList;
                } else {
                    if (data.result.activeMain.inputArea === '1') {
                        if (data.result.activeArea) {
                            state.activeMainViewData.areaCode = data.result.activeArea.areaCode;
                        }
                    } else {
                        if (data.result.activeArea) {
                            state.activeMainViewData.provinceCode = data.result.activeArea.provinceCode;
                            state.activeMainViewData.cityCode = data.result.activeArea.cityCode;
                        }
                    }
                }
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
                }
            }
        },
        setAreaName: function (state, data) {
            if (data.isSuccess) {
                state.activeMainViewData.areaName = '';
                if (data.result.length > 0) {
                    for (var i = 0; i < data.result.length; i++) {
                        state.activeMainViewData.areaName += data.result[i].label;
                        if (data.result.length !== (i + 1)) {
                            state.activeMainViewData.areaName += '，';
                        }
                    }
                }
            }
        },
        setProvinceName: function (state, data) {
            if (data.isSuccess) {
                state.activeMainViewData.provinceName = '';
                if (data.result.length > 0) {
                    for (var i = 0; i < data.result.length; i++) {
                        state.activeMainViewData.provinceName += data.result[i].label;
                        if (data.result.length !== (i + 1)) {
                            state.activeMainViewData.provinceName += '，';
                        }
                    }
                }
            }
        },
        setCityName: function (state, data) {
            if (data.isSuccess) {
                state.activeMainViewData.cityName = '';
                if (data.result.length > 0) {
                    for (var i = 0; i < data.result.length; i++) {
                        state.activeMainViewData.cityName += data.result[i].label;
                        if (data.result.length !== (i + 1)) {
                            state.activeMainViewData.cityName += '，';
                        }
                    }
                }
            }
        },
        setSeriesName: function (state, data) {
            if (data.isSuccess) {
                state.activeMainViewData.seriesName = '';
                if (data.result.length > 0) {
                    for (var i = 0; i < data.result.length; i++) {
                        state.activeMainViewData.seriesName += data.result[i].label;
                        if (data.result.length !== (i + 1)) {
                            state.activeMainViewData.seriesName += '，';
                        }
                    }
                }
            }
        },
        setModelName: function (state, data) {
            if (data.isSuccess) {
                state.activeMainViewData.moderName = '';
                if (data.result.length > 0) {
                    for (var i = 0; i < data.result.length; i++) {
                        state.activeMainViewData.moderName += data.result[i].label;
                        if (data.result.length !== (i + 1)) {
                            state.activeMainViewData.moderName += '，';
                        }
                    }
                }
            }
        }
    }
};
export default activeMainView;
