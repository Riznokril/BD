package com.riznokril.DAO.implementation;
import com.riznokril.DAO.AbstractDAO;
import com.riznokril.entity.AircraftEntity;
import com.riznokril.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AircraftDaoImpl implements AbstractDAO<AircraftEntity>{

    private static final String GET_ALL = "SELECT * FROM rizhko.aircraft";
    private static final String GET_BY_ID = "SELECT * FROM rizhko.aircraft WHERE id_aircraft=?";
    private static final String CREATE = "INSERT INTO rizhko.aircraft "
            + "(`company_id`, `expiration_date`, `date_of_commissioning`, `model_id`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE rizhko.aircraft"
            + " SET company_id=?, expiration_date=?, date_of_commissioning=?, model_id=? WHERE id_aircraft=?";
    private static final String DELETE = "DELETE FROM rizhko.aircraft WHERE id_aircraft=?";

    public List<AircraftEntity> findAll() throws SQLException {
        List<AircraftEntity> aircrafts = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                AircraftEntity flight = new AircraftEntity(
                        resultSet.getInt("id_aircraft"),
                        resultSet.getInt("company_id"),
                        resultSet.getDate("expiration_date"),
                        resultSet.getDate("date_of_commissioning"),
                        resultSet.getInt("model_id")
                );
                aircrafts.add(flight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aircrafts;
    }

    @Override
    public AircraftEntity findById(Integer id) throws SQLException {
        AircraftEntity aircraft = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                aircraft = new AircraftEntity(
                        resultSet.getInt("id_aircraft"),
                        resultSet.getInt("company_id"),
                        resultSet.getDate("expiration_date"),
                        resultSet.getDate("date_of_commissioning"),
                        resultSet.getInt("model_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aircraft;
    }

    @Override
    public void create(AircraftEntity aircraft) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(aircraft.getId_aircraft()));
            statement.setString(2, String.valueOf(aircraft.getCompany_id()));
            statement.setString(3, String.valueOf(aircraft.getExpiration_date()));
            statement.setString(4, String.valueOf(aircraft.getDate_of_commissioning()));
            statement.setString(5, String.valueOf(aircraft.getModel_id()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, AircraftEntity aircraft) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, aircraft.getId_aircraft());
            statement.setInt(2, aircraft.getCompany_id());
            statement.setDate(3, aircraft.getExpiration_date());
            statement.setDate(4, aircraft.getDate_of_commissioning());
            statement.setInt(5, aircraft.getModel_id());
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
