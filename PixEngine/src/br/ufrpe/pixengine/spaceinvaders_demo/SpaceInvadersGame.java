package br.ufrpe.pixengine.spaceinvaders_demo;

import br.ufrpe.pixengine.core.AbstractGame;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;

public class SpaceInvadersGame extends AbstractGame {
    
    public SpaceInvadersGame() {
        push(new InvadingState());
    }

    @Override
    public void init(GameContainer gc) {
        //carregar recursos
    }

    @Override
    public void update(GameContainer gc, float dt) {
        this.peek().update(gc, dt);
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        this.peek().render(gc, r);
    }

    public static void main(String[] args) {
        GameContainer gc = new GameContainer(new SpaceInvadersGame());
        gc.setWidth(240);
        gc.setHeight(420);
        gc.setScale(2);
        gc.setTitle("Invasores do Espaço");
        gc.setClearScreen(true);
        gc.setLightEnable(false);
        gc.setDynamicLights(false);
        gc.start();
    }
    
}
