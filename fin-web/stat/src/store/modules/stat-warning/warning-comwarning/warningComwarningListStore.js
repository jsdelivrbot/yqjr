import {apiComwarningQueryList, apiselectByIndicatorname, genJuZhiBiaoChaMingZiLuJing, chaXun} from '../../../../api/stat-warning/warning-comwarning/warningComwarningApi.js';
import config from '@/config';

const comwarningList = {
    state: {
        comwarningList: [],
        zhiBiaoQueryList: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        comwarningQueryList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiComwarningQueryList(formQueryData).then(res => {
                    commit('setTeamMainQueryList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        genJuZhiBiaoChaMingZi ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                genJuZhiBiaoChaMingZiLuJing(formQueryData).then(res => {
                    commit('setZhiBiaoList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        selectByIndicatorname ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiselectByIndicatorname(formQueryData).then(res => {
                    commit('setzhibiao1List', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        chaXunButten ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                chaXun(formQueryData).then(res => {
                    commit('setTeamMainQueryList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        }
    },
    mutations: {
        setTeamMainQueryList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.comwarningList = data.rows;
        },
        setZhiBiaoList (state, data) {
            state.zhiBiaoQueryList = data.rows;
        },
        setzhibiao1List (state, data) {
            state.zhiBiaoQueryList = data;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default comwarningList;
