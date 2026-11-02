import java.util.Scanner;

public class DevTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // Part A
        String name = SafeInput.getNonZeroLenString(in, "Enter your name");
        System.out.println("Name: " + name);

        // Part B
        int anyInt = SafeInput.getInt(in, "Enter any integer");
        System.out.println("Int: " + anyInt);

        // Part C
        double anyDouble = SafeInput.getDouble(in, "Enter any number");
        System.out.println("Double: " + anyDouble);

        // Part D
        int ranged = SafeInput.getRangedInt(in, "Enter an integer", 1, 10);
        System.out.println("Ranged int: " + ranged);

        // Part E
        double rangedD = SafeInput.getRangedDouble(in, "Enter a number", 0.0, 1.0);
        System.out.println("Ranged double: " + rangedD);

        // Part F
        boolean yes = SafeInput.getYNConfirm(in, "Do you want to continue?");
        System.out.println("Confirm: " + yes);

        // Part G
        String ssn = SafeInput.getRegExString(in, "Enter an SSN (###-##-####)", "\\d{3}-\\d{2}-\\d{4}");
        System.out.println("SSN: " + ssn);
    }
}