package controllers;

import DAO.calendarioDAO;
import entities.Calendario;
import entities.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class calendarioController implements Initializable {

    @FXML
    private Button botonRegresar;

    @FXML
    private TableView<Calendario> tablaCalendario;

    @FXML
    private TableColumn<Calendario, Integer> IDColumn;

    @FXML
    private TableColumn<Calendario, String> productoColumn;

    @FXML
    private TableColumn<Calendario, Boolean> lunesColumn;

    @FXML
    private TableColumn<Calendario, Boolean> martesColumn;

    @FXML
    private TableColumn<Calendario, Boolean> miercolesColumn;

    @FXML
    private TableColumn<Calendario, Boolean> juevesColumn;

    @FXML
    private TableColumn<Calendario, Boolean> viernesColumn;

    @FXML
    private TableColumn<Calendario, Boolean> sabadoColumn;

    @FXML
    private TableColumn<Calendario, Boolean> domingoColumn;

    private ObservableList<Calendario> items = FXCollections.observableArrayList();

    @FXML
    private Button botonAgregar;

    @FXML
    private Button botonActualizar;

    @FXML
    private Button botonEliminar;

    @FXML
    void botonActualizarOMC(MouseEvent event) {
        try {
            Main.setFXML("actualizarCalendario","Vivero - Actualizar Calendario");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void botonAgregarOMC(MouseEvent event) {
        try {
            Main.setFXML("agregarCalendario","Vivero - Agregar Calendario");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void botonEliminarOMC(MouseEvent event) {
        try {
            Main.setFXML("eliminarCalendario","Vivero - Eliminar Calendario");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void botonRegresarOMC(MouseEvent event) {
        try {
            Main.setFXML("sample","Vivero - Index");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        calendarioL(items);
        tablaCalendario.setItems(items);
        IDColumn.setCellValueFactory(new PropertyValueFactory<Calendario,Integer>("idCalendario"));
        productoColumn.setCellValueFactory(new PropertyValueFactory<Calendario,String>("nombreProducto"));
        lunesColumn.setCellValueFactory(new PropertyValueFactory<Calendario,Boolean>("lunes"));
        martesColumn.setCellValueFactory(new PropertyValueFactory<Calendario,Boolean>("martes"));
        miercolesColumn.setCellValueFactory(new PropertyValueFactory<Calendario,Boolean>("miercoles"));
        juevesColumn.setCellValueFactory(new PropertyValueFactory<Calendario,Boolean>("jueves"));
        viernesColumn.setCellValueFactory(new PropertyValueFactory<Calendario,Boolean>("viernes"));
        sabadoColumn.setCellValueFactory(new PropertyValueFactory<Calendario,Boolean>("sabado"));
        domingoColumn.setCellValueFactory(new PropertyValueFactory<Calendario,Boolean>("domingo"));
    }

    public void calendarioL(ObservableList<Calendario> items) {
        calendarioDAO dao = new calendarioDAO();
        for (Calendario calendario:dao.getListaCalendario()) {
            items.add(calendario);
        }
    }

}
