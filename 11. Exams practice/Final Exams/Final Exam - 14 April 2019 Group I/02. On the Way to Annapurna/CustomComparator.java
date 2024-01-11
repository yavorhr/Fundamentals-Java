import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CustomComparator implements Comparator<Map.Entry<String, List<String>>> {

    @Override
    public int compare(Map.Entry<String, List<String>> item1, Map.Entry<String, List<String>> item2) {
        int result = item2.getValue().size() - item1.getValue().size();
        if (result == 0) {
            result = item2.getKey().compareTo(item1.getKey());
        }
        return result;
    }
}


