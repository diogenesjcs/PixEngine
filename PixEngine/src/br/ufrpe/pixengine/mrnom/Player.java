package br.ufrpe.pixengine.mrnom;

import java.util.ArrayList;
import java.util.Arrays;

import br.ufrpe.pixengine.components.Collider;
import br.ufrpe.pixengine.components.GameObject;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Player extends GameObject {
	private Image imageHead;
	private ArrayList<Image> imagesTail;
	private ArrayList<Double> imagesPositionX;
	private ArrayList<Double> imagesPositionY;
	private int tailSize;
	private int speed;
	private int direction;
	private int time;
	private boolean increase;

	public Player(int x, int y) {
		increase=false;
		tailSize = 2;
		setTag("player");
		this.imageHead = new Image("/mr.nom/headdown.png");
		this.imagesTail = new ArrayList<Image>();
		this.imagesPositionX = new ArrayList<Double>();
		this.imagesPositionY = new ArrayList<Double>();
		this.x = x;
		this.y = y;
		this.speed = (int) (imageHead.getHeight()/(1.2f));
		addComponent(new Collider());
		w = (float) imageHead.getWidth();
		h = (float) imageHead.getHeight();
		time = 0;
		imagesPositionX.add(0, (double) x);
		imagesPositionY.add(0, (double) y);
		imagesPositionX.add(1, (double) x);
		imagesPositionY.add(1, (double) y);
		setTailPosition(x, y);
		for (int i = 0; i < tailSize; i++) {
			this.imagesTail.add(new Image("/mr.nom/tail.png"));
		}
		direction = KeyCode.DOWN.ordinal();
		
	}

	public void setTailSize(int n) {
		tailSize = n;
	}

	
	public void setTailPosition(float xT, float yT){
		for (int i = tailSize-1; i >=1; i--) {
			if(imagesPositionX.size()<=tailSize-1){
				imagesPositionX.add(imagesPositionX.get(i-1));
				imagesPositionY.add(imagesPositionY.get(i-1));
			}
			else{
				imagesPositionX.set(i, imagesPositionX.get(i-1));
				imagesPositionY.set(i, imagesPositionY.get(i-1));
			}
			
			
			
		}
		imagesPositionX.set(0, (double) xT);
		imagesPositionY.set(0, (double) yT);
	}
	
	public Boolean checkColision(float xT, float yT){
		for (int i = tailSize-1; i >=0; i--) {
			if(imagesPositionX.get(i)==xT&&imagesPositionY.get(i)==yT){
				return true;
			}
		}
		return false;
	}
	

	@Override
	public void update(GameContainer gc, float dt) {
		
		time++;
		if (gc.getInput().isKeyPressed(KeyCode.LEFT.ordinal())) {
			direction = KeyCode.LEFT.ordinal();
			

		}
		if (gc.getInput().isKeyPressed(KeyCode.RIGHT.ordinal())) {
			direction = KeyCode.RIGHT.ordinal();
			

		}
		if (gc.getInput().isKeyPressed(KeyCode.UP.ordinal())) {
			direction = KeyCode.UP.ordinal();
			

		}
		if (gc.getInput().isKeyPressed(KeyCode.DOWN.ordinal())) {
			direction = KeyCode.DOWN.ordinal();
			
		}
		if(time > (1/dt/(2.5))){
			if(increase){
				this.setTailSize(tailSize+1);
				increase=false;}
			
			setTailPosition(x,y);
			time = 0;
			if (direction == KeyCode.LEFT.ordinal()) {
				this.imageHead = new Image("/mr.nom/headleft.png");
				x -= speed;
				
			}
			if (direction == KeyCode.RIGHT.ordinal()) {
				this.imageHead = new Image("/mr.nom/headright.png");
				x += speed;
			}
			if (direction == KeyCode.UP.ordinal()) {
				this.imageHead = new Image("/mr.nom/headup.png");
				y -= speed;
				
			}
			if (direction == KeyCode.DOWN.ordinal()) {
				this.imageHead = new Image("/mr.nom/headdown.png");
				y += speed;				
			}
			if(x>gc.getWidth())
				x = 0;
			if(x<0)
				x = gc.getWidth();
			if(y>gc.getHeight())
				y = 0;
			if(y<0)
				y = gc.getHeight();
			if(checkColision(x,y)){
				gc.getGame().push(new GameOverState(tailSize-2));
			}
		}
		updateComponents(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(imageHead, (int) x, (int) y);
		for (int i = 0; i < imagesPositionX.size()-1; i++) {
			
			r.drawImage(imagesTail.get(i), imagesPositionX.get(i).intValue(), imagesPositionY.get(i).intValue());
		}
		
	}

	@Override
	public void dispose() {

	}

	public void increaseTailSize() {
		this.imagesTail.add(new Image("/mr.nom/tail.png"));
		increase = true;
	}

	public int getTailSize() {
		return tailSize;
	}

	@Override
	public void componentEvent(String name, GameObject object) {
		

	}

}
