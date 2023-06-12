package controllers;

import DAO.calendarioDAO;
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

public class Controller {
    @FXML
    private Button botonHistorial;

    @FXML
    private Button botonCalendario;

    @FXML
    private Button botonProductos;

    @FXML
    private Button botonTipos;

    @FXML
    private Button botonRiego;

    @FXML
    void botonCalendarioOMC(MouseEvent event) {
        try {
            Main.setFXML("calendario","Calendario - Index");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void botonHistorialOMC(MouseEvent event) {
        try {
            Main.setFXML("historial","Vivero - Historial");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void botonProductosOMC(MouseEvent event) {
        try {
            Main.setFXML("productos","Vivero - Productos");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void botonRiegoOMC(MouseEvent event) {

    }

    @FXML
    void botonTiposOMC(MouseEvent event) {
        try {
            Main.setFXML("tipo","Vivero - Tipo");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
