import java.security.SecureRandom;
import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {

        SecureRandom oRand = new SecureRandom();


        String[] asWords = new String[10];
        String sTargetWord;
      //  int iTargetWord;
        int sTargetWordIndex;
       // int iIndexFound;
        int iIndexReturned;
        long lTimeStarted;
        long lTimeEnded;

        asWords[0] = "Zero";
        asWords[1] = "One";
        asWords[2] = "Two";
        asWords[3] = "Three";
        asWords[4] = "Four";
        asWords[5] = "Five";
        asWords[6] = "Six";
        asWords[7] = "Seven";
        asWords[8] = "Eight";
        asWords[9] = "Nine";

        Arrays.sort(asWords); //vital.

        sTargetWordIndex = oRand.nextInt(asWords.length); //0-99
        sTargetWord = asWords[sTargetWordIndex];
        System.out.println("target number's index is: " + sTargetWordIndex);

        BinarySearch oBinarySearch = new BinarySearch();

        // begin binary search test
        lTimeStarted = System.nanoTime();
        iIndexReturned = oBinarySearch.findNumberBinarySearch(asWords, sTargetWord, asWords.length-1, 0);
        lTimeEnded = System.nanoTime();
        System.out.println("Binary Search elapsed time: " + (lTimeEnded - lTimeStarted));
        System.out.println("Binary search returned: " + iIndexReturned);

        // begin linear search test
        lTimeStarted = System.nanoTime();
        iIndexReturned = oBinarySearch.findNumberLinearSearch(asWords, sTargetWord);
        lTimeEnded = System.nanoTime();
        System.out.println("Linear Search elapsed time: " + (lTimeEnded - lTimeStarted));
        System.out.println("Linear search returned: " + iIndexReturned);
    }

    /**
     * Find index of target num using binary search via recursion.
     */
    private int findNumberBinarySearch(String[] asWords, String sTargetWord, int iHighIndex, int iLowIndex){

        // Get middle index
        int iMiddleIndex = ((iHighIndex + iLowIndex) /2);

        // Check if target number is at middle index
        if(asWords[iMiddleIndex].equals(sTargetWord)){
            return iMiddleIndex;
        }

        // Check if target number is greater than the number at the middle index.
        if(sTargetWord.compareTo(asWords[iMiddleIndex]) > 0){
            return findNumberBinarySearch(asWords, sTargetWord, iHighIndex, iMiddleIndex +1);
        }

        // Then target number is less than the number at the middle index.
        else{
            return findNumberBinarySearch(asWords, sTargetWord, iMiddleIndex -1, iLowIndex);
        }

    }


    /**
     *  Find index of target num using linear search.
     */

    private int findNumberLinearSearch(String[] asWords, String sTargetWord){

        for(int x = 0; x < asWords.length; x++) {
            if (asWords[x].equals(sTargetWord)) {
                return x;
            }
        }
        return -1; // -1 is a standard error
    }

}
