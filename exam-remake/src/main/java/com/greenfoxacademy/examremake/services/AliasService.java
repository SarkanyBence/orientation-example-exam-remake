package com.greenfoxacademy.examremake.services;

import com.greenfoxacademy.examremake.models.UniqueAlias;

public interface AliasService {
  UniqueAlias save(UniqueAlias newUniqueAlias);

  boolean existsUniqueAliasByAlias(String alias);

  UniqueAlias incrementHitCount(String alias);
}
