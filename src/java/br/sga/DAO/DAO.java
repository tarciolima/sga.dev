/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sga.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.jpa.internal.EntityManagerImpl;

/**
 *
 * @author mlopes
 */
public class DAO {
    
    private EntityManagerFactory emf;
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public DAO (){
        emf = Persistence.createEntityManagerFactory("sga.devPU");
    }
    
    public Session getSession(){
        
        if (getEntityManager().getDelegate() instanceof EntityManagerImpl) {
            
            EntityManagerImpl entityManagerImpl = (EntityManagerImpl) getEntityManager().getDelegate();
            return entityManagerImpl.getSession();
                
	} else {
            
            return (Session) getEntityManager().getDelegate();
	
        }
        
    }
    
}
