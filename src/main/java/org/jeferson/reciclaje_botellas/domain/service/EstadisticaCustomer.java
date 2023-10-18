package org.jeferson.reciclaje_botellas.domain.service;

public interface EstadisticaCustomer {

  boolean idSearching(String idSearching);

  int countByGender(char gender);

  int countGenderAndRecycle(char gender, boolean recycle);

  int youngRecycler();

  StringBuilder mostRecycler();
}
