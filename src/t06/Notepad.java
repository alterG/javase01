package t06;

/**
 * Notepad where people can add, delete and edit entries {@link NotepadEntry NotepadEntry}
 *
 * <p>Entries storage is an array</p>
 *
 *
 * @author alterG
 * @version 1.0
 */

public class Notepad {
    private static final int MAX_ENTRIES = 50;  /*size of notepad*/
    private int indexOfLastEntry;
    private NotepadEntry entryes[];

    public Notepad() {
        entryes = new NotepadEntry[MAX_ENTRIES];
        indexOfLastEntry = -1; //no entries
    }

    /**
     * Add entry in notepad
     *
     * @param entry new entry to write it into notepad
     * @throws Exception if notepad is overflow
     */
    public void addEntry(NotepadEntry entry) throws Exception {
        if (indexOfLastEntry == MAX_ENTRIES - 1) throw new Exception();
        entryes[++indexOfLastEntry] = entry;
    }

    /**
     * Show all entries in notepad
     *
     * @throws Exception if notepad has no entries
     */
    public void showEntryes() throws Exception {
        if (indexOfLastEntry == -1) throw new Exception();
        for (int i = 0; i <= indexOfLastEntry; i++) {
            System.out.println("Entry #"+i+"\n"+entryes[i].getEntry());
        }
    }

    /**
     * Delete entry with entered index
     *
     * @param number index of entry to delete
     * @throws Exception if notepad hasn't entry with entered index
     */
    public void deleteEntry (int number) throws Exception {
        if (number > indexOfLastEntry || number < 0) {
            throw new Exception();
        }
        for (int i = number; i < indexOfLastEntry - 1; i++) {
            entryes[i] = entryes[i+1];
        }
        indexOfLastEntry--;
    }

    /**
     * Edit entry in notepad
     *
     * @param number index of entry to edit
     * @param entry new entry to replace old entry
     * @throws Exception if notepad hasn't entry with entered index
     */
    public  void editEntry (int number, NotepadEntry entry) throws Exception{
        if (indexOfLastEntry == -1 || number < 0 || number > indexOfLastEntry) throw new Exception();
        entryes[number].setHeader(entry.getHeader());
        entryes[number].setContent(entry.getContent());
    }
}
