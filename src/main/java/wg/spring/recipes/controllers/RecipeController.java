package wg.spring.recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wg.spring.recipes.commands.RecipeCommand;
import wg.spring.recipes.services.RecipeService;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }

    @RequestMapping("/recipe/new")
    public String newRecipe(Model model){

        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }

    @RequestMapping("/recipe/{id}/update")
    public String updateRecipy(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/recipeform";
    }

    @PostMapping("/recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){

        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }
}
