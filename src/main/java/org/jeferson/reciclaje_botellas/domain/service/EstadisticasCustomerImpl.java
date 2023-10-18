package org.jeferson.reciclaje_botellas.domain.service;

import java.util.List;
import org.jeferson.reciclaje_botellas.domain.model.RecyclerCustomer;
import org.jeferson.reciclaje_botellas.domain.repository.RecyclerCustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EstadisticasCustomerImpl implements EstadisticaCustomer {
  private static final Logger logger = LoggerFactory.getLogger(EstadisticasCustomerImpl.class);
  private final RecyclerCustomerRepository recyclerCustomerRepository;
  private List<RecyclerCustomer> customerInformationsList;

  public EstadisticasCustomerImpl(RecyclerCustomerRepository recyclerCustomerRepository) {
    this.recyclerCustomerRepository = recyclerCustomerRepository;
    this.customerInformationsList = this.recyclerCustomerRepository.listarCustomerInformation();
  }

  // Metodos
  @Override
  // Este metodo se encarga de buscar por Id si una persona esta en la lista de datos
  public boolean idSearching(String idSearching) {
    logger.info("Buscando un cliente por id");
    boolean result = false;
    for (RecyclerCustomer customer : customerInformationsList) {
      if (customer.id().equals(idSearching)) {
        result = true;
        break;
      }
    }
    return result;
  }

  @Override
  // Este método cuenta la cantidad de clientes por género.
  public int countByGender(char gender) {
    logger.info("Contando clientes por genero");
    long count =
        customerInformationsList.stream()
            .filter(customer -> customer.gender() == gender) // Filtra los clientes por género
            .count();
    return (int) count;
  }

  @Override
  // Este método cuenta la cantidad de clientes por género que reciclan
  public int countGenderAndRecycle(char gender, boolean recycle) {
    logger.info("Contando clientes que reciclan por genero");
    long count =
        customerInformationsList.stream()
            .filter(customer -> customer.gender() == gender && customer.recycle())
            .count();
    return (int) count;
  }

  @Override
  // Este metodo cuenta la cantidad de clientes que recicla entre 18 y 27 años
  public int youngRecycler() {
    logger.info("Contar la cantidad de clientes entre 18 y 27 años");
    int youngRecyclers = 0;
    for (RecyclerCustomer customer : customerInformationsList) {
      if (customer.age() >= 18 && customer.age() <= 27 && customer.recycle()) {
        youngRecyclers++;
      }
    }
    return youngRecyclers;
  }

  @Override
  // Este metodo se encarga de encontrar el cliente que mas ha reciclado
  public StringBuilder mostRecycler() {
    logger.info("Encontrando la persona que mas recicla");
    StringBuilder personalInformation = new StringBuilder();
    String nameCustomer = "";
    String surnameCustomer = "";
    int maxBottles = 0;
    for (RecyclerCustomer customer : customerInformationsList) {
      if (customer.numberBottles() > maxBottles) {
        maxBottles = customer.numberBottles();
        nameCustomer = customer.name();
        surnameCustomer = customer.surname();
      }
    }
    personalInformation.append(nameCustomer).append(" ").append(surnameCustomer);

    return personalInformation;
  }
}
