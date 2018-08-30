package com.liyosi.recipe.services;

import com.liyosi.recipe.domain.Recipe;
import com.liyosi.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liyosi on Aug, 2018
 */
@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

  private final RecipeRepository recipeRepository;

  public RecipeServiceImpl(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @Override
  public Set<Recipe> getRecipes() {

    log.debug("I'm getting recipes, and am happ");

    Set<Recipe> recipes = new HashSet<>();

    recipeRepository.findAll().iterator().forEachRemaining(recipes::add);

    return recipes;
  }
}
