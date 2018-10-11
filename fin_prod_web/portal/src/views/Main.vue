<style lang="less">
    @import "./main.less";
    #iframeParent{
        overflow: hidden;
    }
    #iframe-parent{
        overflow: hidden;
    }
</style>
<template>
    <div class="main" :class="{'main-hide-text': shrink}" id="grandParent">
        <div class="sidebar-menu-con" :style="{width: shrink?'60px':'270px', overflow: shrink ? 'visible' : 'auto',background: menuTheme=='dark'?'#495060':'#fff'}">
            <scroll-bar ref="scrollBar">
                <shrinkable-menu
                        :shrink="shrink"
                        @on-change="handleSubmenuChange"
                        :theme="menuTheme"
                        :before-push="beforePush"
                        :open-names="openedSubmenuArr"
                        :menu-list="menuList">
                    <div slot="top" class="logo-con">
                        <img v-show="!shrink"  src="../images/logo.jpg" key="max-logo" />
                        <img v-show="shrink" src="../images/logo-min.jpg" key="min-logo" />
                    </div>
                </shrinkable-menu>
            </scroll-bar>
        </div>
        <div class="main-header-con" :style="{paddingLeft: shrink?'60px':'270px'}">
            <div class="main-header">
                <div class="navicon-con">
                    <Button :style="{transform: 'rotateZ(' + (this.shrink ? '-90' : '0') + 'deg)'}" type="text" @click="toggleClick">
                        <Icon type="navicon" size="32"></Icon>
                    </Button>
                </div>
                <div class="header-middle-con">
                    <div class="main-breadcrumb">
                        <breadcrumb-nav :currentPath="currentPath"></breadcrumb-nav>
                    </div>
                </div>

                <div class="navigation-con">
                    <Dropdown style="margin-left: 20px" @on-click="changSystem">
                        <i-button type="primary" >
                            {{systemName}}
                            <Icon type="arrow-down-b"></Icon>
                        </i-button>
                        <Dropdown-menu slot="list" >
                            <Dropdown-item   v-for="(systemNamelist,index) in systemNamelist" :name="index">{{systemNamelist}}</Dropdown-item>
                        </Dropdown-menu>
                    </Dropdown>
                </div>

                <div class="header-avator-con">
                    <full-screen v-model="isFullScreen" @on-change="fullscreenChange"></full-screen>
                    <!--<lock-screen></lock-screen>-->
                    <!--<message-tip v-model="mesCount"></message-tip>-->
                    <theme-switch></theme-switch>

                    <div class="user-dropdown-menu-con">
                        <Row type="flex" justify="end" align="middle" class="user-dropdown-innercon">
                            <Dropdown transfer trigger="click" @on-click="handleClickUserDropdown">
                                <a href="javascript:void(0)">
                                    <span class="main-user-name">{{ loginName }}</span>
                                    <Icon type="arrow-down-b"></Icon>
                                </a>
                                <DropdownMenu slot="list">
                                    <DropdownItem name="ownSpace">个人中心</DropdownItem>
                                    <DropdownItem name="loginout" divided>退出登录</DropdownItem>
                                </DropdownMenu>
                            </Dropdown>
                            <Avatar shape="circle" icon="person" style="background: #619fe7;margin-left: 10px;"></Avatar>
                        </Row>
                    </div>
                </div>
            </div>
            <div class="tags-con">
                <tags-page-opened :pageTagsList="pageTagsList"></tags-page-opened>
            </div>
        </div>
        <div class="single-page-con" id="iframeParent" :style="{left: shrink?'60px':'270px'}">
            <div class="single-page" id="iframe-parent" style="margin:0;">
                <!--<keep-alive :include="cachePage">-->
                    <router-view></router-view>
                <!--</keep-alive>-->
                <!--将keep-alive删除 为了不发生缓存 如果产生缓存 则会导致个人中心页面的设置宽度自适应函数 在mounted里面只执行一次-->
            </div>
        </div>
    </div>
