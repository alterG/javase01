package module1.t06;

/**
 * Entry, which can be written in notepad {@link Notepad}
 *
 * @author alterG
 * @version 1.0
 */
public class NotepadEntry {

    private String header;
    private String content;

    public String getHeader() {
        return header;
    }
    public void setHeader(String header) {
        this.header = header;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public NotepadEntry(String header, String content) {
        this.header = header;
        this.content = content;
    }

    /**
     *
     * @return formatted String representing an entry
     */
    public String getEntry() {
        return header+"\n-----\n"+content+"\n";
    }
}
