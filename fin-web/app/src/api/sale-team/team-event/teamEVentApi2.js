import axios from '../../../libs/api.request';
// var qs = require('qs');
export const apiTeamList2 = (data) => {
    return axios.request({
        url: '/risk/stat/indicatorRanges/selIndicatorRangesByPage?pageNum=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
// export const apiTeamAddToReview = (data) => {
//     return axios.request({
//         url: '/risk/stat/indicators/InsertIndicatorsRest?typecode=' + data.typecode + '&indicatorcode=' + data.indicatorcode + '&indicatortarget= ' + data.indicatortarget+
//         '&indicatorname='+data.indicatorname+'&indicatorcaption='+data.indicatorcaption+'&indicatorgroup='+data.indicatorgroup+'&indicatordesc='+data.indicatordesc+'&alertflag='+data.alertflag
//         +'&enabledflag='+data.enabledflag+'&displayorder='+data.displayorder+'&parentindicatorcode='+data.parentindicatorcode+'&comcode='+data.comcode+'&remark='+data.remark+'&calformula='+data.calformula,
//         params: data,
//         method: 'get'
//     });
// };
export const apiIndicatorTypes2 = (data) => {
    return axios.request({
        url: '/risk/stat/IndicatorTypesRest/SelectLikeByNameAndCode?pageNum=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
export const apiDelTeamList2 = (data) => {
    return axios.request({
        url: '/risk/stat/indicators/DeleteIndicatorsRest?params=' + data.toString(),
        method: 'get'
    });
};
export const apiTeamAddToReview = (data) => {
    return axios.request({
        url: '/risk/stat/indicators/InsertIndicatorsRest',
        params: data,
        method: 'post'
    });
};
export const apiQueryTeamById = (data) => {
    return axios.request({
        // url: '/risk/stat/IndicatorTypesRest/SelectLikeByNameAndCode?id=' + data,
        // // params: data,
        // method: 'get'
        url: '/risk/stat/indicators/SelectIndicatorsById?id=' + data,
        method: 'get'
    });
};
// export const apiQueryTeamById = (id) => {
//     return axios.request({
//         url: '/risk/stat/indicators/SelectIndicatorsById?id=' + id,
//         method: 'get'
//     });
// };
// export const apiQueryTeamById = (id) => {
//     return axios.request({
//         url: '/mkmm/sales/teamMains/pageByJqGrid?id=' + id,
//         method: 'get'
//     });
// };
export const apiSubmitToReview = (data) => {
    // var params = new URLSearchParams();
    // params.append('data', data);
    return axios.request({
        url: '/risk/stat/indicators/UpdateIndicatorsRest',
        // params: qs.stringify(data),
        params: data,
        method: 'get'
        // headers: {
        //     'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        // }
        // headers: {'Content-Type': 'application/json'}
    });
};
// export const apiSubmitToReview = (data) => {
//     return axios.request({
//         url: '/mkmm/sales/teamReviews/edit/' + data.id,
//         data,
//         method: 'patch'
//     });
// };
// export const apiTeamAddToReview = (data) => {
//     return axios.request({
//         url: '/mkmm/sales/teamReviews/add',
//         data,
//         method: 'post'
//     });
// };
