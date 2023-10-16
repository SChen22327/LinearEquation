public class LinearEquation {
    private int x1, y1, x2, y2;;
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return (double) Math.round(distance * 100) / 100;
    }

    public double yIntercept() {
        return 0;
    }
}
