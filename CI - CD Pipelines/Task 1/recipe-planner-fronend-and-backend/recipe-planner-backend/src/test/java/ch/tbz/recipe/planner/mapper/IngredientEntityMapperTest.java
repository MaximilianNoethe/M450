package ch.tbz.recipe.planner.mapper;

import ch.tbz.recipe.planner.domain.Ingredient;
import ch.tbz.recipe.planner.domain.Unit;
import ch.tbz.recipe.planner.entities.IngredientEntity;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class IngredientEntityMapperTest {

    @Autowired
    private IngredientEntityMapper mapper;

    @Test
    void mapsEntityToDomainAndBack() {
        UUID id = UUID.randomUUID();
        IngredientEntity entity = new IngredientEntity(id, "Sugar", "Fine", Unit.GRAMM, 100);

        Ingredient domain = mapper.entityToDomain(entity);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(domain.getId()).isEqualTo(id);
        softly.assertThat(domain.getName()).isEqualTo("Sugar");
        softly.assertThat(domain.getComment()).isEqualTo("Fine");
        softly.assertThat(domain.getUnit()).isEqualTo(Unit.GRAMM);
        softly.assertThat(domain.getAmount()).isEqualTo(100);

        IngredientEntity mappedBack = mapper.domainToEntity(domain);
        softly.assertThat(mappedBack.getId()).isEqualTo(id);
        softly.assertThat(mappedBack.getName()).isEqualTo("Sugar");
        softly.assertThat(mappedBack.getComment()).isEqualTo("Fine");
        softly.assertThat(mappedBack.getUnit()).isEqualTo(Unit.GRAMM);
        softly.assertThat(mappedBack.getAmount()).isEqualTo(100);
        softly.assertAll();
    }

    @Test
    void mapsListsBothDirections() {
        IngredientEntity entityA = new IngredientEntity(UUID.randomUUID(), "Salt", "", Unit.GRAMM, 5);
        IngredientEntity entityB = new IngredientEntity(UUID.randomUUID(), "Oil", "", Unit.DECILITRE, 2);

        List<Ingredient> domains = mapper.entitiesToDomains(List.of(entityA, entityB));
        List<IngredientEntity> entities = mapper.domainsToEntities(domains);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(domains).hasSize(2);
        softly.assertThat(domains.get(0).getName()).isEqualTo("Salt");
        softly.assertThat(domains.get(1).getUnit()).isEqualTo(Unit.DECILITRE);
        softly.assertThat(entities).hasSize(2);
        softly.assertThat(entities.get(0).getAmount()).isEqualTo(5);
        softly.assertThat(entities.get(1).getName()).isEqualTo("Oil");
        softly.assertAll();
    }
}
