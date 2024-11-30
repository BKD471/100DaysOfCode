package Day30;

import utilities.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PostOrderInOrder {
    private final Map<Integer,Integer> inOrderMap=new HashMap<>();

    private TreeNode constructTree(int[] inOrder,int[] postOrder,int inStart,
                                   int inEnd,int postStart,int postEnd){
        if(postStart>postEnd || inStart>inEnd) return null;

        int key=postOrder[postEnd];
        TreeNode root=new TreeNode(key);

        int inOrderIndex=inOrderMap.get(key);
        int totalELements=inOrderIndex-inStart;

        root.left=constructTree(inOrder,postOrder,inStart,inOrderIndex-1,
                postStart,postStart+totalELements-1);

        root.right=constructTree(inOrder,postOrder,inOrderIndex+1,inEnd,
                postStart+totalELements,postEnd-1);

        return root;
    }

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        int m=inOrder.length, n=postOrder.length;

        if(m!=n) return null;
        for(int index=0;index<m;index++) inOrderMap.put(inOrder[index],index);
        return constructTree(inOrder,postOrder,0,m-1,0,n-1);
    }
}
