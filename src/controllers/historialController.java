package controllers;

import DAO.fotosDAO;
import DAO.productoDAO;
import entities.Fotos;
import entities.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class historialController {

    @FXML
    private AnchorPane anchorPaneHistorial;

    @FXML
    private Button botonRegresar;


    @FXML
    void botonRegresarOMC(MouseEvent event) {
        try {
            Main.setFXML("sample","Vivero - Index");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
