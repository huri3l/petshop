/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author 20201PF.CC0165
 */
@Entity
@Table(name = "pet")
public class Pet implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_pet", sequenceName = "seq_pet_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pet", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome é um campo obrigatório")
    @NotBlank(message = "O nome é um campo obrigatório")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O nascimento é um campo obrigatório")
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    
    @NotNull(message = "O peso é um campo obrigatório")
    @Column(name = "peso", nullable = false)
    private Double peso;
    
    @NotNull(message = "A espécie é um campo obrigatório")
    @NotBlank(message = "A espécie é um campo obrigatório")
    @Length(max = 40, message = "A espécie não pode ter mais que {max} caracteres")
    @Column(name = "especie", length = 40, nullable = false)
    private String especie;
    
    @NotNull(message = "A raça deve ser informada")
    @ManyToOne
    @JoinColumn(name = "raca", referencedColumnName = "id", nullable = false)
    private Raca raca;
    
    public Pet() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }
    
        @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.getId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pet other = (Pet) obj;
        return Objects.equals(this.getId(), other.getId());
    }
}
