/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intervaltimer;

import accesoBD.AccesoBD;
import com.sun.org.apache.xpath.internal.axes.WalkerFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import modelo.Grupo;
import modelo.Gym;
import modelo.SesionTipo;

/**
 * FXML Controller class
 *
 * @author lisas
 */
public class FXMLDocumentController1 implements Initializable {

    @FXML
    private AnchorPane mainAnchorPane;
    @FXML
    private Button buttonAddGr;
    
     private IntervalTimer app;
    AccesoBD model;
    public Stage primaryStage;
      private ObservableList<Grupo> grupos;
      private Gym gym;
    @FXML
    private TextField tf_codigo;
    @FXML
    private TextField tf_descripcion;
    @FXML
    private TableView<Grupo> tv_grupos;
    @FXML
    private TableColumn<Grupo, String> grupos_column;
    @FXML
    private TableColumn<Grupo, String> descrip_column;
    @FXML
    private Button botonBorrar;
    private int pos;
    @FXML
    private Button next;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        
        this.gym = AccesoBD.getInstance().getGym();
        grupos = FXCollections.observableList(gym.getGrupos());
       
        tv_grupos.setItems(grupos);
        grupos_column.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCodigo()));
        descrip_column.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDescripcion()));
      
        AccesoBD.getInstance().salvar();
        final ObservableList<Grupo> tablaDocSel = tv_grupos.getSelectionModel().getSelectedItems();
        tablaDocSel.addListener(selectorTablaGrupo);

        BooleanBinding noDoctorSelected = Bindings.isEmpty(tv_grupos.getSelectionModel().getSelectedItems());
        this.botonBorrar.disableProperty().bind(noDoctorSelected);
        this.next.disableProperty().bind(noDoctorSelected);
        
       
    }    
    
     public void setApp(IntervalTimer app) {
        this.app = app;
        
    }
     
    public void initStage(Stage stage, AccesoBD accesoBD) {
        this.primaryStage = stage;
        this.model = accesoBD;
        this.tv_grupos.setItems(grupos);
        ArrayList<Grupo> lgrupos = model.getGym().getGrupos();
        tv_grupos.getItems().addAll(lgrupos);
        
        

    }

    @FXML
    private void AddGrupo(ActionEvent event) throws Exception { 
        Grupo grupo = new Grupo();
        grupo.setCodigo(tf_codigo.getText());
        grupo.setDescripcion(tf_descripcion.getText());
       grupos.add(grupo);
//       this.list_grupos.refresh();
       AccesoBD.getInstance().salvar();
       
       
     
    }

    @FXML
    private void bt_borrar(ActionEvent event) {
        int i = tv_grupos.getSelectionModel().getSelectedIndex();
        if(i>-1){
            grupos.remove(i);
        }
        tv_grupos.getSelectionModel().clearSelection();
        AccesoBD.getInstance().salvar();
                
    }
    
     private final ListChangeListener<Grupo> selectorTablaGrupo
            = new ListChangeListener<Grupo>() {
                
        @Override
        public void onChanged(ListChangeListener.Change<? extends Grupo> c) {
            abrirSesionGrupo();
        }
    };

    public Grupo getTablaGrupoSeleccionados() {
        if (tv_grupos != null) {
            List<Grupo> tabla = tv_grupos.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Grupo competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;

            }

        }
        return null;

    }

    private void abrirSesionGrupo(){
        final Grupo grupo = getTablaGrupoSeleccionados();
        pos = grupos.indexOf(grupo);
        if (grupo != null) {
            tf_codigo.setText(grupo.getCodigo());
            tf_descripcion.setText(grupo.getDescripcion());
            

        }
    }

    @FXML
    private void bt_next(ActionEvent event) throws Exception {
       
    }
}

   

 
  

