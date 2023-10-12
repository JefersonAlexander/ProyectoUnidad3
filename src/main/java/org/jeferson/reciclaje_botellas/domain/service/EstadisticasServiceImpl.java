package org.jeferson.reciclaje_botellas.domain.service;

import org.jeferson.reciclaje_botellas.domain.model.RecyclerCustomer;
import org.jeferson.reciclaje_botellas.domain.repository.RecyclerCustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
public class EstadisticasServiceImpl implements EstadisticasService {
    private static final Logger logger = LoggerFactory.getLogger(EstadisticasServiceImpl.class);
    private final RecyclerCustomerRepository recyclerCustomerRepository;

    public EstadisticasServiceImpl(RecyclerCustomerRepository recyclerCustomerRepository) {
        this.recyclerCustomerRepository = recyclerCustomerRepository;
    }

    @Override
    public boolean searchId(String idSerching) {
        List<RecyclerCustomer> customerInformationsList= recyclerCustomerRepository.listarCustomerInformation();
        int i=0;
        while (i< customerInformationsList.size()){
            RecyclerCustomer customer=customerInformationsList.get(i);
            if(customer.id().equals(idSerching)){
                return true;
            } i ++;
        }
        return false;
    }

    @Override
    public int[] statistics() {
        return new int[0];
    }


}

