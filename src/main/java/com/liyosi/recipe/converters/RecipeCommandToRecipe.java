package com.liyosi.recipe.converters;

import com.liyosi.recipe.commands.RecipeCommand;
import com.liyosi.recipe.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by liyosi on Sep, 2018
 */
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

  private final NotesCommandToNotes notesCommandToNotes;
  private final IngredientCommandToIngredient ingredientCommandToIngredient;
  private final CategoryCommandToCategory categoryCommandToCategory;

  public RecipeCommandToRecipe(NotesCommandToNotes notesCommandToNotes, IngredientCommandToIngredient ingredientCommandToIngredient, CategoryCommandToCategory categoryCommandToCategory) {
    this.notesCommandToNotes = notesCommandToNotes;
    this.ingredientCommandToIngredient = ingredientCommandToIngredient;
    this.categoryCommandToCategory = categoryCommandToCategory;
  }

  @Synchronized
  @Nullable
  @Override
  public Recipe convert(RecipeCommand source) {
    if (source == null)
      return null;

    final Recipe recipe = new Recipe();
    recipe.setId(source.getId());
    recipe.setDescription(source.getDescription());
    recipe.setPrepTime(source.getPrepTime());
    recipe.setCookTime(source.getCookTime());
    recipe.setServings(source.getServings());
    recipe.setUrl(source.getUrl());
    recipe.setDescription(source.getDescription());
    recipe.setDifficulty(source.getDifficulty());
    recipe.setNotes(notesCommandToNotes.convert(source.getNotes()));

    if (source.getCategories() != null && source.getCategories().size() > 0) {
      source.getCategories().forEach(category -> recipe.getCategories().add(categoryCommandToCategory.convert(category)));
    }

    if (source.getIngredients() != null && source.getIngredients().size() > 0) {
      source.getIngredients().forEach(ingredient -> recipe.getIngredients().add(ingredientCommandToIngredient.convert(ingredient)));
    }
    return recipe;
  }
}
