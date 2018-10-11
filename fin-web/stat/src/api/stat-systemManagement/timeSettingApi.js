/* eslint-disable no-undef */
import axios from '../../libs/api.request';

export const apiFindById = (id) => {
    return axios.request({
        url: '/risk/stat/scheduleJobs/findById?id=' + id,
        method: 'get'
    });
};

export const apiDelete = (data) => {
    return axios.request({
        url: '/risk/stat/scheduleJobs/delete?ids=' + data.toString(),
        method: 'get'
    });
};
export const apiList = (data) => {
    return axios.request({
        url: '/risk/stat/scheduleJobs/pageByJqGrid?pageNum=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
export const apiAdd = (data) => {
    return axios.request({
        url: '/risk/stat/scheduleJobs/add',
        params: data,
        method: 'post'
    });
};
export const apiUpdate = (data) => {
    return axios.request({
        url: '/risk/stat/scheduleJobs/update',
        params: data,
        method: 'GET'
    });
};

export const apiPause = (data) => {
    return axios.request({
        url: '/risk/stat/scheduleJobs/pause?ids=' + data.toString(),
        method: 'get'
    });
};
export const apiResume = (data) => {
    return axios.request({
        url: '/risk/stat/scheduleJobs/resume?ids=' + data.toString(),
        method: 'get'
    });
};
export const apiRunOnce = (data) => {
    return axios.request({
        url: '/risk/stat/scheduleJobs/runOnce?ids=' + data.toString(),
        method: 'get'
    });
};
