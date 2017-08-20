package com.arief.fx.FxControllers;

import com.arief.fx.config.AbstractFxController;
import com.arief.fx.entity.Person;
import com.arief.fx.services.PersonDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import sun.applet.Main;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Arief on 8/20/2017.
 */
@Component
public class FormController  extends AbstractFxController{


    @FXML
    private Button bMenu;
    @FXML
    private Button bSimpan;
    @FXML
    private TextField fieldId;
    @FXML
    private TextField fieldNama;

    @Autowired
    private MainController main;

    @Autowired
    private PersonDAO dao;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void refreshComponents() {
        fieldId.setText("");
        fieldNama.setText("");
    }

    public void showMenu(ActionEvent ev){
        Stage st = (Stage)((Node)ev.getSource()).getScene().getWindow();
        main.stageReload(st,"MainMenu.fxml", MainController.class);
    }


    public void doSave(ActionEvent ev){



        try{
            int id = Integer.parseInt(fieldId.getText().trim());
            String nama = fieldNama.getText().trim();


            if(id<=0 || nama.equals("")){
                buatDialog("Info","Error input", Alert.AlertType.ERROR);
            }else{
                dao.simpanData(new Person(id,nama));
                buatDialog("Info","Simpan Data berhasil", Alert.AlertType.CONFIRMATION);
                refreshComponents();
            }

        }catch (NumberFormatException ex){
            buatDialog("Error","Id must be number", Alert.AlertType.ERROR);
            refreshComponents();
        }catch (DuplicateKeyException ex){
         buatDialog("Error",ex.getMessage(), Alert.AlertType.ERROR);
         refreshComponents();
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            refreshComponents();
        }
    }

    private void buatDialog(String title,String contentText, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);

        alert.setTitle(title);
        alert.setContentText(contentText);

        alert.show();

    }

}
