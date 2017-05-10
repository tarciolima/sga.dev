/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sga.BEAN;

import br.sga.VO.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tarcio
 */

public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "com.mycompany_usuario_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    public List<User> getUsers() {
        return em.createNamedQuery("User.findAll").getResultList();
    }
    
    
}
