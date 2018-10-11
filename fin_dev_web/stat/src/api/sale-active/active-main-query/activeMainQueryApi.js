import axios from '../../../libs/api.request';
// 活动综合查询列表
export const apiActiveMainQueryList = (data) => {
    return axios.request({
        url: '/mkmm/sales/activeMains/mainAllActiveList?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
// 活动综合查询列表
export const apiActiveMainBrandsCodeQueryList = () => {
    return axios.request({
        url: 'mkmm/sales/selectCode/CarBrand?isUpCode=0',
        method: 'get'
    });
};
// 根据activeCode查看活动详情信息
export const apiActiveMainQueryView = (activeCode) => {
    return axios.request({
        url: '/mkmm/sales/activeAlls/queryActive?activeCode=' + activeCode,
        method: 'get'
    });
};
// 根据codeType: Province ,codeCode: 13,15,21 查询--区域信息--活动省份
export const apiActiveMainProvinceQueryView = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/translateCode?codeType=' + data.codeType + '&codeCode=' + data.codeCode,
        // params: data,
        method: 'get'
    });
};
// 根据codeType: City ,codeCode: 2157,2158,2101 查询--区域信息--活动城市
export const apiActiveMainCityQueryView = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/translateCode?codeType=' + data.codeType + '&codeCode=' + data.codeCode,
        // params: data,
        method: 'get'
    });
};
// 根据codeType: CarBrand , codeCode: 625 查询--品牌信息--活动品牌
export const apiActiveMainBrandQueryView = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/translateCode?codeType=' + data.codeType + '&codeCode=' + data.codeCode,
        // params: data,
        method: 'get'
    });
};
// 根据codeType: CarBrandDetail ,codeCode: 36,18,30 查询--品牌信息--活动子品牌
export const apiActiveMainSecondBrandQueryView = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/translateCode?codeType=' + data.codeType + '&codeCode=' + data.codeCode,
        // params: data,
        method: 'get'
    });
};
// 根据codeType: CarBrandName , codeCode: 2341,2342,2343查询--品牌信息--活动车型
export const apiActiveMainCarTypeQueryView = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/translateCode?codeType=' + data.codeType + '&codeCode=' + data.codeCode,
        // params: data,
        method: 'get'
    });
};
// 根据codeType: CarBrandName , codeCode: 2341,2342,2343查询活动区域
export const apiActiveAreaQueryView = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/translateCode?codeType=' + data.codeType + '&codeCode=' + data.codeCode,
        // params: data,
        method: 'get'
    });
};
// 查询--产品信息
export const apiActiveMainProductQueryView = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/selectProductAll',
        method: 'get'
    });
};
