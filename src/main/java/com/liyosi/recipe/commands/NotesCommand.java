package com.liyosi.recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by liyosi on Sep, 2018
 */
@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {

  private Long id;
  private RecipeCommand recipe;
  private String recipeNotes;
}
