import Controladores.MenuControlador;
import database.ConfigDB;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        MenuControlador objMenu = new MenuControlador();
        objMenu.menuPrincipal();
    }
}