package com.ly.orderingsystem.controller;


import com.ly.orderingsystem.entity.DistributionCenter;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.result.AjaxResult;
import com.ly.orderingsystem.result.ResultFactory;
import com.ly.orderingsystem.service.DistributionCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distributionCenter")
public class DistributionCenterController {
    /*
    /配送中心信息的增删改查
     */
    @Autowired
    private DistributionCenterService distributionCenterService;
    @RequestMapping("/getDistributionCenters")
    public Page getDistributionCenters(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "5") Integer size){
        return distributionCenterService.getDistributionCenters(page,size);
    }
    //根据ID获取一个配送中心信息
    @RequestMapping("/getDistributionCenter")
    public DistributionCenter getDistributionCenter(@RequestParam Integer dcId){
        return distributionCenterService.getDistributionCenter(dcId);
    }
    //增加一个配送中心信息
    @RequestMapping("/addDistributionCenter")
    public AjaxResult addDistributionCenter(@RequestBody DistributionCenter distributionCenter){
        String msg=distributionCenterService.addDistributionCenter(distributionCenter);
        return ResultFactory.buildFailResult(msg);
    }
    //修改一个配送中心信息
    @RequestMapping("/updateDistributionCenter")
    public AjaxResult updateDistributionCenter(@RequestParam Integer dcId,
                                               @RequestBody DistributionCenter distributionCenter){
        distributionCenter.setDcId(dcId);
        String msg=distributionCenterService.updateDistributionCenter(distributionCenter);
        return ResultFactory.buildFailResult(msg);
    }

    //删除一个配送中心
    @RequestMapping("/deleteDistributionCenter")
    public AjaxResult deleteDistributionCenter(@RequestParam Integer dcId){
        String msg=distributionCenterService.deleteDistributionCenter(dcId);
        return ResultFactory.buildFailResult(msg);
    }
}
