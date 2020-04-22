package com.ly.orderingsystem.service;

import com.ly.orderingsystem.entity.DistributionCenter;
import com.ly.orderingsystem.model.Page;

public interface DistributionCenterService {
    Page getDistributionCenters(Integer page, Integer size);

    DistributionCenter getDistributionCenter(Integer dcId);

    String addDistributionCenter(DistributionCenter distributionCenter);

    String updateDistributionCenter(DistributionCenter distributionCenter);

    String deleteDistributionCenter(Integer dcId);
}
