package com.ly.orderingsystem.service;

import com.ly.orderingsystem.model.Page;
import com.ly.orderingsystem.model.RouteMaster;

import java.util.Map;

public interface RouteService {
    Page getRoutes(Integer page, Integer size);

    RouteMaster getRoute(Integer routeId);

    String addRoute(RouteMaster routeMaster);

    String updateRoute(RouteMaster routeMaster);

    String deleteById(Integer routeId);

    Page getRoutesBySearch(Integer page, Map<String, Object> searchParam, Integer size);
}
