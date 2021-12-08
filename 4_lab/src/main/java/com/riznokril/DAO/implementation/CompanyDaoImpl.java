package com.riznokril.DAO.implementation;
import com.riznokril.DAO.AbstractDAO;
import com.riznokril.entity.CompanyEntity;
import com.riznokril.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImpl implements AbstractDAO<CompanyEntity>{

    private static final String GET_ALL = "SELECT * FROM rizhko.company";
    private static final String GET_BY_ID = "SELECT * FROM rizhko.company WHERE id_company=?";
    private static final String CREATE = "INSERT rizhko.company "
            + "(`year_of_foundation`, `city_id`) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE rizhko.company"
            + " SET year_of_foundation=?, city_id=? WHERE id_company=?";
    private static final String DELETE = "DELETE FROM rizhko.company WHERE id_company=?";

    public List<CompanyEntity> findAll() throws SQLException {
        List<CompanyEntity> companies = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CompanyEntity company = new CompanyEntity(
                        resultSet.getInt("id_company"),
                        resultSet.getString("year_of_foundation"),
                        resultSet.getInt("city_id")
                );
                companies.add(company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public CompanyEntity findById(Integer id) throws SQLException {
        CompanyEntity company = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                company = new CompanyEntity(
                        resultSet.getInt("id_company"),
                        resultSet.getString("year_of_foundation"),
                        resultSet.getInt("city_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void create(CompanyEntity company) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(company.getId_company()));
            statement.setString(2, String.valueOf(company.getYear_of_foundation()));
            statement.setString(3, String.valueOf(company.getCity_id()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, CompanyEntity company) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, company.getId_company());
            statement.setString(2, company.getYear_of_foundation());
            statement.setInt(3, company.getCity_id());
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
