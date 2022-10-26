import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static int compareDates(Date startDate, Date endDate) {
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        int daysBetween = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return daysBetween;
    }

    // This checks whether the inputted date is valid in the regex of MM/dd/yyyy or
    // MM/dd
    public static boolean validateDate(String date) {
        return date.matches("^(0[1-9]|1[012])/(0[1-9]|[12][0-9]|[3][01])/\\d{4}$")
                || date.matches("^(0[1-9]|1[012])/(0[1-9]|[12][0-9]|[3][01])$");
    }

    public static void showDates() throws FileNotFoundException {
        System.out.println("Choose Date or please enter a valid date(MM/dd/yyyy or MM/dd)!");
        Scanner scanner = new Scanner(new FileInputStream(new File("dates.txt")));
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static String handleSelection(String selection) {
        String currDate = "";
        switch (selection) {
            case "a":
                currDate = "09/14/2022";
                break;
            case "b":
                currDate = "09/28/2022";
                break;
            case "c":
                currDate = "10/26/2022";
                break;
            case "d":
                currDate = "10/26/2022";
                break;
            case "e":
                currDate = "12/07/2022";
                break;
            case "f":
                currDate = "09/28/2022";
                break;
            case "g":
                currDate = "10/26/2022";
                break;
            case "h":
                currDate = "11/23/2022";
                break;
            case "i":
                currDate = "12/07/2022";
                break;
            case "j":
                currDate = "12/19/2022";
                break;
            default:
                currDate = selection;
        }
        return currDate;
    }

    public static Date getDate() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String date = "";
        // continously prompts user to enter a date or view upcoming dates
        while (date == "") {
            showDates();
            String currDate1 = handleSelection(scanner.nextLine());

            if (!validateDate(currDate1)) {
                System.out.println("You entered an invalid date. Please enter a valid date(MM/dd/yyyy or MM/dd!");
            } else {
                date = currDate1.length() < 10 ? currDate1 + "/2023" : currDate1;
            }
        }
        return new Date(date);
    }

    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Date date1 = getDate();
        Date date2 = getDate();
        System.out.println(compareDates(date1, date2));

    }
}