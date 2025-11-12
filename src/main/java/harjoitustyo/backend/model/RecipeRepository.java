package harjoitustyo.backend.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByTitleContainingIgnoreCase(String title);
    List<Recipe> findByCategory_Id(Long categoryId);
    List<Recipe> findByTitleContainingIgnoreCaseAndCategory_Id(String title, Long categoryId);

}
