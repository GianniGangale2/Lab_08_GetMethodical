import java.util.Scanner;

public class SafeInput
{
    /**
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    /**
     * Gets any int value from the user.
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return an int entered by the user
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine(); // clear the newline from the pipe
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer, not: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets any double value from the user.
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a double entered by the user
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // clear the newline from the pipe
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a number, not: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets an int within an inclusive range from the user.
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user (the [low - high] is appended here)
     * @param low low end of the range (inclusive)
     * @param high high end of the range (inclusive)
     * @return an int between low and high inclusive
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine(); // clear the newline from the pipe
                if (retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("Number is out of range [" + low + " - " + high + "]: " + retVal);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer, not: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets a double within an inclusive range from the user.
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user (the [low - high] is appended here)
     * @param low low end of the range (inclusive)
     * @param high high end of the range (inclusive)
     * @return a double between low and high inclusive
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // clear the newline from the pipe
                if (retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("Number is out of range [" + low + " - " + high + "]: " + retVal);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a number, not: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets a Yes/No confirmation from the user.
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user ([Y/N] is appended here)
     * @return true for yes, false for no
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response = "";
        boolean retVal = false;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();
            if (response.matches("[yY]"))
            {
                retVal = true;
                done = true;
            }
            else if (response.matches("[nN]"))
            {
                retVal = false;
                done = true;
            }
            else
            {
                System.out.println("You must answer Y or N, not: " + response);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets a String that matches a RegEx pattern.
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param regEx the RegEx pattern (Java String format) to match
     * @return a String that matches the pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String response = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("Input does not match the required pattern: " + response);
            }
        } while (!done);

        return response;
    }

    /**
     * Displays a 3-line header, 60 characters wide, with the message centered
     * on the middle line between 3 asterisks at each end.
     * @param msg the message to center in the header
     */
    public static void prettyHeader(String msg)
    {
        final int WIDTH = 60;
        final int STARS = 3;

        // Top row
        for (int i = 0; i < WIDTH; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        // Middle row: 3 stars, padding, message, padding, 3 stars
        int space = WIDTH - 2 * STARS - msg.length(); // room left for padding
        int leftPad = space / 2;
        int rightPad = space - leftPad; // extra space goes on the right when odd

        for (int i = 0; i < STARS; i++)
        {
            System.out.print("*");
        }
        for (int i = 0; i < leftPad; i++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < rightPad; i++)
        {
            System.out.print(" ");
        }
        for (int i = 0; i < STARS; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        // Bottom row
        for (int i = 0; i < WIDTH; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}