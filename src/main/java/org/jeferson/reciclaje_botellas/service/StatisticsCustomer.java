package org.jeferson.reciclaje_botellas.service;

import java.util.List;
import org.jeferson.reciclaje_botellas.exception.RecyclerCustomerNotCountException;
import org.jeferson.reciclaje_botellas.model.RecyclerCustomer;

public interface StatisticsCustomer {

  boolean searchingId(String idSearching);

  int countByGender(char gender);

  int countGenderAndRecycle(char gender, boolean recycle);

  int countRecyclerByAges(int initialAge, int finalAge) throws RecyclerCustomerNotCountException;

  StringBuilder findingMostRecycler();

  List<RecyclerCustomer> listAllCustomers();

  RecyclerCustomer addRecyclerCustomer(RecyclerCustomer newRecycler);
}
