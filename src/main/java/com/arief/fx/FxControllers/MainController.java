package com.arief.fx.FxControllers;

import com.arief.fx.config.AbstractFxController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Arief on 8/20/2017.
 */
@Component
public class MainController extends AbstractFxController {



    @Autowired
    private FormController form;
    @Autowired
    private ListController list;



    @FXML
    private BorderPane borderMain;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    public void stageReload(Stage st,String fxmlFile,Class  c){
        Parent p = (Parent)((AbstractFxController)context.getBean(c)).initLoaderForView(fxmlFile);
        st.setTitle("Spring Boot Java Fx");
        st.setResizable(false);
        st.setScene(new Scene(p));
        st.show();
    }


    public void setCenter(Node newNode){
        borderMain.setCenter(newNode);
    }

    public void showForm(ActionEvent ev){
        Stage stage = (Stage) ((Node)ev.getSource()).getScene().getWindow();
        stageReload(stage,"form.fxml",FormController.class);
    }


    public void showList(ActionEvent ev){
        setCenter(list.initLoaderForView("list.fxml"));
    }

    @Override
    public void refreshComponents() {

    }
}
