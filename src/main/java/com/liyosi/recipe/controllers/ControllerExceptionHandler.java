package com.liyosi.recipe.controllers;

import com.liyosi.recipe.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by liyosi on Sep, 2018
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundException.class)
  public ModelAndView handleNotFound(Exception exception) {
    log.error("Resource not found");

    log.error("Error message: " + exception.getMessage());

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("404");

    modelAndView.addObject("exception", exception);
    return modelAndView;
  }


  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(NumberFormatException.class)
  public ModelAndView handleInvalidId(Exception exception) {
    log.error("Invalid user request: " + exception.getMessage());

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("404");
    modelAndView.addObject("exception", exception);
    return modelAndView;
  }
}
