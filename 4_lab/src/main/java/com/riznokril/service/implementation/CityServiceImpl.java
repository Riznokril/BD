package com.riznokril.service.implementation;

import com.riznokril.DAO.implementation.CityDaoImpl;
import com.riznokril.entity.CityEntity;
import com.riznokril.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class CityServiceImpl implements AbstractService<CityEntity> {

    private final CityDaoImpl dao = new CityDaoImpl();

    @Override
    public List<CityEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public CityEntity findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(CityEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, CityEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}