public class bucketsort implements sorter {

    @Override
    public String name() { return "bucket sort"; }

    @Override
    public sortmetrics sort(int[] v) {
        sortmetrics m = new sortmetrics();
        int n = v.length;
        if (n <= 1) return m;

        int min = v[0];
        int max = v[0];
        for (int i = 1; i < n; i++) {
            m.addI(1);
            if (v[i] < min) min = v[i];
            if (v[i] > max) max = v[i];
        }

        int M = 1;                 // set n° de baldes 
        while (M * M < n) M++; 

        // calculo do range
        long range = (long)max - (long)min + 1;
        if (range <= 0) range = 1;

        int[] count = new int[M];            // contagem de elementos por balde 
        for (int i = 0; i < n; i++) {     
            m.addI(1);
            int x = v[i];
            int idx = (int)(((long)(x - min) * M) / range);
            if (idx < 0) idx = 0;
            if (idx >= M) idx = M - 1;
            count[idx]++;
        }

        int[][] buckets = new int[M][];      // destina os baldes com tamanho exato
        for (int b = 0; b < M; b++) {
            m.addI(1);
            int tam = count[b];
            int[] bucket = new int[tam];
            buckets[b] = bucket;
        }

        int[] pos = new int[M];
        for (int i = 0; i < n; i++) {                        // preenche cada balde 
            m.addI(1);
            int x = v[i];
            int idx = (int)(((long)(x - min) * M) / range);
            if (idx < 0) idx = 0;
            if (idx >= M) idx = M - 1;
            int p = pos[idx];
            buckets[idx][p] = x;
            pos[idx] = p + 1;
        }

        // insertion sort em cada balde
        int k = 0;
        for (int b = 0; b < M; b++) {
            m.addI(1);
            int[] a = buckets[b];
            int tam = count[b];

            for (int i = 1; i < tam; i++) {
                m.addI(1);
                int chave = a[i];
                int j = i - 1;
                while (j >= 0 && a[j] > chave) {
                    m.addI(1);
                    a[j + 1] = a[j];
                    m.addT(1);
                    j--;
                }
                a[j + 1] = chave;
            }

            
            for (int i = 0; i < tam; i++) {
                m.addI(1);
                v[k] = a[i];
                k++;
            }
        }
        return m;
    }
}
