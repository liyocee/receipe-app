package com.liyosi.recipe.controllers;

import com.liyosi.recipe.domain.Category;
import com.liyosi.recipe.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by liyosi on Aug, 2018
 */
public class IndexControllerTest {

  IndexController indexController;

  @Mock
  CategoryRepository categoryRepository;

  @Mock
  Model model;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    indexController = new IndexController(categoryRepository);
  }

  @Test
  public void indexPage() throws Exception {
    String categoryDesc = "Italian";
    Category category = new Category();
    category.setId(1L);
    category.setDescription(categoryDesc);
    Set<Category> categories = new HashSet<>();

    when(categoryRepository.findByDescription(categoryDesc)).thenReturn(Optional.of(category));

    when(categoryRepository.findAll()).thenReturn(categories);

    String viewName = indexController.indexPage(model);

    verify(categoryRepository, times(1)).findByDescription(categoryDesc);

    verify(model, times(1)).addAttribute("categories", categories);

    assertEquals(viewName, "index");
  }
}
