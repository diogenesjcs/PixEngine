package br.ufrpe.pixengine.core;

import java.awt.BorderLayout;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.InputEvent;
import javafx.stage.Stage;

public class Window {
	private Stage frame;
	private Scene mainScene;
	private Canvas canvas;
	private BufferedImage image;
	private GraphicsContext g;
	private BufferStrategy bs;

	public Window(GameContainer gc, Stage primaryStage) {
		image = new BufferedImage(gc.getWidth(), gc.getHeight(), BufferedImage.TYPE_INT_RGB);

		frame = primaryStage;
        frame.setTitle(gc.getTitle());

        Group root = new Group();
	    mainScene = new Scene(root);
	    frame.setScene(mainScene);
	 
	    canvas = new Canvas();
	    root.getChildren().add(canvas);
		
		canvas.setWidth(gc.getWidth() * gc.getScale());
		canvas.setHeight(gc.getHeight() * gc.getScale());

		
		frame.setLayout(new BorderLayout());
		frame.add(canvas, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		canvas.createBufferStrategy(1);
		bs = canvas.getBufferStrategy();
		g = bs.getDrawGraphics();
	}

	public void update() {
		g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight());
		bs.show();
	}

	public void cleanUp() {
		g.dispose();
		bs.dispose();
		image.flush();
		frame.dispose();
	}

	public void addEventHandler(EventHandler<? extends InputEvent> eh) {
	    this.mainScene.addEventHandler(eventType, eventHandler);
	}
	
	public BufferedImage getImage() {
		return image;
	}
}
