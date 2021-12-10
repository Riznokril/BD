package com.riznokril.DAO.implementation;
import com.riznokril.DAO.AbstractDAO;
import com.riznokril.entity.CityEntity;
import com.riznokril.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements AbstractDAO<CityEntity>{

    private static final String GET_ALL = "SELECT * FROM rizhko.city";
    private static final String GET_BY_ID = "SELECT * FROM rizhko.city WHERE id_city=?";
    private static final String CREATE = "INSERT INTO rizhko.city "
            + "(`name`, `country`, `post_number`, `year_of_foundation`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE rizhko.city"
            + " SET name=?, country=?, post_number=?, year_of_foundation=? WHERE id_city=?";
    private static final String DELETE = "DELETE FROM rizhko.city WHERE id_city=?";

    public List<CityEntity> findAll() throws SQLException {
        List<CityEntity> cities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CityEntity city = new CityEntity(
                        resultSet.getInt("id_city"),
                        resultSet.getString("name"),
                        resultSet.getString("country"),
                        resultSet.getString("post_number"),
                        resultSet.getString("year_of_foundation")
                );
                cities.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public CityEntity findById(Integer id) throws SQLException {
        CityEntity city = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                city = new CityEntity(
                        resultSet.getInt("id_city"),
                        resultSet.getString("name"),
                        resultSet.getString("country"),
                        resultSet.getString("post_number"),
                        resultSet.getString("year_of_foundation")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public void create(CityEntity city) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(city.getName()));
            statement.setString(2, String.valueOf(city.getCountry()));
            statement.setString(3, String.valueOf(city.getPost_number()));
            statement.setString(4, String.valueOf(city.getPost_number()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, CityEntity city) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, city.getId_city());
            statement.setString(2, city.getName());
            statement.setString(3, city.getCountry());
            statement.setString(4, city.getPost_number());
            statement.setString(5, city.getPost_number());
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
