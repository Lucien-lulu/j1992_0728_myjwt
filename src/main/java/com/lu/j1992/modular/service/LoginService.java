package com.lu.j1992.modular.service;

import com.lu.j1992.jwts.commom.*;
import com.lu.j1992.modular.entity.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/7/28.
 */
@Service
public class LoginService {
    @Value("${jwt.safety.secret}")
    private String jwtSafetySecret;

    @Value("${jwt.valid.time}")
    private int jwtValidTime;

    /**
     * 登录
     * @param customerId
     * @return
     */
    public String login(String customerId) {
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setName("jiayao");
        customer.setPhone("1234567890");
        return createTokenString(customer);
    }

    /**
     * 根据id查用户
     *
     * @param customerId
     * @return
     */
    public Customer findCustomerById(String customerId) {
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setName("jiayao");
        customer.setPhone("1234567890");
        return customer;
    }

    /**
     * 生成token
     *
     * @param customer
     * @return
     */
    public String createTokenString(Customer customer) {
        String jwtToken = null;
        try {
            jwtToken = Jwts.header(Header.SM4, jwtSafetySecret)
                    .payload(new JwtClaims()
                            .put("id", customer.getId())
                            .put("name", customer.getName())
                            .put("phone", customer.getPhone())
                            .put("failureTime", FailureTimeUtils.createValidTime(FailureTime.DAY, jwtValidTime))
                            .put("mytest", "我的个性属性"))
                    .compact();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jwtToken.replaceAll("\r\n","");
    }
}
