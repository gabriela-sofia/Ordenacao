ublic class main {

    public static void main(String[] args) {
        int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};

        sorter[] algs = new sorter[6];
        algs[0] = new combsort();
        algs[1] = new gnomesort();
        algs[2] = new bucketsort();
        algs[3] = new bubbleflagsort();
        algs[4] = new selectionsort();
        algs[5] = new cocktailsort();

        roda("vetor 1 (aleatório)", vetor1, algs);
        System.out.println();
        roda("vetor 2 (ordenado)", vetor2, algs);
        System.out.println();
        roda("vetor 3 (inverso)", vetor3, algs);
    }

    private static void roda(String titulo, int[] base, sorter[] algs) {
        System.out.println("=== " + titulo + " ===");
        int nAlg = algs.length;

        String[] nomes = new String[nAlg];
        long[] iters = new long[nAlg];
        long[] trocas = new long[nAlg];

        for (int a = 0; a < nAlg; a++) {
            sorter s = algs[a];
            nomes[a] = s.name();

            int[] copia = new int[base.length];
            for (int i = 0; i < base.length; i++) copia[i] = base[i];

            sortmetrics m = s.sort(copia);
            if (!ok(copia)) System.out.println("aviso: " + s.name() + " não ordenou corretamente.");

            iters[a] = m.iteracoes;
            trocas[a] = m.trocas;
        }

        // tabela 
        System.out.println("algoritmo                  |    iteracoes |       trocas");
        System.out.println("----------------------------+--------------+--------------");
        for (int a = 0; a < nAlg; a++) {
            alinhar(nomes[a], 26);
            System.out.print(" | ");
            alinharNum(iters[a], 12);
            System.out.print(" | ");
            alinharNum(trocas[a], 12);
            System.out.println();
        }

        // ranking por trocas
        long[] ordT = copiaArray(trocas);
        int[] idxT = indicesOrdenados(ordT);
        System.out.println("\nranking (menos trocas):");
        for (int i = 0; i < nAlg; i++) {
            int a = idxT[i];
            System.out.println((i + 1) + ") " + nomes[a] + " - trocas=" + trocas[a]);
        }

        // ranking por iterações
        long[] ordI = copiaArray(iters);
        int[] idxI = indicesOrdenados(ordI);
        System.out.println("\nranking (menos iteracoes):");
        for (int i = 0; i < nAlg; i++) {
            int a = idxI[i];
            System.out.println((i + 1) + ") " + nomes[a] + " - iteracoes=" + iters[a]);
        }
    }

    private static boolean ok(int[] v) {                       // check de ordem do vetor
        for (int i = 1; i < v.length; i++) if (v[i - 1] > v[i]) return false;
        return true;
    }

    private static long[] copiaArray(long[] src) {
        long[] c = new long[src.length];
        for (int i = 0; i < src.length; i++) c[i] = src[i];    // copia elemento por elemento (manual de array long)
        return c;
    }

    private static int[] indicesOrdenados(long[] vals) {   // menor primeiro
        int n = vals.length;
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (vals[idx[j]] < vals[idx[min]]) min = j;
            }
            if (min != i) {
                int tmp = idx[i];
                idx[i] = idx[min];
                idx[min] = tmp;
            }
        }
        return idx;
    }

    private static void alinhar(String s, int tam) {
        System.out.print(s);
        for (int i = s.length(); i < tam; i++) System.out.print(" ");
    }
  
    private static void alinharNum(long n, int tam) {
        String s = Long.toString(n);
        for (int i = s.length(); i < tam; i++) System.out.print(" ");
        System.out.print(s);
    }
}
