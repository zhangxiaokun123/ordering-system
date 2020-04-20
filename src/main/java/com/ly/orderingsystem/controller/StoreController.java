package com.ly.orderingsystem.controller;

import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.model.StoreMaster;
import com.ly.orderingsystem.result.AjaxResult;
import com.ly.orderingsystem.result.ResultFactory;
import com.ly.orderingsystem.service.StoreService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "门店控制")
@RequestMapping("/store")
public class StoreController {
    /*
    /实现门店信息的增删改查
     */
    @Autowired
    private StoreService storeService;

    //获取所有门店
    @RequestMapping("/getStores")
    public Page getStores(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "5") Integer size){

        return storeService.getStores(page,size);
    }

    //根据ID获取门店信息
    @RequestMapping("/getStore")
    public StoreMaster getStore(@RequestParam Integer storeId){
        return storeService.getStoreById(storeId) ;
    }

    //新增一个门店信息
    @RequestMapping("/addStore")
    public AjaxResult addStore(@RequestBody StoreMaster storeMaster){
        String msg=storeService.addStore(storeMaster);
        return ResultFactory.buildFailResult(msg);
    }

    //修改门店信息

    @RequestMapping("/update")
    public AjaxResult updateStore(@RequestParam Integer storeId,@RequestBody StoreMaster storeMaster){
        storeMaster.setStoreId(storeId);
        String msg=storeService.update(storeMaster);
        return ResultFactory.buildFailResult(msg);
    }



}
