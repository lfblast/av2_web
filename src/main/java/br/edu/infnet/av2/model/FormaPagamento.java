package br.edu.infnet.av2.model;


public enum FormaPagamento {
    
    BOLETO(1),
    CARTAO(2),
    PAY_PAL(3);
    
    private final int val;
    
    FormaPagamento(int val) {
        this.val = val;
    }
    
    public int getVal() {
        return val;
    }
    
    public static FormaPagamento fromInt(int i) {
    for (FormaPagamento formaPagamento : FormaPagamento.values()) {
      if (formaPagamento.getVal()== i) {
        return formaPagamento;
      }
    }
    return null;
  }
}