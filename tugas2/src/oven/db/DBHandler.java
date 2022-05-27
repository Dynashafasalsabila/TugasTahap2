/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oven.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oven.model.Oven;
import oven.model.OvenProperty;
/**
 *
 */
public class DBHandler {
    public final Connection conn;

    public DBHandler(String driver) {
        this.conn = DBHelper.getConnection(driver);
    }
    public void addOven(Oven ovn){
        String insertOvn = "INSERT INTO `oven`(`id`, `nama`, `tgl_beli`,`merk_oven`,`pembayaran`)"
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmtInsert = conn.prepareStatement(insertOvn);
            stmtInsert.setString(1, ovn.getId());
            stmtInsert.setString(2, ovn.getNama());
            stmtInsert.setString(3, ovn.getTanggalBeli());
            stmtInsert.setString(4, ovn.getMerkOven());
            stmtInsert.setString(5, ovn.getPembayaran());
            stmtInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ObservableList<OvenProperty> getOven(){
        ObservableList<OvenProperty> data = FXCollections.observableArrayList();
        
        String sql = "SELECT id, nama, tgl_beli, merk_oven, pembayaran FROM `oven` ORDER BY id";
        
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                OvenProperty ovn = new OvenProperty(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                data.add(ovn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
    public void deleteOven(OvenProperty ovn){
        String deleteOvn = "DELETE FROM oven WHERE `oven`.`id` = ?";
        try {
            PreparedStatement stmtDelete = conn.prepareStatement(deleteOvn);
            stmtDelete.setString(1, ovn.getId());
            stmtDelete.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
