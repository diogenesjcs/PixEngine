package br.ufrpe.pixengine.pong_demo;

import br.ufrpe.pixengine.core.GameContainer;
import javafx.application.Application;
import javafx.stage.Stage;

public class PongGame extends Application {
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameContainer gc = new GameContainer(new GameManager(), primaryStage);
        gc.setWidth(320);
        gc.setHeight(240);
        gc.setScale(3);
        gc.setTitle("My Pong!");
        gc.setClearScreen(true);
        gc.setLightEnable(false);
        gc.setDynamicLights(false);
        gc.start();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
