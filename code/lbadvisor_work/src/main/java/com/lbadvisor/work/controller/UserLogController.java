package com.lbadvisor.work.controller;

import com.lbadvisor.work.entity.LbadvisorUser;
import com.lbadvisor.work.entity.LbadvisorUserLog;
import com.lbadvisor.work.service.LbadvisorUserLogService;
import com.lbadvisor.work.service.LbadvisorUserService;
import com.lbadvisor.work.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/whchat/userLog")
public class UserLogController {

    @Autowired
    private LbadvisorUserLogService lbadvisorUserLogService;

    @Autowired
    private LbadvisorUserService lbadvisorUserService;


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Response getUsers() {

        return new Response().success(lbadvisorUserLogService.find());
    }

    @RequestMapping(value = "findUserLogByopenid", method = RequestMethod.POST)
    public Response findUserLogByopenid(HttpServletRequest request, String openid) {
        return lbadvisorUserLogService.findUserLogByopenid(openid);
    }

    /**
     * <B>功能简述</B><br>
     * 日志保存功能
     *
     * @param openid
     * @param userLog
     * @param workHour
     * @param workProudctName
     * @return
     * @date 2017/8/14 下午5:11
     * @author liuhongshen
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Response save(@RequestParam String openid, @RequestParam String userLog, @RequestParam int workHour, @RequestParam String workProudctName) {
        LbadvisorUser lbadvisorUser = lbadvisorUserService.getByOpenid(openid);
        if (null == lbadvisorUser) {
            return new Response().failure("openid is error");
        }
        LbadvisorUserLog lbadvisorUserLog = new LbadvisorUserLog();
        lbadvisorUserLog.setUserId(lbadvisorUser.getId());
        lbadvisorUserLog.setUserLog(userLog.trim());
        lbadvisorUserLog.setWorkHour(workHour + 1);
        lbadvisorUserLog.setWorkProudctName(workProudctName);
        lbadvisorUserLog.setCreateTime(new Date());
        String result = lbadvisorUserLogService.saveLbadvisorUserLog(lbadvisorUserLog);
        return new Response().success(result);
    }

}
