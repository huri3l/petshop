/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20201PF.CC0165
 */
public class TestePersistirProduto {
        
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Produto p = new Produto();
        p.setNome("Sabonete para Cachorro");
        p.setValor(14.99);
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
