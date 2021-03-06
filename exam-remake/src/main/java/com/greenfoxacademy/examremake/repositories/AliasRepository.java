package com.greenfoxacademy.examremake.repositories;

import com.greenfoxacademy.examremake.models.UniqueAlias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AliasRepository extends JpaRepository<UniqueAlias, Long> {

  boolean existsUniqueAliasByAlias(String alias);
  boolean existsUniqueAliasById(Long id);

  UniqueAlias findUniqueAliasByAlias(String alias);

  UniqueAlias findUniqueAliasById(Long id);
}
