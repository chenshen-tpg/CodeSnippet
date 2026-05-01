package SystemDesign.AppDesign.Tinder;

import java.util.HashSet;
import java.util.Set;

public class matchingLogic {
    // Static sets to mock persistent storage
    private static final Set<String> swipes = new HashSet<>();
    private static final Set<String> matches = new HashSet<>();

    static class User {
        String key;
        public User(String key) { this.key = key; }
        @Override
        public String toString() { return key; }
    }

    public static void main(String[] args) {
        User userA = new User("A");
        User userB = new User("B");
        User userC = new User("C");

        swipeRight(userA, userB); // A likes B
        swipeRight(userB, userA); // B likes A, should match
        swipeRight(userA, userC); // A likes C
        swipeRight(userC, userA); // C likes A, should match

        System.out.println("Matches: " + matches);
    }

    public static boolean swipeRight(User swiper, User swipee) {
        String swipeKey = swiper + ":" + swipee;
        swipes.add(swipeKey);
        String reverseKey = swipee + ":" + swiper;
        if (swipes.contains(reverseKey)) {
            String matchKey = swiper + ":" + swipee;
            matches.add(matchKey);
            System.out.println("Match! " + swiper + " <-> " + swipee);
            return true;
        }
        return false;
    }
}