package com.lbadvisor.work.service;

import com.alibaba.fastjson.JSONObject;
import com.lbadvisor.work.dao.LbadvisorUserDao;
import com.lbadvisor.work.dao.LbadvisorUserLogDao;
import com.lbadvisor.work.entity.LbadvisorUser;
import com.lbadvisor.work.entity.LbadvisorUserLog;
import com.lbadvisor.work.utils.BeanToMapUtil;
import com.lbadvisor.work.utils.HttpRequest;
import com.lbadvisor.work.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

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

    private static String secret = "e2ec5f79376448379d4fb4380e6dd2d8";

    private static final Logger log = LoggerFactory.getLogger(MainServiceV1.class);

    @Autowired
    private LbadvisorUserDao lbadvisorUserDao;

    @Autowired
    private LbadvisorUserLogDao lbadvisorUserLogDao;
    /**
     * 获取openId
     * @param code
     * @return
     */
    public Response getOpenIdByCode(String code) {
        JSONObject obj = null;
        try {
            String rlt = HttpRequest.sendRedirect("https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret="+secret+"&js_code="+code+"&grant_type=authorization_code");
            obj = JSONObject.parseObject(rlt);
            if (null == obj.get("openid")) {
                log.info("rlt:",rlt);
                return new Response().failure("请求失败请稍后再试");
            }
        } catch (Exception e) {
            log.error("getOpenIdByCode is error:",e);
            return new Response().failure("请求失败请稍后再试");
        }
        return new Response().success(obj.get("openid"));
    }

    public Response saveUser(LbadvisorUser lbadvisorUser) {
        lbadvisorUser.setAppId(appid);
        LbadvisorUser oldLbadvisorUser=lbadvisorUserDao.getByOpenId(lbadvisorUser.getOpenid());
        if (null == oldLbadvisorUser) {
            lbadvisorUser.setCreateTime(new Date());
            lbadvisorUser.setUpdateTime(new Date());
            lbadvisorUserDao.insert(lbadvisorUser);
        } else {
            lbadvisorUser.setId(oldLbadvisorUser.getId());
            lbadvisorUser.setUpdateTime(new Date());
            lbadvisorUserDao.update(lbadvisorUser);
        }
        return new Response().success("添加成功");
    }

}