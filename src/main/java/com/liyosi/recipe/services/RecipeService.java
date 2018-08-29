package com.liyosi.recipe.services;

import com.liyosi.recipe.domain.Recipe;

import java.util.Set;

/**
 * Created by liyosi on Aug, 2018
 */
public interface RecipeService {

  public Set<Recipe> getRecipes();
}
