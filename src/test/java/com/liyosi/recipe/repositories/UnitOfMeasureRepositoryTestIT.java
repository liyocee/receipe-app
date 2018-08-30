package com.liyosi.recipe.repositories;

import com.liyosi.recipe.domain.UnitOfMeasure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Created by liyosi on Aug, 2018
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTestIT {

  @Autowired
  UnitOfMeasureRepository unitOfMeasureRepository;

  @Test
  public void findByName() throws Exception {
    String name = "Teaspoon";
    Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByName(name);

    assertEquals(unitOfMeasureOptional.get().getName(), name);
  }

  @Test
  public void findByNameAfterInsert() throws Exception {
    String uomName = "testing uom";
    UnitOfMeasure uom = UnitOfMeasure.builder().name(uomName).build();
    unitOfMeasureRepository.save(uom);

    assertEquals(unitOfMeasureRepository.findByName(uomName).get().getName(), uomName);
  }
}
