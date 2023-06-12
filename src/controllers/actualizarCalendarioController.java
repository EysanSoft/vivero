package controllers;

import DAO.calendarioDAO;
import entities.Calendario;
import entities.Producto;
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
import java.util.ResourceBundle;

public class actualizarCalendarioController implements Initializable {
    @FXML
    private AnchorPane anchorPaneActualizarCalendario;

    @FXML
    private TextField textFieldBusqueda;

    @FXML
    private Button botonBuscar;

    @FXML
    private Button botonRegresar;

    @FXML
    private Button botonActualizar;

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
    private CheckBox ckLunes;

    @FXML
    private CheckBox ckMartes;

    @FXML
    private CheckBox ckMiercoles;

    @FXML
    private CheckBox ckJueves;

    @FXML
    private CheckBox ckViernes;

    @FXML
    private CheckBox ckSabado;

    @FXML
    private CheckBox ckDomingo;

    @FXML
    private TextField textFieldIDProducto;

    @FXML
    private Label labelIDProducto;

    private Calendario calendario = new Calendario();

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
    void botonActualizarOMC(MouseEvent event) {
        calendarioDAO dao = new calendarioDAO();
        String idProductoCadena = textFieldIDProducto.getText();
        int idProducto = Integer.parseInt(idProductoCadena);
        Producto producto = new Producto();

        producto.setIdProducto(idProducto);
        calendario.setProducto(producto);
        calendario.setLunes(lunes);
        calendario.setMartes(martes);
        calendario.setMiercoles(miercoles);
        calendario.setJueves(jueves);
        calendario.setViernes(viernes);
        calendario.setSabado(sabado);
        calendario.setDomingo(domingo);
        dao.actualizarCalendario(calendario);

        try {
            Main.setFXML("actualizarCalendario","Vivero - Actualizar Calendario");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void botonBuscarOMC(MouseEvent event) {
        calendarioDAO dao = new calendarioDAO();
        String idBusqueda = textFieldBusqueda.getText();
        int idCalendario = Integer.parseInt(idBusqueda);
        calendario = dao.getCalendario(idCalendario);
        anchorPaneActualizarCalendario.getChildren().add(textFieldIDProducto);
        anchorPaneActualizarCalendario.getChildren().add(ckLunes);
        anchorPaneActualizarCalendario.getChildren().add(ckMartes);
        anchorPaneActualizarCalendario.getChildren().add(ckMiercoles);
        anchorPaneActualizarCalendario.getChildren().add(ckJueves);
        anchorPaneActualizarCalendario.getChildren().add(ckViernes);
        anchorPaneActualizarCalendario.getChildren().add(ckSabado);
        anchorPaneActualizarCalendario.getChildren().add(ckDomingo);
        anchorPaneActualizarCalendario.getChildren().add(botonActualizar);
        anchorPaneActualizarCalendario.getChildren().add(labelIDProducto);
        anchorPaneActualizarCalendario.getChildren().remove(tablaCalendario);
        anchorPaneActualizarCalendario.getChildren().remove(textFieldBusqueda);
        anchorPaneActualizarCalendario.getChildren().remove(botonBuscar);

        textFieldIDProducto.setText(calendario.getProducto().getIdProducto().toString());

        if(calendario.getLunes() == true) {
            conLun = 1;
            lunes = true;
            ckLunes.setSelected(true);
        }

        if(calendario.getMartes() == true) {
            conMar = 1;
            martes = true;
            ckMartes.setSelected(true);
        }

        if(calendario.getMiercoles() == true) {
            conMie = 1;
            miercoles = true;
            ckMiercoles.setSelected(true);
        }

        if(calendario.getJueves() == true) {
            conJue = 1;
            jueves = true;
            ckJueves.setSelected(true);
        }

        if(calendario.getViernes() == true) {
            conVie = 1;
            viernes = true;
            ckViernes.setSelected(true);
        }

        if(calendario.getSabado() == true) {
            conSab = 1;
            sabado = true;
            ckSabado.setSelected(true);
        }

        if(calendario.getDomingo() == true) {
            conDom = 1;
            domingo = true;
            ckDomingo.setSelected(true);
        }
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
    void ckViernesOMC(MouseEvent event) {
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
        anchorPaneActualizarCalendario.getChildren().remove(textFieldIDProducto);
        anchorPaneActualizarCalendario.getChildren().remove(ckLunes);
        anchorPaneActualizarCalendario.getChildren().remove(ckMartes);
        anchorPaneActualizarCalendario.getChildren().remove(ckMiercoles);
        anchorPaneActualizarCalendario.getChildren().remove(ckJueves);
        anchorPaneActualizarCalendario.getChildren().remove(ckViernes);
        anchorPaneActualizarCalendario.getChildren().remove(ckSabado);
        anchorPaneActualizarCalendario.getChildren().remove(ckDomingo);
        anchorPaneActualizarCalendario.getChildren().remove(botonActualizar);
        anchorPaneActualizarCalendario.getChildren().remove(labelIDProducto);
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
