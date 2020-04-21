package com.ly.orderingsystem.controller;

import com.ly.orderingsystem.entity.StoreType;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.result.AjaxResult;
import com.ly.orderingsystem.result.ResultFactory;
import com.ly.orderingsystem.service.StoreService;
import com.ly.orderingsystem.service.StoreTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storeType")
public class StoreTypeController {
    @Autowired
    private StoreTypeService storeTypeService;
    //获取所有分类信息
    @RequestMapping("/getStoreTypes")
    public Page getStoreTypes(@RequestParam(defaultValue = "1")Integer page,
                              @RequestParam(defaultValue = "5")Integer size){
        return storeTypeService.getStoreTypes(page,size);
    }
    //获取一个分类信息
    @RequestMapping("/getStoreType")
    public StoreType getStoreType(@RequestParam Integer typeId){
        return storeTypeService.getStoreType(typeId);
    }

    //增加一个分类
    @RequestMapping("/addStoreType")
    public AjaxResult addStoreType(@RequestBody StoreType storeType){
        String msg=storeTypeService.addStoreType(storeType);
        return ResultFactory.buildFailResult(msg);
    }

    //修改一个分类
    @RequestMapping("/updateStoreType")
    public AjaxResult updateStoreType(@RequestParam Integer typeId,@RequestBody StoreType storeType){
        storeType.setTypeId(typeId);
        String msg=storeTypeService.updateStoreType(storeType);
        return ResultFactory.buildFailResult(msg);
    }

    //删除一个分类
    @RequestMapping("/deleteStoreType")
    public AjaxResult deleteStoreType(@RequestParam Integer typeId){
        String msg=storeTypeService.deleteStoreType(typeId);
        return ResultFactory.buildFailResult(msg);
    }

}
