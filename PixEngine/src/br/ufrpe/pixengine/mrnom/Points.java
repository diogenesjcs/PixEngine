package br.ufrpe.pixengine.mrnom;

import br.ufrpe.pixengine.components.GameObject;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.shape.Rectangle;

public class Points extends GameObject {
	
	private Image image;
	private int number;

	@Override
	public void update(GameContainer gc, float dt) {
		updateComponents(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		
		r.drawImage(image,20*number, 0, 20, image.getHeight(),
	            x, y, 20, image.getHeight());
		
	}

	@Override
	public void componentEvent(String name, GameObject object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public void setNumber(int n){
		number =n;
	}
	
	public Points(String tag,String path,int x,int y){
		setTag(tag);
		number =0;
		this.image = new Image(path);
		this.x = x;
		this.y = y;
	}

}
