package org.jeferson.reciclaje_botellas.controller;

import java.util.List;
import org.jeferson.reciclaje_botellas.model.RecyclerCustomer;
import org.jeferson.reciclaje_botellas.repository.RecyclerCustomerRepositoryImpl;
import org.jeferson.reciclaje_botellas.service.StatisticsCustomer;
import org.jeferson.reciclaje_botellas.service.StatisticsCustomerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recyclerCustomer/")
@CrossOrigin(origins = "*")
public class RecyclerCustomerController {
  StatisticsCustomer statisticsService =
      new StatisticsCustomerImpl(new RecyclerCustomerRepositoryImpl());

  @GetMapping
  public List<RecyclerCustomer> listRecyclers() {
    List<RecyclerCustomer> recyclerCustomers = statisticsService.listAllCustomers();

    return recyclerCustomers;
  }

  @PostMapping("/addRecycler")
  public ResponseEntity<RecyclerCustomer> addRecyclers(@RequestBody RecyclerCustomer newRecycler) {
    System.out.println("adding recycler");
    RecyclerCustomer recyclerCustomer = statisticsService.addRecyclerCustomer(newRecycler);
    return ResponseEntity.status(HttpStatus.OK).body(recyclerCustomer);
  }
}
