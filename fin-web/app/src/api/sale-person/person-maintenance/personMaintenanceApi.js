import axios from '@/libs/api.request';
export const apiPersonList = (data) => {
    return axios.request({
        url: '/mkmm/sales/personMains/pageByJqGrid?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};

export const apiQueryPersonById = (personId) => {
    return axios.request({
        url: '/mkmm/sales/personMains/edit?id=' + personId,
        method: 'get'
    });
};

export const apiQueryBySearchPerson = (searchPerson) => {
    return axios.request({
        url: '/mkmm/sales/personMainReviews/selectByCheckUniquen?searchPerson=' + searchPerson + '&1313123s',
        method: 'get'
    });
};
export const apiQueryBySearchTeam = (searchTeam) => {
    return axios.request({
        url: '/mkmm/sales/autoComplete/Team?name=' + searchTeam,
        method: 'get'
    });
};

export const apiQueryProvinceList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/Province?isUpCode=0',
        method: 'get'
    });
};
export const apiQueryCityList = (provinces) => {
    if (provinces[0] === '00') {
        return axios.request({
            url: '/mkmm/sales/selectCode/City?isUpCode=' + 0,
            method: 'get'
        });
    } else {
        return axios.request({
            url: '/mkmm/sales/selectCode/City?isUpCode=' + 1 + '&upCode=' + provinces,
            method: 'get'
        });
    }
};
export const apiQueryBrandList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrandList?isUpCode=0',
        method: 'get'
    });
};
export const apiAddPersonToRev = (data) => {
    return axios.request({
        url: '/mkmm/sales/personMainReviews/add',
        data,
        method: 'post'
    });
};

export const apiEditPersonToRev = (data) => {
    return axios.request({
        url: '/mkmm/sales/personMains/modify',
        data,
        method: 'post'
    });
};

export const apiValidatePersonNature = (data) => {
    return axios.request({
        url: '/mkmm/sales/personTeams/validatePersonNature?teamCode=' + data,
        method: 'get'
    });
};
