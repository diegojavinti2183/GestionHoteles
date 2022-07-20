/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionhoteles.servicios;

import com.gestionhoteles.entidades.Habitaciones;
import com.gestionhoteles.entidades.Hoteles;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author diego
 */
@Stateless
public class HabitacionesFacade extends AbstractFacade<Habitaciones> {

    @PersistenceContext(unitName = "com.websoft_GestionHoteles_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HabitacionesFacade() {
        super(Habitaciones.class);
    }

    /////////////Consulta solo habitaciones de un Hotel////////////////
    public List<Habitaciones> registroHabitaciones(Date fecha) {
        List<Habitaciones> result = null;
        javax.persistence.Query q = getEntityManager().createNamedQuery("Habitaciones.findByHabHotelHabitaciones");
       // q.setParameter("hotel", hotel);
        q.setParameter("fecha", fecha);
        if (!q.getResultList().isEmpty()) {
            result = q.getResultList();
        }
        return result;
    }

}
