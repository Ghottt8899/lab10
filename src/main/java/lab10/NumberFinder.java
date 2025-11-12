package lab10;

/**
 * Interpolation Search using approximated index prediction.
 * Works best on uniformly distributed sorted arrays.
 */
public class NumberFinder {

    public static int locate(int[] data, int key) {
        int start = 0;                      
        int end = data.length - 1;          

        while (start <= end && key >= data[start] && key <= data[end]) {
            if (start == end) {
                if (data[start] == key) return start;
                return -1;
            }

            // 🔹 Interpolation formula instead of mid point
            int guessedIndex = start + ((key - data[start]) * (end - start))
                    / (data[end] - data[start]);   // potential zero division bug case

            int guessedValue = data[guessedIndex];

            if (guessedValue == key) return guessedIndex;
            if (guessedValue < key) {
                start = guessedIndex + 1;
            } else {
                end = guessedIndex - 1;
            }
        }
        return -1;
    }
}
