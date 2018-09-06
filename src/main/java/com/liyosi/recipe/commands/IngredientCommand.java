package com.liyosi.recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by liyosi on Sep, 2018
 */
@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
  private Long id;
  private String description;
  private BigDecimal amount;
  private UnitOfMeasureCommand uom;
}
