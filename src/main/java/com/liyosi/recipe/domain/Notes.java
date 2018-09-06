package com.liyosi.recipe.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by liyosi on Aug, 2018
 */
@Data
@Entity
@EqualsAndHashCode(exclude = {"recipe"})
public class Notes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  private Recipe recipe;

  @Lob
  private String recipeNotes;
}
