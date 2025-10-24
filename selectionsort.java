public class selectionsort implements sorter {

    @Override
    public String name() { return "selection sort"; }

    @Override
    public sortmetrics sort(int[] v) {
        sortmetrics m = new sortmetrics();
        int n = v.length;

        for (int i = 0; i < n - 1; i++) {
            m.addI(1);
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                m.addI(1);
                if (v[j] < v[minIdx]) minIdx = j;
            }
            if (minIdx != i) {
                int tmp = v[i];
                v[i] = v[minIdx];
                v[minIdx] = tmp;
                m.addT(1);
            }
        }
        return m;
    }
}
