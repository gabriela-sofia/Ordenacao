public class combsort implements sorter {

    @Override
    public String name() { return "comb sort"; }

    @Override
    public sortmetrics sort(int[] v) {
        sortmetrics m = new sortmetrics();
        int n = v.length;
        int gap = n;
        boolean trocou = true;
        final double shrink = 1.3; // valor padrão set

        while (gap > 1 || trocou) {
            m.addI(1);
            gap = (int) (gap / shrink);
            if (gap < 1) gap = 1;
            trocou = false;

            for (int i = 0; i + gap < n; i++) {
                m.addI(1);
                if (v[i] > v[i + gap]) {
                    int tmp = v[i];
                    v[i] = v[i + gap];
                    v[i + gap] = tmp;
                    m.addT(1);
                    trocou = true;
                }
            }
        }
        return m;
    }
}
