import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        List<String> participants = new ArrayList<>();

        for (String name : input) {
            participants.add(name);
        }

        Map<String, Integer> finalists = new LinkedHashMap<>();
        String letterRegex = "[A-Za-z]+";
        String digixRegex = "\\d";

        Pattern letterPattern = Pattern.compile(letterRegex);
        Pattern digitPattern = Pattern.compile(digixRegex);

        String racers = scanner.nextLine();
        while (!"end of race".equals(racers)) {
            Matcher letterMatcher = letterPattern.matcher(racers);
            StringBuilder sb = new StringBuilder();

            while (letterMatcher.find()) {
                sb.append(letterMatcher.group());
            }

            if (participants.contains(sb.toString())) {
                finalists.putIfAbsent(sb.toString(), 0);
                int km = finalists.get(sb.toString());

                Matcher digitMatcher = digitPattern.matcher(racers);

                while (digitMatcher.find()) {
                    km += Integer.parseInt(digitMatcher.group());
                }

                finalists.put(sb.toString(), km);
            }
            racers = scanner.nextLine();
        }

        List<String> output = new ArrayList<>();
        output.add("1st place: ");
        output.add("2nd place: ");
        output.add("3rd place: ");

        finalists
                .entrySet()
                .stream()
                .sorted((f1, f2) -> f2.getValue().compareTo(f1.getValue()))
                .limit(3)
                .forEach(f -> {
                    System.out.println(output.remove(0) + f.getKey());
                });
    }
}

