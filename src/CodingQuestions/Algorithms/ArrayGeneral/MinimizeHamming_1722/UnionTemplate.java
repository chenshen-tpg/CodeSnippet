package CodingQuestions.Algorithms.ArrayGeneral.MinimizeHamming_1722;

public class UnionTemplate {

    private int[] parent;
    public UnionTemplate(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    // Find the root parent of x
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    // Union the sets containing x and y
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    public static void main(String[] args) {
        UnionTemplate uf = new UnionTemplate(8);
        uf.union(0, 1); // 01
        uf.union(1, 2); // 012
        uf.union(3, 4); // 34
        uf.union(5, 6); // 56
        uf.union(6, 7); // 567
        uf.union(2, 5); // 012567
        for (int i = 0; i < 8; i++) {
            System.out.println(uf.find(i));
        }
        uf.union(4, 7);
        System.out.println(uf.find(2));
    }


}
