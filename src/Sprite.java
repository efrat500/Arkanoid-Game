//ID:206475907

import biuoop.DrawSurface;

/**
 * This interface represent the function that all the object called sprite need to implement.
 */
public interface Sprite {

        /**
         * This function draw the sprite to the screen.
         * @param d the draw surface.
         */
        void drawOn(DrawSurface d);

        /**
         * This function notify the sprite that time has passed.
         */
        void timePassed();

}
