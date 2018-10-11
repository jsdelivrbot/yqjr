import {apiActiveMainQueryList, apiActiveMainQueryView, apiActiveMainProvinceQueryView, apiActiveMainCityQueryView, apiActiveMainBrandQueryView, apiActiveMainSecondBrandQueryView, apiActiveMainCarTypeQueryView, apiActiveMainProductQueryView, apiActiveAreaQueryView, apiActiveMainBrandsCodeQueryList} from '../../../../api/sale-active/active-main-query/activeMainQueryApi';
import config from '@/config';
import {isEmpty} from '../../../../libs/util';

const activeMainQueryList = {
    state: {
        activeMainQueryList: [], // 活动信息列表
        brandsCodeList: [], // 活动信息列表品牌查询
        activeMainDetailsQueryData: {
            activeAdditional: {},
            activeArea: '',
            activeBusiness: '',
            activeCar: '',
            activeDealeList: '',
            activeMain: '',
            activeMarketing: '',
            activeProdList: ''
        },
        provinceParams: {
            codeType: '',
            codeCode: ''
        },
        cityParams: {
            codeType: '',
            codeCode: ''
        },
        brandParams: {
            codeType: '',
            codeCode: ''
        },
        secondBrandParams: {
            codeType: '',
            codeCode: ''
        },
        carTypeParams: {
            codeType: '',
            codeCode: ''
        },
        activeAreaParams: {
            codeType: '',
            codeCode: ''
        },
        // 活动信息详情
        activeMainProvinceQueryList: [], // 活动省份列表
        activeMainCityQueryList: [], // 活动城市列表
        activeMainBrandQueryList: [], // 活动品牌列表
        activeMainSecondBrandQueryList: [], // 活动子品牌列表
        activeMainCarTypeQueryList: [], // 活动车型
        // 产品信息 option
        financeCodes: [],
        businessCodes: [],
        creditCodes: [],
        marketingCodes: [],
        additionalCodes: [],
        activeMainAreaQueryList: [], // 活动区域 option
        // v-model
        vModel: {
            financeCodesList: [],
            businessCodesList: [],
            creditCodesList: [],
            marketingCodesList: [],
            additionalCodesList: [],
            provinceList: [],
            cityList: [],
            secondBrandList: [],
            carTypeList: [],
            brandList: [],
            activeAreaList: []
        },
        // --v-model
        ifShowArea: false,
        ifShowProvince: false,
        ifShowAdd: false,
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0, // 总页数,
        isSuccess: false,
        msg: ''
    },
    actions: {
        // 查询活动信息列表
        handleActiveMainQueryList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveMainQueryList(formQueryData).then(res => {
                    commit('setActiveMainQueryList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        // 查询活动信息列表品牌列表
        handleActiveMainBrandsCodeQueryList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveMainBrandsCodeQueryList(formQueryData).then(res => {
                    commit('setActiveMainBrandsCodeQueryList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        // 查询活动详情
        handleActiveMainQueryViewById ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveMainQueryView(formQueryData).then(res => {
                    commit('setActiveMainDetailsQueryView', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleActiveMainProvinceQuery ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveMainProvinceQueryView(formQueryData).then(res => {
                    commit('setActiveMainProvinceQueryView', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        }, // 查询活动省会
        handleActiveMainCityQuery ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveMainCityQueryView(formQueryData).then(res => {
                    commit('setActiveMainCityQueryView', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        }, // 查询活动城市
        handleActiveMainBrandQuery ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveMainBrandQueryView(formQueryData).then(res => {
                    commit('setActiveMainBrandQueryView', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        }, // 查询活动品牌
        handleActiveMainSecondBrandQuery ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveMainSecondBrandQueryView(formQueryData).then(res => {
                    commit('setActiveMainSecondBrandQueryView', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        }, // 查询活动子品牌
        handleActiveMainCarTypeQuery ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveMainCarTypeQueryView(formQueryData).then(res => {
                    commit('setActiveMainCarTypeQueryView', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        }, // 查询活动车型
        handleActiveMainProductQuery ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveMainProductQueryView(formQueryData).then(res => {
                    commit('setActiveMainProductQueryView', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        }, // 查询活动产品信息
        handleActiveMainAreaQuery ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveAreaQueryView(formQueryData).then(res => {
                    commit('setActiveMainAreaQueryView', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        } // 查询活动区域
    },
    mutations: {
        // 活动信息列表
        setActiveMainQueryList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.activeMainQueryList = data.rows;
        },
        // 活动信息品牌列表
        setActiveMainBrandsCodeQueryList (state, data) {
            if (data.isSuccess) {
                state.isSuccess = true;
                // state.msg = '查询成功';
                state.brandsCodeList = data.result;
            } else {
                state.isSuccess = false;
                state.msg = '查询失败';
            }
        },
        // 活动信息详情
        setActiveMainDetailsQueryView (state, data) {
            if (data.isSuccess) {
                state.isSuccess = true;
                // state.msg = '查询成功';
                state.activeMainDetailsQueryData = data.result;
                if (data.result.activeMain.inputArea === '0') {
                    state.ifShowProvince = true;
                    state.ifShowArea = false;
                } else {
                    state.ifShowArea = true;
                    state.ifShowProvince = false;
                }
                if (data.result.activeMain.additionFlag === '1') {
                    state.ifShowAdd = true;
                } else {
                    state.ifShowAdd = false;
                }
                if (!isEmpty(data.result.activeAdditional)) {
                    if (data.result.activeAdditional.additionalCode !== '') {
                        var additionalCodesArr = data.result.activeAdditional.additionalCode.split(',');
                    } else {
                        additionalCodesArr.push('');
                    }
                }
                if (!isEmpty(data.result.activeBusiness)) {
                    if (data.result.activeBusiness.businessCode !== '') {
                        var businessCodesListArr = data.result.activeBusiness.businessCode.split(',');
                    } else {
                        businessCodesListArr.push('');
                    }
                }
                if (!isEmpty(data.result.activeProdList)) {
                    if (data.result.activeProdList.length === 1) {
                        if (data.result.activeProdList[0].prodCode === undefined) {
                            // alert(100);
                            var financeCodesListArr = [];
                            financeCodesListArr.push('');
                        } else {
                            // alert(111);
                            financeCodesListArr = data.result.activeProdList[0].prodCode.split(',');
                        }
                        // alert(1);
                    } else if (data.result.activeProdList.length === 2) {
                        if (data.result.activeProdList[0].prodCode === undefined) {
                            financeCodesListArr.push('');
                            // alert(200);
                        } else {
                            // alert(211);
                            financeCodesListArr = data.result.activeProdList[0].prodCode.split(',');
                        }
                        if (data.result.activeProdList[1].prodCode === undefined) {
                            var creditCodesListArr = [];
                            creditCodesListArr.push('');
                            // alert(2000);
                        } else {
                            // alert(2111);
                            creditCodesListArr = data.result.activeProdList[1].prodCode.split(',');
                        }
                        // alert(2);
                    }
                }
                if (!isEmpty(data.result.activeMarketing)) {
                    if (data.result.activeMarketing.marketingCode !== '') {
                        var marketingCodesListArr = data.result.activeMarketing.marketingCode.split(',');
                    } else {
                        marketingCodesListArr.push('');
                    }
                }
                if (data.result.activeArea === undefined) {
                    state.provinceParams.codeCode = '';
                    state.cityParams.codeCode = '';
                    state.activeAreaParams.codeCode = '';
                } else {
                    state.provinceParams.codeCode = data.result.activeArea.provinceCode;
                    state.cityParams.codeCode = data.result.activeArea.cityCode;
                    state.activeAreaParams.codeCode = data.result.activeArea.areaCode;
                }
                // state.provinceParams.codeCode = data.result.activeArea.provinceCode;
                state.provinceParams.codeType = 'Province';
                // state.cityParams.codeCode = data.result.activeArea.cityCode;
                state.cityParams.codeType = 'City';
                state.brandParams.codeCode = data.result.activeCar.brandsCode;
                state.brandParams.codeType = 'CarBrand';
                state.secondBrandParams.codeCode = data.result.activeCar.seriesCode;
                state.secondBrandParams.codeType = 'CarBrandDetail';
                state.carTypeParams.codeCode = data.result.activeCar.moderCode;
                state.carTypeParams.codeType = 'CarBrandName';
                // state.activeAreaParams.codeCode = data.result.activeArea.areaCode;
                state.activeAreaParams.codeType = 'Zone';
                state.vModel.additionalCodesList = additionalCodesArr;
                state.vModel.financeCodesList = financeCodesListArr;
                state.vModel.businessCodesList = businessCodesListArr;
                state.vModel.creditCodesList = creditCodesListArr;
                state.vModel.marketingCodesList = marketingCodesListArr;
                state.vModel.businessCodesList = businessCodesListArr;
            } else {
                state.isSuccess = false;
                state.msg = '查询失败';
            }
        },
        // 活动省份
        setActiveMainProvinceQueryView (state, data) {
            if (data.isSuccess) {
                state.isSuccess = true;
                // state.msg = '查询成功';
                state.activeMainProvinceQueryList = data.result;
                var provinceListArr = [];
                if (!isEmpty(data.result)) {
                    for (let i = 0; i < data.result.length; i++) {
                        provinceListArr.push(data.result[i].value);
                    }
                }
                state.vModel.provinceList = provinceListArr;
            } else {
                state.isSuccess = false;
                state.msg = '查询失败';
            }
        },
        // 活动城市
        setActiveMainCityQueryView (state, data) {
            if (data.isSuccess) {
                state.isSuccess = true;
                // state.msg = '查询成功';
                state.activeMainCityQueryList = data.result;
                var cityListArr = [];
                if (!isEmpty(data.result)) {
                    for (let i = 0; i < data.result.length; i++) {
                        cityListArr.push(data.result[i].value);
                    }
                }
                state.vModel.cityList = cityListArr;
            } else {
                state.isSuccess = false;
                state.msg = '查询失败';
            }
        },
        // 活动品牌
        setActiveMainBrandQueryView (state, data) {
            if (data.isSuccess) {
                state.isSuccess = true;
                // state.msg = '查询成功';
                state.activeMainBrandQueryList = data.result;
                var BrandArr = [];
                if (!isEmpty(data.result)) {
                    for (let i = 0; i < data.result.length; i++) {
                        BrandArr.push(data.result[i].value);
                    }
                }
                state.vModel.brandList = BrandArr;
            } else {
                state.isSuccess = false;
                state.msg = '查询失败';
            }
        },
        // 活动子品牌
        setActiveMainSecondBrandQueryView (state, data) {
            if (data.isSuccess) {
                state.isSuccess = true;
                // state.msg = '查询成功';
                state.activeMainSecondBrandQueryList = data.result;
                var SecondBrandArr = [];
                if (!isEmpty(data.result)) {
                    for (let i = 0; i < data.result.length; i++) {
                        SecondBrandArr.push(data.result[i].value);
                    }
                }
                state.vModel.secondBrandList = SecondBrandArr;
            } else {
                state.isSuccess = false;
                state.msg = '查询失败';
            }
        },
        // 活动车型
        setActiveMainCarTypeQueryView (state, data) {
            if (data.isSuccess) {
                state.isSuccess = true;
                // state.msg = '查询成功';
                state.activeMainCarTypeQueryList = data.result;
                var carTypeArr = [];
                if (!isEmpty(data.result)) {
                    for (let i = 0; i < data.result.length; i++) {
                        carTypeArr.push(data.result[i].value);
                    }
                }
                state.vModel.carTypeList = carTypeArr;
            } else {
                state.isSuccess = false;
                state.msg = '查询失败';
            }
        },
        // 活动产品信息
        setActiveMainProductQueryView (state, data) {
            if (data.isSuccess) {
                state.isSuccess = true;
                // state.msg = '查询成功';
                state.activeMainProductQueryData = data.result;
                state.financeCodes = data.result.financeCodes;
                state.businessCodes = data.result.businessCodes;
                state.creditCodes = data.result.creditCodes;
                state.marketingCodes = data.result.marketingCodes;
                state.additionalCodes = data.result.additionalCodes;
            } else {
                state.isSuccess = false;
                state.msg = '查询失败';
            }
        },
        // 活动区域
        setActiveMainAreaQueryView (state, data) {
            if (data.isSuccess) {
                state.isSuccess = true;
                // state.msg = '查询成功';
                state.activeMainAreaQueryList = data.result;
                var activeAreaArr = [];
                if (!isEmpty(data.result)) {
                    for (let i = 0; i < data.result.length; i++) {
                        activeAreaArr.push(data.result[i].value);
                    }
                }
                state.vModel.activeAreaList = activeAreaArr;
            } else {
                state.isSuccess = false;
                state.msg = '查询失败';
            }
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default activeMainQueryList;
