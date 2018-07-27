package br.edu.infnet.av2.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pedido_id", nullable=false, unique=true, length=11)
    private long id;
    
    @OneToMany(mappedBy="pedido", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<ProdutoPedido> produtos;
    
    @ManyToOne
    @JoinColumn(name="atendente_id", nullable=false)
    private Atendente atendente;
    
    @ManyToOne
    @JoinColumn(name="entregador_id", nullable=false)
    private Motoboy entregador;
    
    @ManyToOne
    @JoinColumn(name="cliente_id", nullable=false)
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name="endereco_id", nullable=false)
    private Endereco endereco;
    
    @Column(name="entrega", nullable=false)
    private boolean entrega;
    
    @Column(name="desconto")
    private BigDecimal desconto;
    
    @Column(name="taxa_entrega")
    private BigDecimal taxaEntrega;
    
    @Column(name="valor", nullable=false)
    private BigDecimal valor;
    
    @Column(name="troco")
    private BigDecimal troco;
    
    @Column(name="data", nullable=false)
    private LocalDate data;
    
    @Column(name="hora", nullable=false)
    private LocalTime hora;
    
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
    @Column(name="forma_pagamento")
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    public Pedido() {
    }

    public Pedido(List<ProdutoPedido> produtos, Atendente atendente, Motoboy entregador, Cliente cliente, Endereco endereco, boolean entrega, BigDecimal desconto, BigDecimal taxaEntrega, BigDecimal valor, BigDecimal troco, LocalDate data, LocalTime hora, StatusPedido status) {
        this.produtos = produtos;
        this.atendente = atendente;
        this.entregador = entregador;
        this.cliente = cliente;
        this.endereco = endereco;
        this.entrega = entrega;
        this.desconto = desconto;
        this.taxaEntrega = taxaEntrega;
        this.valor = valor;
        this.troco = troco;
        this.data = data;
        this.hora = hora;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ProdutoPedido> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoPedido> produtos) {
        this.produtos = produtos;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Motoboy getEntregador() {
        return entregador;
    }

    public void setEntregador(Motoboy entregador) {
        this.entregador = entregador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(BigDecimal taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getTroco() {
        return troco;
    }

    public void setTroco(BigDecimal troco) {
        this.troco = troco;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}