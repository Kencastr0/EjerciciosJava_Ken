package Controladores;

import entity.Autor;
import model.AutorModel;

import javax.swing.*;

public class AutorControl {

    AutorModel objM = new AutorModel();

    public void insertA() {
        Autor autor = new Autor();
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del autor a registrar: ");
        String nacionalidad = JOptionPane.showInputDialog("Ingresa la nacionalidad: ");

        autor.setNombre(nombre);
        autor.setNacionalidad(nacionalidad);

        autor = (Autor) this.objM.insert(autor);
        JOptionPane.showMessageDialog(null, autor);
    }

    public void updateA() {
        String listaAutores = "";
        for (Object obj : objM.findAll()) {
            Autor objA = (Autor) obj;
            listaAutores += objA.toString() + "\n";
        }
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(listaAutores + "Ingresa el Id del autor: "));
        Autor objAutor = (Autor) this.objM.findById(idUpdate);

        if (objAutor == null) {
            JOptionPane.showMessageDialog(null, "Busqueda sin resultados.");
        } else {
            objAutor.setNacionalidad(JOptionPane.showInputDialog(null, "Ingrese nuevo nombre si es necesario: ", objAutor.getNacionalidad()));
            objAutor.setNombre(JOptionPane.showInputDialog(null, "Ingrese nueva nacionalidad si es necesario: ", objAutor.getNombre()));
            this.objM.update(objAutor);
        }
    }

    public void deleteA() {
        String listaAutores = "";
        for (Object obj : objM.findAll()) {
            Autor objA = (Autor) obj;
            listaAutores += objA.toString() + "\n";
        }
        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listaAutores + "Ingrese el Id del Autor a eliminar: "));
        Autor objAutor = (Autor) this.objM.findById(idDelete);
        if (objAutor == null) {
            JOptionPane.showMessageDialog(null, "Autor no encontrado");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Are your sure want to delete the coder: \n" + objAutor.toString());
            if (confirm == 0) {
                this.objM.delete(objAutor);
            }
        }
    }

    public void all() {
        String listaAutores = "";
        for (Object obj : objM.findAll()) {
            Autor objA = (Autor) obj;
            listaAutores += objA.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, "Autores: \n" + listaAutores);
    }
}
