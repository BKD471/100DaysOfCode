package Day17;

public class BusDilemma {
    // O(B*n)
    public int solve(int[] A, int B) {
        int n = A.length;
        if (n == 0 || B == 0) return 0;

        long countOfCombinationOfPeopleInitially = 0;
        for (int numberOfPeopleInitially = 0; numberOfPeopleInitially <= B; numberOfPeopleInitially++) {

            long[] peoplePresentInBus = new long[n];
            peoplePresentInBus[0] = numberOfPeopleInitially + A[0];
            long maxPeople = peoplePresentInBus[0];
            long minPeople = peoplePresentInBus[0];
            for (int stations = 1; stations < n; stations++) {
                long peopleBoarded = A[stations];
                peoplePresentInBus[stations] = peoplePresentInBus[stations - 1] + peopleBoarded;
                minPeople = Math.min(minPeople, peoplePresentInBus[stations]);
                maxPeople = Math.max(maxPeople, peoplePresentInBus[stations]);
                if (minPeople < 0 || maxPeople > B) break;
            }
            if (minPeople >= 0 && maxPeople <= B) countOfCombinationOfPeopleInitially++;
        }
        return (int) countOfCombinationOfPeopleInitially;
    }

    // O(n)
    public int solveBest(int[] A, int B) {
        int n = A.length;
        if (n == 0 || B == 0) return 0;

        long[] peoplePresentInBus = new long[n];
        peoplePresentInBus[0] = A[0];
        long maxPeople = A[0];
        long minPeople = A[0];
        for (int stations = 1; stations < n; stations++) {
            long peopleBoarded = A[stations];
            peoplePresentInBus[stations] = peoplePresentInBus[stations - 1] + peopleBoarded;
            minPeople = Math.min(minPeople, peoplePresentInBus[stations]);
            maxPeople = Math.max(maxPeople, peoplePresentInBus[stations]);
        }


        long minNumberOfPeoplePossibleInitially = - minPeople;
        long maxNumberOfPeoplePossibleInitially = B - maxPeople;
        if (minNumberOfPeoplePossibleInitially < 0) minNumberOfPeoplePossibleInitially = 0;
        if (maxNumberOfPeoplePossibleInitially > B) maxNumberOfPeoplePossibleInitially = B;

        if (minNumberOfPeoplePossibleInitially > maxNumberOfPeoplePossibleInitially) return 0;
        long countOfCombinationOfPeopleInitially = maxNumberOfPeoplePossibleInitially - minNumberOfPeoplePossibleInitially + 1;
        return (int) countOfCombinationOfPeopleInitially;

    }

//    [-3,-4,4]  7
//
//    [-3,-7,-3]
//
//    min=-7, max=-3
//
//    -7+x=0   -3+x=4
//    x=7        x=4

    public static void main(String[] args) {
        int[] nums = {-3, -4, 4};
        int k = 4;

        BusDilemma busDilemma = new BusDilemma();
        int res = busDilemma.solveBest(nums, k);
        System.out.println(res);
    }
}
