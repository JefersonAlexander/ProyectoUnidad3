package org.jeferson.reciclaje_botellas.domain.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.jeferson.reciclaje_botellas.domain.model.RecyclerCustomer;

public class RecyclerCustomerRepositoryImpl implements RecyclerCustomerRepository {
  @Override
  public List<RecyclerCustomer> listarCustomerInformation() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    List<RecyclerCustomer> listRecyclerCustomer =
        List.of(
            new RecyclerCustomer(
                "Marta",
                "Gonzales",
                24,
                'F',
                "182",
                true,
                13,
                LocalDate.parse("15/03/2021", formatter)),
            new RecyclerCustomer("Marti", "Alvares", 32, 'M', "273", false, 0, null),
            new RecyclerCustomer("Juana", "Martines", 45, 'F', "364", false, 0, null),
            new RecyclerCustomer(
                "Estafania",
                "Gonzales",
                36,
                'F',
                "451",
                true,
                38,
                LocalDate.parse("24/10/2021", formatter)),
            new RecyclerCustomer("Esteban", "Colorado", 62, 'M', "512", false, 0, null),
            new RecyclerCustomer(
                "Angela",
                "Fuentes",
                19,
                'F',
                "645",
                true,
                6,
                LocalDate.parse("15/01/2020", formatter)),
            new RecyclerCustomer("Camilo", "Conrrado", 70, 'M', "736", false, 0, null),
            new RecyclerCustomer("Luisa", "Conrrado", 21, 'F', "827", false, 0, null),
            new RecyclerCustomer(
                "Carlos",
                "Ochoa",
                31,
                'M',
                "918",
                true,
                19,
                LocalDate.parse("15/12/2023", formatter)),
            new RecyclerCustomer(
                "Juan",
                "Fuentes",
                52,
                'M',
                "192",
                true,
                12,
                LocalDate.parse("15/06/2023", formatter)),
            new RecyclerCustomer("Camila", "Martines", 55, 'F', "283", false, 0, null),
            new RecyclerCustomer(
                "Susana",
                "Zapata",
                28,
                'F',
                "374",
                true,
                26,
                LocalDate.parse("15/03/2023", formatter)),
            new RecyclerCustomer("Diana", "Nuñes", 25, 'F', "371", false, 0, null),
            new RecyclerCustomer(
                "Alfonso",
                "Alvares",
                42,
                'M',
                "372",
                true,
                30,
                LocalDate.parse("15/03/2023", formatter)),
            new RecyclerCustomer(
                "Samara",
                "Martinez",
                61,
                'F',
                "373",
                true,
                25,
                LocalDate.parse("15/03/2022", formatter)),
            new RecyclerCustomer("Sebastian", "Gutierrez", 23, 'M', "375", false, 0, null),
            new RecyclerCustomer(
                "Alejandra",
                "Gonzales",
                58,
                'F',
                "376",
                true,
                12,
                LocalDate.parse("15/03/2022", formatter)),
            new RecyclerCustomer(
                "Sergio",
                "Ochoa",
                66,
                'M',
                "377",
                true,
                19,
                LocalDate.parse("15/03/2020", formatter)),
            new RecyclerCustomer("Yane", "Fernandez", 19, 'F', "378", false, 0, null),
            new RecyclerCustomer(
                "Yovani",
                "zAPATA",
                30,
                'M',
                "379",
                true,
                9,
                LocalDate.parse("15/03/2022", formatter)));

    return listRecyclerCustomer;
  }
}
