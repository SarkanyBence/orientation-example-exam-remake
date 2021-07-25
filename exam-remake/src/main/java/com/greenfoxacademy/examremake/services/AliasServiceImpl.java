package com.greenfoxacademy.examremake.services;

import com.greenfoxacademy.examremake.models.UniqueAlias;
import com.greenfoxacademy.examremake.repositories.AliasRepository;
import java.util.List;
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

  @Override
  public List<UniqueAlias> findAll() {
    return aliasRepo.findAll();
  }

  @Override
  public boolean existsUniqueAliasById(Long id) {
    return aliasRepo.existsUniqueAliasById(id);
  }

  @Override
  public UniqueAlias findUniqueAliasById(Long id) {
    return aliasRepo.findById(id).get();
  }

  @Override
  public void deleteUniqueAliasById(Long id) {
    aliasRepo.deleteById(id);
  }
}
