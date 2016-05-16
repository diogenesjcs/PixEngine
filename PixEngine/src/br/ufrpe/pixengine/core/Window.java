package br.ufrpe.pixengine.core;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

public class Window {
	private Stage mainStage;
	private Scene mainScene;
	private Canvas canvas;
	private WritableImage img;
	private GraphicsContext g;

	public Window(GameContainer gc, Stage primaryStage) {
	    img = new WritableImage(gc.getWidth(), gc.getHeight());

		mainStage = primaryStage;
        mainStage.setTitle(gc.getTitle());

        Group root = new Group();
	    mainScene = new Scene(root);
	 
	    canvas = new Canvas();
	    root.getChildren().add(canvas);
		
		canvas.setWidth(gc.getWidth() * gc.getScale());
		canvas.setHeight(gc.getHeight() * gc.getScale());

		mainStage.setWidth(canvas.getWidth());
		mainStage.setHeight(canvas.getHeight());
		mainStage.setScene(mainScene);
		
		mainStage.setResizable(false);
		mainStage.show();

		g = canvas.getGraphicsContext2D();
	}

	public void update() {
		g.drawImage(img, 0, 0, canvas.getWidth(), canvas.getHeight());
	}

	public void cleanUp() {
		img.cancel();
		mainStage.close();
	}

    public Canvas getCanvas() {
        return canvas;
    }
	
    public WritableImage getImage() {
		return this.img;
	}
}
