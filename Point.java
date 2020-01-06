public class Point {

    private final int x, y;

    /**
     *
     * @param x
     * @param y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public boolean egal(int x, int y) {
        return x == this.x && y == this.y;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

}
