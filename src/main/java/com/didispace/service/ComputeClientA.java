package com.didispace.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-A")
public interface ComputeClientA {

    /**
     * addA是service-A的服务
     * @param a
     * @param b
     * @param accessToken
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/addA")
    String addFeignA(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b, @RequestParam(value = "accessToken") String accessToken);

}