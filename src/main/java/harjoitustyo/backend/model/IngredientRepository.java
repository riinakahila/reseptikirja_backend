package harjoitustyo.backend.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Recipe> findByName(String name);
}
