import {
    apiQueryBySearchPerson,
    apiQueryBySearchTeam,
    apiQueryProvinceList,
    apiQueryCityList,
    apiQueryBrandList,
    apiAddPersonToRev,
    apiValidatePersonNature
} from '../../../../api/sale-person/person-maintenance/personMaintenanceApi';
import {formatDate} from '@/libs/util.js';
const personAdd = {
    state: {
        searchPersonData: {
            personCode: '', // 人员代码
            companyCode: '', // 公司代码
            teamCode: '', // 团队代码
            teamName: '', // 团队名称
            areaCode: '', // 区域代码
            areaName: '', // 区域名称
            personNature: '1', // 人员性质（0团队负责人，1销售经理）
            personLevel: '1', // 人员级别
            personStatus: '0', // 人员状态
            personCheckStart: '', // 考核开始时间
            personUptime: '', // 上岗时间
            personCorrectime: '', // 转正时间
            personTryStartime: '', // 试用期开始时间
            personTryEndtime: '', // 试用期结束时间
            personJointime: '', // 加入我司时间
            remark: '', // 备注
            personName: '', // 人员姓名
            personIdcard: '', // 身份证号
            personAge: '', // 年龄
            personEthnic: '', // 民族
            personMarr: '', // 婚姻状况
            personSchool: '', // 毕业学校
            personSubject: '', // 专业
            personEdu: '', // 最高学历
            personEdulevel: '', // 学位
            personWorktime: '', // 工龄
            personFirstworktime: '', // 参加工作时间
            personAddress: '', // 家庭住址
            personHomephone: '', // 家庭电话
            personWorkphone: '', // 工作电话
            personPhone: '', // 移动电话
            personEmail: '', // e-mail
            personBirth: '', // 出生日期
            reviewStatus: '', // 审核状态（00驳回,01提交审核,02待审核,03审核中,04审核通过）
            startTime: '', // 生效时间
            provinces: [], // 负责省份
            cities: [], // 负责城市
            brands: [], // 负责品牌
            TeamMain: '',
            teamMain: '', // 团队信息
            searchPerson: '', // 登录
            company: '',
            tempTeamName: ''
        },
        searchTeamData: {},
        searchProvinceList: [],
        searchCityList: [],
        searchBrandList: [],
        loading: false,
        msg: '成功',
        isSuccess: true
    },
    actions: {
        handleQueryBySearchPerson ({ commit }, searchPerson) {
            return new Promise((resolve, reject) => {
                apiQueryBySearchPerson(searchPerson).then(res => {
                    commit('setQuerySearchPersonData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleQueryBySearchTeam ({ commit }, searchTeam) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryBySearchTeam(searchTeam).then((res) => {
                    commit('setQuerySearchTeamData', res);
                    commit('success');
                    resolve();
                }).catch((err) => {
                    commit('success');
                    reject(err);
                });
            });
        },

        handleQueryProvinceList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryProvinceList().then((res) => {
                    commit('setQueryProvinceList', res);
                    commit('success');
                    resolve();
                }).catch((err) => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleQueryCityList ({ commit }, provinces) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryCityList(provinces).then((res) => {
                    commit('setQueryCityList', res);
                    commit('success');
                    resolve();
                }).catch((err) => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleQueryBrandList ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryBrandList().then((res) => {
                    commit('setQueryBrandList', res);
                    commit('success');
                    resolve();
                }).catch((err) => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleAddPersonToRev ({ commit }, data) {
            // 格式化UTC时间
            data.personCheckStart = formatDate(new Date(data.personCheckStart), 'yyyy-MM-dd');
            data.personUptime = formatDate(new Date(data.personUptime), 'yyyy-MM-dd');
            data.personCorrectime = formatDate(new Date(data.personCorrectime), 'yyyy-MM-dd');
            data.personTryStartime = formatDate(new Date(data.personTryStartime), 'yyyy-MM-dd');
            data.personTryEndtime = formatDate(new Date(data.personTryEndtime), 'yyyy-MM-dd');
            data.personJointime = formatDate(new Date(data.personJointime), 'yyyy-MM-dd');
            data.personFirstworktime = formatDate(new Date(data.personFirstworktime), 'yyyy-MM-dd');
            data.personBirth = formatDate(new Date(data.personBirth), 'yyyy-MM-dd');
            data.startTime = formatDate(new Date(data.startTime), 'yyyy-MM-dd');
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiAddPersonToRev(data).then((res) => {
                    commit('setAddPersonToRev', res);
                    commit('success');
                    resolve();
                }).catch((err) => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleResetSearchPersonData ({ commit }) {
            commit('resetSearchPersonData');
        },
        handleValidatePersonNature ({ commit }, teamCode) {
            return new Promise((resolve, reject) => {
                apiValidatePersonNature(teamCode).then(res => {
                    commit('setValidatePersonNature', res);
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
        setQuerySearchPersonData: function (state, data) {
            if (data.isSuccess) {
                for (var item in data.result) {
                    state.searchPersonData[item] = data.result[item];
                }
                state.searchPersonData.personBirth = formatDate(new Date(state.searchPersonData.personBirth), 'yyyy-MM-dd');
                state.searchPersonData.personFirstworktime = formatDate(new Date(state.searchPersonData.personFirstworktime), 'yyyy-MM-dd');
            }
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        setQuerySearchTeamData: function (state, data) {
            if (data.isSuccess) {
                state.searchTeamData = data.result;
            }
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        setQueryProvinceList: function (state, data) {
            if (data.isSuccess) {
                state.searchProvinceList = data.result;
            }
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        setQueryCityList: function (state, data) {
            if (data.isSuccess) {
                state.searchCityList = data.result;
            }
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        setQueryBrandList: function (state, data) {
            if (data.isSuccess) {
                state.searchBrandList = data.result;
            }
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        setAddPersonToRev: function (state, data) {
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        resetSearchPersonData: function (state) {
            state.searchPersonData = {
                personCode: '', // 人员代码
                companyCode: '', // 公司代码
                teamCode: '', // 团队代码
                teamName: '', // 团队名称
                areaCode: '', // 区域代码
                areaName: '', // 区域名称
                personNature: '1', // 人员性质（0团队负责人，1销售经理）
                personLevel: '1', // 人员级别
                personStatus: '0', // 人员状态
                personCheckStart: '', // 考核开始时间
                personUptime: '', // 上岗时间
                personCorrectime: '', // 转正时间
                personTryStartime: '', // 试用期开始时间
                personTryEndtime: '', // 试用期结束时间
                personJointime: '', // 加入我司时间
                remark: '', // 备注
                personName: '', // 人员姓名
                personIdcard: '', // 身份证号
                personAge: '', // 年龄
                personEthnic: '', // 民族
                personMarr: '', // 婚姻状况
                personSchool: '', // 毕业学校
                personSubject: '', // 专业
                personEdu: '', // 最高学历
                personEdulevel: '', // 学位
                personWorktime: '', // 工龄
                personFirstworktime: '', // 参加工作时间
                personAddress: '', // 家庭住址
                personHomephone: '', // 家庭电话
                personWorkphone: '', // 工作电话
                personPhone: '', // 移动电话
                personEmail: '', // e-mail
                personBirth: '', // 出生日期
                reviewStatus: '', // 审核状态（00驳回,01提交审核,02待审核,03审核中,04审核通过）
                startTime: '', // 生效时间
                provinces: [], // 负责省份
                cities: [], // 负责城市
                brands: [], // 负责品牌
                TeamMain: '',
                teamMain: '', // 团队信息
                searchPerson: '', // 登录
                company: ''
            };
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        },
        setValidatePersonNature (state, data) {
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
        }
    }
};
export default personAdd;
