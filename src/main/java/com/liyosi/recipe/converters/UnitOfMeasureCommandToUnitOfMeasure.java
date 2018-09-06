package com.liyosi.recipe.converters;

import com.liyosi.recipe.commands.UnitOfMeasureCommand;
import com.liyosi.recipe.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by liyosi on Sep, 2018
 */
@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

  @Synchronized
  @Nullable
  @Override
  public UnitOfMeasure convert(UnitOfMeasureCommand source) {
    if (source == null)
      return null;

    final UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
    unitOfMeasure.setId(source.getId());
    unitOfMeasure.setName(source.getName());

    return unitOfMeasure;
  }
}
