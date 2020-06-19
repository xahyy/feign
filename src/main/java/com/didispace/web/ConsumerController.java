package com.didispace.web;

import com.didispace.service.ComputeClient;
import com.didispace.service.ComputeClientA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    ComputeClient computeClient;

    @Autowired
    ComputeClientA computeClientA;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 20);
    }

    /**
     * addB是service-B的服务,请求成功
     * @return
     */
    @RequestMapping(value = "/addFeign", method = RequestMethod.GET)
    public String addaddFeign() {
        return computeClient.addFeign(10, 20,"123456");//computeClient
    }

    /**
     * addBX不是service-B的服务,请求失败
     * @return
     */
    @RequestMapping(value = "/addFeignX", method = RequestMethod.GET)
    public String addaddFeignX() {
        return computeClient.addFeignX(10, 20,"123456");//computeClient
    }

    /**
     * addA是service-A的服务,请求成功
     * @return
     */
    @RequestMapping(value = "/addFeignA", method = RequestMethod.GET)
    public String addFeignA() {
        return computeClientA.addFeignA(10, 20,"123456");//computeClientA
    }

    /**
     * addA不是service-B的服务,请求失败
     * @return
     */
    @RequestMapping(value = "/addFeignAA", method = RequestMethod.GET)
    public String addFeignAA() {
        return computeClient.addFeignA(10, 20,"123456");//computeClient
    }
}