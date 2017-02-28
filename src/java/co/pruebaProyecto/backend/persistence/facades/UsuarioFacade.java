/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.pruebaProyecto.backend.persistence.facades;

import co.pruebaProyecto.backend.persistence.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author alexandra
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "PruebaProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario ingresar(Usuario us){
     TypedQuery<Usuario> q = em.createQuery("FROM Usuario us WHERE us.cedula = ?1 and us.clave = ?2 ", Usuario.class);
        q.setParameter(1, us.getCedula());
        q.setParameter(2, us.getClave());
        if (!q.getResultList().isEmpty()){
            return q.getResultList().get(0);
        } else {
            return null;
        }
    }
    
}
