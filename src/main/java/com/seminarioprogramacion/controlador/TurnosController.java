/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.seminarioprogramacion.controlador;

import com.seminarioprogramacion.dto.EspecialidadDTO;
import com.seminarioprogramacion.dto.MecanicoDTO;
import com.seminarioprogramacion.main.App;
import com.seminarioprogramacion.modelo.Especialidad;
import com.seminarioprogramacion.modelo.Mecanico;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ikukl
 */
public class TurnosController implements Initializable {

    @FXML
    private Button btnAsignarTurno;
    @FXML
    private Button btnEliminarTurno;
    @FXML
    private Button brnAsistencia;
    @FXML
    private Button btnFichaMecanica;
    @FXML
    private Button btnImprimirComprobante;
    @FXML
    private Button btnImprimirFichaMecanica;
    @FXML
    private ComboBox combobox_especialidades;
    @FXML
    private ComboBox combobox_mecanicos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Especialidad
        Especialidad especialidad = new Especialidad();
        List<EspecialidadDTO> especialidades = especialidad.listar();
        combobox_especialidades.getItems().addAll(especialidades);         
             
        //Mecanicos
         Mecanico mecanico = new Mecanico();
        List<MecanicoDTO> mecanicos = mecanico.listar();
        combobox_mecanicos.getItems().addAll(mecanicos); 
        //Modelo
        //Lista
        //combobox
    }   
    
    @FXML
    private void switchToAsignarTurno() throws IOException {
        //App.setRoot("testui",400,600);
        
        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        
        App.newWindow("AsignarTurno",((Stage) btnAsignarTurno.getScene().getWindow()),"Asignar Turno");
    }
    
        @FXML
        private void eliminarTurno(ActionEvent event) {
        String mensaje = "¿Está seguro que quiere eliminar este Turno?";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mensaje, ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
    }
    
        
        @FXML
        private void confirmarAsistencia(ActionEvent event) {
        String mensaje = "¿El titular asistió al turno seleccionado?";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mensaje, ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();     
    }
        
        @FXML
        private void imprimirComprobante(ActionEvent event) throws IOException{
        String mensaje = "¿Desea imprimir el comprobante?";
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensaje, ButtonType.OK, ButtonType.CANCEL);
        alert.showAndWait();
    }
        
         @FXML
        private void imprimirFichaMecanica(ActionEvent event) throws IOException{
        String mensaje = "¿Desea imprimir la ficha mecánica?";
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensaje, ButtonType.OK, ButtonType.CANCEL);
        alert.showAndWait();
    }
}
