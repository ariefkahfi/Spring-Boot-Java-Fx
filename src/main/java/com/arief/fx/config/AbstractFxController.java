package com.arief.fx.config;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Arief on 8/20/2017.
 */
public abstract class AbstractFxController implements FxInit {

    protected ApplicationContext context;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    @Override
    public Node initLoaderForView(String fxmlFileName) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/scene/"+fxmlFileName));
        loader.setController(context.getBean(getClass()));

        try {
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
