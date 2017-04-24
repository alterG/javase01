package t06;

/**
 * Created by alterG on 23.04.2017.
 */
public class Notepad {
    int MAX_ENTRYES = 50;
    int currentEntryes;
    boolean isOverflow;
    NotepadEntry entryes[];

    public boolean isOverflow() {
        return isOverflow;
    }

    public Notepad() {
        entryes = new NotepadEntry[MAX_ENTRYES];
    }

    public void addEntry(NotepadEntry entry) {
        if (!isOverflow) {
            entryes[currentEntryes++] = entry;
        }
        if (currentEntryes == MAX_ENTRYES) {
            isOverflow = true;
        }
    }

    public void showEntryes() {
        for (int i = 0; i < currentEntryes; i++) {
            System.out.println("Entry #"+i+"\n"+entryes[i].getEntry());
        }
    }

    public void deleteEntry (int number) {
        for (int i = number; i < currentEntryes - 1; i++) {
            entryes[i] = entryes[i+1];
        }
        currentEntryes--;
    }

    public  void replaceEntry (int number, NotepadEntry entry) {
        entryes[number] = entry;
    }
}
