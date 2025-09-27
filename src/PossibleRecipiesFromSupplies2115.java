import java.util.*;

public class PossibleRecipiesFromSupplies2115 {
    private static class Solution {
        private static final List<String> EMPTY = Collections.emptyList();

        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            HashMap<String, Integer> dependencyCount = new HashMap<>();
            HashMap<String, List<String>> dependentRecipes = new HashMap<>();
            HashSet<String> availableSupplies = new HashSet<>(Arrays.asList(supplies));
            for (int i = 0; i < recipes.length; i++) {
                int dependentCount = 0;
                for (String ing : ingredients.get(i)) {
                    if (!availableSupplies.contains(ing)) {
                        dependentCount++;
                        dependentRecipes.computeIfAbsent(ing, _ -> new ArrayList<>()).add(recipes[i]);
                    }
                }

                dependencyCount.put(recipes[i], dependentCount);
            }
            Queue<String> recipeQueue = new LinkedList<>();
            for (String recipe : dependencyCount.keySet()) {
                if (dependencyCount.get(recipe) == 0) {
                    recipeQueue.add(recipe);
                }
            }
            List<String> result = new ArrayList<>();

            while (!recipeQueue.isEmpty()) {
                String recipe = recipeQueue.poll();
                if (dependencyCount.get(recipe) == 0) {
                    result.add(recipe);
                    List<String> dependents = dependentRecipes.getOrDefault(recipe, EMPTY);
                    for (String dependentRecipe : dependents) {
                        int newCount = dependencyCount.get(dependentRecipe) - 1;
                        if (newCount == 0) {
                            recipeQueue.add(dependentRecipe);
                        }
                        dependencyCount.put(dependentRecipe, newCount);
                    }
                }
            }
            return result;
        }
    }
}
