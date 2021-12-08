package com.riznokril.controller.implementation;

import com.riznokril.controller.AbstractController;
import com.riznokril.entity.AirportEntity;
import com.riznokril.service.implementation.AirportServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class AirportControllerImpl implements AbstractController<AirportEntity> {

    AirportServiceImpl service = new AirportServiceImpl();

    @Override
    public List<AirportEntity> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public AirportEntity findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(AirportEntity entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, AirportEntity entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
