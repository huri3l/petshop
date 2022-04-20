/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author hurie
 */
@Entity
@Table(name = "item_servico")
public class ItemServico implements Serializable {    
    
    @Id
    @SequenceGenerator(name = "seq_item_servico", sequenceName = "seq_item_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_item_servico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Min(value = 0, message = "A quantidade não pode ser negativa")
    @NotNull(message = "A quantidade deve ser informada")
    @Column(name = "quantidade", nullable = false, columnDefinition = "decimal(6,2)")
    private Double quantidade;
    
    @Min(value = 0, message = "O valor unitário não pode ser negativo")
    @NotNull(message = "O valor unitário deve ser informado")
    @Column(name = "valor_unitario", nullable = false, columnDefinition = "decimal(6,2)")
    private Double valorUnitario;
    
    @Min(value = 0, message = "O valor total não pode ser negativo")
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false, columnDefinition = "decimal(6,2)")
    private Double valorTotal;
    
    @NotNull(message = "O serviço deve ser informado")
    @ManyToOne
    @JoinColumn(name = "servico", referencedColumnName = "id", nullable = false)
    private Servico servico;
    
    @NotNull(message = "A ordem de serviço deve ser informada")
    @ManyToOne
    @JoinColumn(name = "ordem_servico", referencedColumnName = "id", nullable = false)
    private OrdemServico ordem_servico;
    
    public ItemServico() {
        
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
     * @return the quantidade
     */
    public Double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valorUnitario
     */
    public Double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
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
     * @return the servico
     */
    public Servico getServico() {
        return servico;
    }

    /**
     * @param servico the servico to set
     */
    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
    /**
     * @return the ordem_servico
     */
    public OrdemServico getOrdem_servico() {
        return ordem_servico;
    }

    /**
     * @param ordem_servico the ordem_servico to set
     */
    public void setOrdem_servico(OrdemServico ordem_servico) {
        this.ordem_servico = ordem_servico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final ItemServico other = (ItemServico) obj;
        return Objects.equals(this.id, other.id);
    }    
}
