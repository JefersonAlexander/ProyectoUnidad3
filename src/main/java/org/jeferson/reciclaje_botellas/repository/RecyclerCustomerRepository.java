package org.jeferson.reciclaje_botellas.repository;

import java.util.List;
import org.jeferson.reciclaje_botellas.model.RecyclerCustomer;

public interface RecyclerCustomerRepository {

  List<RecyclerCustomer> findAllRecyclerCustomer();

  RecyclerCustomer addRecyclerCustomer(RecyclerCustomer newRecycler);
}
