package com.ly.orderingsystem.service.imp;

import com.ly.orderingsystem.entity.Area;
import com.ly.orderingsystem.entity.City;
import com.ly.orderingsystem.entity.Store;
import com.ly.orderingsystem.mapper.AreaMapper;
import com.ly.orderingsystem.mapper.AreaMasterMapper;
import com.ly.orderingsystem.mapper.CityMapper;
import com.ly.orderingsystem.mapper.StoreMapper;
import com.ly.orderingsystem.model.AreaMaster;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImp implements AreaService {
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private AreaMasterMapper areaMasterMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private StoreMapper storeMapper;
    @Override
    public Page getAreas(Integer page, Integer size) {
        Page pageEntity=new Page();
        //默认从零开始
        if (page != null && size != null) {
            page = (page-1)*size;
        }
        List<City> cities=areaMasterMapper.seletAll(page,size);
        pageEntity.setData(cities);
        //获取数据总数
        Long total=areaMasterMapper.getTotal();
        pageEntity.setTotal(total);
        return pageEntity;
}

    @Override
    public AreaMaster getArea(Integer areaId) {
        return areaMasterMapper.selectById(areaId);
    }

    @Override
    public String addArea(AreaMaster areaMaster) {
        Area area=new Area(areaMaster.getAreaId(),areaMaster.getAreaName(),
                cityMapper.getIdByName(areaMaster.getCityName()));
                Integer i=areaMapper.selectIdByName(area.getAreaName());
                if (i==null){
                    Integer j=areaMapper.insert(area);
                    if (j>0){
                        String msg=String.format("插入数据成功");
                        return msg;
                    }else {
                        String msg=String.format("插入数据失败");
                        return msg;
                    }
                }else {
                    String msg=String.format("插入数据失败,该区域已存在");
                    return msg;
                }
    }

    @Override
    public String updateArea(AreaMaster areaMaster) {
        Area area=new Area(areaMaster.getAreaId(),areaMaster.getAreaName(),
                cityMapper.getIdByName(areaMaster.getCityName()));
        Integer i=areaMapper.selectIdByName(area.getAreaName());
        if (i==null){
            Integer j=areaMapper.update(area);
            if (j>0){
                String msg=String.format("修改数据成功");
                return msg;
            }else {
                String msg=String.format("修改数据失败");
                return msg;
            }
        }else {
            String msg=String.format("修改数据失败,该区域已存在");
            return msg;
        }
    }

    @Override
    public String deleteById(Integer areaId) {
        //先判断该区域名称是否被使用
        List<Store> stores=storeMapper.selectByAreaId(areaId);
        if (stores.size()>0){
            String msg=String.format("/删除失败,该区域名称正在被使用");
            return msg;
        }else {
            Integer i=areaMapper.deleteById(areaId);
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
