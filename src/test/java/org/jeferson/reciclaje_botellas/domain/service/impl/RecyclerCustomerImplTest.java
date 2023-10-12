package org.jeferson.reciclaje_botellas.domain.service.impl;

import org.jeferson.reciclaje_botellas.domain.service.EstadisticasService;
import org.jeferson.reciclaje_botellas.domain.service.EstadisticasServiceImpl;
import org.jeferson.reciclaje_botellas.domain.repository.RecyclerCustomerRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecyclerCustomerImplTest {
    private EstadisticasService recyclerCustomer=new EstadisticasServiceImpl(new RecyclerCustomerRepositoryImpl() );
    @Test
    void searching_for_costumer_by_id_when_client_exists() {
        boolean id = recyclerCustomer.searchId("182");
        assertTrue(id);
    }
    @Test
    void searching_for_costumer_by_id_when_client_no_exists() {
        boolean id = recyclerCustomer.searchId("18");
        assertFalse(id);
    }

}