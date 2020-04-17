package com.ly.orderingsystem.controller;

import com.ly.orderingsystem.entity.Unit;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.result.AjaxResult;
import com.ly.orderingsystem.result.ResultFactory;
import com.ly.orderingsystem.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/*
/实现计量单位的增删改查
 */
@RestController
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;
    @RequestMapping("/getUnits")
    //查询所有单位信息
    public Page getUnits(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size){
        return unitService.getUnits(page,size);
    }

    @RequestMapping("/getUnit")
    //根据ID查询单位信息
    public Unit getUnti(@RequestParam Integer unitId){
        return unitService.getUnit(unitId);
    }

    @RequestMapping("/addUnit")
    //添加单位信息
    public AjaxResult addUnit(@RequestBody Unit unit){
        String message=unitService.addUnit(unit);
        return ResultFactory.buildFailResult(message);
    }

    //修改单位信息
    @RequestMapping("/update")
    public AjaxResult updateUnit(@RequestParam Integer unitId,
                                 @RequestBody Unit unit){
        unit.setUnitId(unitId);
       String msg=unitService.updateById(unit);
      return ResultFactory.buildFailResult(msg);
    }
    //删除单位信息
    @RequestMapping("/delete")
    public AjaxResult deleteUnti(@RequestParam Integer unitId) {
        String msg = unitService.deleteById(unitId);
        return ResultFactory.buildFailResult(msg);

    }
    }

