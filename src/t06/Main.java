package t06;

/**
 * Created by alterG on 23.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        NotepadEntry entry1 = new NotepadEntry("Crazy world", "Nuclear bomb has dropped on Notrh Korea");
        NotepadEntry entry2 = new NotepadEntry("Edge of bio-science", "Bio engineers decoded mouse genom last Friday");
        Notepad notepad = new Notepad();
        notepad.addEntry(entry1);
        notepad.addEntry(entry2);
        notepad.showEntryes();
    }
}
