package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.controller.util.ControllerUtil;
import br.edu.infnet.av2.model.Atendente;
import br.edu.infnet.av2.model.Cliente;
import br.edu.infnet.av2.model.FormaPagamento;
import br.edu.infnet.av2.model.Motoboy;
import br.edu.infnet.av2.model.Pedido;
import br.edu.infnet.av2.model.Produto;
import br.edu.infnet.av2.service.AtendenteService;
import br.edu.infnet.av2.service.ClienteService;
import br.edu.infnet.av2.service.MotoboyService;
import br.edu.infnet.av2.service.PedidoService;
import br.edu.infnet.av2.service.ProdutoService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class PedidoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private AtendenteService atendenteService;
    @Autowired
    private MotoboyService entregadorService;
    private List<Pedido> pedidos;
    private Pedido pedido = new Pedido();
    private List<Cliente> clientes;
    private List<Produto> produtos;
    private List<Atendente> atendentes;
    private List<Motoboy> entregadores;
    
    public String listar() {

        pedido = new Pedido();
        pedidos = pedidoService.findAll();

        return "/pedido/ConsultaPedidos?faces-redirect=true";
    }

    public String detalhar() {

        String id = ControllerUtil.recuperaParametro("idPed");
        pedido = pedidoService.findById(new Long(id));

        return "/pedido/DetalhesPedido?faces-redirect=true";
    }

    public String cadastrar() {

        pedidoService.save(pedido);

        return listar();
    }

    public String alterar() {

        String id = ControllerUtil.recuperaParametro("idPed");
        Pedido pedidoCadastrado = pedidoService.findById(new Long(id));

        pedidoService.save(pedidoCadastrado);

        return listar();
    }

    public String remover() {

        String id = ControllerUtil.recuperaParametro("idPed");

        Pedido cat = pedidoService.findById(new Long(id));
        pedidoService.delete(cat);

        return listar();
    }

    public String listarClientes() {

        clientes = clienteService.findAll();

        return "/pedido/CadastraPedidoCliente?faces-redirect=true";
    }

    public String preparaCadastro() {

        recuperaDadosCadastro();

        return "/pedido/CadastraPedido?faces-redirect=true";
    }

    private void recuperaDadosCadastro() {

        Cliente cli = clienteService.findById(pedido.getCliente().getId());
        pedido.setCliente(cli);
        produtos = produtoService.findAll();
        atendentes = atendenteService.findAll();
        entregadores = entregadorService.findAll();
    }

    public PedidoService getPedidoService() {
        return pedidoService;
    }

    public void setPedidoService(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public ProdutoService getProdutoService() {
        return produtoService;
    }

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public AtendenteService getAtendenteService() {
        return atendenteService;
    }

    public void setAtendenteService(AtendenteService atendenteService) {
        this.atendenteService = atendenteService;
    }

    public MotoboyService getEntregadorService() {
        return entregadorService;
    }

    public void setEntregadorService(MotoboyService entregadorService) {
        this.entregadorService = entregadorService;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Atendente> getAtendentes() {
        return atendentes;
    }

    public void setAtendentes(List<Atendente> atendentes) {
        this.atendentes = atendentes;
    }

    public List<Motoboy> getEntregadores() {
        return entregadores;
    }

    public void setEntregadores(List<Motoboy> entregadores) {
        this.entregadores = entregadores;
    }
    
    public FormaPagamento[] getFormaPagamento() {
        return FormaPagamento.values();
    }
}