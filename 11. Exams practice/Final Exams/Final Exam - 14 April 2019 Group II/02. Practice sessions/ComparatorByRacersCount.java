import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ComparatorByRacersCount implements Comparator<Map.Entry<String, List<String>>> {

    @Override
    public int compare(Map.Entry<String, List<String>> first, Map.Entry<String, List<String>> second) {
        int result = Integer.compare(second.getValue().size(), first.getValue().size());

        if (result == 0) {
            result = first.getKey().compareTo(second.getKey());
        }
        return result;
    }
}
