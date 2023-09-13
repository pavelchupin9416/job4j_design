package outputstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ResultFile {
    public static void main(String[] args) {

        Integer[][] multipTabl = new Integer[10][10];
        for (int cell = 0; cell < multipTabl.length; cell++) {
            for (int row = 0; row < multipTabl[cell].length; row++) {
                multipTabl[cell][row] = (cell + 1) * (row + 1);
            }
        }

        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (Integer[] number: multipTabl) {
                out.write(Arrays.deepToString(number).getBytes());
                out.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}