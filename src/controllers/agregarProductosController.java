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
import sample.Main;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class agregarProductosController implements Initializable {

    @FXML
    private Button botonRegresar;

    @FXML
    private TextField textFieldNombreProducto;

    @FXML
    private TextField textFieldEstado;

    @FXML
    private DatePicker datePickerIngreso;

    @FXML
    private Button botonAgregar;

    @FXML
    private TableView<Tipo> tablaTipo;

    @FXML
    private TableColumn<Tipo, Integer> columnID;

    @FXML
    private TableColumn<Tipo, String> columnTipo;

    private ObservableList<Tipo> items = FXCollections.observableArrayList();

    @FXML
    void botonRegresarOMC(MouseEvent event) {
        try {
            Main.setFXML("productos","Vivero - Productos");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void botonAgregarOMC(MouseEvent event) {
        productoDAO dao = new productoDAO();
        Producto producto = new Producto();
        Tipo tipo = tablaTipo.getSelectionModel().getSelectedItem();

        producto.setNombre(textFieldNombreProducto.getText());
        producto.setTipo(tipo);
        producto.setEstado(textFieldEstado.getText());
        producto.setIngreso(datePickerIngreso.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        dao.agregarProducto(producto);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipos(items);
        tablaTipo.setItems(items);
        columnID.setCellValueFactory(new PropertyValueFactory<Tipo,Integer>("idTipo"));
        columnTipo.setCellValueFactory(new PropertyValueFactory<Tipo,String>("Tipo"));
    }

    public void tipos(ObservableList<Tipo> items) {
        tipoDAO dao = new tipoDAO();
        for (Tipo tipo:dao.getTipos()) {
            System.out.println(tipo);
            items.add(tipo);
        }
    }
}
