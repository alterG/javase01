package module4.t04;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alterG on 29.05.2017.
 */
public class Movie implements Serializable{
    private String title;
    private Set<Actor> actorSet;

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        return actorSet != null ? actorSet.equals(movie.actorSet) : movie.actorSet == null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Кино \"%s\"",title));
        if (!actorSet.isEmpty()) {
            result.append(" (в ролях ");
            for (Actor actor : actorSet) {
                result.append(actor+", ");
            }
            result.delete(result.length()-2, result.length());
            result.append(")");
        }
        return result.toString();
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (actorSet != null ? actorSet.hashCode() : 0);
        return result;
    }

    public Movie(String title, Set actorSet) {
        this.title = title;
        this.actorSet = actorSet;
    }

}
