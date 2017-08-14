package com.lbadvisor.work.controller;

import com.lbadvisor.work.entity.LbadvisorUser;
import com.lbadvisor.work.entity.LbadvisorUserLog;
import com.lbadvisor.work.service.LbadvisorUserLogService;
import com.lbadvisor.work.service.LbadvisorUserService;
import com.lbadvisor.work.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by huicai on 2017/8/11.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("whchat/v1/log")
public class LogControllerV1 {

    @Autowired
    private LbadvisorUserLogService lbadvisorUserLogService;

    @Autowired
    private LbadvisorUserService lbadvisorUserService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Response save(@RequestParam String openid, @RequestParam String userLog, @RequestParam int workHour, @RequestParam String workProudctName) {
        LbadvisorUser lbadvisorUser = lbadvisorUserService.getByOpenid(openid);
        if (null == lbadvisorUser) {
            return new Response().failure("openid is error");
        }
        LbadvisorUserLog lbadvisorUserLog = new LbadvisorUserLog();
        lbadvisorUserLog.setUserId(lbadvisorUser.getId());
        lbadvisorUserLog.setUserLog(userLog);
        lbadvisorUserLog.setWorkHour(workHour + 1);
        lbadvisorUserLog.setWorkProudctName(workProudctName);
        lbadvisorUserLog.setCreateTime(new Date());
        String result = lbadvisorUserLogService.saveLbadvisorUserLog(lbadvisorUserLog);
        return new Response().success(result);
    }
}
