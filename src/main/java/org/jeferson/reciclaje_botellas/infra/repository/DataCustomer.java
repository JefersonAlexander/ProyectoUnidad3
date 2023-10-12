package org.jeferson.reciclaje_botellas.infra.repository;

import org.jeferson.reciclaje_botellas.domain.model.RecyclerCustomer;

import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class DataCustomer {
    public static List<RecyclerCustomer> Data() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<RecyclerCustomer> customerData = new ArrayList<>();

        customerData.add(new RecyclerCustomer("Marta", "Gonzales", 24, 'F', "182", true, 13, LocalDate.parse("15/03/2021", formatter)));
        customerData.add(new RecyclerCustomer("Marti", "Alvares", 32, 'M', "273", true, 28, LocalDate.parse("07/09/2020", formatter)));
        customerData .add(new RecyclerCustomer("Juana", "Martines", 45, 'F', "364", false, 0, null));

        return customerData;
    }
}

