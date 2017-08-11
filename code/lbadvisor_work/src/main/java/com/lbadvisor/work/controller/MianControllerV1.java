package com.lbadvisor.work.controller;

import org.springframework.web.bind.annotation.*;

/**
 *登录
 * @author wn
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/whchat/v1")
public class MianControllerV1 {
    /**
     * 查询关键词
     * @param openId
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(@RequestParam String openId) {
        return null;
    }
}
