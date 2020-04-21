package com.ly.orderingsystem.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface DistributionCenterMapper {

    Integer selectIdByName(String dcName);
}
