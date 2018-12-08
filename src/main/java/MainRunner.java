import java.util.Scanner;

public class MainRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Body Mass Index Calculator !");
        double height;
        do{
            System.out.println("Please enter your height in meters, i.e. 1,69");
            while (!scanner.hasNextDouble()){
                System.out.println("You have used incorrect format, please  use only digits and \",\" to separate them.");
                scanner.next();
            }
            height = scanner.nextDouble();
            if (height <= 0) System.out.println("Pleas enter a digit larger than 0");
        }while (height == 0);

        double mass;
        do {
            System.out.println("Please enter your mass in kilograms i.e 60");
            while (!scanner.hasNextDouble()){
            System.out.println("You have used incorrect format, please use only digits and \",\" to separate them.");
            scanner.next();
        }
            mass =scanner.nextDouble();
            if (mass <= 0) System.out.println("Pleas enter a digit larger than 0");
        }while (mass == 0);

        BodyCalculator bmiCalc = new BMIndex(height,mass);
        System.out.println("Your BMI is : "+ bmiCalc.calculate()+" which places you in "+bmiCalc.interpret()+" category.");
    }
}
