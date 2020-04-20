package com.ly.orderingsystem.service.imp;

import com.ly.orderingsystem.entity.Store;
import com.ly.orderingsystem.mapper.*;
import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.model.StoreMaster;
import com.ly.orderingsystem.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImp implements StoreService {

    @Autowired
    private StoreMasterMapper storeMasterMapper;
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private RouteMapper routeMapper;
    @Autowired
    private StoreTypeMapper storeTypeMapper;
    @Autowired
    private StoreMapper storeMapper;
    @Override
    public Page getStores(Integer page, Integer size) {
        Page pageEntity=new Page();
        //默认从零开始
        if (page != null && size != null) {
            page = (page-1)*size;
        }
        //获取门店信息
        List<StoreMaster> storeMasters=storeMasterMapper.selectAll(page,size);
        pageEntity.setData(storeMasters);
        //获取数量
        Long total=storeMasterMapper.getTotal();
        pageEntity.setTotal(total);
        return pageEntity;

    }

    @Override
    public StoreMaster getStoreById(Integer storeId) {
        return storeMasterMapper.selectById(storeId);
    }

    @Override
    public String addStore(StoreMaster storeMaster) {
        Store s=storeMapper.selectById(storeMaster.getStoreId());
        System.out.println(s);
        if(s==null){
        Store store=new Store(storeMaster.getStoreId(),storeMaster.getStoreName(),
                               areaMapper.selectIdByName(storeMaster.getAreaName()),
                               storeMaster.getAddress(),
                               routeMapper.selectIdByName(storeMaster.getRouteName()),
                               storeTypeMapper.selectIdByName(storeMaster.getStoreType()),
                               storeMaster.getStatus());
        Integer i=storeMapper.insert(store);

        if (i<1){
            String message=String.format("插入数据失败");
            return message;
        }else{
            String message=String.format("插入数据成功");
            return message;}}
        else {
            String message=String.format("插入数据失败,门店编号已存在");
            return message;
        }
    }

    @Override
    public String update(StoreMaster storeMaster) {
        Store store=new Store(storeMaster.getStoreId(),storeMaster.getStoreName(),
                areaMapper.selectIdByName(storeMaster.getAreaName()),
                storeMaster.getAddress(),
                routeMapper.selectIdByName(storeMaster.getRouteName()),
                storeTypeMapper.selectIdByName(storeMaster.getStoreType()),
                storeMaster.getStatus());
        System.out.println(store);
        Integer i=storeMapper.update(store);

        if (i<1){
            String message=String.format("修改数据失败");
            return message;
        }else{
            String message=String.format("修改数据成功");
            return message;}

    }
}
