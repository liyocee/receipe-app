package com.liyosi.recipe.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by liyosi on Aug, 2018
 */
@Data
@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;

  @ManyToMany(mappedBy = "categories")
  private Set<Recipe> recipes;

}
