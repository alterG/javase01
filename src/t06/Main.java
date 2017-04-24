package t06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by alterG on 23.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Notepad notepad = new Notepad();
        int choice;
        String bufHead;
        String bufBody;
        int bufIndex;
        printMenu();
        while (true) {
            System.out.print("Please type a number: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.print("Type header of new entry: ");
                        bufHead=reader.readLine();
                        System.out.print("Type body of new entry: ");
                        bufBody=reader.readLine();
                        notepad.addEntry(new NotepadEntry(bufHead, bufBody));
                        System.out.println("New entry has added.");
                        } catch (Exception e) {
                        System.out.println("Notepad is overflow. Please delete some entries.");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Type index of entry to delete it: ");
                        bufIndex = scanner.nextInt();
                        notepad.deleteEntry(bufIndex);
                        System.out.printf("Entry#%d has successfully deleted.\n", bufIndex);
                    } catch (Exception e) {
                        System.out.println("Notepad hasn't entry with this index.");
                    }
                    break;
                case 3:
                    try {
                        notepad.showEntryes();
                    } catch (Exception e) {
                        System.out.println("Notepad hasn't any entries.");
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Type index of entry to edit it: ");
                        int entryNumber = scanner.nextInt();
                        System.out.print("Type new header of entry: ");
                        bufHead = reader.readLine();
                        System.out.print("Type new body of entry: ");
                        bufBody = reader.readLine();
                        notepad.editEntry(entryNumber, new NotepadEntry(bufHead, bufBody));
                        System.out.println("Entry is successfully edited.");
                    } catch (Exception e) {
                        System.out.println("Notepad hasn't entry with this index.");
                    }
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Unknown menu point. Type '5' to print menu.");
            }
        }


    }

    private static void printMenu() {
        System.out.print("Menu:\n" +
                "   1. Add new entry.\n" +
                "   2. Delete entry by index.\n" +
                "   3. Show all entries.\n" +
                "   4. Edit entry by index.\n" + "" +
                "   5. Print menu.\n" +
                "   6. Exit.\n");
    }

}
