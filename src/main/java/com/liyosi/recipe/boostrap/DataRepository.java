package com.liyosi.recipe.boostrap;

import com.liyosi.recipe.repositories.CategoryRepository;
import com.liyosi.recipe.repositories.RecipeRepository;
import com.liyosi.recipe.repositories.UnitOfMeasureRepository;

/**
 * Created by liyosi on Aug, 2018
 */
public class DataRepository {
  private final CategoryRepository categoryRepository;
  private final RecipeRepository recipeRepository;
  private final UnitOfMeasureRepository unitOfMeasureRepository;

  public DataRepository(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
    this.categoryRepository = categoryRepository;
    this.recipeRepository = recipeRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }
}
