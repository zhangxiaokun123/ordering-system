package com.ly.orderingsystem.service.imp;

import com.ly.orderingsystem.entity.Route;
import com.ly.orderingsystem.entity.Store;
import com.ly.orderingsystem.mapper.DistributionCenterMapper;
import com.ly.orderingsystem.mapper.RouteMapper;
import com.ly.orderingsystem.mapper.RouteMasterMapper;
import com.ly.orderingsystem.mapper.StoreMapper;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.model.RouteMaster;
import com.ly.orderingsystem.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RouteServicrImp implements RouteService {

    @Autowired
    private RouteMasterMapper routeMasterMapper;
    @Autowired
    private DistributionCenterMapper distributionCenterMapper;
    @Autowired
    private RouteMapper routeMapper;
    @Autowired
    private StoreMapper storeMapper;

    @Override
    public Page getRoutes(Integer page, Integer size) {
        Page pageEntity=new Page();
        if (page != null && size != null) {
            page = (page-1)*size;
        }
        //获取线路信息
        List<RouteMaster> routeMasters=routeMasterMapper.selectAll(page,size);
        pageEntity.setData(routeMasters);
        //获取总数
        Long total=routeMasterMapper.getTotal();
        pageEntity.setTotal(total);
        return pageEntity;
    }

    @Override
    public RouteMaster getRoute(Integer routeId) {
        return routeMasterMapper.selectById(routeId);
    }

    @Override
    public String addRoute(RouteMaster routeMaster) {
        Route route=new Route(routeMaster.getRouteId(),routeMaster.getRouteName(),routeMaster.getDriverName(),
                                routeMaster.getPhoneNumber(),distributionCenterMapper.selectIdByName(routeMaster.getDcName()));
        Integer i=routeMapper.insert(route);
        if (i<1){
            String message=String.format("插入数据失败");
            return message;
        }else{
            String message=String.format("插入数据成功");
            return message;}
    }

    @Override
    public String updateRoute(RouteMaster routeMaster) {
        Route route=new Route(routeMaster.getRouteId(),routeMaster.getRouteName(),routeMaster.getDriverName(),
                routeMaster.getPhoneNumber(),distributionCenterMapper.selectIdByName(routeMaster.getDcName()));
        Integer i=routeMapper.update(route);
        if (i<1){
            String message=String.format("修改数据失败");
            return message;
        }else{
            String message=String.format("修改数据成功");
            return message;}
    }

    @Override
    public String deleteById(Integer routeId) {
            //先查看该Id是否被使用
        List<Store> stores=storeMapper.selectByRouteId(routeId);
        if (stores.size()<1) {
        Integer i=routeMapper.deleteById(routeId);
        if (i<1){
            String message=String.format("删除数据失败");
            return message;
        }else{
            String message=String.format("删除数据成功");
            return message;}
        }else {
            String message=String.format("删除数据失败,该线路正在被使用");
            return message;
        }

    }

    @Override
    public Page getRoutesBySearch(Integer page, Map<String, Object> searchParam, Integer size) {
        Page pageEntity=new Page();
        //默认从零开始
        if (page != null && size != null) {
            page = (page-1)*size;
        }
        searchParam.put("page",page);
        searchParam.put("size",size);
        //获取线路信息
        List<RouteMaster> routeMasters=routeMasterMapper.getRoutesBySearch(searchParam);
        pageEntity.setData(routeMasters);
        //获取总数
        Long total=routeMasterMapper.getTotalBySearch(searchParam);
        pageEntity.setTotal(total);
        return pageEntity;
    }
}
