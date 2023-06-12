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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class eliminarProductosController implements Initializable {
    @FXML
    private Button botonRegresar;

    @FXML
    private Button botonEliminar;

    @FXML
    private TextField textFieldID;

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
    void botonEliminarOMC(MouseEvent event) {
        productoDAO dao = new productoDAO();
        String cadenaIDProducto = textFieldID.getText();
        int id = Integer.parseInt(cadenaIDProducto);
        Producto producto = dao.getProducto(id);
        dao.eliminarProducto(producto);
        try {
            Main.setFXML("eliminarProductos","Vivero - Eliminar Productos");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void botonRegresarOMC(MouseEvent event) {
        try {
            Main.setFXML("productos","Vivero - Productos");
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
