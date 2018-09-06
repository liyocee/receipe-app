package com.liyosi.recipe.converters;

import com.liyosi.recipe.commands.IngredientCommand;
import com.liyosi.recipe.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by liyosi on Sep, 2018
 */
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

  private final UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureConverter;

  public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureConverter) {
    this.unitOfMeasureConverter = unitOfMeasureConverter;
  }

  @Synchronized
  @Nullable
  @Override
  public Ingredient convert(IngredientCommand source) {
    if (source == null)
      return null;

    final Ingredient ingredient = new Ingredient();
    ingredient.setId(source.getId());
    ingredient.setDescription(source.getDescription());
    ingredient.setAmount(source.getAmount());
    ingredient.setUom(unitOfMeasureConverter.convert(source.getUom()));
    return ingredient;
  }
}
