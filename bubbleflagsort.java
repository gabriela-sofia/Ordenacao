public class bubbleflagsort implements sorter {

    @Override
    public String name() { return "bubble sort"; }

    @Override
    public sortmetrics sort(int[] v) {
        sortmetrics m = new sortmetrics();
        int n = v.length;
        boolean trocou = true;

        for (int pass = 0; pass < n - 1 && trocou; pass++) {
            m.addI(1);
            trocou = false;
            for (int i = 0; i < n - 1 - pass; i++) {
                m.addI(1);
                if (v[i] > v[i + 1]) {
                    int tmp = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = tmp;
                    m.addT(1);
                    trocou = true;
                }
            }
        }
        return m;
    }
}
