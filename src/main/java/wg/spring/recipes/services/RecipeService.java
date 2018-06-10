package wg.spring.recipes.services;

import wg.spring.recipes.commands.RecipeCommand;
import wg.spring.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand findCommandById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
