package com.greenfoxacademy.examremake.controllers;


import com.greenfoxacademy.examremake.dtos.CodeDto;
import com.greenfoxacademy.examremake.models.UniqueAlias;
import com.greenfoxacademy.examremake.services.AliasService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  final
  private AliasService aliasService;

  public RestController(AliasService aliasService) {
    this.aliasService = aliasService;
  }

  @GetMapping("/api/links")
  public Object getAllLinks() {
    List<UniqueAlias> aliases = aliasService.findAll();

    return aliases;
  }

  @RequestMapping("/api/links/{id}")
  public ResponseEntity<?> deleteAlias(@PathVariable(required = false) Long id,
                                       @RequestBody(required = false) CodeDto secretCode) {

    if (secretCode.getSecretCode() == null || !aliasService.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    UniqueAlias tmpAlias = aliasService.findUniqueAliasById(id);

    if (!secretCode.getSecretCode().equals(tmpAlias.getSecretCode())) {

      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    aliasService.deleteUniqueAliasById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

  }
}
