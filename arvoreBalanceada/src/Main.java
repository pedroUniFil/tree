import tree.Tree;

public class Main {
    public static void main(String[] args) {
        Tree t = new Tree();

        t.insert(20, "20");
        t.insert(5, "5");
        t.insert(40, "40");
        t.insert(0, "0");
        t.insert(10, "10");
        t.insert(30, "30");
        t.insert(50, "50");

        System.out.println("Valor da key 5: " + t.get(5));//5
        System.out.println("Valor da key 500: " + t.get(500));//null

        t.remove(40);

        t.inorder();
        t.preorder();
        t.postorder();
    }
}