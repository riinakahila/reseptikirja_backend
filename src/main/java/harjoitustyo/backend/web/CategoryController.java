package harjoitustyo.backend.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import harjoitustyo.backend.model.Category;
import harjoitustyo.backend.model.CategoryRepository;
import harjoitustyo.backend.model.RecipeRepository;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CategoryController {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;

    public CategoryController(RecipeRepository recipeRepository, CategoryRepository categoryRepository){
        this.recipeRepository=recipeRepository;
        this.categoryRepository=categoryRepository;
    }

     @GetMapping("/categorylist")
    public String showCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist";

    }
     @PreAuthorize("hasAuthority('ADMIN')")
     @GetMapping("/addCategory")
    public String ShowAddCategory(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("recipes", recipeRepository.findAll());
        return "addCategory";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }
    

}
