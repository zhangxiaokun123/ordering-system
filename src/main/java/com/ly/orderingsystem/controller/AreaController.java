package com.ly.orderingsystem.controller;

import com.ly.orderingsystem.entity.Area;
import com.ly.orderingsystem.model.AreaMaster;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.result.AjaxResult;
import com.ly.orderingsystem.result.ResultFactory;
import com.ly.orderingsystem.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    //获取所有区域信息
    @RequestMapping("/getAreas")
    public Page getAreas(@RequestParam(defaultValue = "1")Integer page,
                         @RequestParam(defaultValue = "5")Integer size){
        return areaService.getAreas(page,size);
    }
    //获取一个区域信息
    @RequestMapping("/getArea")
    public AreaMaster getArea(@RequestParam Integer areaId){
        return areaService.getArea(areaId);
    }

    //增加一个区域信息
    @RequestMapping("/addArea")
    public AjaxResult addArea(@RequestBody AreaMaster areaMaster){
        String msg=areaService.addArea(areaMaster);
        return ResultFactory.buildFailResult(msg);
    }

    //修改一个区域信息
    @RequestMapping("/updateArea")
    public AjaxResult updateArea(@RequestParam Integer areaId,
                                 @RequestBody AreaMaster areaMaster){
        areaMaster.setAreaId(areaId);
        String msg=areaService.updateArea(areaMaster);
        return ResultFactory.buildFailResult(msg);
    }
    //删除一个区域信心
    @RequestMapping("/deleteArea")
    public AjaxResult deleteArea(@RequestParam Integer areaId){
        String msg=areaService.deleteById(areaId);
        return ResultFactory.buildFailResult(msg);
    }

}
