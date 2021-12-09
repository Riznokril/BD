package com.riznokril.controller.implementation;

import com.riznokril.controller.AbstractController;
import com.riznokril.entity.CompanyEntity;
import com.riznokril.service.implementation.CompanyServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class CompanyControllerImpl implements AbstractController<CompanyEntity> {

    CompanyServiceImpl service = new CompanyServiceImpl();

    @Override
    public List<CompanyEntity> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public CompanyEntity findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(CompanyEntity entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, CompanyEntity entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}