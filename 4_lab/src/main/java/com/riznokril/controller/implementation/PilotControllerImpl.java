package com.riznokril.controller.implementation;

import com.riznokril.controller.AbstractController;
import com.riznokril.entity.PilotEntity;
import com.riznokril.service.implementation.PilotServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class PilotControllerImpl implements AbstractController<PilotEntity> {

    PilotServiceImpl service = new PilotServiceImpl();

    @Override
    public List<PilotEntity> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public PilotEntity findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(PilotEntity entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, PilotEntity entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}