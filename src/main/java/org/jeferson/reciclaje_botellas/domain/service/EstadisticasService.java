package org.jeferson.reciclaje_botellas.domain.service;

public interface EstadisticasService {

  boolean searchId(String idSearching);

  int countCustomersByGender(char gender);

  int countCustomersByGenderAndRecycle(char gender, boolean recycle);
}
