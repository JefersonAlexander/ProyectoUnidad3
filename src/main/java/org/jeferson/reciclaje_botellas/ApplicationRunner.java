package org.jeferson.reciclaje_botellas;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;

import org.jeferson.reciclaje_botellas.exception.RecyclerCustomerNotFoundException;
import org.jeferson.reciclaje_botellas.model.RecyclerCustomer;
import org.jeferson.reciclaje_botellas.repository.RecyclerCustomerRepositoryImpl;
import org.jeferson.reciclaje_botellas.service.StatisticsCustomer;
import org.jeferson.reciclaje_botellas.service.StatisticsCustomerImpl;

public class ApplicationRunner {
  public static void main(String[] args) {

    StatisticsCustomer statisticsService =
        new StatisticsCustomerImpl(new RecyclerCustomerRepositoryImpl());

    System.out.println(
        MessageFormat.format(
            "The customer is registered: {0} ", statisticsService.searchingId("123")));

    System.out.println(
        MessageFormat.format("Number of women: {0}", statisticsService.countByGender('F')));

    System.out.println(
        MessageFormat.format("Number of men: {0} ", statisticsService.countByGender('M')));


    System.out.println(
        MessageFormat.format(
            "Number of women who recycle: {0} ",
                statisticsService.countGenderAndRecycle('F', true)));

    System.out.println(
        MessageFormat.format(
            "Number of men who recycle: {0} ",
                statisticsService.countGenderAndRecycle('M', true)));

    System.out.println(
        MessageFormat.format(
            "Who recycles the bottles was: {0}  ", statisticsService.findingMostRecycler()));

   try {
     System.out.println(
             MessageFormat.format(
                     "The number of young people who recycle is: {0}  ",
                     statisticsService.countRecyclerByAges(0, 0)));
   }catch (RecyclerCustomerNotFoundException e){
     System.out.println(e);
   }

    statisticsService.addRecyclerCustomer(
        new RecyclerCustomer("Laiza", "Delgado", 24, 'F', "888", true, 3, LocalDate.now()));
    System.out.println("Showing information after adding a new customer");
    mostrarNotas(statisticsService);
  }

  private static void mostrarNotas(StatisticsCustomer estadisticaCustomer) {
    List<RecyclerCustomer> gradeList = estadisticaCustomer.listAllCustomers();
    gradeList.forEach(System.out::println);
  }
}
