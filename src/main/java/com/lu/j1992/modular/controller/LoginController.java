package com.lu.j1992.modular.controller;

import com.lu.j1992.jwts.commom.JwtClaims;
import com.lu.j1992.modular.service.LoginService;
import com.lu.j1992.modular.tools.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2019/7/28.
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     *
     * @param customerId
     * @return
     */
    @GetMapping(value = "/login")
    public Json login(String customerId) {
        try {
            return Json.newInstance(loginService.login(customerId));
        } catch (Exception e) {
            log.error("登录失败，错误信息{}", e.getMessage());
            return Json.CODE_500;
        }
    }

    /**
     * 登录
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/findCustomerById")
    public Json findCustomerById(HttpServletRequest request) {
        try {
            String customerId = ((JwtClaims) request.getAttribute("claims")).get("id").toString();
            return Json.newInstance(loginService.findCustomerById(customerId));
        } catch (Exception e) {
            log.error("登录失败，错误信息{}", e.getMessage());
            System.out.println("sssss");
            return Json.CODE_500;
        }
    }
}
