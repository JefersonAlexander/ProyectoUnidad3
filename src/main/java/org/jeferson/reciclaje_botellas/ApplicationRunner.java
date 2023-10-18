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
            "El cliente se encuentra  registrado: {0} ", estadisticaService.idSearching("123")));
    System.out.println(
        MessageFormat.format("Numero de mujeres: {0}", estadisticaService.countByGender('F')));

    System.out.println(
        MessageFormat.format("Numero de hombres: {0} ", estadisticaService.countByGender('M')));
    System.out.println(
        MessageFormat.format(
            "Numero de mujeres que reciclan: {0} ",
            estadisticaService.countGenderAndRecycle('F', true)));
    System.out.println(
        MessageFormat.format(
            "Numero de hombres que reciclan: {0} ",
            estadisticaService.countGenderAndRecycle('M', true)));
    System.out.println(
        MessageFormat.format(
            "Quien reciclo mas botellas fue: {0}  ", estadisticaService.mostRecycler()));
    System.out.println(
        MessageFormat.format(
            "La cantidad de personas jovenes que reciclan es: {0}  ",
            estadisticaService.youngRecycler()));
  }
}
