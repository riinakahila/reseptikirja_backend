package harjoitustyo.backend.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import harjoitustyo.backend.model.CategoryRepository;
import harjoitustyo.backend.model.Recipe;
import harjoitustyo.backend.model.RecipeRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class RecipeController {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;

    public RecipeController(RecipeRepository recipeRepository, CategoryRepository categoryRepository){
        this.recipeRepository=recipeRepository;
        this.categoryRepository=categoryRepository;
    }

    @GetMapping("/main")
    public String showMainPage() {
        return "main";
    }
    @GetMapping ("/recipelist")
    public String showRecipes(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());
        model.addAttribute("recipe", new Recipe());
        return "recipelist";
    }
    
     @PreAuthorize("hasAuthority('ADMIN')")
     @GetMapping("/addRecipe")
    public String showAddRecipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addRecipe";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    public String saveRecipe(@ModelAttribute Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/recipelist";
    }

    @GetMapping("/recipe/{id}")
    public String showRecipe(@PathVariable Long id, Model model) { 
    Recipe recipe = recipeRepository.findById(id).orElse(null);
    model.addAttribute("recipe", recipe);
    return "openRecipe";

    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id);
        return "redirect:/recipelist";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/edit/{id}")
    public String editRecipe(@PathVariable Long id, Model model) {
        model.addAttribute("editRecipe", recipeRepository.findById(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editRecipe";
    }
   @PreAuthorize("hasAuthority('ADMIN')")
   @PostMapping("/saveEdited")
    public String saveEdited(@ModelAttribute Recipe recipe) {
    recipeRepository.save(recipe);
    return "redirect:/main";

}
}

