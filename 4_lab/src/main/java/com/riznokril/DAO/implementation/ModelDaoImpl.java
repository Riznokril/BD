package com.riznokril.DAO.implementation;
import com.riznokril.DAO.AbstractDAO;
import com.riznokril.entity.ModelEntity;
import com.riznokril.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelDaoImpl implements AbstractDAO<ModelEntity>{

    private static final String GET_ALL = "SELECT * FROM rizhko.model";
    private static final String GET_BY_ID = "SELECT * FROM rizhko.model WHERE id_model=?";
    private static final String CREATE = "INSERT INTO rizhko.model "
            + "(`name`, `max_speed`, `passenger_capacity`, `width`, `length`, `height`) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE rizhko.model"
            + " SET name=?, max_speed=?, passenger_capacity=?, width=?, length=?, height=? WHERE id_model=?";
    private static final String DELETE = "DELETE FROM rizhko.model WHERE id_model=?";

    public List<ModelEntity> findAll() throws SQLException {
        List<ModelEntity> cities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ModelEntity city = new ModelEntity(
                        resultSet.getInt("id_model"),
                        resultSet.getString("name"),
                        resultSet.getString("max_speed"),
                        resultSet.getInt("passenger_capacity"),
                        resultSet.getString("width"),
                        resultSet.getString("height"),
                        resultSet.getString("length")
                );
                cities.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public ModelEntity findById(Integer id) throws SQLException {
        ModelEntity model = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                model = new ModelEntity(
                        resultSet.getInt("id_model"),
                        resultSet.getString("name"),
                        resultSet.getString("max_speed"),
                        resultSet.getInt("passenger_capacity"),
                        resultSet.getString("width"),
                        resultSet.getString("height"),
                        resultSet.getString("length")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public void create(ModelEntity model) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(model.getName()));
            statement.setString(2, String.valueOf(model.getMax_speed()));
            statement.setString(3, String.valueOf(model.getPassenger_capacity()));
            statement.setString(4, String.valueOf(model.getWidth()));
            statement.setString(5, String.valueOf(model.getHeight()));
            statement.setString(6, String.valueOf(model.getLength()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, ModelEntity model) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, model.getId_model());
            statement.setString(2, model.getName());
            statement.setString(3, model.getMax_speed());
            statement.setInt(4, model.getPassenger_capacity());
            statement.setString(5, model.getWidth());
            statement.setString(6, model.getHeight());
            statement.setString(7, model.getLength());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
