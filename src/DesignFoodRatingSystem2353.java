import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class DesignFoodRatingSystem2353 {
    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(
                new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7}
        );
        System.out.println(foodRatings.highestRated("korean"));   // bulgogi (rating 9 vs 7, so kimchi)
        System.out.println(foodRatings.highestRated("japanese")); // ramen (rating 14)
        foodRatings.changeRating("sushi", 16);
        System.out.println(foodRatings.highestRated("japanese")); // sushi (rating 16)
        foodRatings.changeRating("ramen", 16);
        System.out.println(foodRatings.highestRated("japanese")); // ramen (rating 16, ramen < sushi lexicographically)
    }

    private static class FoodRatings {
        HashMap<String, SegmentTree> cuisineSegmentTreeMap = new HashMap<>();
        HashMap<String, Integer> foodSegmentIndexMap = new HashMap<>();
        HashMap<String, String> foodCuisineMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            int n = foods.length;
            Integer[] indexes = new Integer[n];
            for (int i = 0; i < n; i++) {
                indexes[i] = i;
            }

            Arrays.sort(indexes, Comparator.comparing(i -> cuisines[i]));
            int start = 0;
            for (int i = 0; i < n; i++) {
                if (!cuisines[indexes[i]].equals(cuisines[indexes[start]])) {
                    cuisineSegmentTreeMap.put(cuisines[indexes[start]], new SegmentTree(foods, cuisines, ratings, indexes, start, i - 1));
                    start = i;
                }

                foodSegmentIndexMap.put(foods[indexes[i]], i - start);
                foodCuisineMap.put(foods[indexes[i]], cuisines[indexes[i]]);
            }

            cuisineSegmentTreeMap.put(cuisines[indexes[start]], new SegmentTree(foods, cuisines, ratings, indexes, start, n - 1));
        }

        public void changeRating(String food, int newRating) {
            int segmentIndex = foodSegmentIndexMap.get(food);
            cuisineSegmentTreeMap.get(foodCuisineMap.get(food)).update(segmentIndex, newRating);
        }

        public String highestRated(String cuisine) {
            return cuisineSegmentTreeMap.get(cuisine).query();
        }

        private static class SegmentTree {
            Food[] tree;
            int n;

            public SegmentTree(String[] foods, String[] cuisines, int[] ratings, Integer[] indexes, int start, int end) {
                n = end - start + 1;
                tree = new Food[2 * n];
                for (int i = n; i < 2 * n; i++) {
                    tree[i] = new Food(foods[indexes[i - n + start]], cuisines[indexes[i - n + start]], ratings[indexes[i - n + start]]);
                }

                for (int i = n - 1; i >= 0; i--) {
                    tree[i] = bestFood(tree[i * 2], tree[i * 2 + 1]);
                }
            }

            private Food bestFood(Food food1, Food food2) {
                if (food1 == null) return food2;
                return food1.compareTo(food2) < 0 ? food1 : food2;
            }

            public String query(int left, int right) {
                Food res = null;
                left += n;
                right += n;

                while (left <= right) {  // Changed from < to <=
                    if ((left & 1) == 1) {
                        res = bestFood(res, tree[left]);
                        left++;
                    }
                    if ((right & 1) == 0) {
                        res = bestFood(res, tree[right]);
                        right--;
                    }
                    left >>= 1;
                    right >>= 1;
                }

                return res != null ? res.name : null;  // Handle null case
            }

            public String query() {
                return query(0, n - 1);
            }

            private void update(int index, int newRating) {
                index += n;
                tree[index].rating = newRating;

                while (index > 1) {
                    index >>= 1;
                    tree[index] = bestFood(tree[index * 2], tree[index * 2 + 1]);
                }
            }
        }

        static class Food implements Comparable<Food> {
            String name, cuisine;
            int rating;

            Food(String name, String cuisine, int rating) {
                this.name = name;
                this.cuisine = cuisine;
                this.rating = rating;
            }

            @Override
            public int compareTo(Food o) {
                if (this.rating == o.rating) {
                    return this.name.compareTo(o.name);
                }
                return Integer.compare(o.rating, this.rating);
            }
        }
    }
}
