//ID:206475907

/**
 * This class is used for counting things.
 */
public class Counter {
    private int num;

    /**
     * constructor.
     * @param counter the counter
     */
    public Counter(int counter) {
        this.num = counter;
    }

    /**
     * This function add number to current count.
     * @param number the number
     */
    public void increase(int number) {
        this.num += number;

    }

    /**
     * This function subtract number from current count.
     * @param number the number
     */
    public void decrease(int number) {
        this.num -= number;
    }

    /**
     * This function get current count.
     * @return this number
     */
    public int getValue() {
        return this.num;
    }
}
