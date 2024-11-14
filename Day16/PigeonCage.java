package Day16;

public class PigeonCage {
    public int turnPigeons(String A) {
        if(A==null || A.isEmpty()) return 0;

        int countOfR=0,countOfSwitch=0;
        for(char ch:A.toCharArray()){
            if(ch=='R') countOfR++;
            else{
                if(countOfR>0){
                    countOfSwitch++;
                    countOfR--;
                }
            }
        }
        return countOfSwitch;
    }
}
