package com.liyosi.recipe.controllers;

import com.liyosi.recipe.commands.UnitOfMeasureCommand;
import com.liyosi.recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.liyosi.recipe.domain.UnitOfMeasure;
import com.liyosi.recipe.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by liyosi on Sep, 2018
 */
@Controller
@Slf4j
public class UnitOfMeasureController {


  private final UnitOfMeasureService unitOfMeasureService;

  private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

  public UnitOfMeasureController(UnitOfMeasureService unitOfMeasureService, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
    this.unitOfMeasureService = unitOfMeasureService;
    this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
  }

  @RequestMapping("/uom/new")
  public String newUOM(Model model) {
    model.addAttribute("uom", new UnitOfMeasureCommand());

    return "uoms/uomform.html";
  }

  @RequestMapping("/uom/update/{id}")
  public String updateUOM(@PathVariable String id, Model model) {
    Optional<UnitOfMeasure> uom = unitOfMeasureService.findById(new Long(id));

    if (!uom.isPresent())
      throw new RuntimeException("UOM with Id: " + id + " not found");

    model.addAttribute("uom", unitOfMeasureToUnitOfMeasureCommand.convert(uom.get()));

    return "uoms/uomform.html";
  }

  @PostMapping
  @RequestMapping(value = "/uom/save", name = "uom")
  public String saveOrUpdae(@ModelAttribute UnitOfMeasureCommand unitOfMeasureCommand) {

    UnitOfMeasureCommand savedUoM = unitOfMeasureService.saveUnitOfMeasureCommand(unitOfMeasureCommand);

    log.info("Saved UoM, Id: " + savedUoM.getId());

    return "redirect:/uom/new";
  }
}
