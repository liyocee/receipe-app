package com.liyosi.recipe.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liyosi on Aug, 2018
 */
@Entity
@Data
public class Recipe {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;

  private Integer prepTime;

  private Integer cookTime;

  private Integer servings;

  private String source;

  private String url;

  private String directions;

  @Enumerated(value = EnumType.STRING)
  Difficulty difficulty;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
  private Set<Ingredient> ingredients = new HashSet<>();

  @Lob
  private Byte[] image;

  @OneToOne(cascade = CascadeType.ALL)
  private Notes notes;

  @ManyToMany
  @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id"))
  private Set<Category> categories = new HashSet<>();

  public void setNotes(Notes notes) {
    this.notes = notes;
    notes.setRecipe(this);
  }

  public void setIngredients(Set<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }
}
