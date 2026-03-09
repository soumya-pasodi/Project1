 import java.util.*;

public class BadgeSystem {

    // Assign badges to students based on rank
    public static void assignBadges(List<Student> students) {
        if (students.isEmpty()) return;

        // Sort students by overall percentage descending
        students.sort((a, b) -> 
            Double.compare(b.calculateOverallPercentage(), a.calculateOverallPercentage())
        );

        System.out.println(ConsoleColors.CYAN + "\n--- 🏅 Student Badges ---" + ConsoleColors.RESET);

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            String badge = "";

            if (i == 0) badge = "🥇 Topper 🏆";
            else if (i == 1) badge = "🥈 Second";
            else if (i == 2) badge = "🥉 Third";
            else if (s.calculateOverallPercentage() >= 75) badge = "🎖️ Merit";
            else badge = "✅ Participant";

            // Color coding based on badge
            String color = ConsoleColors.RESET;
            switch (i) {
                case 0: color = ConsoleColors.GREEN; break;
                case 1: color = ConsoleColors.CYAN; break;
                case 2: color = ConsoleColors.YELLOW; break;
            }

            System.out.println(color + s.getName() + " | USN: " + s.getUsn() + " | %" +
                               s.calculateOverallPercentage() + " → " + badge + ConsoleColors.RESET);
        }
    }
}