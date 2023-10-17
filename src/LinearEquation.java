public class LinearEquation {
    private int x1, y1, x2, y2;
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double roundedToHundredth(double toRound) {
        return (double) Math.round(toRound * 100) / 100;
    }
    public double distance() {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return roundedToHundredth(distance);
    }

    public double yIntercept() {
        double yIntercept = y1;
        yIntercept -= slope() * x1;
        return roundedToHundredth(yIntercept);
    }

    public double slope() {
        double slope = y2 - y1;
        slope /= x2 - x1;
        return roundedToHundredth(slope);
    }

    public String equation() {
        String equation = "y = ";
        if (slope() == -1) {
            equation += "-x ";
        } else if (slope() == 0) {}
        else if (slope() / (int) slope() != 1) {
            for (int i = 2; i > 1; i++) {
                double num = slope();
                num *= i;
                if (num / (int) num == 1) {
                    equation += num + "/" + i;
                    break;
                }
            }
        } else {
            equation += "x ";
        }

    }
}
