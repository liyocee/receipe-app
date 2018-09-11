package com.liyosi.recipe.controllers;

import com.liyosi.recipe.domain.Recipe;
import com.liyosi.recipe.repositories.RecipeRepository;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by liyosi on Aug, 2018
 */
public class IndexControllerTest {

  IndexController indexController;

  @Mock
  RecipeRepository recipeRepository;

  @Mock
  Model model;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    indexController = new IndexController(recipeRepository);
  }

  @Test
  public void indexPage() throws Exception {
    String recipeDesc = "Italian";
    Recipe recipe = new Recipe();
    recipe.setId(1L);
    recipe.setDescription(recipeDesc);
    Set<Recipe> recipes = new HashSet<>();

    // given
    recipes.add(new Recipe());
    recipes.add(new Recipe());

    when(recipeRepository.findByDescription(recipeDesc)).thenReturn(Optional.of(recipe));
    when(recipeRepository.findAll()).thenReturn(recipes);

    ArgumentCaptor argumentCaptor = ArgumentCaptor.forClass(Set.class) ;

    // when
    String viewName = indexController.indexPage(model);

    // then

//    verify(recipeRepository, times(1)).findByDescription(recipeDesc);

//    verify(model, times(1)).addAttribute(eq("categories"), argumentCaptor.capture());

//    assertEquals(viewName, "index");

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
