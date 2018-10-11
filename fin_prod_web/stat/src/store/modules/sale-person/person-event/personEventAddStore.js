import { apiPersonEventAddSub, apiQueryBySearchPerson } from '../../../../api/sale-person/person-event/personEventApi';
import config from '@/config';

const personEventAdd = {
    state: {
        searchPersonData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize:
        config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0, // 总页数
        isSuccess: true,
        msg: '添加成功'
    },
    actions: {
        handlePersonEventAddSub ({ commit }, addPersonEventAdd) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiPersonEventAddSub(addPersonEventAdd).then(res => {
                    commit('setPersonEventAdd', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleQueryBySearchPerson ({ commit }, addPersonEventAddSearchData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryBySearchPerson(addPersonEventAddSearchData).then(res => {
                    commit('setPersonEventAddSeachData', res);
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
        setPersonEventAdd (state, data) {
            state.isSuccess = data.isSuccess;
            state.msg = data.msg;
        },
        setPersonEventAddSeachData (state, data) {
            state.isSuccess = data.isSuccess;
            state.msg = data.msg;
            state.searchPersonData = data.result;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default personEventAdd;
