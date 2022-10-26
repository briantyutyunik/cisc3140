import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

    public HashMap<String, LocalDate> labs = new HashMap<>();

    public Main() {
        labs.put("Lab 1", LocalDate.parse("2022-09-28"));
        labs.put("Lab 2", LocalDate.parse("2022-10-26"));
        labs.put("Lab 3", LocalDate.parse("2022-10-23"));
        labs.put("Lab 4", LocalDate.parse("2022-12-07"));
    }

    public void compareDates() {
        long currDiff;
        for (String labName : labs.keySet()) {
            currDiff = ChronoUnit.DAYS.between(LocalDate.now(), labs.get(labName));

            System.out.printf("Time until %s due: %.2f %s\n", labName, currDiff >= 7 ? (float) currDiff / 7 : currDiff,
                    currDiff >= 7 ? "week(s)" : "day(s)");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.compareDates();
    }
}
