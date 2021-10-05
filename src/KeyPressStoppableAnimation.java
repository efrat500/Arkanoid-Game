//ID:206475907

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * This class responsible on the "key" that pressed and stopped the animation.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    private boolean stop;

    /**
     * constructor.
     * @param sensor keyboard
     * @param key the key
     * @param animation animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboardSensor = sensor;
        this.key = "space";
        this.animation = animation;
        this.isAlreadyPressed = true;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        //if pressed "space"
        if (keyboardSensor.isPressed(key) && (!isAlreadyPressed)) {
            stop = true;
        } else {
            isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
