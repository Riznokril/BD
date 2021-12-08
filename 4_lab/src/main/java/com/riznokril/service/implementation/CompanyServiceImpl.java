package com.riznokril.service.implementation;

import com.riznokril.DAO.implementation.CompanyDaoImpl;
import com.riznokril.entity.CompanyEntity;
import com.riznokril.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class CompanyServiceImpl implements AbstractService<CompanyEntity> {

    private final CompanyDaoImpl dao = new CompanyDaoImpl();

    @Override
    public List<CompanyEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public CompanyEntity findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(CompanyEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, CompanyEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}