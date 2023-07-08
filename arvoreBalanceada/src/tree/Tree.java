package tree;

public class Tree {

    private Node root;

    public void insert(int key, Object value) {
        this.root = insertNode(this.root, key, value);
    }

    private Node insertNode(Node root, int key, Object value) {
        if (root == null) {
            Node node = new Node();
            node.setKey(key);
            node.setValue(value);
            return node;
        } else {
            if (key < root.getKey()) {
                root.setLeft(insertNode(root.getLeft(), key, value));
            } else if (key > root.getKey()) {
                root.setRight(insertNode(root.getRight(), key, value));
            }
            return root;
        }
    }

    public Object get(int key) {
        return getNode(this.root, key);
    }

    private Object getNode(Node root, int key) {
        if (root != null) {
            if (key < root.getKey()) {
                return getNode(root.getLeft(), key);
            } else if (key > root.getKey()) {
                return getNode(root.getRight(), key);
            } else {
                return root.getValue();
            }
        }
        return null;
    }

    public void remove(int key) {
        this.root = removeNode(this.root, key);
    }

    private Node removeNode(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.getKey()) {
            root.setLeft(removeNode(root.getLeft(), key));
        } else if (key > root.getKey()) {
            root.setRight(removeNode(root.getRight(), key));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }

            Node nodeMin = findMin(root.getRight());
            root.setKey(nodeMin.getKey());
            root.setValue(nodeMin.getValue());

            root.setRight(removeNode(root.getRight(), nodeMin.getKey()));
        }

        return root;
    }

    private Node findMin(Node node) {
        Node current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public void inorder() {
        System.out.println("Em ordem: ");
        inorder(this.root);
        System.out.println();
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.getLeft());
            System.out.print(root.getKey() + " ");
            inorder(root.getRight());
        }
    }

    public void preorder() {
        System.out.println("Pre-ordem :");
        preorder(this.root);
        System.out.println();
    }

    private void preorder(Node root) {
        if (root != null) {
            System.out.print(root.getKey() + " ");
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }

    public void postorder() {
        System.out.println("Post-ordem: ");
        postorder(this.root);
        System.out.println();
    }

    private void postorder(Node root) {
        if (root != null) {
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.print(root.getKey() + " ");
        }
    }

    private String print(Node root, int lvl) {
        String out = "";
        for (int i = 0; i < lvl; i++) {
            out += "\t";
        }
        out += root.getKey() + ": " + (root.getValue() != null ? root.getValue() : "null");
        out += "\n";
        out += (root.getLeft() != null ? print(root.getLeft(), lvl + 1) : "");
        out += (root.getRight() != null ? print(root.getRight(), lvl + 1) : "");
        return out;
    }

    @Override
    public String toString() {
        return print(this.root, 0);
    }
}
