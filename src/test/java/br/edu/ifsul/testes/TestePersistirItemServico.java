/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.ItemServico;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.modelo.Servico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20201PF.CC0165
 */
public class TestePersistirItemServico {
        
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Servico s1 = em.find(Servico.class, 5);
        OrdemServico os = em.find(OrdemServico.class, 2);
        
        ItemServico is = new ItemServico();
        is.setQuantidade(2d);
        is.setValorUnitario(46.48d);
        is.setValorTotal(92.96d);
        is.setServico(s1);
        os.adicionarItemServico(is);
        
        em.getTransaction().begin();
        em.persist(os);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
