/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20201PF.CC0165
 */
public class TestePersistirFuncionario {
        
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        Funcionario f = new Funcionario();
        f.setNome("Huriel Lopez");
        f.setNomeUsuario("hlopez");
        f.setAtivo(Boolean.TRUE);
        f.setSenha("1234567890");
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
