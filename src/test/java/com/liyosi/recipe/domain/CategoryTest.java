package com.liyosi.recipe.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by liyosi on Aug, 2018
 */
public class CategoryTest {

  private Category category;

  @Before
  public void setup() {
    category = new Category();
  }

  @Test
  public void getId() throws Exception {
    Long idValue = 4L;
    category.setId(idValue);
    assertEquals(idValue, category.getId());
  }

  @Test
  public void getDescription() throws Exception {
    String desc = "hey there";
    category.setDescription(desc);
    assertEquals(desc, category.getDescription());
  }

  @Test
  public void getRecipes() throws Exception {
    Set<Recipe> recipes = new HashSet<>();
    Recipe recipe = new Recipe();
    Long recipeId = 1L;
    recipe.setId(recipeId);

    recipes.add(recipe);

    category.setRecipes(recipes);

    category.getRecipes().forEach(recipe1 -> assertEquals(recipeId, recipe1.getId()));
  }

}
