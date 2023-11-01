package org.jeferson.reciclaje_botellas.domain.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.jeferson.reciclaje_botellas.exception.RecyclerCustomerNotFoundException;
import org.jeferson.reciclaje_botellas.repository.RecyclerCustomerRepositoryImpl;
import org.jeferson.reciclaje_botellas.service.StatisticsCustomer;
import org.jeferson.reciclaje_botellas.service.StatisticsCustomerImpl;
import org.junit.jupiter.api.Test;

class RecyclerCustomerImplTest {
  private StatisticsCustomer recyclerCustomer =
      new StatisticsCustomerImpl(new RecyclerCustomerRepositoryImpl());

  @Test
  void searching_for_costumer_by_id_when_client_exists()  {
    /*El cliente con id 182 se encuentra en la lista*/
    boolean id = recyclerCustomer.searchingId("182");
    assertTrue(id);
  }

  @Test
  void searching_for_costumer_by_id_when_client_no_exists()  {
    /*El cliente con id 18 no existe en los datos*/
    boolean id = recyclerCustomer.searchingId("18");
    assertFalse(id);
  }

  @Test
  void counting_the_number_of_women_successfully()  {
    /*Son 11 mujeres en los datos*/
    int numberWomen = recyclerCustomer.countByGender('F');
    assertEquals(11, numberWomen);
  }

  @Test
  void counting_the_number_of_women_by_recycling_successfully() {
    // La cantidad de mujeres que reciclan son 6
    int numberWomenRecycling = recyclerCustomer.countGenderAndRecycle('F', true);
    assertEquals(6, numberWomenRecycling);
  }

  @Test
  void counting_the_person_young_by_recycling_successfully() throws RecyclerCustomerNotFoundException {
    // Hay dos personas que reciclan entre 18 y 27 años
    int youngRecycler = recyclerCustomer.countRecyclerByAges(18, 27);
    assertEquals(2, youngRecycler);
  }

  @Test
  void find_the_person_who_recycles_the_most() {
    // La persona que mas recicla es Estafania Gonzales
    StringBuilder ecological = recyclerCustomer.findingMostRecycler();
    assertEquals("Estafania Gonzales", ecological.toString());
  }
}
