package br.ufrpe.pixengine.core;

import java.awt.image.BufferedImage;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Window {
	private Stage mainStage;
	private Scene mainScene;
	private Canvas canvas;
	private BufferedImage image;
	private WritableImage wImage;
	private GraphicsContext g;

	public Window(GameContainer gc, Stage primaryStage) {
	    image = new BufferedImage(gc.getWidth(), gc.getHeight(), BufferedImage.TYPE_INT_RGB);
	    wImage = new WritableImage(gc.getWidth(), gc.getHeight());
	    
		mainStage = primaryStage;
        mainStage.setTitle(gc.getTitle());

        Group root = new Group();
	    mainScene = new Scene(root, Color.BLACK);
	 
	    canvas = new Canvas(gc.getWidth() * gc.getScale(), gc.getHeight() * gc.getScale());
	    root.getChildren().add(canvas);
		
		mainStage.setScene(mainScene);
		
		mainStage.setResizable(false);
		mainStage.show();

		g = canvas.getGraphicsContext2D();
	}

	public void update() {
	    SwingFXUtils.toFXImage(image, wImage);
		g.drawImage(wImage, 0, 0, canvas.getWidth(), canvas.getHeight());
	}

	public void cleanUp() {
	    image.flush();
		mainStage.close();
	}

    public Canvas getCanvas() {
        return canvas;
    }

    public Scene getScene() {
        return this.mainScene;
    }
    
    public BufferedImage getImage() {
		return this.image;
	}
    
    public WritableImage getWImage() {
        return this.wImage;
    }

    public Stage getMainStage() {
        return mainStage;
    }
}
