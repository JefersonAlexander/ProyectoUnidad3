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
  // This method is responsible for searching by ID if a customer is in the data list
  public boolean searchingId(String idSearching) {
    logger.info("Searching for a customer by id");
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
  // This method counts the number of customers by gender.
  public int countByGender(char gender) {
    logger.info("Counting customers by gender");
    var count =
        customerInformationsList.stream()
            .filter(customer -> customer.gender() == gender) // Filter customer by gender
            .count();
    return (int) count;
  }

  @Override
  // This method counts the number of customers by gender who recycle.
  public int countGenderAndRecycle(char gender, boolean recycle) {
    logger.info("Counting customers who recycle by gender");
    var count =
        customerInformationsList.stream() // Filter customer by gender and recycler
            .filter(customer -> customer.gender() == gender && customer.recycle())
            .count();
    return (int) count;
  }

  @Override
  // This method counts the number of customers who recycle between 18 and 27 years old.
  public int countYoungRecycler() {
    logger.info("Count the number of clients between 18 and 27 years old");
    int youngRecyclers = 0;
    for (RecyclerCustomer customer : customerInformationsList) {
      if (customer.age() >= 18 && customer.age() <= 27 && customer.recycle()) {
        youngRecyclers++;
      }
    }
    return youngRecyclers;
  }

  @Override
  // This method is responsible for finding the customer who has recycled the most
  public StringBuilder findingMostRecycler() {
    logger.info("Finding the customer who recycles the most");
    StringBuilder fullName = new StringBuilder();
    String name = "";
    String surname = "";
    int maxBottles = 0;
    for (RecyclerCustomer customer : customerInformationsList) {
      if (customer.numberBottles() > maxBottles) {
        maxBottles = customer.numberBottles();
        name = customer.name();
        surname = customer.surname();
      }
    }
    fullName.append(name).append(" ").append(surname);

    return fullName;
  }
}
