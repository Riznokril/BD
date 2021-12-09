package com.riznokril.DAO;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO<Entity> {
    List<Entity> findAll() throws SQLException;

    Entity findById(Integer id) throws SQLException;

    void create(Entity entity) throws SQLException;

    void update(Integer id, Entity entity) throws SQLException;

    void delete(Integer id) throws SQLException;
}
