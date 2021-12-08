package com.riznokril.view;

import com.riznokril.controller.ControllerImpl;
import com.riznokril.entity.FlightsEntity;
import com.riznokril.persistant.ConnectionManager;
import com.riznokril.service.implementation.FlightsServiceImpl;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {

    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static final Scanner input = new Scanner(System.in);

    public View() {

        menu = new LinkedHashMap<>();
        menu.put("1", "1 - print NumberList");
        menu.put("2", "2 - regenerate NumberList");
        menu.put("3", "3 - regenerate NumberList & print");
        menu.put("4", "4 - print Statistics");
        menu.put("Q", "Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("1", this::pressButton1);
        methodsMenu.put("2", this::pressButton2);
        methodsMenu.put("3", this::pressButton3);
        methodsMenu.put("4", this::pressButton4);
    }


    private void selectAllTable() throws SQLException {
        selectFlights();
        selectAircraft();
        selectAirport();
        selectCity();
        selectCompany();
        selectPilot();
        selectModel();
    }


    private void takeStructureOfDb() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        MetaDataService metaDataService = new MetaDataService();
        List<TableMetaData> tables = metaDataService.getTablesStructure();
        System.out.println("TABLE OF DATABASE: "+connection.getCatalog());

        for (TableMetaData table: tables) {
            System.out.println(table);
        }
    }


    private void selectFlights() throws SQLException {
        System.out.println("\nTable: Flights");
        FlightsServiceImpl flightsService = new FlightsServiceImpl();
        List<FlightsEntity> flights = flightsService.findAll();
        for (FlightsEntity entity : flights) {
            System.out.println(entity);
        }
    }











    private void outputMenu() {
        System.out.println("\nMENU: ");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches( "^\\v")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {}
        } while(!keyMenu.equals("Q"));
    }
}
