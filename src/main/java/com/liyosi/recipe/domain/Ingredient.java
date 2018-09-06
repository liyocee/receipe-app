package com.liyosi.recipe.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by liyosi on Aug, 2018
 */
@Data
@Entity
@EqualsAndHashCode(exclude = {"uom", "recipe"})
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;
  private BigDecimal amount;

  @OneToOne(fetch = FetchType.EAGER)
  private UnitOfMeasure uom;

  @ManyToOne
  private Recipe recipe;

  public Ingredient() {
  }

  public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
    this.description = description;
    this.amount = amount;
    this.uom = uom;
  }
}

