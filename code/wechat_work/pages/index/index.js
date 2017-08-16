//index.js
//获取应用实例
var app = getApp()
Page({
  data: {
    motto: 'Hello World',
    userInfo: {}
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../addlog/addlog'
    })
  },
  //跳转日志列表
  tologlist: function(){
    wx.switchTab({
      url: '../logList/logList',
    })
  },
  //跳转添加页面
  tosavelog: function(){
    wx.navigateTo({
      url: '../addlog/addlog',
    })
  },
  //最近一周日志
  today7log: function(){
    wx.switchTab({
      url: '../logList/logList',
    })
  },
  //跳转asm智投
  toasmzt: function(){
  },
  //跳转app反欺诈
  toappfqz: function(){
  },
  //跳转营销数据解决方案
  toyxshu: function(){

  },
  onLoad: function () {
    console.log('onLoad');
    app.onLaunch();
    var that = this;
    //调用应用实例的方法获取全局数据
    app.getUserInfo(function(userInfo){
      //更新数据
      that.setData({
        userInfo:userInfo
      })
    })
  }
})
