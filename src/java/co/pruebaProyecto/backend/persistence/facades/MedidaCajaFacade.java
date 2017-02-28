/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.pruebaProyecto.backend.persistence.facades;

import co.pruebaProyecto.backend.persistence.entity.MedidaCaja;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alexandra
 */
@Stateless
public class MedidaCajaFacade extends AbstractFacade<MedidaCaja> {

    @PersistenceContext(unitName = "PruebaProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedidaCajaFacade() {
        super(MedidaCaja.class);
    }
    
}
