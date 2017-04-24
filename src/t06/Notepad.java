package t06;

/**
 * Created by alterG on 23.04.2017.
 */
public class Notepad {
    private static final int MAX_ENTRIES = 50;
    private int indexOfLastEntry;
    private NotepadEntry entryes[];

    public Notepad() {
        entryes = new NotepadEntry[MAX_ENTRIES];
        indexOfLastEntry = -1; //no entries
    }

    public void addEntry(NotepadEntry entry) throws Exception {
        if (indexOfLastEntry == MAX_ENTRIES - 1) throw new Exception();
        entryes[++indexOfLastEntry] = entry;
    }

    public void showEntryes() throws Exception {
        if (indexOfLastEntry == -1) throw new Exception();
        for (int i = 0; i <= indexOfLastEntry; i++) {
            System.out.println("Entry #"+i+"\n"+entryes[i].getEntry());
        }
    }

    public void deleteEntry (int number) throws Exception {
        if (number > indexOfLastEntry || number < 0) {
            throw new Exception();
        }
        for (int i = number; i < indexOfLastEntry - 1; i++) {
            entryes[i] = entryes[i+1];
        }
        indexOfLastEntry--;
    }

    public  void editEntry (int number, NotepadEntry entry) throws Exception{
        if (indexOfLastEntry == -1 || number < 0 || number > indexOfLastEntry) throw new Exception();
        entryes[number].setHeader(entry.getHeader());
        entryes[number].setContent(entry.getContent());
    }
}
