package org.jeferson.reciclaje_botellas.domain.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.jeferson.reciclaje_botellas.domain.repository.RecyclerCustomerRepositoryImpl;
import org.jeferson.reciclaje_botellas.domain.service.EstadisticasService;
import org.jeferson.reciclaje_botellas.domain.service.EstadisticasServiceImpl;
import org.junit.jupiter.api.Test;

class RecyclerCustomerImplTest {
  private EstadisticasService recyclerCustomer =
      new EstadisticasServiceImpl(new RecyclerCustomerRepositoryImpl());

  @Test
  void searching_for_costumer_by_id_when_client_exists() {
    boolean id = recyclerCustomer.searchId("182");
    assertTrue(id);
  }

  @Test
  void searching_for_costumer_by_id_when_client_no_exists() {
    boolean id = recyclerCustomer.searchId("18");
    assertFalse(id);
  }

  @Test
  void counting_the_number_of_women_successfully() {
    int numberWomen = recyclerCustomer.countCustomersByGender('F');
    assertEquals(numberWomen, 11);
  }

  @Test
  void counting_the_number_of_women_by_recycling_successfully() {
    int numberWomenRecycling = recyclerCustomer.countCustomersByGenderAndRecycle('F', true);
    assertEquals(numberWomenRecycling, 6);
  }
}
