import axios from '../../../libs/api.request';

/**
 * 分页查询
 * @param data
 * @returns {*}
 */
export const apiActiveSearchDate = (data) => {
    return axios.request({
        url: '/mkmm/sales/activeMatchDetails/pageByJqGrid?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
/**
 * 活动品牌查询
 * @returns {*}
 */
export const apiSearchSelectBrandsCodeList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrand?isUpCode=0',
        method: 'get'
    });
};
/**
 * 活动子品牌查询
 * @param data
 * @returns {*}
 */
export const apiSearchSeriesCodeList = (data, isUpCode) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrandDetail?isUpCode=' + isUpCode + '&upCode=' + data,
        method: 'get'
    });
};
/**
 * 活动车型
 * @param data
 * @returns {*}
 */
export const apiSearchCarBrandTypeList = (data, isUpCode) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrandName?isUpCode=' + isUpCode + '&upCode=' + data,
        method: 'get'
    });
};
/**
 * 活动编码查询
 * @param data
 * @returns {*}
 */
export const apiSearchActiveCodeListforActive = (data) => {
    return axios.request({
        url: '/mkmm/sales/autoComplete/ActiveCode?name=' + data,
        method: 'get'
    });
};
