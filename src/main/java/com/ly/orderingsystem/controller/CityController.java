package com.ly.orderingsystem.controller;

import com.ly.orderingsystem.entity.City;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.result.AjaxResult;
import com.ly.orderingsystem.result.ResultFactory;
import com.ly.orderingsystem.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    //显示所有城市信息
    @RequestMapping("/getCities")
    public Page getCities(@RequestParam(defaultValue = "1")Integer page,
                          @RequestParam(defaultValue = "5")Integer size){
        return cityService.getCities(page,size);
    }

    //显示一个城市信息
    @RequestMapping("/getCity")
    public City getCity(@RequestParam Integer cityId){
        return cityService.getCity(cityId);
    }

    //增加一个城市信息
    @RequestMapping("/addCity")
    public AjaxResult addCity(@RequestBody City city){
        String msg=cityService.addCity(city);
        return ResultFactory.buildFailResult(msg);
    }

    //修改城市信息
    @RequestMapping("/updateCity")
    public AjaxResult updateCity(@RequestParam Integer cityId,@RequestBody City city){
        city.setCityId(cityId);
        String msg=cityService.updateCity(city);
        return ResultFactory.buildFailResult(msg);
    }

    //删除一个城市信息
    @RequestMapping("/deleteCity")
    public AjaxResult deleteCity(@RequestParam Integer cityId){
        String msg=cityService.deleteCity(cityId);
        return ResultFactory.buildFailResult(msg);
    }
}
