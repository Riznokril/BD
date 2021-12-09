package com.riznokril.controller.implementation;

import com.riznokril.controller.AbstractController;
import com.riznokril.entity.CityEntity;
import com.riznokril.service.implementation.CityServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class CityControllerImpl implements AbstractController<CityEntity> {

    CityServiceImpl service = new CityServiceImpl();

    @Override
    public List<CityEntity> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public CityEntity findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(CityEntity entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, CityEntity entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
