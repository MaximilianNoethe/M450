package ch.tbz.recipe.planner.mapper;

import ch.tbz.recipe.planner.domain.Ingredient;
import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.domain.Unit;
import ch.tbz.recipe.planner.entities.IngredientEntity;
import ch.tbz.recipe.planner.entities.RecipeEntity;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class RecipeEntityMapperTest {

    @Autowired
    private RecipeEntityMapper mapper;

    @Test
    void mapsEntityToDomainAndBack() {
        IngredientEntity ingredientEntity = new IngredientEntity(
                UUID.randomUUID(),
                "Cheese",
                "",
                Unit.GRAMM,
                50
        );
        UUID recipeId = UUID.randomUUID();
        RecipeEntity entity = new RecipeEntity(
                recipeId,
                "Pizza",
                "Cheesy",
                "http://img/pizza.png",
                List.of(ingredientEntity)
        );

        Recipe domain = mapper.entityToDomain(entity);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(domain.getId()).isEqualTo(recipeId);
        softly.assertThat(domain.getName()).isEqualTo("Pizza");
        softly.assertThat(domain.getDescription()).isEqualTo("Cheesy");
        softly.assertThat(domain.getImageUrl()).isEqualTo("http://img/pizza.png");
        softly.assertThat(domain.getIngredients()).hasSize(1);
        softly.assertThat(domain.getIngredients().get(0).getName()).isEqualTo("Cheese");
        softly.assertThat(domain.getIngredients().get(0).getUnit()).isEqualTo(Unit.GRAMM);

        RecipeEntity mappedBack = mapper.domainToEntity(domain);
        softly.assertThat(mappedBack.getId()).isEqualTo(recipeId);
        softly.assertThat(mappedBack.getName()).isEqualTo("Pizza");
        softly.assertThat(mappedBack.getDescription()).isEqualTo("Cheesy");
        softly.assertThat(mappedBack.getImageUrl()).isEqualTo("http://img/pizza.png");
        softly.assertThat(mappedBack.getIngredients()).hasSize(1);
        softly.assertThat(mappedBack.getIngredients().get(0).getAmount()).isEqualTo(50);
        softly.assertAll();
    }

    @Test
    void mapsDomainWithIngredients() {
        Ingredient ingredient = new Ingredient(UUID.randomUUID(), "Flour", "", Unit.KILOGRAMM, 1);
        UUID recipeId = UUID.randomUUID();
        Recipe recipe = new Recipe(
                recipeId,
                "Bread",
                "Basic bread",
                "http://img/bread.png",
                List.of(ingredient)
        );

        RecipeEntity entity = mapper.domainToEntity(recipe);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(entity.getId()).isEqualTo(recipeId);
        softly.assertThat(entity.getName()).isEqualTo("Bread");
        softly.assertThat(entity.getDescription()).isEqualTo("Basic bread");
        softly.assertThat(entity.getImageUrl()).isEqualTo("http://img/bread.png");
        softly.assertThat(entity.getIngredients()).hasSize(1);
        softly.assertThat(entity.getIngredients().get(0).getName()).isEqualTo("Flour");
        softly.assertThat(entity.getIngredients().get(0).getUnit()).isEqualTo(Unit.KILOGRAMM);
        softly.assertAll();
    }
}
