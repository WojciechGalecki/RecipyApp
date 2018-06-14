package wg.spring.recipes.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wg.spring.recipes.commands.IngredientCommand;
import wg.spring.recipes.converters.IngredientToIngredientCommand;
import wg.spring.recipes.domain.Recipe;
import wg.spring.recipes.repositories.RecipeRepository;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final RecipeRepository recipeRepository;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    public IngredientServiceImpl(RecipeRepository recipeRepository, IngredientToIngredientCommand ingredientToIngredientCommand) {
        this.recipeRepository = recipeRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()) {
            // TODO: impl error handling
            log.error("Recipe id not found. Id: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if (!ingredientCommandOptional.isPresent()) {
            //TODO impl error handling
            log.error("Ingredient id not found. Id: " + ingredientId);
        }

        return ingredientCommandOptional.get();
    }
}
