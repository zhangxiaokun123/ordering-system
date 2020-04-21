package com.ly.orderingsystem.controller;

import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.model.RouteMaster;
import com.ly.orderingsystem.result.AjaxResult;
import com.ly.orderingsystem.result.ResultFactory;
import com.ly.orderingsystem.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/route")
public class RouteController {
    /*
    /线路控制
     */
    @Autowired
    private RouteService routeService;
    //查询所有线路信息
    @RequestMapping("/getRoutes")
    public Page getRoutes(@RequestParam(defaultValue = "1")Integer page,
                          @RequestParam(defaultValue = "5")Integer size){
        return routeService.getRoutes(page,size);
    }
    //查询单个路线信息
    @RequestMapping("/getRoute")
    public RouteMaster getRoute(@RequestParam Integer routeId){
        return routeService.getRoute(routeId);
    }

    //添加一个线路
    @RequestMapping("/addRoute")
    public AjaxResult addRoute(@RequestBody RouteMaster routeMaster){
        String msg=routeService.addRoute(routeMaster);
        return ResultFactory.buildFailResult(msg);
    }

    //修改一条线路
    @RequestMapping("/update")
    public AjaxResult updateRoute(@RequestParam Integer routeId,@RequestBody RouteMaster routeMaster){
        routeMaster.setRouteId(routeId);
        String msg=routeService.updateRoute(routeMaster);
        return ResultFactory.buildFailResult(msg);
    }
  //删除一条线路
    @RequestMapping("/delete")
    public AjaxResult deleteRoute(@RequestParam Integer routeId){
        String msg=routeService.deleteById(routeId);
        return ResultFactory.buildFailResult(msg);
    }
    //线路多搜索框实现
    @RequestMapping("/getRoutesBySearch")
    public Page getRoutesBySearch(@RequestParam(defaultValue = "1")Integer page,
                                  @RequestParam(defaultValue = "5")Integer size,
                                  @RequestParam(defaultValue = "")String routeName,
                                  @RequestParam(defaultValue = "")String dcName){
        //利用map存取数据
        Map<String,Object> searchParam=new HashMap<>();
        searchParam.put("routeName",routeName);
        searchParam.put("dcName",dcName);
        return routeService.getRoutesBySearch(page,searchParam,size);
    }
}
