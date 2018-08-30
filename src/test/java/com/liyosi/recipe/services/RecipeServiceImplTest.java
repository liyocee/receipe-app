package com.liyosi.recipe.services;

import com.liyosi.recipe.domain.Recipe;
import com.liyosi.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by liyosi on Aug, 2018
 */
public class RecipeServiceImplTest {

  RecipeServiceImpl recipeService;

  @Mock
  RecipeRepository recipeRepository;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    recipeService = new RecipeServiceImpl(recipeRepository);
  }

  @Test
  public void getRecipes() throws Exception {
    Recipe recipe = new Recipe();

    HashSet<Recipe> recipes = new HashSet<>();
    recipes.add(recipe);

    when(recipeRepository.findAll()).thenReturn(recipes);

    assertEquals(recipeService.getRecipes().size(), 1);

    verify(recipeRepository, times(1)).findAll();
  }

}
