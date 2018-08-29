package com.liyosi.recipe.controllers;

import com.liyosi.recipe.domain.Category;
import com.liyosi.recipe.domain.UnitOfMeasure;
import com.liyosi.recipe.repositories.CategoryRepository;
import com.liyosi.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by liyosi on Aug, 2018
 */
@Controller
public class IndexController {

  private CategoryRepository categoryRepository;
  private UnitOfMeasureRepository unitOfMeasureRepository;

  public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
    this.categoryRepository = categoryRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }

  @RequestMapping({"", "/", "/index.html", "index"})
  public String indexPage() {

    System.out.println("Reload the app...., looks good");

    Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByName("Cup");
    Optional<Category> categoryOptional = categoryRepository.findByDescription("Italian");

    Optional<Category> categoryOptional2 = categoryRepository.findByIdOrDescription(2L,"fa");

    System.out.println("CatId is : " + categoryOptional.get().getId());

    System.out.println("CatId 2 is : " + categoryOptional2.get().getId());

    System.out.println("UoM Id is : " + unitOfMeasureOptional.get().getId());


    return "index";
  }
}
