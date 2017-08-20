package com.arief.fx.main;

import com.arief.fx.FxControllers.MainController;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Arief on 8/20/2017.
 */
@SpringBootApplication
@ComponentScan("com.arief.fx")
public class App  extends Application{


    private static String a[];

    private ConfigurableApplicationContext context;



    @Override
    public void start(Stage primaryStage) throws Exception {
        Task<Void> task  = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                context = SpringApplication.run(App.class,a);
                return null;
            }
        }  ;
        task.setOnSucceeded(e->{
            MainController main = context.getBean(MainController.class);
            Parent p = (Parent) main.initLoaderForView("MainMenu.fxml");

            primaryStage.setTitle("Spring Boot Java Fx");
            primaryStage.setResizable(false);
            primaryStage.setScene(new Scene(p));
            primaryStage.show();

        });
        task.run();
    }

    public static void main(String[]x){
        a= x;
        launch(x);
    }

}
