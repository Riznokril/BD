package com.riznokril.DAO.implementation;
import com.riznokril.DAO.AbstractDAO;
import com.riznokril.entity.FlightsEntity;
import com.riznokril.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightsDaoImpl implements AbstractDAO<FlightsEntity>{

    private static final String GET_ALL = "SELECT * FROM rizhko.flights";
    private static final String GET_BY_ID = "SELECT * FROM rizhko.flights WHERE flight_number=?";
    private static final String CREATE = "INSERT INTO rizhko.flights "
            + "(`aircraft_id`, `departure_time`, `arrival_time`, `arrival_airport_id`, `departure_airport_id`) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE rizhko.flights"
            + " SET aircraft_id=?, departure_time=?, arrival_time=?, arrival_airport_id=?, departure_airport_id=? WHERE flight_number=?";
    private static final String DELETE = "DELETE FROM rizhko.flights WHERE flight_number=?";

    public List<FlightsEntity> findAll() throws SQLException {
        List<FlightsEntity> flightss = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FlightsEntity flight = new FlightsEntity(
                        resultSet.getInt("flight_number"),
                        resultSet.getInt("aircraft_id"),
                        resultSet.getTimestamp("departure_time"),
                        resultSet.getTimestamp("arrival_time"),
                        resultSet.getInt("arrival_airport_id"),
                        resultSet.getInt("departure_airport_id")
                );
                flightss.add(flight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightss;
    }

    @Override
    public FlightsEntity findById(Integer id) throws SQLException {
        FlightsEntity flight = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                flight = new FlightsEntity(
                        resultSet.getInt("flight_number"),
                        resultSet.getInt("aircraft_id"),
                        resultSet.getTimestamp("departure_time"),
                        resultSet.getTimestamp("arrival_time"),
                        resultSet.getInt("arrival_airport_id"),
                        resultSet.getInt("departure_airport_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flight;
    }

    @Override
    public void create(FlightsEntity flight) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
                statement.setString(1, String.valueOf(flight.getFlight_number()));
                statement.setString(2, String.valueOf(flight.getAircraft_id()));
                statement.setString(3, String.valueOf(flight.getDeparture_time()));
                statement.setString(4, String.valueOf(flight.getArrival_time()));
                statement.setString(5, String.valueOf(flight.getArrival_airport_id()));
                statement.setString(6, String.valueOf(flight.getDeparture_airport_id()));
                statement.executeUpdate();
                System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, FlightsEntity flight) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, flight.getFlight_number());
            statement.setInt(2, flight.getAircraft_id());
            statement.setTimestamp(3, flight.getDeparture_time());
            statement.setTimestamp(4, flight.getArrival_time());
            statement.setInt(5, flight.getArrival_airport_id());
            statement.setInt(6, flight.getDeparture_airport_id());
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
