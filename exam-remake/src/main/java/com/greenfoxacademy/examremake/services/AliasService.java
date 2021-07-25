package com.greenfoxacademy.examremake.services;

import com.greenfoxacademy.examremake.models.UniqueAlias;
import java.util.List;

public interface AliasService {
  UniqueAlias save(UniqueAlias newUniqueAlias);

  boolean existsUniqueAliasByAlias(String alias);

  UniqueAlias incrementHitCount(String alias);

  List<UniqueAlias> findAll();

  boolean existsById(Long id);

  UniqueAlias findUniqueAliasById(Long id);

  void deleteUniqueAliasById(Long id);
}
