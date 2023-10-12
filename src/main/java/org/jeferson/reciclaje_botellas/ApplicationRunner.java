package org.jeferson.reciclaje_botellas;

import org.jeferson.reciclaje_botellas.domain.repository.RecyclerCustomerRepositoryImpl;
import org.jeferson.reciclaje_botellas.domain.service.EstadisticasService;
import org.jeferson.reciclaje_botellas.domain.service.EstadisticasServiceImpl;

import java.text.MessageFormat;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ApplicationRunner {
    public static void main(String[] args) {

        EstadisticasService estadisticasService=new
                EstadisticasServiceImpl(new RecyclerCustomerRepositoryImpl());

        String idSearching="123";
        System.out.println("El usuario se con : {id} se encuentra  registrado " + estadisticasService.searchId( idSearching));
    }
}