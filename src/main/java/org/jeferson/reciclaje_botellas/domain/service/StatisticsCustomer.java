package org.jeferson.reciclaje_botellas.domain.service;

import java.util.List;
import org.jeferson.reciclaje_botellas.domain.model.RecyclerCustomer;

public interface StatisticsCustomer {

  boolean searchingId(String idSearching);

  int countByGender(char gender);

  int countGenderAndRecycle(char gender, boolean recycle);

  int countRecyclerByAges(int initialAge, int finalAge);

  StringBuilder findingMostRecycler();

  List<RecyclerCustomer> listAllCustomers();

  RecyclerCustomer addRecyclerCustomer(RecyclerCustomer newRecycler);
}
