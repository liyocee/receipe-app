package com.liyosi.recipe.controllers;

import com.liyosi.recipe.domain.Category;
import com.liyosi.recipe.domain.UnitOfMeasure;
import com.liyosi.recipe.repositories.CategoryRepository;
import com.liyosi.recipe.repositories.RecipeRepository;
import com.liyosi.recipe.repositories.UnitOfMeasureRepository;
import com.liyosi.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by liyosi on Aug, 2018
 */
@Controller
public class IndexController {

  private CategoryRepository categoryRepository;
  private UnitOfMeasureRepository unitOfMeasureRepository;
  private RecipeRepository recipeRepository;
  private final RecipeService recipeService;

  public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository, RecipeService recipeService) {
    this.categoryRepository = categoryRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
    this.recipeRepository = recipeRepository;
    this.recipeService = recipeService;
  }

  @RequestMapping({"", "/", "/index.html", "index"})
  public String indexPage(Model model) {

    System.out.println("Reload the app...., looks good");

    Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByName("Cup");
    Optional<Category> categoryOptional = categoryRepository.findByDescription("Italian");

    Optional<Category> categoryOptional2 = categoryRepository.findByIdOrDescription(2L,"fa");

    System.out.println("CatId is : " + categoryOptional.get().getId());

    System.out.println("CatId 2 is : " + categoryOptional2.get().getId());

    System.out.println("UoM Id is : " + unitOfMeasureOptional.get().getId());

    model.addAttribute("recipes", recipeService.getRecipes());

    return "index";
  }
}
