package Day4;

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int ax1 = rec1[0], ay1 = rec1[1], ax2 = rec1[2], ay2 = rec1[3];
        int bx1 = rec2[0], by1 = rec2[1], bx2 = rec2[2], by2 = rec2[3];
        // rectangle 1 L(ax1,ay1)  R(ax2,ay2)
        // rectangle 2 L(bx1,by1)  R(bx2,by2)

        // 1 -> 2  x     bx1>=ax2
        // 2 -> 1  x     ax1>=bx2
        // 1 -> 2  y     ay1>=by2
        // 2 -> 1  y     by1>=ay2
        if (bx1 >= ax2 || ax1 >= bx2 || ay1 >= by2 || by1 >= ay2) return false;
        return true;
    }
}
