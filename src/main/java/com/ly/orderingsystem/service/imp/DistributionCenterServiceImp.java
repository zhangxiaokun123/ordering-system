package com.ly.orderingsystem.service.imp;

import com.ly.orderingsystem.entity.DistributionCenter;
import com.ly.orderingsystem.entity.Route;
import com.ly.orderingsystem.mapper.DistributionCenterMapper;
import com.ly.orderingsystem.mapper.RouteMapper;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.service.DistributionCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributionCenterServiceImp implements DistributionCenterService
{

    @Autowired
    private DistributionCenterMapper distributionCenterMapper;
    @Autowired
    private RouteMapper routeMapper;
    @Override
    public Page getDistributionCenters(Integer page, Integer size) {
        Page pageEntity=new Page();
        //默认从零开始
        if (page != null && size != null) {
            page = (page-1)*size;
        }
        List<DistributionCenter> distributionCenters=distributionCenterMapper.selectAll(page,size);
        pageEntity.setData(distributionCenters);
        Long total=distributionCenterMapper.getTotal();
        pageEntity.setTotal(total);
        return pageEntity;
    }

    @Override
    public DistributionCenter getDistributionCenter(Integer dcId) {
        return distributionCenterMapper.selectById(dcId);
    }

    @Override
    public String addDistributionCenter(DistributionCenter distributionCenter) {
         Integer i=distributionCenterMapper.selectIdByName(distributionCenter.getDcName());
         if (i==null)
         {
             Integer j=distributionCenterMapper.insert(distributionCenter);
             if (j>0){
                 String msg=String.format("插入数据成功");
                 return msg;
             }else {
                 String msg=String.format("插入数据失败");
                 return msg;
             }
         }else {
             String msg=String.format("插入数据失败,中心名称已存在");
             return msg;
         }
    }

    @Override
    public String updateDistributionCenter(DistributionCenter distributionCenter) {
        Integer i=distributionCenterMapper.update(distributionCenter);
        if (i>0){
            String msg=String.format("修改数据成功");
            return msg;
        }else {
            String msg=String.format("修改数据失败");
            return msg;
        }
    }

    @Override
    public String deleteDistributionCenter(Integer dcId) {
        List<Route> routes=routeMapper.selectByDcId(dcId);
        if (routes.size()>0){
            String msg=String.format("配送中心正在被使用,不可删除");
            return msg;
        }else {
            Integer i=distributionCenterMapper.delete(dcId);
            if (i>0){
                String msg=String.format("删除成功");
                return msg;
            }else {
                String msg=String.format("删除失败");
                return msg;
            }
        }
    }

}
