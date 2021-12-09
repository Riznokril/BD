package com.riznokril.controller.implementation;

import com.riznokril.controller.AbstractController;
import com.riznokril.entity.FlightsEntity;
import com.riznokril.service.implementation.FlightsServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class FlightsControllerImpl implements AbstractController<FlightsEntity> {

    FlightsServiceImpl service = new FlightsServiceImpl();

    @Override
    public List<FlightsEntity> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public FlightsEntity findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(FlightsEntity entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, FlightsEntity entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}