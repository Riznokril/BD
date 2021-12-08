package com.riznokril.service.implementation;

import com.riznokril.DAO.implementation.AircraftDaoImpl;
import com.riznokril.entity.AircraftEntity;
import com.riznokril.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class AircraftServiceImpl implements AbstractService<AircraftEntity> {

    private final AircraftDaoImpl dao = new AircraftDaoImpl();

    @Override
    public List<AircraftEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public AircraftEntity findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(AircraftEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, AircraftEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}