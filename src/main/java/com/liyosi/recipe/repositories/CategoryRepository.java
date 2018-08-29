package com.liyosi.recipe.repositories;

import com.liyosi.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by liyosi on Aug, 2018
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

  Optional<Category> findByDescription(String description);

  Optional<Category> findByIdAndDescription(Long id, String description);

  Optional<Category> findByIdOrDescription(Long id, String description);
}
