package com.liyosi.recipe.controllers;

import com.liyosi.recipe.domain.Category;
import com.liyosi.recipe.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by liyosi on Aug, 2018
 */
@Controller
@Slf4j
public class IndexController {

  private CategoryRepository categoryRepository;

  public IndexController(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @RequestMapping({"", "/", "/index.html", "index"})
  public String indexPage(Model model) {

    log.info("Reload the app...., looks good");

    Optional<Category> categoryOptional = categoryRepository.findByDescription("Italian");

//    log.info("CatId is : " + categoryOptional.get().getId());

    model.addAttribute("categories", categoryRepository.findAll());

    return "index";
  }
}
