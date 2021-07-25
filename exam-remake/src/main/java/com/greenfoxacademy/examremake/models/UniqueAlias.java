package com.greenfoxacademy.examremake.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "aliases")
public class UniqueAlias {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String url;
  private String alias;

  @JsonIgnore
  private Integer secretCode;

  private Integer hitCount = 0;

  public UniqueAlias(String url, String alias) {
    this.url = url;
    this.alias = alias;
    this.secretCode = generateSecretCode();
  }

  @Transient
  private Integer generateSecretCode() {
    Random random = new Random();
    return random.nextInt(9999 - 1000) + 1000;
  }


}
