package br.ufrpe.pixengine.spaceinvaders_demo;

import java.awt.event.KeyEvent;

import br.ufrpe.pixengine.components.GameObject;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;

public class Player extends GameObject {
    
    public Player(int x, int y) {
        setTag("player");
        this.x = x;
        this.y = y;
        this.w = 25;
        this.h = 25;
    }

    @Override
    public void update(GameContainer gc, float dt) {
        if (gc.getInput().isKey(KeyEvent.VK_A)) {
            
            x -= 60 * dt;

            if (x < 0) {
                x = 0;
            }
        }

        if (gc.getInput().isKey(KeyEvent.VK_D)) {
            x += 60 * dt;

            if (x + this.w > gc.getWidth()) {
                x = gc.getWidth() - this.w;
            }
        }

        updateComponents(gc, dt);
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawFillRect((int) x, (int) y, (int) w, (int) h, 0x0000FFFF);
    }

    @Override
    public void componentEvent(String name, GameObject object) {
        // TODO Auto-generated method stub
    }

    @Override
    public void dispose() {
        // descarregar imagens
    }

}
