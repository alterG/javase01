package t06;

/**
 * Created by alterG on 23.04.2017.
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

    public String getEntry() {
        return header+"\n-----\n"+content+"\n";
    }
}
