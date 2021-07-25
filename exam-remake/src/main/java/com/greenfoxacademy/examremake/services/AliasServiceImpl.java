package com.greenfoxacademy.examremake.services;

import com.greenfoxacademy.examremake.repositories.AliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AliasServiceImpl  implements AliasService{

  @Autowired
  private AliasRepository aliasRepo;

}
