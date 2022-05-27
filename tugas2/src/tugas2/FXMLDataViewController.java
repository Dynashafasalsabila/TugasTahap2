/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import oven.db.DBHandler;
import oven.model.OvenProperty;

/**
 * FXML Controller class
 *
 
 */
public class FXMLDataViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<OvenProperty> tblOven;

    @FXML
    private TableColumn<OvenProperty, String> colMerkOven;

    @FXML
    private TableColumn<OvenProperty, String> colId;

    @FXML
    private TableColumn<OvenProperty, String> colNama;

    @FXML
    private TableColumn<OvenProperty, String> colPembayaran;

    @FXML
    private TableColumn<OvenProperty, String> colTglBeli;

    @FXML
    private MenuItem menuAddData;

    @FXML
    private MenuItem menuDeleteData;

    @FXML
    void viewAddDataForm(ActionEvent event) throws IOException {
        Stage modal = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        modal.setScene(scene);
//        modal.initOwner(((Node)event.getSource()).getScene().getWindow() );
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }

    @FXML
    void deleteDataOven(ActionEvent event) {
        OvenProperty ovn = tblOven.getSelectionModel().getSelectedItem();
        DBHandler dh = new DBHandler("MYSQL");
        dh.deleteOven(ovn);
        showDataOven();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showDataOven();

        tblOven.getSelectionModel().selectedIndexProperty().addListener(listener -> {
//            JOptionPane.showMessageDialog(null, "Table Diklik!");
            menuDeleteData.setDisable(false);
        });
    }

    public void showDataOven() {
        DBHandler dh = new DBHandler("MYSQL");
        ObservableList<OvenProperty> data = dh.getOven();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMerkOven.setCellValueFactory(new PropertyValueFactory<>("MerkOven"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colPembayaran.setCellValueFactory(new PropertyValueFactory<>("pembayaran"));
        colTglBeli.setCellValueFactory(new PropertyValueFactory<>("tanggalBeli"));
        tblOven.setItems(null);
        tblOven.setItems(data);
    }
}
