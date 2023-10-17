import javax.sound.sampled.Line;
import java.util.Scanner;
public class LinearEquationLogic {
    int x1, y1, x2, y2;
    private Scanner scan;
    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }
    public void start() {
        getCoords();

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
        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
        //System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
    }
}
