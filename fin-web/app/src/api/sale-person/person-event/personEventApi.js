import axios from '../../../libs/api.request';
export const apiPersonEventList = (data) => {
    return axios.request({
        url: 'mkmm/sales/eventPersons/pageByJqGridList?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
export const apiQueryPersonEventById = (id) => {
    return axios.request({
        url: '/mkmm/sales/eventPersons/pageByJqGridList?id=' + id,
        method: 'get'
    });
};

export const apiPersonEventEditSubToRev = (data) => {
    return axios.request({
        url: '/mkmm/sales/eventPersons/updateById',
        data,
        method: 'post'
    });
};

export const apiPersonEventAddSub = (data) => {
    return axios.request({
        url: '/mkmm/sales/eventPersons/insertById',
        data,
        method: 'post'
    });
};

export const apiDelPersonEventList = (data) => {
    return axios.request({
        url: '/mkmm/sales/eventPersons/batch/' + data.toString(),
        method: 'delete'
    });
};

export const apiQueryBySearchPerson = (data) => {
    return axios.request({
        url: '/mkmm/sales/autoComplete/Person?name=' + data,
        method: 'get'
    });
};
