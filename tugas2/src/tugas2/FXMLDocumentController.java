/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import oven.db.DBHandler;
import oven.model.Oven;

/**
 *

 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private Button btnSave;

    @FXML
    private ComboBox<?> cbPembayaran;

    @FXML
    private DatePicker dpTanggalBeli;

    @FXML
    private ToggleGroup MerkOven;

    @FXML
    private Label label;

    @FXML
    private RadioButton rdCosmos;

    @FXML
    private RadioButton rdPhilips;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfNama;

    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
//        label.setText("Hello "+tfNama.getText());
        System.out.println(tfId.getText());
        System.out.println(tfNama.getText());
        System.out.println(dpTanggalBeli.getValue().toString());
        String MerkOven="";
        if (rdCosmos.isSelected())
           MerkOven=rdCosmos.getText();
        if (rdPhilips.isSelected())
           MerkOven=rdPhilips.getText();
        
        System.out.println(MerkOven);
        System.out.println(cbPembayaran.getValue().toString());
//        Mahasiswa(String id, String nama, String tanggalBeli, String merk oven, String pembayaran)
        Oven ovn = new Oven(tfId.getText(),tfNama.getText(),dpTanggalBeli.getValue().toString(),
            MerkOven,cbPembayaran.getValue().toString());
        DBHandler dh = new DBHandler("MYSQL");
        dh.addOven(ovn);
        FXMLDataViewController view = new FXMLDataViewController();
        view.showDataOven();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        ArrayList <String> list = new ArrayList<String>();
        list.add("Cash");
        list.add("Kredit");
        ObservableList items = FXCollections.observableArrayList(list);
        cbPembayaran.setItems(items);
    }    
    
}
