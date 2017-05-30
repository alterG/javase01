package sandbox.Exceptions.HiddenException;

/**
 * Created by alterG on 30.05.2017.
 */
public class HiddenException extends Exception {
    private Exception hidden;

    public HiddenException(String message) {
        super(message);
    }

    public HiddenException(String message, Exception hidden) {
        super(message);
        this.hidden = hidden;
    }

    public Exception getHidden() {
        return hidden;
    }
}
