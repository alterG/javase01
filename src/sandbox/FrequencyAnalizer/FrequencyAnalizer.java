package sandbox.FrequencyAnalizer;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alterG on 26.05.2017.
 */
public class FrequencyAnalizer {

    public static void main(String[] args) throws IOException {
        String fileName = "war_and_peace.txt";
        Map map = wordStats(fileName);
        Entry[] elems = getMaxElems(10, map);
        printEntries(elems);
    }

    private static void printEntries(Entry[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getValue()+" = "+array[i].getFrequency());
        }
    }
    private static Entry[] getMaxElems(int count, Map<String, Integer> map) {
        Entry[] allEntries= new Entry[map.size()];
        Entry[] result = new Entry[count];
        int i = 0;
        for (String x : map.keySet()) {
            allEntries[i++] = new Entry(x, map.get(x));
        }
        Arrays.sort(allEntries);
        for (int j = 0; j < count; j++) {
            result[j] = allEntries[j];
        }
        return result;
    }

    public static TreeMap<String, Integer> wordStats(String fileName){
        Class<FrequencyAnalizer> cl = FrequencyAnalizer.class;
        Scanner scanner = new Scanner(cl.getResourceAsStream(fileName));
        scanner.useDelimiter("[^a-zA-Z]+");
        TreeMap<String, Integer> map = new TreeMap<>();
        Pattern pattern = Pattern.compile("[a-zA-Z]{3,}");
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()) {
            map.merge(word, 1, Integer::sum);
            }
        }
        return map;
    }

    public static TreeMap<Character, Integer> charStats(String source) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < source.length(); i++) {
            char c = Character.toLowerCase(source.charAt(i));
            map.merge(c, 1, Integer::sum);
//            if (Character.isLetter(c)) {
//                if (!map.containsKey(c)) {
//                    map.put(c, 1);
//                } else {
//                    Integer current = map.get(c);
//                    current++;
//                    map.put(c, current);
//                }
            }
        return map;
    }

//    private static SortedMap<Character, Integer> initializeMap() {
//        SortedMap<Character, Integer> map = new HashMap<>();
//        for (char i = 'a'; i < 'z'; i++) {
//            map.put(i, 0);
//        }
//        return map;
//    }
}

class Entry implements Comparable{
    private String value;
    private int frequency;

    public String getValue() {
        return value;
    }

    public int getFrequency() {
        return frequency;
    }

    public Entry(String value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Object o) {
        return -(frequency - ((Entry)o).frequency);
    }
}
