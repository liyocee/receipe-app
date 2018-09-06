package com.liyosi.recipe.services;

import com.liyosi.recipe.commands.CategoryCommand;
import com.liyosi.recipe.converters.CategoryCommandToCategory;
import com.liyosi.recipe.domain.Category;
import com.liyosi.recipe.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liyosi on Sep, 2018
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryCommandToCategory categoryCommandToCategory;

  public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryCommandToCategory categoryCommandToCategory) {
    this.categoryRepository = categoryRepository;
    this.categoryCommandToCategory = categoryCommandToCategory;
  }

  @Override
  public Set<Category> getCategories() {
    Set<Category> categories = new HashSet<>();

    categoryRepository.findAll().iterator().forEachRemaining(categories::add);

    return categories;
  }

  @Override
  public CategoryCommand saveCategoryCommand(@NotNull CategoryCommand categoryCommand) {

    Category category = categoryCommandToCategory.convert(categoryCommand);

    if (category != null) {
      category = categoryRepository.save(category);
      categoryCommand.setId(category.getId());

      log.info("Saved recipe, id: " + categoryCommand.getId());
    }

    return categoryCommand;
  }
}
