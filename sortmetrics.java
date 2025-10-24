public class sortmetrics {
    public long iteracoes;     // n° de repetições 
    public long trocas;        // n° de vezes que o vetor troca de posição

    public sortmetrics addI(long k) { this.iteracoes += k; return this; }
    public sortmetrics addT(long k) { this.trocas += k; return this; }

    @Override
    public String toString() {
        return "iteracoes=" + iteracoes + ", trocas=" + trocas;
    }
}
