package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.Unit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitMapper {

    Integer getIdByName(String b);

    Integer getIdByName2(String u);

    List<Unit> selectAll(Integer page, Integer size);

    Long getTotal();

    Unit selectById(Integer unitId);

    Integer insert(Unit unit);

    Integer update(Unit unit);

    Integer deleteByUnitId(Integer unitId);
}
