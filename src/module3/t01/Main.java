package module3.t01;

import java.io.IOException;
import java.util.Date;

/**
 * Created by alterG on 24.05.2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        CrazyLogger logger = new CrazyLogger();
        logger.add("Some problem.");
        logger.add("Problem has fixed.");
        logger.add("New user has registered on site.");
        System.out.println("All messages:");
        logger.printContent();
        System.out.println("Search by \"Problem\":");
        logger.findByMessage("Problem");
        System.out.println("Search by date (today):");
        Date date = new Date();
        logger.findByDate(date);

//        Output:
//        All messages:
//        25-17-2017 : 12-17 - Logger has run.
//        25-17-2017 : 12-17 - Some problem.
//        25-17-2017 : 12-17 - Problem has fixed.
//        25-17-2017 : 12-17 - New user has registered on site.
//        Search by "Problem":
//        25-17-2017 : 12-17 - Some problem.
//        25-17-2017 : 12-17 - Problem has fixed.
//        Search by date (today):
//        25-17-2017 : 12-17 - Logger has run.
//        25-17-2017 : 12-17 - Some problem.
//        25-17-2017 : 12-17 - Problem has fixed.
//        25-17-2017 : 12-17 - New user has registered on site.
    }
}
