package org.jeferson.reciclaje_botellas.domain.service;

import java.util.List;
import org.jeferson.reciclaje_botellas.domain.model.RecyclerCustomer;
import org.jeferson.reciclaje_botellas.domain.repository.RecyclerCustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EstadisticasServiceImpl implements EstadisticasService {
  private static final Logger logger = LoggerFactory.getLogger(EstadisticasServiceImpl.class);
  private final RecyclerCustomerRepository recyclerCustomerRepository;
  private List<RecyclerCustomer> customerInformationsList;

  public EstadisticasServiceImpl(RecyclerCustomerRepository recyclerCustomerRepository) {
    this.recyclerCustomerRepository = recyclerCustomerRepository;
    this.customerInformationsList = this.recyclerCustomerRepository.listarCustomerInformation();
  }



  // Metodos
  @Override
  public boolean searchId(String idSearching) {
    int i = 0;
      while (i < customerInformationsList.size()) {
          RecyclerCustomer customer = customerInformationsList.get(i);
          if (customer.id().equals(idSearching)) {
              return true;
          }
          i++;
      }
    return false;
  }

  @Override
  public int countCustomersByGender(char gender) {
    return (int)
        customerInformationsList.stream()
            .filter(CustomerInformation -> CustomerInformation.gender() == gender)
            .count();
  }

  @Override
  public int countCustomersByGenderAndRecycle(char gender, boolean recycle) {
    return (int)
        customerInformationsList.stream()
            .filter(
                CustomerInformation ->
                    CustomerInformation.gender() == gender && CustomerInformation.recycle())
            .count();
  }
}
