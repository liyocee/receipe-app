package com.liyosi.recipe.repositories;

import com.liyosi.recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by liyosi on Aug, 2018
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
