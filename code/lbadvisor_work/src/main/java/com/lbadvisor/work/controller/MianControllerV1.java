package com.lbadvisor.work.controller;

import com.lbadvisor.work.entity.LbadvisorUser;
import com.lbadvisor.work.service.MainServiceV1;
import com.lbadvisor.work.utils.Response;
import com.lbadvisor.work.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *登录
 * @author wn
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("lbadvisor_work/whchat/v1")
public class MianControllerV1 {

    @Autowired
    private MainServiceV1 mainServiceV1;

    /**
     * 登录获取openId
     * @param code
     * @return
     */
    @RequestMapping(value = "onLogin",method = RequestMethod.GET)
    public Response login(@RequestParam String code) {
        return mainServiceV1.getOpenIdByCode(code);
    }

    /**
     * 保存用户
     * @param lbadvisorUser
     * @return
     */
    @RequestMapping(value = "onUserSave",method = RequestMethod.POST)
    public Response onUserSave(LbadvisorUser lbadvisorUser, HttpServletRequest request) {
        return mainServiceV1.saveUser(lbadvisorUser);
    }
}
