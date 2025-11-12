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
        model.addAttribute("categories", categoryRepository.findAll());
        return "recipeSearch";
    }
    @PostMapping("/recipeSearch")
    public String search(@ModelAttribute("recipe") Recipe recipe, @RequestParam(required=false) Long categoryId, Model model) {
        String title = recipe.getTitle() == null ? "": recipe.getTitle();
        List<Recipe> foundRecipes; 
        if (title != null && categoryId != null) {
            foundRecipes = recipeRepository.findByTitleContainingIgnoreCaseAndCategory_Id(title,categoryId);
        } else if (title != null) {
            foundRecipes = recipeRepository.findByTitleContainingIgnoreCase(title);
        } else if (categoryId != null) {
            foundRecipes = recipeRepository.findByCategory_Id(categoryId);
        } else {
            foundRecipes = List.of();
        }
        model.addAttribute("foundRecipes", foundRecipes);
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("selectedCategoryId", categoryId);
        return "recipeSearch";
    }

}
