package com.ly.orderingsystem.service.imp;

import com.ly.orderingsystem.entity.Store;
import com.ly.orderingsystem.entity.StoreType;
import com.ly.orderingsystem.mapper.StoreMapper;
import com.ly.orderingsystem.mapper.StoreTypeMapper;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.model.StoreMaster;
import com.ly.orderingsystem.service.StoreTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreTypeServiceImp implements StoreTypeService {
    @Autowired
    private StoreTypeMapper storeTypeMapper;
    @Autowired
    private StoreMapper storeMapper;

    @Override
    public Page getStoreTypes(Integer page, Integer size) {
        Page pageEntity=new Page();
        //默认从零开始
        if (page != null && size != null) {
            page = (page-1)*size;
        }
        //获取门店信息
        List<StoreType> storeTypes=storeTypeMapper.selectAll(page,size);
        pageEntity.setData(storeTypes);
        //获取数量
        Long total=storeTypeMapper.getTotal();
        pageEntity.setTotal(total);
        return pageEntity;
    }

    @Override
    public StoreType getStoreType(Integer typeId) {
        return storeTypeMapper.selectIdById(typeId);
    }

    @Override
    public String addStoreType(StoreType storeType) {
        String typeName=storeType.getTypeName();
        Integer i=storeTypeMapper.selectIdByName(typeName);
        if (i!=null){
            String message=String.format("插入数据失败,分类名称已存在,请勿重复添加");
            return message;
        }else {
            Integer j=storeTypeMapper.insert(storeType);
            if (j<1){
                String message=String.format("插入数据失败");
                return message;
            }else{
                String message=String.format("插入数据成功");
                return message;}
        }
        }

    @Override
    public String updateStoreType(StoreType storeType) {
        String typeName=storeType.getTypeName();
        Integer i=storeTypeMapper.selectIdByName(typeName);
        if (i!=null){
            String message=String.format("修改数据失败,分类名称已存在,请勿重复添加");
            return message;
        }else {
            Integer j=storeTypeMapper.update(storeType);
            if (j<1){
                String message=String.format("修改数据失败");
                return message;
            }else{
                String message=String.format("修改数据成功");
                return message;}
        }
    }

    @Override
    public String deleteStoreType(Integer typeId) {
        List<Store> stores=storeMapper.selectByTypeId(typeId);
        if (stores.size()<1)
        {
            Integer i=storeTypeMapper.deleteById(typeId);
            if (i<1){
                String message=String.format("删除数据失败");
                return message;
            }else{
                String message=String.format("删除数据成功");
                return message;}
        }
        else {
            String message=String.format("删除数据失败,该分类名称正在被使用");
            return message;
        }
    }


}
