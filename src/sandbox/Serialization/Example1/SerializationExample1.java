package sandbox.Serialization.Example1;

import java.io.*;

/**
 * During serialization transient field gets value by default
 * static filed gets value of same class in its scope or default
 * Constructor isn't invoked, other filed get values from stream
 * Note: object must be serializable, same to all objects (Source object graph) are in it
 *
 * If serializable class extends non-serializable class, its parents must have available constructors without arguments
 * Created by alterG on 25.05.2017.
 */
public class SerializationExample1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Serialize Integer
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Object objectSave = new Integer(1);
        ObjectOutputStream streamForSerialize = new ObjectOutputStream(stream);
        streamForSerialize.writeObject(objectSave);

//        Let's see what data are in stream
        byte[] b = stream.toByteArray();
        for (byte x : b) {
            System.out.print((char) x);
        }
        System.out.println();

//        Deserialize data
        ByteArrayInputStream stream2 = new ByteArrayInputStream(b);
        ObjectInputStream streamForDeserialize = new ObjectInputStream(stream2);
        Object objectRead = streamForDeserialize.readObject();

//        See the results
        System.out.println("Read object is " + objectRead.toString());
        System.out.println("Saved and read object are equal? " + objectSave.equals(objectRead));
        System.out.println("Object references are the same? "+ (objectRead == objectSave));

    }
}
