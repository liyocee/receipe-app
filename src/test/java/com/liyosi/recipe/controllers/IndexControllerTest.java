package com.liyosi.recipe.controllers;

import com.liyosi.recipe.domain.Category;
import com.liyosi.recipe.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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

    // given
    categories.add(new Category());
    categories.add(new Category());

    when(categoryRepository.findByDescription(categoryDesc)).thenReturn(Optional.of(category));
    when(categoryRepository.findAll()).thenReturn(categories);

    ArgumentCaptor argumentCaptor = ArgumentCaptor.forClass(Set.class) ;

    // when
    String viewName = indexController.indexPage(model);

    // then

    verify(categoryRepository, times(1)).findByDescription(categoryDesc);

    verify(model, times(1)).addAttribute(eq("categories"), argumentCaptor.capture());

    assertEquals(viewName, "index");

//    assertEquals(argumentCaptor.getAllValues().size(), 2);
  }

  @Test
  public void testMvcMock() throws Exception {
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

    mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("index"));
  }
}
