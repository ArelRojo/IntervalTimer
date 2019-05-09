/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intervaltimer;

import accesoBD.AccesoBD;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Grupo;
import modelo.Sesion;
import modelo.SesionTipo;

/**
 * FXML Controller class
 *
 * @author lisas
 */
public class FXMLSesionController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Button buttonAddSesion;
    @FXML
    private TableView<Sesion> tv_sesiones;
    @FXML
    private TableColumn<?, ?> sesion_column;
    @FXML
    private TableColumn<?, ?> descripSesion_column;
    @FXML
    private Button botonBorrarSesion;
    private IntervalTimer app;
    public Stage primaryStage;
    AccesoBD dao;
    private ObservableList<Sesion> sesiones;
    private ObservableList<Grupo> grupo;
    AccesoBD model;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void AddGrupo(ActionEvent event) {
    }

    @FXML
    private void bt_borrar(ActionEvent event) {
    }
    
    
}
