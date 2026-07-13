package main.Coding.Algorithms.Medium.DesignAFoodRating_2353;

import main.Coding.Lib.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class SampleAns {
    private Map<String, Integer> foodRatingMap = new HashMap<>();
    private Map<String, String> foodCuisineMap = new HashMap<>();
    private Map<String, TreeSet<Pair<Integer, String>>> cuisineFoodMap = new HashMap<>();


    public static void main(String[] args) {

    }

    public void changeRating(String food, int newRating) {
        String cuisineName = foodCuisineMap.get(food);
        TreeSet<Pair<Integer, String>> cuisineSet = cuisineFoodMap.get(cuisineName);
        Pair<Integer, String> oldElement = new Pair<>(-foodRatingMap.get(food), food);
        cuisineSet.remove(oldElement);
        foodRatingMap.put(food, newRating);
        cuisineSet.add(new Pair<>(-newRating, food));
    }

    public String highestRated(String cuisine) {
        Pair<Integer, String> highestRated = cuisineFoodMap.get(cuisine).first();
        return highestRated.getValue();
    }
}
