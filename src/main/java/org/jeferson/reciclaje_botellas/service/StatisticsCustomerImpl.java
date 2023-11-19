package org.jeferson.reciclaje_botellas.service;

import java.util.List;
import org.jeferson.reciclaje_botellas.exception.RecyclerCustomerNotCountException;
import org.jeferson.reciclaje_botellas.model.RecyclerCustomer;
import org.jeferson.reciclaje_botellas.repository.RecyclerCustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatisticsCustomerImpl implements StatisticsCustomer {
  private static final Logger logger = LoggerFactory.getLogger(StatisticsCustomerImpl.class);
  private final RecyclerCustomerRepository recyclerCustomerRepository;
  private List<RecyclerCustomer> customerInformationsList;

  public StatisticsCustomerImpl(RecyclerCustomerRepository recyclerCustomerRepository) {
    this.recyclerCustomerRepository = recyclerCustomerRepository;
    this.customerInformationsList = this.recyclerCustomerRepository.findAllRecyclerCustomer();
  }

  @Override
  // This method is responsible for searching by ID if a customer is in the data list
  public boolean searchingId(String idSearching) {
    logger.info("Searching for a customer by id");
    return customerInformationsList.stream()
        .anyMatch(customer -> customer.id().equals(idSearching));
  }

  @Override
  // This method counts the number of customers by gender.
  public int countByGender(char gender) {
    logger.info("Counting customers by gender");
    return (int)
        customerInformationsList.stream()
            .filter(customer -> customer.gender() == gender) // Filter customer by gender
            .count();
  }

  @Override
  // This method counts the number of customers by gender who recycle.
  public int countGenderAndRecycle(char gender, boolean recycle) {
    logger.info("Counting customers who recycle by gender");
    return (int)
        customerInformationsList.stream()
            .filter(customer -> customer.gender() == gender && customer.recycle())
            .count();
  }

  @Override
  public int countRecyclerByAges(int initialAge, int finalAge)
      throws RecyclerCustomerNotCountException {
    logger.info("Count the number of clients for age ");
    if (initialAge > finalAge || initialAge < 0 || finalAge < 0) {
      logger.error("Can't count customers");
      throw new RecyclerCustomerNotCountException(initialAge, finalAge);
    } else {

    }

    return (int)
        customerInformationsList.stream()
            .filter(
                customer ->
                    customer.age() >= initialAge
                        && customer.age() <= finalAge
                        && customer.recycle())
            .count();
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

    return fullName.append(name).append(" ").append(surname);
  }

  @Override
  public List<RecyclerCustomer> listAllCustomers() {
    logger.info("Showing all customers");
    return this.recyclerCustomerRepository.findAllRecyclerCustomer();
  }

  @Override
  public RecyclerCustomer addRecyclerCustomer(RecyclerCustomer newRecycler) {
    logger.info("Adding a new recycler Customer");
    return this.recyclerCustomerRepository.addRecyclerCustomer(newRecycler);
  }
}
