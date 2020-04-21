package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.model.StoreMaster;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StoreMasterMapper {
    List<StoreMaster> selectAll(Integer page, Integer size);

    Long getTotal();

    StoreMaster selectById(Integer storeId);

    List<StoreMaster> selectBySearch(Map<String, Object> searchParam);

    Long selectTotalBySearch(Map<String, Object> searchParam);
}
