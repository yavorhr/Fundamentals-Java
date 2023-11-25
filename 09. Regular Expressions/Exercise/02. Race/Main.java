import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> racersList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> racersMap = new HashMap<>();

        String regexForAlphabets = "[A-Za-z]+";
        String regexForDigits = "\\d";

        String input = scanner.nextLine();
        while (!"end of race".equals(input)) {

            Pattern alphabetsPattern = Pattern.compile(regexForAlphabets);
            Pattern digitsPattern = Pattern.compile(regexForDigits);

            Matcher matcher = alphabetsPattern.matcher(input);

            StringBuilder racerSb = getName(matcher);
            String currentRacer = racerSb.toString();

            if (racersList.contains(currentRacer)) {
                racersMap.putIfAbsent(currentRacer, 0);

                Matcher matchDigits = digitsPattern.matcher(input);

                int km = racersMap.get(currentRacer);
                while (matchDigits.find()) {
                    km += Integer.parseInt(matchDigits.group());
                }

                racersMap.put(currentRacer, km);
            }
            input = scanner.nextLine();
        }
        printResult(racersMap);
    }

    private static void printResult(Map<String, Integer> racersMap) {
        List<String> positions = new ArrayList<>();
        positions.add("1st place: ");
        positions.add("2nd place: ");
        positions.add("3rd place: ");

        racersMap
                .entrySet()
                .stream()
                .sorted((l, r) -> r.getValue().compareTo(l.getValue()))
                .limit(3)
                .forEach( e -> System.out.println(positions.remove(0) + e.getKey()));
    }

    private static StringBuilder getName(Matcher matcher) {
        StringBuilder currentRacer = new StringBuilder();
        while (matcher.find()) {
            currentRacer.append(matcher.group());
        }
        return currentRacer;
    }
}
