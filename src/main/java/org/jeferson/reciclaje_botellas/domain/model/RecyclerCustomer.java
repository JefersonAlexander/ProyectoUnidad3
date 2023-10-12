package org.jeferson.reciclaje_botellas.domain.model;
import java.time.LocalDate;

public record RecyclerCustomer(
        String name,
        String surname,
        Integer age,
        Character gender,
        String id,
        boolean recycle,
        int numberBottles,
        LocalDate recyclinStartDate
) {
}
