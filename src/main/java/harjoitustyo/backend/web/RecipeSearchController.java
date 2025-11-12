package harjoitustyo.backend.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import harjoitustyo.backend.model.CategoryRepository;
import harjoitustyo.backend.model.Recipe;
import harjoitustyo.backend.model.RecipeRepository;

@Controller
public class RecipeSearchController {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;

    public RecipeSearchController(RecipeRepository recipeRepository, CategoryRepository categoryRepository){
        this.recipeRepository=recipeRepository;
        this.categoryRepository=categoryRepository;
    }
    @GetMapping("/recipeSearch")
    public String recipeSearch(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("foundRecipes", List.of());
        return "recipeSearch";
    }
    @PostMapping
    public String search(@ModelAttribute("recipe") Recipe recipe, Model model) {
        String title = recipe.getTitle() == null ? "": recipe.getTitle();
        List<Recipe> foundRecipes = title.isBlank() ? List.of() : recipeRepository.findByTitleContainingIgnoreCase(title);
        model.addAttribute("foundRecipes", foundRecipes);
        model.addAttribute("recipe", recipe);
        return "recipeSearch";
    }

}
