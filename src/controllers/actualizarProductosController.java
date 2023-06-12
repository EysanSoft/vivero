package controllers;

import DAO.productoDAO;
import DAO.tipoDAO;
import entities.Producto;
import entities.Tipo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class actualizarProductosController implements Initializable {
    @FXML
    private AnchorPane anchorPaneActualizarProductos;

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

    @FXML
    private DatePicker datePickerFecha;

    @FXML
    private TextField textFieldEstado;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldIdTipo;

    @FXML
    private TextField textFieldBusqueda;

    @FXML
    private Button botonBuscar;

    @FXML
    private Button botonActualizar;

    @FXML
    private Button botonRegresar;

    private ObservableList<Producto> items = FXCollections.observableArrayList();

    private Producto producto = new Producto();

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelEstado;

    @FXML
    private Label labelTipo;

    @FXML
    private Label labelIngreso;

    @FXML
    void botonActualizarOMC(MouseEvent event) {
        productoDAO dao = new productoDAO();
        String idTipoCadena = textFieldIdTipo.getText();
        int idTipo = Integer.parseInt(idTipoCadena);
        Tipo tipo = new Tipo();

        tipo.setIdTipo(idTipo);
        producto.setNombre(textFieldNombre.getText());
        producto.setTipo(tipo);
        producto.setEstado(textFieldEstado.getText());
        producto.setIngreso(datePickerFecha.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        dao.actualizarProducto(producto);
        try {
            Main.setFXML("actualizarProductos","Vivero - Actualizar Productos");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void botonBuscarOMC(MouseEvent event) {
        productoDAO dao = new productoDAO();
        String idBusqueda = textFieldBusqueda.getText();
        int idProducto = Integer.parseInt(idBusqueda);
        producto = dao.getProducto(idProducto);

        anchorPaneActualizarProductos.getChildren().add(textFieldEstado);
        anchorPaneActualizarProductos.getChildren().add(textFieldNombre);
        anchorPaneActualizarProductos.getChildren().add(textFieldIdTipo);
        anchorPaneActualizarProductos.getChildren().add(datePickerFecha);
        anchorPaneActualizarProductos.getChildren().add(botonActualizar);
        anchorPaneActualizarProductos.getChildren().remove(tablaProductos);
        anchorPaneActualizarProductos.getChildren().remove(textFieldBusqueda);
        anchorPaneActualizarProductos.getChildren().remove(botonBuscar);
        anchorPaneActualizarProductos.getChildren().add(labelEstado);
        anchorPaneActualizarProductos.getChildren().add(labelIngreso);
        anchorPaneActualizarProductos.getChildren().add(labelTipo);
        anchorPaneActualizarProductos.getChildren().add(labelNombre);

        textFieldNombre.setText(producto.getNombre());
        textFieldIdTipo.setText(producto.getTipo().getIdTipo().toString());
        textFieldEstado.setText(producto.getEstado());
        datePickerFecha.setValue(LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
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
        //Ocultar Elementos
        anchorPaneActualizarProductos.getChildren().remove(textFieldEstado);
        anchorPaneActualizarProductos.getChildren().remove(textFieldNombre);
        anchorPaneActualizarProductos.getChildren().remove(textFieldIdTipo);
        anchorPaneActualizarProductos.getChildren().remove(datePickerFecha);
        anchorPaneActualizarProductos.getChildren().remove(botonActualizar);
        anchorPaneActualizarProductos.getChildren().remove(labelEstado);
        anchorPaneActualizarProductos.getChildren().remove(labelIngreso);
        anchorPaneActualizarProductos.getChildren().remove(labelTipo);
        anchorPaneActualizarProductos.getChildren().remove(labelNombre);
        //Llenar Tabla
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

    public void tipos(ObservableList<Tipo> items) {
        tipoDAO dao = new tipoDAO();
        for (Tipo tipo:dao.getTipos()) {
            System.out.println(tipo);
            items.add(tipo);
        }
    }

}
