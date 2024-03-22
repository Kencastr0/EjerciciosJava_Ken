package Controladores;

import javax.swing.*;


public class MenuControlador {


    public void menuPrincipal() {
        String option = "";
        do {
            option = JOptionPane.showInputDialog("""
                    MENU
                    1. Autores:               
                    2. Libros:                    
                    3. Salir                    
                    """);
            switch (option) {
                case "1":
                    menuAutores();
                    break;
                case "2":
                    menuLibros();
                    break;
            }
        } while (!option.equals("3"));
    }

    public void menuAutores() {
        AutorControl objAC = new AutorControl();
        String optionA = "";
        do {
            optionA = JOptionPane.showInputDialog("""
                    MENU
                    1. Nuevo Autor:               
                    2. Editar Información Autor:                    
                    3. Eliminar Autor:
                    4. Mostrar todos los autores:
                    5. Buscar Autor:
                    6. Salir.
                    """);
            switch (optionA) {
                case "1":
                    objAC.insertA();
                    break;
                case "2":
                    objAC.updateA();
                    break;
                case "3":
                    objAC.deleteA();
                    break;
                case "4":
                    objAC.all();
                    break;
                case "5":
                    break;

            }

        } while (!optionA.equals("6"));
    }

    public void menuLibros() {
        LibroControl objLC = new LibroControl();
        String optionL = "";
        do {
            optionL = JOptionPane.showInputDialog("""
                     MENU
                    1. Nuevo Libro:               
                     2. Editar Información Libro:                    
                     3. Eliminar Libro:
                     4. Mostrar todos los Libros:
                      5. Buscar Libro:
                     6. Salir.
                      """);
            switch (optionL) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
            }
        } while (!optionL.equals("6"));
    }
}
