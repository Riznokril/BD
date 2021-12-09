package com.riznokril.view;

import com.riznokril.controller.implementation.*;
import com.riznokril.entity.*;


import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();

    private final AircraftControllerImpl aircraftController = new AircraftControllerImpl();
    private final AirportControllerImpl airportController = new AirportControllerImpl();
    private final CityControllerImpl cityController = new CityControllerImpl();
    private final CompanyControllerImpl companyController = new CompanyControllerImpl();
    private final FlightsControllerImpl flightsController = new FlightsControllerImpl();
    private final ModelControllerImpl modelController = new ModelControllerImpl();
    private final PilotControllerImpl pilotController = new PilotControllerImpl();

    public View() {
            menu.put("11", this::getAllAircraft);
            menu.put("12", this::getAircraft);
            menu.put("13", this::createAircraft);
            menu.put("14", this::updateAircraft);
            menu.put("15", this::deleteAircraft);

            menu.put("21", this::getAllAirport);
            menu.put("22", this::getAirport);
            menu.put("23", this::createAirport);
            menu.put("24", this::updateAirport);
            menu.put("25", this::deleteAirport);

            menu.put("31", this::getAllCity);
            menu.put("32", this::getCity);
            menu.put("33", this::createCity);
            menu.put("34", this::updateCity);
            menu.put("35", this::deleteCity);

            menu.put("41", this::getAllCompany);
            menu.put("42", this::getCompany);
            menu.put("43", this::createCompany);
            menu.put("44", this::updateCompany);
            menu.put("45", this::deleteCompany);

            menu.put("51", this::getAllFlights);
            menu.put("52", this::getFlights);
            menu.put("53", this::createFlights);
            menu.put("54", this::updateFlights);
            menu.put("55", this::deleteFlights);

            menu.put("61", this::getAllModel);
            menu.put("62", this::getModel);
            menu.put("63", this::createModel);
            menu.put("64", this::updateModel);
            menu.put("65", this::deleteModel);

            menu.put("71", this::getAllPilot);
            menu.put("72", this::getPilot);
            menu.put("73", this::createPilot);
            menu.put("74", this::updatePilot);
            menu.put("75", this::deletePilot);
        }

        public final void show() {
            String input;
            Menu showMenu = new Menu();
            showMenu.displayMenu();
            System.out.println("\nEnter numbers:\n");
            do {
                try {
                    input = SCANNER.next();
                    menu.get(input).print();
                } catch (Exception ignored) {
                }
            } while (SCANNER.hasNext());
        }

    private void getAllAircraft() throws SQLException {
        System.out.println("\n");
        System.out.println(aircraftController.findAll() + "\n");
    }

    private void getAircraft() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(aircraftController.findById(id) + "\n");
    }

    private AircraftEntity getAircraftData() {
        System.out.println("\nEnter id_aircraft: ");
        Integer id_aircraft = SCANNER.nextInt();
        System.out.println("Enter id_company: ");
        Integer id_company = SCANNER.nextInt();
        System.out.println("Enter expiration_date: ");
        String expiration_date_scan = SCANNER.next();
        Date expiration_date = Date.valueOf(expiration_date_scan);
        System.out.println("Enter date_of_commissioning: ");
        String date_of_commissioning_scan = SCANNER.next();
        Date date_of_commissioning = Date.valueOf(date_of_commissioning_scan);
        System.out.println("Enter model_id: ");
        Integer model_id = SCANNER.nextInt();
        return new AircraftEntity(id_aircraft, id_company, expiration_date, date_of_commissioning, model_id);
    }

    private void createAircraft() throws SQLException {
        System.out.println("\n");
        AircraftEntity aircraft = getAircraftData();
        aircraftController.create(aircraft);
        System.out.println("New aircraft was created!\n");
    }

    private void updateAircraft() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        AircraftEntity aircraft = getAircraftData();
        aircraft.setId_aircraft(id);
        aircraftController.update(aircraft.getId_aircraft(), aircraft);
        System.out.println("Updated aircraft with ID = " + id + "\n");
    }

    private void deleteAircraft() throws SQLException {
        System.out.println("\nEnter ID to delete aircraft: ");
        int id = SCANNER.nextInt();
        aircraftController.delete(id);
        System.out.println("Deleted aircraft with ID = " + id + "\n");
    }

    private void getAllAirport() throws SQLException {
        System.out.println("\n");
        System.out.println(airportController.findAll() + "\n");
    }

    private void getAirport() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(airportController.findById(id) + "\n");
    }

    private AirportEntity getAirportData() {
        //System.out.println("\nEnter id_airport: ");
        //Integer id_airport = SCANNER.nextInt();
        System.out.println("Enter name: ");
        String name = SCANNER.next();
        System.out.println("Enter city_id: ");
        Integer city_id = SCANNER.nextInt();
        return new AirportEntity(name, city_id);
    }

    private void createAirport() throws SQLException {
        System.out.println("\n");
        AirportEntity airport = getAirportData();
        airportController.create(airport);
        System.out.println("New airport was created!\n");
    }

    private void updateAirport() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        AirportEntity airport = getAirportData();
        airport.setId_airport(id);
        airportController.update(airport.getId_airport(), airport);
        System.out.println("Updated airport with ID = " + id + "\n");
    }

    private void deleteAirport() throws SQLException {
        System.out.println("\nEnter ID to delete airport: ");
        int id = SCANNER.nextInt();
        airportController.delete(id);
        System.out.println("Deleted airport with ID = " + id + "\n");
    }

    private void getAllCity() throws SQLException {
        System.out.println("\n");
        System.out.println(cityController.findAll() + "\n");
    }

    private void getCity() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(cityController.findById(id) + "\n");
    }

    private CityEntity getCityData() {
        //System.out.println("\nEnter id_airport: ");
        //Integer id_city = SCANNER.nextInt();
        System.out.println("Enter name: ");
        String name = SCANNER.next();
        System.out.println("Enter country: ");
        String country = SCANNER.next();
        System.out.println("Enter post_number: ");
        String post_number = SCANNER.next();
        System.out.println("Enter year_of_foundation: ");
        String year_of_foundation = SCANNER.next();

        return new CityEntity(name, country, post_number, year_of_foundation);
    }

    private void createCity() throws SQLException {
        System.out.println("\n");
        CityEntity city = getCityData();
        cityController.create(city);
        System.out.println("New city was created!\n");
    }

    private void updateCity() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        CityEntity city = getCityData();
        city.setId_city(id);
        cityController.update(city.getId_city(), city);
        System.out.println("Updated city with ID = " + id + "\n");
    }

    private void deleteCity() throws SQLException {
        System.out.println("\nEnter ID to delete city: ");
        int id = SCANNER.nextInt();
        cityController.delete(id);
        System.out.println("Deleted city with ID = " + id + "\n");
    }

    private void getAllCompany() throws SQLException {
        System.out.println("\n");
        System.out.println(companyController.findAll() + "\n");
    }

    private void getCompany() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(companyController.findById(id) + "\n");
    }

    private CompanyEntity getCompanyData() {
        //System.out.println("\nEnter id_company: ");
        //Integer id_company = SCANNER.nextInt();
        System.out.println("Enter year_of_foundation: ");
        String year_of_foundation = SCANNER.next();
        System.out.println("\nEnter city_id: ");
        Integer city_id = SCANNER.nextInt();

        return new CompanyEntity(year_of_foundation, city_id);
    }

    private void createCompany() throws SQLException {
        System.out.println("\n");
        CompanyEntity company = getCompanyData();
        companyController.create(company);
        System.out.println("New company was created!\n");
    }

    private void updateCompany() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        CompanyEntity company = getCompanyData();
        company.setId_company(id);
        companyController.update(company.getId_company(), company);
        System.out.println("Updated company with ID = " + id + "\n");
    }

    private void deleteCompany() throws SQLException {
        System.out.println("\nEnter ID to delete city: ");
        int id = SCANNER.nextInt();
        companyController.delete(id);
        System.out.println("Deleted company with ID = " + id + "\n");
    }

    private void getAllFlights() throws SQLException {
        System.out.println("\n");
        System.out.println(flightsController.findAll() + "\n");
    }

    private void getFlights() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(flightsController.findById(id) + "\n");
    }

    private FlightsEntity getFlightsData() {
        //System.out.println("\nEnter flight_number: ");
        //Integer flight_number = SCANNER.nextInt();
        System.out.println("\nEnter aircraft_id: ");
        Integer aircraft_id = SCANNER.nextInt();
        System.out.println("Enter departure_time: ");
        String departure_time_data = "2020-12-12 01:24:23";
        Timestamp departure_time = Timestamp.valueOf(departure_time_data);
        System.out.println("Enter arrival_time: ");
        String arrival_time_data = "2020-12-12 01:24:23";
        Timestamp arrival_time = Timestamp.valueOf(arrival_time_data);
        System.out.println("\nEnter arrival_airport_id: ");
        Integer arrival_airport_id = SCANNER.nextInt();
        System.out.println("\nEnter departure_airport_id: ");
        Integer departure_airport_id = SCANNER.nextInt();

        return new FlightsEntity(aircraft_id, departure_time, arrival_time,arrival_airport_id, departure_airport_id);
    }

    private void createFlights() throws SQLException {
        System.out.println("\n");
        FlightsEntity flight = getFlightsData();
        flightsController.create(flight);
        System.out.println("New flight was created!\n");
    }

    private void updateFlights() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        FlightsEntity flight = getFlightsData();
        flight.setFlight_number(id);
        flightsController.update(flight.getFlight_number(), flight);
        System.out.println("Updated flight with ID = " + id + "\n");
    }

    private void deleteFlights() throws SQLException {
        System.out.println("\nEnter ID to delete flight: ");
        int id = SCANNER.nextInt();
        flightsController.delete(id);
        System.out.println("Deleted flight with ID = " + id + "\n");
    }

    private void getAllModel() throws SQLException {
        System.out.println("\n");
        System.out.println(modelController.findAll() + "\n");
    }

    private void getModel() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(modelController.findById(id) + "\n");
    }

    private ModelEntity getModelData() {
        //System.out.println("\nEnter id_model: ");
        //Integer id_model = SCANNER.nextInt();
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter max_speed: ");
        String max_speed = SCANNER.next();
        System.out.println("\nEnter passenger_capacity: ");
        Integer passenger_capacity = SCANNER.nextInt();
        System.out.println("\nEnter width: ");
        String width = SCANNER.next();
        System.out.println("\nEnter length: ");
        String length = SCANNER.next();
        System.out.println("\nEnter height: ");
        String height = SCANNER.next();

        return new ModelEntity(name, max_speed, passenger_capacity, width, length, height);
    }

    private void createModel() throws SQLException {
        System.out.println("\n");
        ModelEntity model = getModelData();
        modelController.create(model);
        System.out.println("New Model was created!\n");
    }

    private void updateModel() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        ModelEntity model = getModelData();
        model.setId_model(id);
        modelController.update(model.getId_model(), model);
        System.out.println("Updated model with ID = " + id + "\n");
    }

    private void deleteModel() throws SQLException {
        System.out.println("\nEnter ID to delete model: ");
        int id = SCANNER.nextInt();
        modelController.delete(id);
        System.out.println("Deleted model with ID = " + id + "\n");
    }

    private void getAllPilot() throws SQLException {
        System.out.println("\n");
        System.out.println(pilotController.findAll() + "\n");
    }

    private void getPilot() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(pilotController.findById(id) + "\n");
    }

    private PilotEntity getPilotData() {
        //System.out.println("\nEnter id_pilot: ");
        //Integer id_pilot = SCANNER.nextInt();
        System.out.println("\nEnter aircraft_id: ");
        Integer aircraft_id = SCANNER.nextInt();
        System.out.println("\nEnter company_id: ");
        Integer company_id = SCANNER.nextInt();
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter licence_number: ");
        String licence_number = SCANNER.next();
        System.out.println("\nEnter surname: ");
        String surname = SCANNER.next();
        System.out.println("\nEnter year_of_employment: ");
        String year_of_employment = SCANNER.next();

        return new PilotEntity(aircraft_id, company_id, name, licence_number, surname, year_of_employment);
    }

    private void createPilot() throws SQLException {
        System.out.println("\n");
        PilotEntity pilot = getPilotData();
        pilotController.create(pilot);
        System.out.println("New pilot was created!\n");
    }

    private void updatePilot() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        PilotEntity pilot = getPilotData();
        pilot.setId_pilot(id);
        pilotController.update(pilot.getId_pilot(), pilot);
        System.out.println("Updated pilot with ID = " + id + "\n");
    }

    private void deletePilot() throws SQLException {
        System.out.println("\nEnter ID to delete pilot: ");
        int id = SCANNER.nextInt();
        pilotController.delete(id);
        System.out.println("Deleted pilot with ID = " + id + "\n");
    }
}
