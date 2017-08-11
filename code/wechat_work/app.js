//app.js
App({
  onLaunch: function() {
    wx.login({
      success: function (res) {
        if (res.code) {
          //发起网络请求
          wx.request({
            url: 'http://localhost:8080/lbadvisor_work/whchat/v1/onLogin',
            data: {
              code: res.code
            },
            header: {
              'content-type': 'application/json'
            },
            success: function (res) {
              wx.setStorageSync('openid', res.data.data)
            }
          })
        } else {
          console.log('获取用户登录态失败！' + res.errMsg)
        }
      }
    });
    wx.getUserInfo({
      lang:'zh_CN',
      success: function (res) {
        var userInfo = res.userInfo;
        wx.request({
          url: 'http://localhost:8080/lbadvisor_work/whchat/v1/onUserSave',
          method: 'POST',
          data:{
            nickName:userInfo.nickName,
            photo:userInfo.avatarUrl,
            gender:userInfo.gender, //性别 0：未知、1：男、2：女
            province:userInfo.province,
            city:userInfo.city,
            country:userInfo.country,
            openid:wx.getStorageSync('openid')
          },
          header:{
            'content-type': 'application/x-www-form-urlencoded'
          },
          success: function (res) {
           
          }
        })
      },
      fail: function (res) {
        wx.request({
          url: 'http://localhost:8080/lbadvisor_work/whchat/v1/onUserSave', //仅为示例，并非真实的接口地址
          data: {
            openid: wx.getStorageSync('openid')
          },
          header: {
            'content-type': 'application/x-www-form-urlencoded'
          },
          success: function (res) {
            
          }
        })
      }
    });
  },


  getUserInfo: function(cb) {
    var that = this
    if (this.globalData.userInfo) {
      typeof cb == "function" && cb(this.globalData.userInfo)
    } else {
      //调用登录接口
      wx.getUserInfo({
        withCredentials: false,
        success: function(res) {
          that.globalData.userInfo = res.userInfo
          typeof cb == "function" && cb(that.globalData.userInfo)
        }
      })
    }
  },

  globalData: {
    userInfo: null
  }
})

