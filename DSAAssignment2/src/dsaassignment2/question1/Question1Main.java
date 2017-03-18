package dsaassignment2.question1;

/**
 * @author Sam Gibson (100115871) <sam.gibson@uea.ac.uk>
 */
public class Question1Main {
    public static void main (String[] args) {
        testAlgorithms(new int[] { 4, 12, 110, 5, 6, 111 } );
    }
    
    public static void testAlgorithms(int[] values) {
        Matrix m = Matrix.defaultMatrix();
        for (int i : values) {
            boolean dResult = findElementD(m, m.getSize(), i);
            boolean d1Result = findElementD1(m, m.getSize(), i);
            boolean d2Result = findElementD2(m, m.getSize(), i);
            
            System.out.printf("VALUE %d:\nd: %b\nd1: %b\nd2: %b\n\n", i, 
                dResult, d1Result, d2Result);
        }
    }
    
    public static boolean findElementD(Matrix a, int n, int p) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a.get(i, j) == p) return true;
            }
        }
        return false;
    }
    
    public static boolean findElementD1(Matrix a, int n, int p) {
        for (int i = 0; i < n; i++) {
            if (binarySearch(i, p, n, a)) return true;
        }
        return false;
    }
    
    public static boolean findElementD2(Matrix a, int n, int p) {
        int row = 0;
        int col = n - 1;
        while (row < n && col > 0) {
            int elem = a.get(row, col);
            
            if (elem < p) row++;
            else if (elem > p) col--;
            else return true;
        }
        return false;
    }
    
    private static boolean binarySearch(int rowNum, int p, int n, Matrix a) {
        boolean found = false;
        int i = 0;
        int min = 0;
        int max = n-1;
        while (found == false && i < n) {
            int guessIndex = (min + max) / 2;
            int guess = a.get(rowNum, guessIndex);
            
            if (guess == p) found = true;
            else if (guess < p) min = guessIndex + 1;
            else max = guessIndex - 1;
            i++;
        }
        return found;
    }
}
