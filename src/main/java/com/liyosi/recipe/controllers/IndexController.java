package com.liyosi.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liyosi on Aug, 2018
 */
@Controller
public class IndexController {

  @RequestMapping({"", "/", "/index.html", "index"})
  public String indexPage() {
    return "index";
  }
}
