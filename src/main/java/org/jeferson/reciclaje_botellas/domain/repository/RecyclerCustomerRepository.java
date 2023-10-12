package org.jeferson.reciclaje_botellas.domain.repository;

import org.jeferson.reciclaje_botellas.domain.model.RecyclerCustomer;

import java.util.List;

public interface RecyclerCustomerRepository {

    List<RecyclerCustomer> listarCustomerInformation();
}
