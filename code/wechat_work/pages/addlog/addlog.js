//获取应用实例
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    openid: "",
    title:"创建日志",
    array: ['东易cim', 'asm智投', 'A米'],
    index: 0,
    hourArray: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12],
    hourIndex: 0
  },

  bindPickerChange: function (e) {
    this.setData({
      index: e.detail.value
    })
  },
  bindPickerChangeHour: function (e) {
    this.setData({
      hourIndex: e.detail.value
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    try {
      var value = wx.getStorageSync('openid')
      if (value) {
        that.setData({
          openid: value
        })
      }
    } catch (e) {

    }
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  formSubmit: function (e) {
    var formData = e.detail.value;
    wx.request({
      url: 'http://localhost:8080/whchat/userLog/save',
      method: 'POST',
      data: formData,
      header: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        wx.showToast({
          image: "../image/verygood.png",
          duration: 1000
        })
        setTimeout(function(){
          wx.switchTab({
            url: '../logList/logList'
          })
        },500),
        wx.redirectTo({
          url: '../logList/logList'
        })
      },
      complete: function () {
       
      }
    });
  }
})