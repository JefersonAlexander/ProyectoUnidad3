package org.jeferson.reciclaje_botellas.domain.service;

public interface EstadisticaCustomer {

  boolean searchingId(String idSearching);

  int countByGender(char gender);

  int countGenderAndRecycle(char gender, boolean recycle);

  int countYoungRecycler();

  StringBuilder findingMostRecycler();
}
