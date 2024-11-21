package org.example;

import dao.AlumnoDAO;
import database.MongoDBConnection;
import dao.ProfesorDAO;
import resources.menu;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        /*MongoDBConnection mongoDBConnection = new MongoDBConnection();
        mongoDBConnection.checkConnection();*/

        menu menu = new menu();
        menu.mostrarMenu();




    }
}
