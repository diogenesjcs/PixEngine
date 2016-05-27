package br.ufrpe.pixengine.mrnom;

import br.ufrpe.pixengine.components.GameObject;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;
import javafx.scene.image.Image;

public class SceneImage extends GameObject {
	
	private Image image;

	@Override
	public void update(GameContainer gc, float dt) {
		// TODO Auto-generated method stub
		updateComponents(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		
		r.drawImage(image,(int)x,(int)y);
		
	}

	@Override
	public void componentEvent(String name, GameObject object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public SceneImage(String tag,String path,int x,int y){
		this.image = new Image(path);
		setTag(tag);
		this.x = x;
		this.y = y;
	}

}
