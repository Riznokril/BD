package com.riznokril.controller.implementation;

import com.riznokril.controller.AbstractController;
import com.riznokril.entity.AircraftEntity;
import com.riznokril.service.implementation.AircraftServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class AircraftControllerImpl implements AbstractController<AircraftEntity> {

        AircraftServiceImpl service = new AircraftServiceImpl();

        @Override
        public List<AircraftEntity> findAll() throws SQLException {
                return service.findAll();
        }

        @Override
        public AircraftEntity findById(Integer id) throws SQLException {
                return service.findById(id);
        }

        @Override
        public void create(AircraftEntity entity) throws SQLException {
                service.create(entity);
        }

        @Override
        public void update(Integer id, AircraftEntity entity) throws SQLException {
                service.update(id, entity);
        }

        @Override
        public void delete(Integer id) throws SQLException {
                service.delete(id);
        }
}
