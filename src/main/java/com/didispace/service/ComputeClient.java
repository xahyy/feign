package com.didispace.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-B")
public interface ComputeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

    /**
     * addB是service-B的服务
     * @param a
     * @param b
     * @param accessToken
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/addB")
    String addFeign(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b, @RequestParam(value = "accessToken") String accessToken);

    /**
     * addBX不是service-B的服务
     * @param a
     * @param b
     * @param accessToken
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/addBX")
    String addFeignX(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b, @RequestParam(value = "accessToken") String accessToken);


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