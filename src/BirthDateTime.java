import java.util.Scanner;

public class BirthDateTime
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int year = SafeInput.getRangedInt(in, "Enter the year you were born", 1950, 2015);
        int month = SafeInput.getRangedInt(in, "Enter the month you were born", 1, 12);

        int maxDay = 31;
        switch (month)
        {
            case 4:
            case 6:
            case 9:
            case 11:
                maxDay = 30;
                break;
            case 2:
                maxDay = 29;
                break;
            default: // 1, 3, 5, 7, 8, 10, 12
                maxDay = 31;
                break;
        }

        int day = SafeInput.getRangedInt(in, "Enter the day you were born", 1, maxDay);
        int hours = SafeInput.getRangedInt(in, "Enter the hour you were born", 1, 24);
        int minutes = SafeInput.getRangedInt(in, "Enter the minute you were born", 1, 59);

        System.out.println("\nYou were born on " + month + "/" + day + "/" + year
                + " at " + hours + ":" + String.format("%02d", minutes) + ".");
    }
}