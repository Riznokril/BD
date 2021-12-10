package com.riznokril.service.implementation;

import com.riznokril.DAO.implementation.AirportDaoImpl;
import com.riznokril.entity.AirportEntity;
import com.riznokril.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class AirportServiceImpl implements AbstractService<AirportEntity> {

    private final AirportDaoImpl dao = new AirportDaoImpl();

    @Override
    public List<AirportEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public AirportEntity findById(Integer id) throws SQLException {        return dao.findById(id);
    }

    @Override
    public void create(AirportEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, AirportEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}