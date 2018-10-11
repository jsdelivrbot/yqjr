<style lang="less">
    @import '../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="formValidate" :rules="ruleValidate" :model="formValidate" :label-width="100">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    用户信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="登录名:" prop="loginName">
                            <Input  placeholder="请输入登录名" v-model="formValidate.loginName" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="用户名称:" prop="userName">
                            <Input  placeholder="请输入用户名称" v-model="formValidate.userName" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="密码:" prop="password">
                            <Input  placeholder="请输入密码" v-model="formValidate.password" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="确认密码:" prop="pwd">
                            <Input  placeholder="请输入确认密码" v-model="formValidate.pwd" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="所属公司:" prop="comCode">
                            <Select v-model="formValidate.comCode" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2" >
                        <FormItem label="所属机构:" prop="affiliation">
                            <Select v-model="formValidate.affiliation" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="OA员工编号:" prop="oa">
                            <Input  placeholder="请输入OA员工编号" v-model="formValidate.indicatordesc" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2" >
                        <FormItem label="是否预警:" prop="alertflag">
                            <Select v-model="formValidate.alertflag" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="是否启用:" prop="enabledflag">
                            <Select v-model="formValidate.enabledflag" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2" >
                        <FormItem label="显示顺序:" pop="displayorder">
                            <Input  placeholder="请输入显示顺序" v-model="formValidate.displayorder" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="上级指标:" pop="parentindicatorcode">
                            <Input  placeholder="请输入上级指标" v-model="formValidate.parentindicatorcode" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2" >
                        <FormItem label="归属公司:" prop="comcode">
                            <Select v-model="formValidate.comcode" style="width:200px">
                                <Option v-for="item in cityList2" :value="item.label" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="12" offset="2" >
                        <FormItem label="备注:" pop="remark">
                            <Input  placeholder="请输入备注" v-model="formValidate.remark" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="12" offset="2" >
                        <FormItem label="公式:" pop="calformula">
                            <Input  placeholder="请输入公式" v-model="formValidate.calformula" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="9">
                        <Button type="primary" icon="checkmark" @click="subTeamAddToRev('formValidate')" :loading="loading">添加</Button>
                    </Col>
                    <Col span="4" >
                        <Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>
                    </Col>
                </Row>
            </Card>
        </Form>
    </div>
</template>
