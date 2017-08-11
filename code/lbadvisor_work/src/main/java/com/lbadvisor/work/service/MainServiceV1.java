package com.lbadvisor.work.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lbadvisor.work.utils.HttpRequest;
import com.lbadvisor.work.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbadvisor.work.entity.LbadvisorSubUser;
import com.lbadvisor.work.utils.orm.mybatis.MyBatisDao;
import com.lbadvisor.work.utils.orm.mybatis.MyBatisService;
import com.lbadvisor.work.dao.LbadvisorSubUserDao;

/**
 *
 * <B>功能简述</B><br>
 * LbadvisorSubUser service 类
 *
 * @date  2017年08月11日 10:17:30
 * @since     [工作日志 /service v1.0]
 */
@Service
public class MainServiceV1 {

    private static String appid = "wx022ccc17b7ab8b38";
    private static final Logger log = LoggerFactory.getLogger(MainServiceV1.class);

    /**
     * 获取openId
     * @param code
     * @return
     */
    public Response getOpenIdByCode(String code) {
        String rlt = HttpRequest.sendRedirect("https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=SECRET&js_code=JSCODE&grant_type=authorization_code");
        JSONObject obj = JSONObject.parseObject(rlt);
        if (null == obj.get("openid")) {
            log.info("rlt:",rlt);
            return new Response().failure("请求失败请稍后再试");
        }
        return new Response().success(obj.get("openid"));
    }

}