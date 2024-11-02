package Day5;

public class AllocatePages {
    private boolean canDistributeLoad(int[] books,long optimalLoad,long students){
        long numberOfStudents=1;
        long load=0;
        for(int v:books){
            if(load+v<=optimalLoad) load+=v;
            else{
                numberOfStudents++;
                load=v;
            }
        }
        return numberOfStudents<=students;

    }
    public int books(int[] books, int students) {
        int n=books.length;
        // every students needs at least one book
        if(n==0 || n<students) return -1;

        long lowestLoad=0;
        long highestLoad=0;
        for(int v:books){
            lowestLoad=Math.max(lowestLoad,v);
            highestLoad+=v;
        }

        long bestLoad=lowestLoad;
        while(lowestLoad<=highestLoad){
            long optimalLoad=lowestLoad+(highestLoad-lowestLoad)/2;

            if(canDistributeLoad(books,optimalLoad,students)){
                bestLoad=optimalLoad;
                highestLoad=optimalLoad-1;
            }else lowestLoad=optimalLoad+1;
        }
        return (int)bestLoad;
    }
}
