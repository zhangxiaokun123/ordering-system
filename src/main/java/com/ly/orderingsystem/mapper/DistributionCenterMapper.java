package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.DistributionCenter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributionCenterMapper {

    Integer selectIdByName(String dcName);

    List<DistributionCenter> selectAll(Integer page, Integer size);

    Long getTotal();

    DistributionCenter selectById(Integer dcId);

    Integer delete(Integer dcId);

    Integer insert(DistributionCenter distributionCenter);

    Integer update(DistributionCenter distributionCenter);
}