</template>
<script>
    /* eslint-disable no-console,no-undef */

    import shrinkableMenu from './main-components/shrinkable-menu/shrinkable-menu.vue';
    import tagsPageOpened from './main-components/tags-page-opened.vue';
    import breadcrumbNav from './main-components/breadcrumb-nav.vue';
    import fullScreen from './main-components/fullscreen.vue';
    import lockScreen from './main-components/lockscreen/lockscreen.vue';
    import messageTip from './main-components/message-tip.vue';
    import themeSwitch from './main-components/theme-switch/theme-switch.vue';
    import Cookies from 'js-cookie';
    import { mapActions } from 'vuex';
    import util from '@/libs/util.js';
    import scrollBar from '@/views/my-components/scroll-bar/vue-scroller-bars';

    export default {
        components: {
            shrinkableMenu,
            tagsPageOpened,
            breadcrumbNav,
            fullScreen,
            lockScreen,
            messageTip,
            themeSwitch,
            scrollBar
        },
        data () {
            return {
                shrink: false,
                loginName: '',
                systemName: '',
                systemNamelist: '',
                isFullScreen: false,
                openedSubmenuArr: this.$store.state.app.openedSubmenuArr,
                menuArr: []
            };
        },
        computed: {
            menuList () {
                return this.$store.state.app.menuList;
            },
            pageTagsList () {
                return this.$store.state.app.pageOpenedList; // 打开的页面的页面对象
            },
            currentPath () {
                return this.$store.state.app.currentPath; // 当前面包屑数组
            },
            avatorPath () {
                return localStorage.avatorImgPath;
            },
            cachePage () {
                return this.$store.state.app.cachePage;
            },
            lang () {
                return this.$store.state.app.lang;
            },
            menuTheme () {
                return this.$store.state.app.menuTheme;
            },
            mesCount () {
                return this.$store.state.app.messageCount;
            }
        },
        methods: {
            ...mapActions([
                'handlegettextMenu'
            ]),
            init () {
                let pathArr = util.setCurrentPath(this, this.$route.name);
                this.$store.commit('updateMenulist');
                console.log(JSON.parse(Cookies.get('user')));
                this.systemNamelist = JSON.parse(Cookies.get('user')).roleSystemNameList;
                this.systemName = JSON.parse(Cookies.get('user')).roleSystemNameList[0];
                this.handlegettextMenu({
                    systemId: JSON.parse(Cookies.get('user')).roleSystemIdList[0]}).then(res => {
                });
                if (pathArr.length >= 2) {
                    this.$store.commit('addOpenSubmenu', pathArr[1].name);
                }
                this.loginName = JSON.parse(Cookies.get('user')).loginName;
                let messageCount = 3;
                this.messageCount = messageCount.toString();
                this.checkTag(this.$route.name);
                this.$store.commit('setMessageCount', 3);
                this.setIframeElement();
            },
            toggleClick () {
                this.shrink = !this.shrink;
                // 如果点击 this.shrink = false 的时候 左边导航width = 270px
                if (this.shrink === false) {
                    this.leftNavWidth = 270;
                    this.setIframeElement();
                    this.setChildPage();
                } else {
                    // 如果点击 this.shrink = true 的时候 左边导航width = 60px
                    this.leftNavWidth = 60;
                    this.setIframeElement();
                    this.setChildPage();
                }
            },
            // 点击隐藏左边或打开左边导航后执行此方法 设置子页面的宽度和高度跟随变化
            // iframe的父亲页面show-iframe-wrap 与 首页home（或其他..如个人中心）的父亲页面mainPage 是并列的关系 一次只能存在一个 所以条件判断
            setChildPage () {
                var grandParentHeight = document.getElementById('grandParent').offsetHeight;
                var grandParentWidth = document.getElementById('grandParent').offsetWidth;
                if (document.getElementById('show-iframe-wrap') === null) {
                    // iframe的父亲页面
                    document.getElementById('mainPage').style.height = grandParentHeight - 100 + 'px';
                    document.getElementById('mainPage').style.width = grandParentWidth - this.leftNavWidth + 'px';
                } else if (document.getElementById('mainPage') === null) {
                    // 首页home的父亲页面
                    document.getElementById('show-iframe-wrap').style.height = grandParentHeight - 100 + 'px';
                    document.getElementById('show-iframe-wrap').style.width = grandParentWidth - this.leftNavWidth + 'px';
                }
            },
            changSystem: function (i) {
                this.systemName = JSON.parse(Cookies.get('user')).roleSystemNameList[i];
                this.handlegettextMenu({
                    systemId: JSON.parse(Cookies.get('user')).roleSystemIdList[i]}).then(res => {
                });
            },
            handleClickUserDropdown (name) {
                if (name === 'ownSpace') {
                    util.openNewPage(this, 'ownspace_index');
                    this.$router.push({
                        name: 'ownspace_index'
                    });
                } else if (name === 'loginout') {
                    // 退出登录
                    this.$store.commit('logout', this);
                    this.$store.commit('clearOpenedSubmenu');
                    this.$router.push({
                        name: 'login'
                    });
                }
            },
            checkTag (name) {
                if (name === 'work_iframe') {
                    name = this.$route.params.pathName;
                }
                let openpageHasTag = this.pageTagsList.some(item => {
                    if (item.name === name) {
                        return true;
                    }
                });
                if (!openpageHasTag) { //  解决关闭当前标签后再点击回退按钮会退到当前页时没有标签的问题
                    util.openNewPage(this, name, this.$route.params || {}, this.$route.query || {});
                }
            },
            // 点击菜单
            handleSubmenuChange (name) {
                this.menuArr.push(name);
                if (this.menuArr[0] === name) {
                    if (document.getElementById('show-iframe') !== null) {
                        window.frames[0].postMessage({
                            act: 'reload',
                            msg: {
                                isReload: true
                            }
                        }, '*');
                    }
                }
                if (this.menuArr.length > 1) {
                    this.menuArr.shift();
                }
            },
            beforePush (name) {
                // if (name === 'accesstest_index') {
                //     return false;
                // } else {
                //     return true;
                // }
                return true;
            },
            fullscreenChange (isFullScreen) {
                // console.log(isFullScreen);
                // 延时100ms后获取高度 重新设置
                setTimeout(() => {
                    this.setAgainHeight();
                }, 10);
            },
            setAgainHeight () {
                var h = document.getElementById('grandParent').offsetHeight;
                // console.log(document.getElementById('grandParent').offsetHeight);
                document.getElementById('iframeParent').style.height = h - 100 + 'px';
                document.getElementById('iframe-parent').style.height = h - 100 + 'px';
                if (document.getElementById('show-iframe-wrap') !== null) {
                    document.getElementById('show-iframe-wrap').style.height = h - 100 + 'px';
                } else if (document.getElementById('mainPage') !== null) {
                    document.getElementById('mainPage').style.height = h - 100 + 'px';
                }
            },
            scrollBarResize () {
                this.$refs.scrollBar.resize();
            },
            setIframeParent (e) {
                if (e.data.act === 'top') {
                    document.getElementById('iframe-parent').scrollTop = e.data.msg.size;
                }
            },
            // 页面初始化 设置div：iframeParent及 div：iframe-parent 的宽高
            // div：的宽度：最外层宽度 - 左边导航的宽度（270/60）
            // div：的高度：最外层高度 - 上边导航的高度（100）
            setIframeElement () {
                var grandParentHeight = document.getElementById('grandParent').offsetHeight; // 获取页面最外层div的高度
                var grandParentWidth = document.getElementById('grandParent').offsetWidth; // 获取页面最外层div的宽度
                document.getElementById('iframeParent').style.height = grandParentHeight - 100 + 'px'; // 设置div:iframeParent的高度
                document.getElementById('iframeParent').style.left = this.leftNavWidth + 'px'; // 设置div:iframeParent居左的距离为270或60
                document.getElementById('iframeParent').style.width = grandParentWidth - this.leftNavWidth + 'px'; // 设置div:iframeParent的宽度
                document.getElementById('iframe-parent').style.height = grandParentHeight - 100 + 'px'; // 设置div:iframe-parent的高度
                document.getElementById('iframe-parent').style.width = grandParentWidth - this.leftNavWidth + 'px'; // 设置div:iframe-parent的宽度
            }
        },
        watch: {
            '$route' (to) {
                let toName = to.name;
                this.$store.commit('setCurrentPageName', toName);
                let pathArr = util.setCurrentPath(this, toName);
                if (pathArr.length > 2) {
                    this.$store.commit('addOpenSubmenu', pathArr[1].name);
                }
                this.checkTag(toName);
                if (name === 'work_iframe') {
                    localStorage.currentPageName = to.params.pathName;
                } else {
                    localStorage.currentPageName = toName;
                }
            },
            lang () {
                util.setCurrentPath(this, this.$route.name); // 在切换语言时用于刷新面包屑
            },
            openedSubmenuArr () {
                setTimeout(() => {
                    this.scrollBarResize();
                }, 300);
            }
        },
        mounted () {
            this.init();
            window.addEventListener('resize', this.scrollBarResize);
            window.addEventListener('message', this.setIframeParent);
        },
        created () {
            // 显示打开的页面的列表
            // this.$store.commit('setOpenedList');
        },
        dispatch () {
            window.removeEventListener('resize', this.scrollBarResize);
            window.removeEventListener('message', this.setIframeParent);
        }
    };
</script>
