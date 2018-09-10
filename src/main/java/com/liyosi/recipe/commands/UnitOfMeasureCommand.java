package com.liyosi.recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by liyosi on Sep, 2018
 */
@Getter
@Setter
@NoArgsConstructor
public class UnitOfMeasureCommand {
  private Long id;

  @NotBlank
  @Size(min = 5, max = 10)
  private String name;
}
