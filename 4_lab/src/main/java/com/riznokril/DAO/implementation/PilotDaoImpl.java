package com.riznokril.DAO.implementation;
import com.riznokril.DAO.AbstractDAO;
import com.riznokril.entity.PilotEntity;
import com.riznokril.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PilotDaoImpl implements AbstractDAO<PilotEntity>{

    private static final String GET_ALL = "SELECT * FROM rizhko.pilot";
    private static final String GET_BY_ID = "SELECT * FROM rizhko.pilot WHERE id_pilot=?";
    private static final String CREATE = "INSERT INTO rizhko.pilot "
            + "(`aircraft_id`, `company_id`, `name`, `licence_number`, `surname`, `year_of_employment`) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE rizhko.pilot"
            + " SET aircraft_id=?, company_id=?, name=?, licence_number=?, surname=?, year_of_employment=? WHERE id_pilot=?";
    private static final String DELETE = "DELETE FROM rizhko.pilot WHERE id_pilot=?";

    public List<PilotEntity> findAll() throws SQLException {
        List<PilotEntity> pilots = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PilotEntity pilot = new PilotEntity(
                        resultSet.getInt("id_pilot"),
                        resultSet.getInt("aircraft_id"),
                        resultSet.getInt("company_id"),
                        resultSet.getString("name"),
                        resultSet.getString("licence_number"),
                        resultSet.getString("surname"),
                        resultSet.getString("year_of_employment")
                );
                pilots.add(pilot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pilots;
    }

    @Override
    public PilotEntity findById(Integer id) throws SQLException {
        PilotEntity pilot = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                pilot = new PilotEntity(
                        resultSet.getInt("id_pilot"),
                        resultSet.getInt("aircraft_id"),
                        resultSet.getInt("company_id"),
                        resultSet.getString("name"),
                        resultSet.getString("licence_number"),
                        resultSet.getString("surname"),
                        resultSet.getString("year_of_employment")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pilot;
    }

    @Override
    public void create(PilotEntity pilot) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(pilot.getAircraft_id()));
            statement.setString(2, String.valueOf(pilot.getCompany_id()));
            statement.setString(3, String.valueOf(pilot.getName()));
            statement.setString(4, String.valueOf(pilot.getLicence_number()));
            statement.setString(5, String.valueOf(pilot.getSurname()));
            statement.setString(6, String.valueOf(pilot.getYear_of_employment()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, PilotEntity pilot) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, pilot.getId_pilot());
            statement.setInt(2, pilot.getAircraft_id());
            statement.setInt(3, pilot.getCompany_id());
            statement.setString(4, pilot.getName());
            statement.setString(5, pilot.getLicence_number());
            statement.setString(6, pilot.getSurname());
            statement.setString(7, pilot.getYear_of_employment());
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
