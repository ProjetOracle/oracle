/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Classe;


import java.sql.SQLException;
/**
 *
 * @author WorkStation
 * @param <T>
 */
public interface SQL_Interface <T>{
    
    public void initialize() throws SQLException;
    public T    initialize(int id) throws SQLException;
    public void update() throws SQLException;
    public void insert() throws SQLException;
    public void delete() throws SQLException; 
    public void delete (int id) throws SQLException;
}
