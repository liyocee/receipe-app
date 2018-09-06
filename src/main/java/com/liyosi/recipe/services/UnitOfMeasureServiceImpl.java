package com.liyosi.recipe.services;

import com.liyosi.recipe.commands.UnitOfMeasureCommand;
import com.liyosi.recipe.converters.UnitOfMeasureCommandToUnitOfMeasure;
import com.liyosi.recipe.domain.UnitOfMeasure;
import com.liyosi.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by liyosi on Sep, 2018
 */
@Service
@Slf4j
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

  private final UnitOfMeasureRepository unitOfMeasureRepository;

  private final UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureConverter;

  public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureConverter) {
    this.unitOfMeasureRepository = unitOfMeasureRepository;
    this.unitOfMeasureConverter = unitOfMeasureConverter;
  }

  @Override
  public Optional<UnitOfMeasure> findById(Long id) {
    return unitOfMeasureRepository.findById(id);
  }

  @Override
  public Set<UnitOfMeasure> getUoMs() {
    Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();

    unitOfMeasureRepository.findAll().iterator().forEachRemaining(unitOfMeasures::add);
    return unitOfMeasures;
  }

  @Override
  public UnitOfMeasureCommand saveUnitOfMeasureCommand(@NotNull UnitOfMeasureCommand unitOfMeasureCommand) {
    @NotNull
    UnitOfMeasure unitOfMeasure = unitOfMeasureConverter.convert(unitOfMeasureCommand);

    UnitOfMeasure unitOfMeasureSaved = unitOfMeasureRepository.save(unitOfMeasure);

    unitOfMeasureCommand.setId(unitOfMeasureSaved.getId());

    return unitOfMeasureCommand;
  }
}
