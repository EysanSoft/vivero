package controllers;

import DAO.calendarioDAO;
import DAO.productoDAO;
import entities.Calendario;
import entities.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class agregarCalendarioController implements Initializable {

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, Integer> idColumn;

    @FXML
    private TableColumn<Producto, String> nombreColumn;

    @FXML
    private TableColumn<Producto, String> tipoColumn;

    @FXML
    private TableColumn<Producto, String> fechaColumn;

    @FXML
    private TableColumn<Producto, String> estadoColumn;

    private ObservableList<Producto> items = FXCollections.observableArrayList();

    @FXML
    private Button botonAgregar;

    @FXML
    private Button botonRegresar;

    @FXML
    private CheckBox ckLunes;

    @FXML
    private CheckBox ckMiercoles;

    @FXML
    private CheckBox ckViernes;

    @FXML
    private CheckBox ckMartes;

    @FXML
    private CheckBox ckJueves;

    @FXML
    private CheckBox ckDomingo;

    @FXML
    private CheckBox ckSabado;

    Producto producto = new Producto();

    private Boolean lunes = false;
    private Boolean martes = false;
    private Boolean miercoles = false;
    private Boolean jueves = false;
    private Boolean viernes = false;
    private Boolean sabado = false;
    private Boolean domingo = false;

    int conLun = 0;
    int conMar = 0;
    int conMie = 0;
    int conJue = 0;
    int conVie = 0;
    int conSab = 0;
    int conDom = 0;

    @FXML
    void botonAgregarOMC(MouseEvent event) {
        calendarioDAO dao = new calendarioDAO();
        Calendario calendario = new Calendario();
        producto = tablaProductos.getSelectionModel().getSelectedItem();

        calendario.setProducto(producto);
        calendario.setLunes(lunes);
        calendario.setMartes(martes);
        calendario.setMiercoles(miercoles);
        calendario.setJueves(jueves);
        calendario.setViernes(viernes);
        calendario.setSabado(sabado);
        calendario.setDomingo(domingo);
        dao.agregarCalendario(calendario);
    }

    @FXML
    void botonRegresarOMC(MouseEvent event) {
        try {
            Main.setFXML("calendario","Vivero - Calendario");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void ckDomingoOMC(MouseEvent event) {
        conDom++;
        if(conDom == 1) {
            domingo = true;
        }
        else {
            domingo = false;
            conDom = 0;
        }
    }

    @FXML
    void ckJuevesOMC(MouseEvent event) {
        conJue++;
        if(conJue == 1) {
            jueves = true;
        }
        else {
            jueves = false;
            conJue = 0;
        }
    }

    @FXML
    void ckLunesOMC(MouseEvent event) {
        conLun++;
        if(conLun == 1) {
            lunes = true;
        }
        else {
            lunes = false;
            conLun = 0;
        }
    }

    @FXML
    void ckMartesOMC(MouseEvent event) {
        conMar++;
        if(conMar == 1) {
            martes = true;
        }
        else {
            martes = false;
            conMar = 0;
        }
    }

    @FXML
    void ckMiercolesOMC(MouseEvent event) {
        conMie++;
        if(conMie == 1) {
            miercoles = true;
        }
        else {
            miercoles = false;
            conMie = 0;
        }
    }

    @FXML
    void ckSabadoOMC(MouseEvent event) {
        conSab++;
        if(conSab == 1) {
            sabado = true;
        }
        else {
            sabado = false;
            conSab = 0;
        }
    }

    @FXML
    void ckViernes(MouseEvent event) {
        conVie++;
        if(conVie == 1) {
            viernes = true;
        }
        else {
            viernes = false;
            conVie = 0;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productos(items);
        tablaProductos.setItems(items);
        idColumn.setCellValueFactory(new PropertyValueFactory<Producto,Integer>("idProducto"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<Producto,String>("nombre"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory<Producto,String>("nombreTipo"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<Producto,String>("ingreso"));
        estadoColumn.setCellValueFactory(new PropertyValueFactory<Producto,String>("estado"));
    }

    public void productos(ObservableList<Producto> items) {
        productoDAO dao = new productoDAO();
        for (Producto producto:dao.getListaProductos()) {
            items.add(producto);
        }
    }
}
