package com.greenfoxacademy.examremake.services;

import com.greenfoxacademy.examremake.models.UniqueAlias;
import com.greenfoxacademy.examremake.repositories.AliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AliasServiceImpl implements AliasService {

  @Autowired
  private AliasRepository aliasRepo;

  @Override
  public UniqueAlias save(UniqueAlias newUniqueAlias) {
    return aliasRepo.save(newUniqueAlias);
  }

  @Override
  public boolean existsUniqueAliasByAlias(String alias) {
    return aliasRepo.existsUniqueAliasByAlias(alias);
  }

  @Override
  public UniqueAlias incrementHitCount(String alias) {
    UniqueAlias tmpAlias = aliasRepo.findUniqueAliasByAlias(alias);
    tmpAlias.setHitCount(tmpAlias.getHitCount() + 1);
    aliasRepo.save(tmpAlias);
    return tmpAlias;
  }
}
