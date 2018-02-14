/*
 * Hades Cruise
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Hades Cruise Corp.
 */
package ec.edu.espe.distribuidas.hades.service;

import ec.edu.espe.distribuidas.hades.dao.ConsumoDAO;
import ec.edu.espe.distribuidas.hades.model.Consumo;
import ec.edu.espe.distribuidas.hades.model.Reserva;
import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Hades Cruise Corp.
 */
@Stateless
@LocalBean
public class ConsumoService {

    @EJB
    private MongoPersistence mp;
    private ConsumoDAO consumoDAO;
    
    @PostConstruct
    public void init() {
        this.consumoDAO = new ConsumoDAO(Consumo.class, mp.context());
    }

    public List<Consumo> obtenerTodos() {
        return this.consumoDAO.find().asList();
    }

    public List<Consumo> obtenerPorReserva(Reserva reserva) {
        return this.consumoDAO.findByReserva(reserva);
    }

    public void crear(Consumo menu) {
        this.consumoDAO.save(menu);
    }
}
