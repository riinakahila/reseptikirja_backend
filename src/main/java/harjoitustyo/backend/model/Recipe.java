package harjoitustyo.backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private double prepTime;

    private String bakeTime;

    private String ingredients;

    private String steps;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    /* @ManyToMany
    @JoinTable (name = "recipe_ingredient",
    joinColumns = @JoinColumn(name = "recipe_id"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients; */


    public Recipe() {

    }

    public Recipe(String title, double prepTime, String bakeTime, String ingredients, String steps, Category category) {
        this.title = title;
        this.prepTime = prepTime;
        this.bakeTime = bakeTime;
        this.steps = steps;
        this.ingredients = ingredients;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(double prepTime) {
        this.prepTime = prepTime;
    }

    public String getBakeTime() {
        return bakeTime;
    }

    public void setBakeTime(String bakeTime) {
        this.bakeTime = bakeTime;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

     public String getIngredients() {
         return ingredients;
     }

     public void setIngredients(String ingredients) {
         this.ingredients = ingredients;
     }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

     @Override
     public String toString() {
        return "Recipe [id= " + id + ", title= " + title + ", Valmistusaika= " + prepTime + ", Valmistuaika= " + bakeTime + "Ainesosat= " + ingredients + ", Valmistus=" + steps +" , Category=" + (category != null ? category.getName() : "ei kategoriaa") + "]";
     }

    


}