/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author hurie
 */
@Entity
@Table(name = "ordem_servico")
public class OrdemServico implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_ordem_servico", sequenceName = "seq_ordem_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_ordem_servico", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Length(max = 300, message = "A descrição não pode ter mais que {max} caracteres")
    @Column(name = "descricao", length = 300, nullable = true)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informada")
    @Column(name = "data", nullable = false)
    private Calendar data;

    @Min(value = 0, message = "O valor total não pode ser negativo")
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false, columnDefinition = "decimal(6,2)")
    private Double valorTotal;

    @NotNull(message = "O pet deve ser informado")
    @ManyToOne
    @JoinColumn(name = "pet", referencedColumnName = "id", nullable = false)
    private Pet pet;

    @NotNull(message = "O cliente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
    private Pessoa cliente;

    @NotNull(message = "O funcionário deve ser informado")
    @ManyToOne
    @JoinColumn(name = "funcionario", referencedColumnName = "id", nullable = false)
    private Funcionario funcionario;

    @OneToMany(mappedBy = "ordem_servico", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ItemServico> itens_servico = new ArrayList<>();

    public OrdemServico() {
        this.data = Calendar.getInstance();
    }
    
    public void adicionarItemServico(ItemServico item_servico) {
        item_servico.setOrdem_servico(this);
        this.getItens_servico().add(item_servico);
    }
    
    public void removerJogador(int index) {
        this.itens_servico.remove(index);
    }


    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * @param pet the pet to set
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * @return the cliente
     */
    public Pessoa getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the itens_servico
     */
    public List<ItemServico> getItens_servico() {
        return itens_servico;
    }

    /**
     * @param itens_servico the itens_servico to set
     */
    public void setItens_servico(List<ItemServico> itens_servico) {
        this.itens_servico = itens_servico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final OrdemServico other = (OrdemServico) obj;
        return Objects.equals(this.id, other.id);
    }
}
