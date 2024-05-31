import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {
    public static Scanner scanner = new Scanner(System.in);

    public int readInt(){
        int inputInt = 0;
        do{
            try{
                inputInt= scanner.nextInt();
                scanner.nextLine();
                return inputInt;
            }catch (InputMismatchException e){
                System.out.println("Please enter a valid input");
                inputInt = 0;
                scanner.nextLine();
            }
        }while(inputInt==0);
        return 0;
    }

    public double readDouble(){
        double inputDouble = 0;
        do{

            try{
                inputDouble = scanner.nextDouble();
                scanner.nextLine();
                return inputDouble;
            }catch (InputMismatchException e){
                System.out.println("Please enter a valid input");
                inputDouble = 0;
                scanner.nextLine();
            }
        }while(inputDouble==0);
        return 0;
    }

    public String readString(){
        boolean valid = false;

        do {
            String inputString = scanner.nextLine();
            try{
                checkInput (inputString);
                return inputString;
            }catch(EmptyStringException e){
                System.out.println("Please enter a valid input");
            }
        }while(!valid);
        return null;
    }

    public static void checkInput(String input) throws EmptyStringException {
        if (input.trim().isEmpty()) {
            throw new EmptyStringException("Input cannot be empty! Please enter a valid name.");
        }
    }
    public static class EmptyStringException extends Exception {
        public EmptyStringException(String message) {
            super(message);
        }
    }
}
