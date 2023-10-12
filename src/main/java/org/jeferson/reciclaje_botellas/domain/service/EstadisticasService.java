package org.jeferson.reciclaje_botellas.domain.service;

public interface EstadisticasService {

    boolean searchId(String idSearching);
    int[]   statistics();
}
