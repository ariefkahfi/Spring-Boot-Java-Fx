package com.arief.fx.config;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import org.springframework.context.ApplicationContextAware;




/**
 * Created by Arief on 8/20/2017.
 */
public interface FxInit extends Initializable,ApplicationContextAware {

    Node initLoaderForView(String fxmlFileName);
    void refreshComponents();
}
