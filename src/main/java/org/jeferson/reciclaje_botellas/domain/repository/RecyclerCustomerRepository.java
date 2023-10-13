package org.jeferson.reciclaje_botellas.domain.repository;

import java.util.List;
import org.jeferson.reciclaje_botellas.domain.model.RecyclerCustomer;

public interface RecyclerCustomerRepository {

  List<RecyclerCustomer> listarCustomerInformation();
}
