package com.riznokril.controller.implementation;

import com.riznokril.controller.AbstractController;
import com.riznokril.entity.ModelEntity;
import com.riznokril.service.implementation.ModelServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class ModelControllerImpl implements AbstractController<ModelEntity> {

    ModelServiceImpl service = new ModelServiceImpl();

    @Override
    public List<ModelEntity> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public ModelEntity findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(ModelEntity entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, ModelEntity entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}