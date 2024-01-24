import java.util.Comparator;

public class ComparatorByMinutesAndName implements Comparator<Band> {
    @Override
    public int compare(Band first, Band second) {
        int result = Integer.compare(second.getPlayTime(), first.getPlayTime());

        if (result == 0) {
            result = first.getName().compareTo(second.getName());
        }

        return result;
    }
}
