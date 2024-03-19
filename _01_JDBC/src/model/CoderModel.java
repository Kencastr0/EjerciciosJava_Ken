package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD {


    @Override
    public Object insert(Object object) {
        //1. Abrimos la conexión
        Connection objConnection = ConfigDB.openConnection();
        //2. Catear el objeto
        Coder objCoder = (Coder) object;

        try {
            //3. Crear SQL
            String sql = "INSERT INTO coder (name,age,clan) VALUES(?,?,?);";
            //4. Utilizar PrepareStatement
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            //5. Ingresar los datos (?,?,?)
            objPrepare.setString(1, objCoder.getName());
            objPrepare.setInt(2, objCoder.getEdad());
            objPrepare.setString(3, objCoder.getClan());
            //6. Ejecutamos el Query
            objPrepare.execute();
            //7. Obtener el resultado
            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objCoder.setId(objResult.getInt(1));
            }

            //8. Cerramos el prepareStatement
            JOptionPane.showMessageDialog(null, "Coder insertion was successful");
            objPrepare.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data cannot be added" + e.getMessage());
        }

        //9. Cerramos la conexión
        ConfigDB.closeConnection();
        return objCoder;
    }

    @Override
    public boolean update(Object object) {
        //1. Abrimos la conexión
        Coder coder = (Coder) object;
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "UPDATE coder SET name = ?, age = ?, clan = ? WHERE (id = ?);";
            PreparedStatement objPreparedStatement = (PreparedStatement) objConnection.prepareStatement(sql);
            objPreparedStatement.setString(1, coder.getName());
            objPreparedStatement.setInt(2, coder.getEdad());
            objPreparedStatement.setString(3, coder.getClan());
            objPreparedStatement.setInt(4, coder.getId());


            objPreparedStatement.executeUpdate();

            System.out.println("Coder was update successfully");
        } catch (SQLException e) {
            System.out.println("Data cannot be updated" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return false;
    }

    @Override
    public boolean delete(int id) {
        //1. Abrimos la conexión
        Connection objConnection = ConfigDB.openConnection();
        try {
            //2. Crear SQL
            String sql = "DELETE FROM coder WHERE id =?;";
            //3 Prepare
            PreparedStatement objPrepareStatement = (PreparedStatement) objConnection.prepareStatement(sql);
            objPrepareStatement.setInt(1,id);
            objPrepareStatement.execute();
            objPrepareStatement.close();

            //4. Coder eliminado
            JOptionPane.showMessageDialog(null, "Coder delete was successful");
        }catch (SQLException e){
            //5. En caso de credenciales incorrectas
            JOptionPane.showMessageDialog(null, "Id invalid" + e.getMessage());
        }

        //Cerramos conexión con DB
        ConfigDB.closeConnection();
        return true;
    }

    @Override
    public List<Object> findAll() {
        //1. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();
        //2. Inicializar la lista donde se guardaran los registros que devuelve DB
        List<Object> listCoders = new ArrayList<>();

        try {
            //3. Escribir la sentencia SQL
            String sql = "SELECT * FROM coder ORDER BY coder.id ASC;";

            //4. Utilizar PrepareStatement
            PreparedStatement objPreparedStatement = (PreparedStatement) objConnection.prepareStatement(sql);

            //5. Ejecutar el Query o prepare
            ResultSet objResult = (ResultSet) objPreparedStatement.executeQuery();

            //6. Obtener los resultados
            while (objResult.next()) {
                Coder objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setEdad(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));

                //Finalmente, agregamos el coder a la lista
                listCoders.add(objCoder);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data acquisition error");
        }

        //7. Cerramos la conexión
        ConfigDB.closeConnection();
        return listCoders;
    }

    @Override
    public Object findById(int id) {
        return null;
    }
}
