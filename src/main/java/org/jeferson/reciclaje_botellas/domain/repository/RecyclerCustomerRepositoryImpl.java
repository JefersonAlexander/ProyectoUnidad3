package org.jeferson.reciclaje_botellas.domain.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.jeferson.reciclaje_botellas.domain.model.RecyclerCustomer;
import org.jeferson.reciclaje_botellas.domain.service.StatisticsCustomerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecyclerCustomerRepositoryImpl implements RecyclerCustomerRepository {

  private static final Logger logger = LoggerFactory.getLogger(StatisticsCustomerImpl.class);
  private List<RecyclerCustomer> recyclerCustomerList;

  public RecyclerCustomerRepositoryImpl() {
    this.recyclerCustomerList = new ArrayList<>(loadReciclerCustomer());
  }

  private List<RecyclerCustomer> loadReciclerCustomer() {
    logger.info("Cargando los datos desde archivo");
    List<String> plainTextGradeList = readFileWithReciclerCustomer();
    return plainTextGradeList.stream().map(this::buildRecyclerCustomer).toList();
  }

  private List<String> readFileWithReciclerCustomer() {
    logger.info("Leyendo el archivo");
    Path path = Paths.get("./src/main/resources/recyclerCustomer.txt");
    try (Stream<String> stream = Files.lines(path)) {
      return stream.toList();
    } catch (IOException x) {
      logger.error("IOException: {0}", x);
    }
    return Collections.emptyList();
  }

  private RecyclerCustomer buildRecyclerCustomer(String plainTextRecyclers) {
    logger.info("costruyendo el vector");
    String[] questionArray = plainTextRecyclers.split(",");

    return new RecyclerCustomer(
        questionArray[0],
        questionArray[1],
        Integer.valueOf(questionArray[2]),
        questionArray[3].charAt(0),
        questionArray[4],
        Boolean.parseBoolean(questionArray[5]),
        Integer.parseInt(questionArray[6]),
        LocalDate.parse(questionArray[7], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
  }

  @Override
  public List<RecyclerCustomer> findAllRecyclerCustomer() {
    return recyclerCustomerList;
  }

  @Override
  public RecyclerCustomer addRecyclerCustomer(RecyclerCustomer newRecycler) {
    this.recyclerCustomerList.add(newRecycler);

    return this.recyclerCustomerList.stream().filter(isTheId(newRecycler)).findAny().orElse(null);
  }

  private Predicate<RecyclerCustomer> isTheId(RecyclerCustomer newRecycler) {
    return p -> p.id().equals(newRecycler.id());
  }
}
