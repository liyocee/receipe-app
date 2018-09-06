package com.liyosi.recipe.services;

import com.liyosi.recipe.commands.CategoryCommand;
import com.liyosi.recipe.domain.Category;

import java.util.Set;

/**
 * Created by liyosi on Sep, 2018
 */
public interface CategoryService {

  public Set<Category> getCategories();

  CategoryCommand saveCategoryCommand(CategoryCommand categoryCommand);
}
