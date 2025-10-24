public class gnomesort implements sorter {

    @Override
    public String name() { return "gnome sort"; }

    @Override
    public sortmetrics sort(int[] v) {
        sortmetrics m = new sortmetrics();
        int n = v.length;
        int i = 0;

        while (i < n) {
            m.addI(1);
            if (i == 0 || v[i - 1] <= v[i]) {
                i++;
            } else {
                int tmp = v[i];
                v[i] = v[i - 1];
                v[i - 1] = tmp;
                m.addT(1);
                i--;
            }
        }
        return m;
    }
}
