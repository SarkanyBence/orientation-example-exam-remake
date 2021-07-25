package com.greenfoxacademy.examremake.controllers;

import com.greenfoxacademy.examremake.models.UniqueAlias;
import com.greenfoxacademy.examremake.services.AliasService;
import java.net.URISyntaxException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

  private final AliasService aliasService;

  public MainController(AliasService aliasService) {
    this.aliasService = aliasService;
  }

  @GetMapping("/")
  public String mainPage(Model model) {

    model.addAttribute("newAlias", new UniqueAlias());
    return "index";
  }

  @PostMapping("/save-link")
  public String saveAlias(@ModelAttribute UniqueAlias newAlias, Model model) {

    if (aliasService.existsUniqueAliasByAlias(newAlias.getAlias())) {
      model.addAttribute("error", "Your alias is already in use!");
      model.addAttribute("newAlias", newAlias);
      return "index";
    }
    model.addAttribute("newAlias", new UniqueAlias());
    UniqueAlias tmpAlias = new UniqueAlias(newAlias.getUrl(), newAlias.getAlias());
    model.addAttribute("success", "Your URL is aliased to "
        + tmpAlias.getAlias()
        + " and your secret code is "
        + tmpAlias.getSecretCode()
        + ".");
    aliasService.save(tmpAlias);

    return "index";
  }

  @GetMapping("/a/{alias}")
  public Object hitCounter(@PathVariable String alias) throws URISyntaxException {

    if (aliasService.existsUniqueAliasByAlias(alias)) {
      UniqueAlias tmpAlias = aliasService.incrementHitCount(alias);

      return "redirect:" + tmpAlias.getUrl();
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }



}
