package uea.api_test.models.enums;

public enum TipoLancamento {
    RECEITA(1),
    DESPESA(2);
    
    private final int valor;
    
    private TipoLancamento(int valor) {
        this.valor = valor;
    }
    
    public int getValor() {
        return valor;
    }
}
