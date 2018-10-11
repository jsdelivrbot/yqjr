<template>
    <div id="main" class="app-main">
        <router-view></router-view>
    </div>
</template>

<style>
html,body{
    width: 100%;
    height: 100%;
    background: #f0f0f0;
    overflow: auto;
    overflow-x: hidden;
}
.app-main{
    position: absolute;
    width: 100%;
    height: 100%;
}
</style>