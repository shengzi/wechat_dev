package com.lbadvisor.work.controller;

import com.lbadvisor.work.service.LbadvisorUserLogService;
import com.lbadvisor.work.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/whchat/userLog")
public class UserLogController {

    @Autowired
    private LbadvisorUserLogService lbadvisorUserLogService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Response getUsers() {

        return new Response().success( lbadvisorUserLogService.find() );
    }

    @RequestMapping(value="findUserLogByopenid" ,method = RequestMethod.POST)
    public Response findUserLogByopenid(HttpServletRequest request, String openid){
        return lbadvisorUserLogService.findUserLogByopenid(openid);
    }

}
