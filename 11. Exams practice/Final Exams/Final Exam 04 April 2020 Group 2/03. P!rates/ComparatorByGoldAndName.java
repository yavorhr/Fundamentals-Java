import java.util.Comparator;
import java.util.Map;

public class ComparatorByGoldAndName implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> first, Map.Entry<String, Integer> second) {
        int result = Integer.compare(second.getValue(), first.getValue());
        if (result == 0) {
            result = first.getKey().compareTo(second.getKey());
        }
        return result;
    }
}
