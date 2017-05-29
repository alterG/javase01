package module4.t04;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alterG on 29.05.2017.
 */
public class StorageManager implements Serializable{
    private Set<Movie> movieCollection;
    private String name;

    public StorageManager(Set<Movie> movieCollection, String name) {
        this.movieCollection = movieCollection;
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Коллекция: "+name+"\n");
        for (Movie movie : movieCollection) {
            result.append(movie+"\n");
        }
        return result.toString();
    }

    public static void save(StorageManager collection, File file) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
        stream.writeObject(collection);
        stream.close();
    }

    public static StorageManager load(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file));
        StorageManager result = (StorageManager) stream.readObject();
        return result;
    }

    public void addMovie(Movie movie) {
        movieCollection.add(movie);
    }

    public void removeMovie(Movie movie) {
        if (movieCollection.contains(movie)) {
            movieCollection.remove(movie);
        }
    }

    // ToDo: change to set
    public static Set<Movie> getStandartKit() {
        Actor actor1 = new Actor("Bruce Lee");
        Actor actor2 = new Actor("Brad Pitt");
        Actor actor3 = new Actor("Keanu Reeves");
        Actor actor4 = new Actor("Angelina Jolie");
        Actor actor5 = new Actor("Anthony Hopkins");
        Movie movie1 = new Movie("The Silence of the Lambs", new HashSet<Actor>(Arrays.asList(actor5)));
        Movie movie2 = new Movie("Mr. and Mrs. Smith", new HashSet<Actor>(Arrays.asList(actor2, actor4)));
        Movie movie3 = new Movie("Matrix", new HashSet<Actor>(Arrays.asList(actor3)));
        Movie movie4 = new Movie("Fist of Fury", new HashSet<Actor>(Arrays.asList(actor1)));
        HashSet<Movie> standartKit = new HashSet<>(Arrays.asList(movie1, movie2, movie3, movie4));
        return standartKit;
    }
}
