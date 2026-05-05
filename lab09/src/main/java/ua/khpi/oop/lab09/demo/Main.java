package ua.khpi.oop.lab09.demo;

import ua.khpi.oop.lab09.model.Achievement;
import ua.khpi.oop.lab09.model.GameItem;
import ua.khpi.oop.lab09.model.Player;
import ua.khpi.oop.lab09.model.ProfileEntry;

import java.util.List;

public class Main {

    public static <T extends Comparable<T>> T findBest(List<T> items) {
        if (items == null || items.isEmpty()) {
            return null;
        }

        T best = items.get(0);

        for (T item : items) {
            if (item.compareTo(best) > 0) {
                best = item;
            }
        }

        return best;
    }

    public static void main(String[] args) {
        Player player = new Player("Shadow", 25);
        GameItem sword = new GameItem("Dragon Sword", 80);
        Achievement achievement = new Achievement("First Victory", true);

        ProfileEntry<Player, String> playerEntry = new ProfileEntry<>(player, "Active profile");
        ProfileEntry<GameItem, Integer> itemEntry = new ProfileEntry<>(sword, 80);
        ProfileEntry<Achievement, Boolean> achievementEntry = new ProfileEntry<>(achievement, true);

        System.out.println("Player entry: " + playerEntry);
        System.out.println("Item entry: " + itemEntry);
        System.out.println("Achievement entry: " + achievementEntry);

        List<Integer> scores = List.of(1200, 2500, 1800, 3100);
        Integer bestScore = findBest(scores);

        List<String> ranks = List.of("Bronze", "Silver", "Gold", "Platinum");
        String bestRank = findBest(ranks);

        System.out.println("Best score: " + bestScore);
        System.out.println("Best rank: " + bestRank);
    }
}