package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.model.StoreMaster;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreMasterMapper {
    List<StoreMaster> selectAll(Integer page, Integer size);

    Long getTotal();

    StoreMaster selectById(Integer storeId);
}
