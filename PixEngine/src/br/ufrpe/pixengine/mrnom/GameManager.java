package br.ufrpe.pixengine.mrnom;

import br.ufrpe.pixengine.core.AbstractGame;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;
import javafx.scene.input.KeyCode;
import javafx.stage.WindowEvent;

public class GameManager extends AbstractGame {
	
	public GameManager() {
		push(new InitState());
	}
	

	@Override
	public void update(GameContainer gc, float dt) {

		peek().update(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		peek().render(gc, r);
	}

	@Override
	public void init(GameContainer gc) {
		
		// TODO Auto-generated method stub
	}

}
