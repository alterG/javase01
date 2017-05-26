package sandbox.Serialization.Example2;

import java.io.*;

/**
 * Created by alterG on 25.05.2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Point point1 = new Point(1.0, 1.0);
        Point point2 = new Point(2.0, 2.0);
        Point point3 = new Point(3.0, 3.0);
        Line line1 = new Line(point1, point2, 1);
        Line line2 = new Line(point2, point3, 2);
        System.out.println(line1);
        System.out.println(line2);
        try (ObjectOutputStream stream1 = new ObjectOutputStream(new FileOutputStream(getPath("out.txt")))) {
            stream1.writeObject(line1);
            line1.setIndex(3);
            stream1.writeObject(line1);     // index didn't change cause object has been serialized
            stream1.reset();                // CARE! stream data don't erase
            stream1.writeObject(line1);     // Now stream1 has: 2 objects Line (index = 1) and 1 object Line (index = 3)
                                            // Note: Line has written after reset(), has new references for its fields (new point1, point2 in this way)
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Deserializable objects:");
        FileInputStream k;
        try (ObjectInputStream stream2 = new ObjectInputStream(k = new FileInputStream(getPath("out.txt")))) {
            while (k.available() > 0) {
                Line currentLine = (Line) stream2.readObject();
                currentLine.printInfo();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Note: It's wrong way
    // Files are created by program should be placed in subdirectory of current package (instead of resource directory)
    @Deprecated
    private static String getPath(String path) {
        Class<Main> cl = Main.class;
        String filePath = "." + new String(".resources." + cl.getPackage().getName() + ".").replace('.', '\\') + path;
        return filePath;
    }

    private static InputStream getResource(String path) {
        Class<Main> cl = Main.class;
        return cl.getResourceAsStream(path);
    }
}

//        Output:
//        Deserializable objects:
//        Line index = 1
//        Object reference = 4f3f5b24
//        From point 1 = Point{x=1.0, y=1.0} 7291c18f
//        To point 2 = Point{x=2.0, y=2.0} 34a245ab

//        Line index = 1
//        Object reference = 4f3f5b24
//        From point 1 = Point{x=1.0, y=1.0} 7291c18f
//        To point 2 = Point{x=2.0, y=2.0} 34a245ab

//        Line index = 3
//        Object reference = 7cc355be
//        From point 1 = Point{x=1.0, y=1.0} 6e8cf4c6
//        To point 2 = Point{x=2.0, y=2.0} 12edcd21