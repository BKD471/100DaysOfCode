package utilities;

public class NodeWithCordinates {
    public TreeNode node;
    public int x, y;

    /*
    * constructor for node containing both vertical and horizontal info
    *
    * */
    public NodeWithCordinates(TreeNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }

    /*
    * constructor for node containing both vertical info
    *
    * */
    public NodeWithCordinates(TreeNode node, int y) {
        this.node = node;
        this.y = y;
    }

}
