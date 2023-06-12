package controllers;

import DAO.productoDAO;
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

public class productosController implements Initializable {
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
    private Button botonAgregarProductos;

    @FXML
    private Button botonEliminarProductos;

    @FXML
    private Button botonActualizarProductos;

    @FXML
    private Button botonRegresar;

    @FXML
    void botonAgregarProductosOMC(MouseEvent event) {
        try {
            Main.setFXML("agregarProductos","Vivero - Agregar Productos");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void botonEliminarProductosOMC(MouseEvent event) {
        try {
            Main.setFXML("eliminarProductos","Vivero - Eliminar Productos");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void botonActualizarProductosOMC(MouseEvent event) {
        try {
            Main.setFXML("actualizarProductos","Vivero - Actualizar Productos");
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
