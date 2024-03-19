package controller;

import entity.Coder;
import model.CoderModel;

import javax.swing.*;

public class CoderController {

    CoderModel objCoderModel;

    //Crear una instancia del model
    public CoderController() {
        this.objCoderModel = new CoderModel();
    }

    //Método para listar todos los coder
    public void getAll() {

        String list = " List Coders \n";
        //Iteramos sobre la lista que devuelve el método find All
        for (Object obj : this.objCoderModel.findAll()) {
            //Convertimos o cateamos el objeto tipo Object a un coder
            Coder objCoder = (Coder) obj;
            //Concatenamos la información
            list += objCoder.toString() + "\n";
        }
        //Mostramos toda la lista
        JOptionPane.showMessageDialog(null, list);

    }

    public void create() {

        Coder objCoder = new Coder();

        String name = JOptionPane.showInputDialog("Insert name: ");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Insert age: "));
        String clan = JOptionPane.showInputDialog("Insert clan: ");

        objCoder.setName(name);
        objCoder.setEdad(age);
        objCoder.setClan(clan);

        objCoder = (Coder) this.objCoderModel.insert(objCoder);

        JOptionPane.showMessageDialog(null, objCoder.toString());
    }

    public void update(){
        Coder coder = new Coder();

         getAll();
         int newId = Integer.parseInt(JOptionPane.showInputDialog("Type new Id"));
         String newName = JOptionPane.showInputDialog("Type new Name");
         int  newAge= Integer.parseInt(JOptionPane.showInputDialog("Type new Age"));
         String newClan = JOptionPane.showInputDialog("Type new Clan");

         coder.setId(newId);
         coder.setName(newName);
         coder.setEdad(newAge);
         coder.setClan(newClan);

        Object object = (Object) coder;
        objCoderModel.update(object);
    }

    public void delete(){
        //Imprimimos lista de coders
        getAll();
        //Selections id
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog("Type Id"));
        //Eliminamos coder por id
        objCoderModel.delete(idDelete);
    }

    public void getByName(){

    }

}

