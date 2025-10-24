public class cocktailsort implements sorter {

    @Override
    public String name() { return "cocktail sort"; }

    @Override
    public sortmetrics sort(int[] v) {
        sortmetrics m = new sortmetrics();
        int n = v.length;
        boolean trocou = true;
        int inicio = 0, fim = n - 1;

        while (trocou) {
            m.addI(1);
            trocou = false;

            // ida
            for (int i = inicio; i < fim; i++) {
                m.addI(1);
                if (v[i] > v[i + 1]) {
                    int tmp = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = tmp;
                    m.addT(1);
                    trocou = true;
                }
            }
            if (!trocou) break;
            trocou = false;
            fim--;

            // volta
            for (int i = fim; i > inicio; i--) {
                m.addI(1);
                if (v[i - 1] > v[i]) {
                    int tmp = v[i - 1];
                    v[i - 1] = v[i];
                    v[i] = tmp;
                    m.addT(1);
                    trocou = true;
                }
            }
            inicio++;
        }
        return m;
    }
}
