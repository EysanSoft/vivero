package controllers;

import DAO.tipoDAO;
import entities.Tipo;
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

public class tipoController implements Initializable {
    @FXML
    private TableView<Tipo> tablaTipo;

    @FXML
    private TableColumn<Tipo, Integer> columnID;

    @FXML
    private TableColumn<Tipo, String> columnTipo;

    private ObservableList<Tipo> items = FXCollections.observableArrayList();

    @FXML
    private TextField textFieldAgregar;

    @FXML
    private Button botonAgregar;

    @FXML
    private TextField textFieldActualizar;

    @FXML
    private TextField textFieldIDTipo;

    @FXML
    private Button botonActualizar;

    @FXML
    private Button botonEliminar;

    @FXML
    private Button botonRegresar;

    @FXML
    void botonActualizarOMC(MouseEvent event) {
        tipoDAO dao = new tipoDAO();
        Tipo tipo = tablaTipo.getSelectionModel().getSelectedItem();
        tipo.setTipo(textFieldActualizar.getText());
        dao.actualizarTipo(tipo);
        try {
            Main.setFXML("tipo","Vivero - Tipo");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void botonAgregarOMC(MouseEvent event) {
        tipoDAO dao = new tipoDAO();
        Tipo tipo = new Tipo();
        String IDTipoCadena = textFieldIDTipo.getText();
        int IDTipo = Integer.parseInt(IDTipoCadena);

        tipo.setIdTipo(IDTipo);
        tipo.setTipo(textFieldAgregar.getText());
        dao.agregarTipo(tipo);
        try {
            Main.setFXML("tipo","Vivero - Tipo");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void botonEliminarOMC(MouseEvent event) {
        tipoDAO dao = new tipoDAO();
        Tipo tipo = tablaTipo.getSelectionModel().getSelectedItem();
        dao.eliminarTipo(tipo);
        try {
            Main.setFXML("tipo","Vivero - Tipo");
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
