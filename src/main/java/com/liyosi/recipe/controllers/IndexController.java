package com.liyosi.recipe.controllers;

import com.liyosi.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liyosi on Aug, 2018
 */
@Controller
@Slf4j
public class IndexController {

  private RecipeRepository recipeRepository;

  public IndexController(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @RequestMapping({"", "/", "/index.html", "index"})
  public String indexPage(Model model) {

    log.info("Reload the app...., looks good");

    model.addAttribute("recipes", recipeRepository.findAll());

    return "index";
  }
}
