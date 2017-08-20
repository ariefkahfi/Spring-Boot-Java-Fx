package com.arief.fx.FxControllers;

import com.arief.fx.config.AbstractFxController;
import com.arief.fx.entity.Person;
import com.arief.fx.services.PersonDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Arief on 8/20/2017.
 */
@Component
public class ListController extends AbstractFxController{

    @FXML
    private TableColumn<Person, Integer> columnId;
    @FXML
    private TableColumn<Person,String> columnNama;
    @FXML
    private TableView<Person> tableView;


    @Autowired
    private PersonDAO personDAO;


    @Override
    public void refreshComponents() {
        tableView.getItems().clear();
        tableView.getItems().addAll(personDAO.getAll());
    }

    @FXML
    private Button refresh;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpColumns();
        refreshComponents();
    }


    private void setUpColumns(){
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
    }

    public void refreshItem(ActionEvent ev){
        refreshComponents();
    }

}
