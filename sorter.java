public interface sorter {
    String name();
    sortmetrics sort(int[] v);    // ordena o vetor in-place e devolve as métricas
}
