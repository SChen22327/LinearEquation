import javax.sound.sampled.Line;
import java.util.Scanner;
public class LinearEquationLogic {
    int x1, y1, x2, y2;
    double numForX;
    private boolean endLoop = false;
    private LinearEquation equation;
    private Scanner scan;
    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }
    public void start() {
        while (endLoop == false) {
            getCoords();
            createLineEquation();
            System.out.println(equation.lineInfo());
            System.out.println(getCoordForX());
            endLoop = endLoop();
        }
    }

    public void getCoords() {
        System.out.println("Welcome to the Linear Equation Calculator");
        System.out.print("Enter coordinate pair 1: ");
        String coord1 = scan.nextLine();
        System.out.print("Enter coordinate pair 2: ");
        String coord2 = scan.nextLine();

        x1 = Integer.parseInt(coord1.substring(1, coord1.indexOf(",")));
        y1 = Integer.parseInt(coord1.substring(coord1.indexOf(",") + 2, coord1.indexOf(")")));
        x2 = Integer.parseInt(coord2.substring(1, coord2.indexOf(",")));
        y2 = Integer.parseInt(coord2.substring(coord2.indexOf(",") + 2, coord2.indexOf(")")));
    }

    public boolean checkUndefined() {
        try {
            int testNum = x1 / x2;
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    public void createLineEquation() {
        if (checkUndefined() == false) {
            equation = new LinearEquation(x1, y1, x2, y2);
            //System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
        } else {
            equation = new LinearEquation(checkUndefined(), y1, y2);
        }
    }

    public String getCoordForX() {
        System.out.print("Enter an x-value: ");
        numForX = scan.nextDouble();
        return equation.coordinateForX(numForX);
    }

    public boolean endLoop() {
        System.out.println("Would you like to enter a new pair of coordinates? y/n");
        if (scan.nextLine().equals("n") || scan.nextLine().equals("no")) {
            return true;
        } else {
            return false;
        }
    }
}
