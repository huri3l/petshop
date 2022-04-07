/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20201PF.CC0165
 */
public class TesteListarPet {
    
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        List<Pet> lista = em.createQuery("from Pet order by id").getResultList();
        for (Pet p : lista) {
            System.out.println("ID: " + p.getId() + " Nome: " + p.getNome() + 
                    " Peso: " + p.getPeso() + " Nascimento: " + sdf.format(p.getNascimento().getTime()) +
                    " Espécie: " + p.getEspecie() + " Raça: " + p.getRaca().getNome());
        }
        em.close();
        emf.close();
    }
}
