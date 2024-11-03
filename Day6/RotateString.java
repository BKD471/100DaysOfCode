package Day6;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        int m=s.length(),n=goal.length();
        if(m!=n) return false;

        for(int rotate=1;rotate<=m;rotate++){
            s=s.substring(1)+s.charAt(0);
            System.out.println(s);
            if(s.equals(goal)) return true;
        }

        return false;
    }


    public boolean rotateStringConcat(String s, String goal) {
        int m=s.length(),n=goal.length();
        if(m!=n) return false;
        // concat of self contains all combinations of rotations.
        return (s + s).contains(goal);
    }
}
