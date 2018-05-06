package wg.spring.recipes.controllers;

import org.springframework.stereotype.Controller;
import wg.spring.recipes.services.RecipeService;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

}
