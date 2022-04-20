/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.ItemServico;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Pet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20201PF.CC0165
 */
public class TestePersistirOrdemServico {
        
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Pet pet = em.find(Pet.class, 2);
        Funcionario fun = em.find(Funcionario.class, 2);
        Pessoa cli = em.find(Pessoa.class, 3);
        
        OrdemServico os = new OrdemServico();
        os.setValorTotal(110.99d);
        os.setDescricao("Descrição de Teste");
        os.setFuncionario(fun);
        os.setCliente(cli);
        os.setPet(pet);
        
        em.getTransaction().begin();
        em.persist(os);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
