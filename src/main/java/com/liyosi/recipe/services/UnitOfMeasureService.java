package com.liyosi.recipe.services;

import com.liyosi.recipe.commands.UnitOfMeasureCommand;
import com.liyosi.recipe.domain.UnitOfMeasure;

import java.util.Optional;
import java.util.Set;

/**
 * Created by liyosi on Sep, 2018
 */
public interface UnitOfMeasureService {

  public Optional<UnitOfMeasure> findById(Long id);

  public Set<UnitOfMeasure> getUoMs ();

  public UnitOfMeasureCommand saveUnitOfMeasureCommand(UnitOfMeasureCommand unitOfMeasureCommand);
}
