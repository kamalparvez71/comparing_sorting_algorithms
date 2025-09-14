import java.util.*;

public class StringSorter {

    public List<String> sortStrings(List<String> strings) {
        List<String> copy = new ArrayList<>(strings);
        copy.sort(Comparator.comparingInt(String::length)
                            .thenComparing(Comparator.reverseOrder()));
        return copy;
    }

}
