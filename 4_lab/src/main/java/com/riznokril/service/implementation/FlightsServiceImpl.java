package com.riznokril.service.implementation;

import com.riznokril.DAO.implementation.FlightsDaoImpl;
import com.riznokril.entity.FlightsEntity;
import com.riznokril.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class FlightsServiceImpl implements AbstractService<FlightsEntity> {

    private final FlightsDaoImpl dao = new FlightsDaoImpl();

    @Override
    public List<FlightsEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public FlightsEntity findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(FlightsEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, FlightsEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
