/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Servico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20201PF.CC0165
 */
public class TestePersistirServico {
        
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Produto p1 = em.find(Produto.class, 1);
        
        Servico s = new Servico();
        s.setNome("Banho Rápido");
        s.adicionarProduto(p1);
        s.setValor(46.48);
        
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
