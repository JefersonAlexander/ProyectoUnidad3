package org.jeferson.reciclaje_botellas;

import java.text.MessageFormat;
import org.jeferson.reciclaje_botellas.domain.repository.RecyclerCustomerRepositoryImpl;
import org.jeferson.reciclaje_botellas.domain.service.EstadisticaCustomer;
import org.jeferson.reciclaje_botellas.domain.service.EstadisticasCustomerImpl;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ApplicationRunner {
  public static void main(String[] args) {

    EstadisticaCustomer estadisticaService =
        new EstadisticasCustomerImpl(new RecyclerCustomerRepositoryImpl());

    System.out.println(
        MessageFormat.format(
            "The customer is registered: {0} ", estadisticaService.idSearching("123")));
    System.out.println(
        MessageFormat.format("Number of women: {0}", estadisticaService.countByGender('F')));

    System.out.println(
        MessageFormat.format("Number of men: {0} ", estadisticaService.countByGender('M')));
    System.out.println(
        MessageFormat.format(
            "Number of women who recycle: {0} ",
            estadisticaService.countGenderAndRecycle('F', true)));
    System.out.println(
        MessageFormat.format(
            "Number of men who recycle: {0} ",
            estadisticaService.countGenderAndRecycle('M', true)));
    System.out.println(
        MessageFormat.format(
            "Who recycles the bottles was: {0}  ", estadisticaService.mostRecycler()));
    System.out.println(
        MessageFormat.format(
            "The number of young people who recycle is: {0}  ",
            estadisticaService.youngRecycler()));
  }
}
