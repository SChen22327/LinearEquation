public class LinearEquation {
    private int x1, y1, x2, y2;
    private boolean undefined;
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public LinearEquation(boolean undefined, int y1, int y2) {
        this.y1 = y1;
        this.y2 = y2;
        this.undefined = undefined;
    }
    public double roundedToHundredth(double toRound) {
        return (double) Math.round(toRound * 100) / 100;
    }
    public double distance() {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return roundedToHundredth(distance);
    }

    public double slope() {
        double slope = y2 - y1;
        slope /= x2 - x1;
        return slope;
    }

    public double yIntercept() {
        double yIntercept = y1;
        yIntercept -= slope() * x1;
        return roundedToHundredth(yIntercept);
    }

    public String equation() {
        String equation;
        if (!undefined) {
            equation = "y = ";
            if (slope() == -1) {
                equation += "-x ";
            } else if(slope() == 1) {
                equation += "x ";
            } else if (slope() == 0) {
                if (yIntercept() / (int) yIntercept() != 1) {
                    equation += yIntercept();
                } else {
                    equation += (int) yIntercept();
                }
            } else if (slope() / (int) slope() != 1) {
                for (int i = 2; i > 1; i++) {
                    double num = slope();
                    num *= i;
                    if (num / (int) num == 1) {
                        equation += (int) num + "/" + i;
                        break;
                    }
                }
                equation += "x ";
            } else if (slope() / (int) slope() == 1) {
                equation += (int) slope() + "x ";
            } else {
                equation += roundedToHundredth(slope()) + "x ";
            }
            if (slope() != 0) {
                if (yIntercept() > 0) {
                    equation += "+ " + yIntercept();
                } else if (yIntercept() < 0) {
                    equation += "- " + Math.abs(yIntercept());
                }
            }
        } else {
            equation = "x = " + x1;
        }
        return equation;
    }

    public String coordinateForX(double x) {
        return "(" + x + ", " + String.format("%.2f",slope() * x + yIntercept()) + ")";
    }

    public String lineInfo() {
        String lineInfo;
        lineInfo = "The two points are (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n";
        lineInfo += "The equation of the line between these points is: " + equation() + "\n";
        lineInfo += "The slope of the line is: ";
        if (undefined) {
            lineInfo += "undefined\n";
            lineInfo += "The x-intercept of this line is: " + x1 + "\n";
        } else {
            lineInfo += roundedToHundredth(slope()) + "\n";
            lineInfo += "The y-intercept of this line is: " + yIntercept() + "\n";
        }
        lineInfo += "The distance between these points is: " + distance();
        return lineInfo;
    }
}
