//ID:206475907

import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *This function saves the entire sprite in a collection and does different actions on the entire sprite together.
 */
public class SpriteCollection {
    private Collection<Sprite> sprites;

    /**
     * constructor.
     */
    public SpriteCollection() {
        sprites = new ArrayList<>();
    }

    /**
     * This function add a sprite to the sprites collection.
     * @param s the sprite we want to add.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * This function remove the sprite from the game.
     * @param s the sprite
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }
    /**
     * This function calls to all the functions timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spriteList = new ArrayList<>(this.sprites);
        for (Sprite s: spriteList) {
           s.timePassed();
        }
    }

    /**
     * This function calls to all the functions drawOn(d) on all sprites.
     * @param d the draw surface.
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> spriteList = new ArrayList<>(this.sprites);
        for (Sprite s: spriteList) {
            s.drawOn(d);
        }
    }
}


