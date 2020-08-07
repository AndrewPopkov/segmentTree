import java.util.ArrayList;


public class SegmentTree {
    private int a[];
    public ArrayList<node> getResult() {
        return result;
    }

    private ArrayList<node> result;
    private node tree[];

    class node {
        int sum;
        int tl;
        int tr;

        public node(int sum, int tl, int tr) {
            this.sum = sum;
            this.tl = tl;
            this.tr = tr;
        }
    }

    public SegmentTree(int[] a) {
        result = new ArrayList<node>();
        tree= new node[4*a.length];
        this.a = a;
    }

    //Построение дерева по изначальному массиву.
    //v - номер текущей вершины; tl, tr - границы соответствующего отрезка
    public void build_tree(int v, int tl, int tr) {
        if (tl == tr) {
            this.tree[v] = new node(a[tl], tl, tr);
            if (a[tl] % a.length == 0)
                result.add(this.tree[v]);
        } else {
            //tm - средний элемент отрезка.
            //отрезок разбивается на два отрезка [tl; tm], [tm + 1; tr]
            int tm = (tl + tr) / 2;
            build_tree(v * 2, tl, tm);
            build_tree(v * 2 + 1, tm + 1, tr);
            tree[v] = new node(this.tree[v * 2].sum + this.tree[v * 2 + 1].sum, tl, tr);
            if (a[tl] % a.length == 0)
                result.add(this.tree[v]);
        }
    }

}
