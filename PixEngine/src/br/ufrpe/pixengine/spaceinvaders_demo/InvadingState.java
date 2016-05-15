package br.ufrpe.pixengine.spaceinvaders_demo;

import br.ufrpe.pixengine.components.ObjectManager;
import br.ufrpe.pixengine.components.State;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;
import br.ufrpe.pixengine.pong_demo.Ball;

public class InvadingState extends State {
    
    public InvadingState() {
        this.manager.addObject(new Ball(240, 400));
        this.manager.addObject(new Player(0, 370));
    }

    @Override
    public void update(GameContainer gc, float dt) {
        manager.updateObjects(gc, dt);
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        manager.renderObjects(gc, r);
    }

    @Override
    public void dipose() {
        manager.diposeObjects();
    }

    public ObjectManager getManager() {
        return manager;
    }

    public void setManager(ObjectManager manager) {
        this.manager = manager;
    }


}
