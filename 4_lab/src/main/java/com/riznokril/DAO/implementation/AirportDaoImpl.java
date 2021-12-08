package com.riznokril.DAO.implementation;
import com.riznokril.DAO.AbstractDAO;
import com.riznokril.entity.AirportEntity;
import com.riznokril.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDaoImpl implements AbstractDAO<AirportEntity>{

    private static final String GET_ALL = "SELECT * FROM rizhko.airport";
    private static final String GET_BY_ID = "SELECT * FROM rizhko.airport WHERE id_airport=?";
    private static final String CREATE = "INSERT rizhko.airport "
            + "(`name`, `city_id`) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE rizhko.airport"
            + " SET name=?, city_id=? WHERE id_airport=?";
    private static final String DELETE = "DELETE FROM rizhko.airport WHERE id_airport=?";

    public List<AirportEntity> findAll() throws SQLException {
        List<AirportEntity> airports = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                AirportEntity flight = new AirportEntity(
                        resultSet.getInt("id_airport"),
                        resultSet.getString("name"),
                        resultSet.getInt("city_id")
                );
                airports.add(flight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airports;
    }

    @Override
    public AirportEntity findById(Integer id) throws SQLException {
        AirportEntity airport = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                airport = new AirportEntity(
                        resultSet.getInt("id_airport"),
                        resultSet.getString("name"),
                        resultSet.getInt("city_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airport;
    }

    @Override
    public void create(AirportEntity airport) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(airport.getId_airport()));
            statement.setString(2, String.valueOf(airport.getName()));
            statement.setString(3, String.valueOf(airport.getCity_id()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, AirportEntity airport) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, airport.getId_airport());
            statement.setString(2, airport.getName());
            statement.setInt(3, airport.getCity_id());
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
