import java.util.*;

public class ChatAnalyzer {
    public static void main(String[] args) {
        // Талдауға арналған хабарламалар тізімі
        List<String> messages = Arrays.asList(
            "Arman: Salem!",
            "Aya: Salem, kalaisyn?",
            "Arman: Zhaksy, ozin?",
            "Aya: Men de zhaksy. Salem barlygyna!"
        );

        Map<String, Integer> userStats = new HashMap<>();
        Map<String, Integer> wordStats = new HashMap<>();

        for (String msg : messages) {
            String[] parts = msg.split(": ");
            if (parts.length < 2) continue;

            String user = parts[0];
            String text = parts[1].toLowerCase().replaceAll("[^a-zа-я0-9]", " ");

            // Қолданушы хабарламаларын санау
            userStats.put(user, userStats.getOrDefault(user, 0) + 1);

            // Сөздердің жиілігін санау
            String[] words = text.split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordStats.put(word, wordStats.getOrDefault(word, 0) + 1);
                }
            }
        }

        // Нәтижені шығару
        System.out.println("--- Пайдаланушылар статистикасы ---");
        userStats.forEach((k, v) -> System.out.println(k + ": " + v + " хабарлама"));

        System.out.println("\n--- Сөздердің жиілігі ---");
        wordStats.forEach((k, v) -> System.out.println(k + ": " + v + " рет"));
    }
}
