package com.lbadvisor.work.controller;

import com.lbadvisor.work.service.MainServiceV1;
import com.lbadvisor.work.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *登录
 * @author wn
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/whchat/v1")
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
}
