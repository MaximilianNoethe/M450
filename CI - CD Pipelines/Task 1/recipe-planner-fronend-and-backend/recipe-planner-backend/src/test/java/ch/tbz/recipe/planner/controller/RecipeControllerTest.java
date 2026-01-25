package ch.tbz.recipe.planner.controller;

import ch.tbz.recipe.planner.domain.Ingredient;
import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.domain.Unit;
import ch.tbz.recipe.planner.mapper.RecipeEntityMapper;
import ch.tbz.recipe.planner.repository.RecipeRepository;
import ch.tbz.recipe.planner.service.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RecipeController.class)
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RecipeService service;

    @MockBean
    private RecipeEntityMapper mapper;

    @MockBean
    private RecipeRepository recipeRepository;

    @Test
    void getRecipes_returnsList() throws Exception {
        UUID recipeId = UUID.randomUUID();
        Recipe recipe = new Recipe(
                recipeId,
                "Pasta",
                "Simple pasta",
                "http://img/pasta.png",
                List.of(new Ingredient(UUID.randomUUID(), "Salt", "", Unit.GRAMM, 5))
        );

        when(service.getRecipes()).thenReturn(List.of(recipe));

        mockMvc.perform(get("/api/recipes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(recipeId.toString()))
                .andExpect(jsonPath("$[0].name").value("Pasta"))
                .andExpect(jsonPath("$[0].description").value("Simple pasta"))
                .andExpect(jsonPath("$[0].imageUrl").value("http://img/pasta.png"))
                .andExpect(jsonPath("$[0].ingredients[0].name").value("Salt"));

        verify(service).getRecipes();
    }

    @Test
    void getRecipe_returnsSingleRecipe() throws Exception {
        UUID recipeId = UUID.randomUUID();
        Recipe recipe = new Recipe(
                recipeId,
                "Soup",
                "Warm soup",
                "http://img/soup.png",
                List.of(new Ingredient(UUID.randomUUID(), "Water", "", Unit.LITRE, 1))
        );

        when(service.getRecipeById(recipeId)).thenReturn(recipe);

        mockMvc.perform(get("/api/recipes/recipe/{id}", recipeId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(recipeId.toString()))
                .andExpect(jsonPath("$.name").value("Soup"))
                .andExpect(jsonPath("$.description").value("Warm soup"))
                .andExpect(jsonPath("$.imageUrl").value("http://img/soup.png"))
                .andExpect(jsonPath("$.ingredients[0].unit").value("LITRE"));

        verify(service).getRecipeById(recipeId);
    }

    @Test
    void addRecipe_createsRecipe() throws Exception {
        UUID createdId = UUID.randomUUID();
        Recipe request = new Recipe(
                null,
                "Salad",
                "Fresh salad",
                "http://img/salad.png",
                List.of(new Ingredient(UUID.randomUUID(), "Tomato", "", Unit.PIECE, 2))
        );
        Recipe response = new Recipe(
                createdId,
                "Salad",
                "Fresh salad",
                "http://img/salad.png",
                request.getIngredients()
        );

        when(service.addRecipe(any(Recipe.class))).thenReturn(response);

        mockMvc.perform(post("/api/recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(createdId.toString()))
                .andExpect(jsonPath("$.name").value("Salad"))
                .andExpect(jsonPath("$.ingredients[0].name").value("Tomato"));

        verify(service).addRecipe(Mockito.any(Recipe.class));
    }
}
