package com.ly.orderingsystem.service.imp;

import com.ly.orderingsystem.entity.ProductUnit;
import com.ly.orderingsystem.entity.Unit;
import com.ly.orderingsystem.mapper.ProductUnitMapper;
import com.ly.orderingsystem.mapper.UnitMapper;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.result.ResultFactory;
import com.ly.orderingsystem.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImp implements UnitService {
    @Autowired
    private UnitMapper unitMapper;

    @Autowired
    private ProductUnitMapper productUnitMapper;
    @Override
    public Page getUnits(Integer page, Integer size) {
        Page pageEntity=new Page();
        //默认从零开始
        if (page != null && size != null) {
            page = (page-1)*size;
        }
        //获取单位信息
        List<Unit> units=unitMapper.selectAll(page,size);
        pageEntity.setData(units);
        //获取总数
        Long total=unitMapper.getTotal();
        pageEntity.setTotal(total);
        return pageEntity;
    }

    @Override
    public Unit getUnit(Integer unitId) {
        return unitMapper.selectById(unitId);
    }

    @Override
    public String addUnit(Unit unit) {
       Integer i= unitMapper.insert(unit);
        if (i<1){
            String message=String.format("添加数据失败");
            return message;
        }else{
            String message=String.format("添加数据成功");
            return message;
        }
    }

    @Override
    public String updateById(Unit unit) {
        Integer i=unitMapper.update(unit);
        if (i<1){
            String message=String.format("修改数据失败");
            return message;
        }else{
            String message=String.format("修改数据成功");
            return message;
        }
    }

    @Override
    public String deleteById(Integer unitId) {
        List<ProductUnit> productUnits=productUnitMapper.seleteByUnitId(unitId);
        System.out.println(productUnits);
        if (productUnits.size()<1){
            Integer i=unitMapper.deleteByUnitId(unitId);
            if (i<1){
                String msg=String.format("删除数据失败");
                return msg;
            }else {
                String msg=String.format("删除数据成功");
                return msg;
            }
        }else {
            String msg=String.format("此单位已被使用,不可删除");
            return msg;
        }
    }
}
