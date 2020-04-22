package com.ly.orderingsystem.service.imp;

import com.ly.orderingsystem.entity.Area;
import com.ly.orderingsystem.entity.City;
import com.ly.orderingsystem.mapper.AreaMapper;
import com.ly.orderingsystem.mapper.CityMapper;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImp implements CityService {

    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public Page getCities(Integer page, Integer size) {
        Page pageEntity=new Page();
        //默认从零开始
        if (page != null && size != null) {
            page = (page-1)*size;
        }
        List<City> cities=cityMapper.seletAll(page,size);
        pageEntity.setData(cities);
        //获取数据总数
        Long total=cityMapper.getTotal();
        pageEntity.setTotal(total);
        return pageEntity;
    }

    @Override
    public City getCity(Integer cityId) {
        return cityMapper.selectById(cityId);
    }

    @Override
    public String addCity(City city) {
        String cityName=city.getCityName();
        List<City> cities=cityMapper.getCityByName(cityName);
        if (cities.size()>0){
            String msg=String.format("该城市名称已存在,请不要重复添加");
            return msg;
        }else {
            Integer i=cityMapper.insert(city);
            if (i>0){
                String msg=String.format("插入成功");
                return msg;
            }else {
                String msg=String.format("插入失败");
                return msg;
            }
        }

    }

    @Override
    public String updateCity(City city) {
        String cityName=city.getCityName();
        List<City> cities=cityMapper.getCityByName(cityName);
        if (cities.size()>0){
            String msg=String.format("该城市名称已存在,请不要重复修改");
            return msg;
        }else {
            Integer i=cityMapper.update(city);
            if (i>0){
                String msg=String.format("修改成功");
                return msg;
            }else {
                String msg=String.format("修改失败");
                return msg;
            }
        }
    }

    @Override
    public String deleteCity(Integer cityId) {
        //先查询该城市信息是否被使用
        List<Area> areas=areaMapper.selectIdByCityId(cityId);
        if (areas.size()>0){
            String msg=String.format("该城市正在被占用,不能删除");
            return msg;
        }else {
            Integer i=cityMapper.deleteById(cityId);
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
