package module3.t01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by alterG on 20.05.2017.
 */
public class CrazyLogger {

    private StringBuilder storage;
    private SimpleDateFormat format = new SimpleDateFormat("dd-mm-YYYY : hh-mm");

    public CrazyLogger() {
        storage = new StringBuilder();
        this.add("Logger has run.");
    }

    public void add(String message) {
        Date currentDate = Calendar.getInstance().getTime();
        storage
                .append(format.format(currentDate))
                .append(" - ")
                .append(message+"\n");
    }

    public void findMessages(String message) {
        String[] messages = storage.toString().split("\n");
        boolean isFound = false;
        for (String entry : messages) {
            if (entry.toLowerCase().contains(message.toLowerCase())) {
                System.out.println(entry);
                isFound = true;
            }
        }
        if (!isFound) System.out.println("This message is missing.");
    }

    public void findByDate(Date date) {
        String[] messages = storage.toString().split("\n");
        boolean isFound = false;
        for (String entry : messages) {
            if (entry.contains(format.format(date))) {
                System.out.println(entry);
                isFound = true;
            }
        }
        if (!isFound) System.out.println("No messages at " + date +".");

    }

    public void printContent() {
        System.out.print(storage);
    }

}
