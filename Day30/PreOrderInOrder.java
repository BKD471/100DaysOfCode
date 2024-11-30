package Day30;

import utilities.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PreOrderInOrder {
    private final Map<Integer,Integer> inOrderMap=new HashMap<>();

    private TreeNode constructTree(int[] inOrder, int[] preOrder, int inStart,
                                   int inEnd, int preStart, int preEnd){
        if(preStart>preEnd || inStart>inEnd) return null;

        int key=preOrder[preStart];
        TreeNode root=new TreeNode(key);

        int inOrderIndex=inOrderMap.get(key);
        int totalELements=inOrderIndex-inStart;

        root.left=constructTree(inOrder,preOrder,inStart,inOrderIndex-1,
                preStart+1,preStart+totalELements);

        root.right=constructTree(inOrder,preOrder,inOrderIndex+1,inEnd,
                preStart+totalELements+1,preEnd);

        return root;
    }
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        int m=inOrder.length, n=preOrder.length;

        if(m!=n) return null;
        for(int index=0;index<m;index++) inOrderMap.put(inOrder[index],index);
        return constructTree(inOrder,preOrder,0,m-1,0,n-1);
    }
}
