package reference;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.*;

public class Reference {
    public static final String PATH_NAMES = "chapter_005_Garbage_Collection/src/main/java/reference/name.txt";

    public static void main(String[] args) {
        example1();
        //example2();
    }

    private static void example1() {
        List<SoftReference<String>> names = new ArrayList<>();
        try {
            File file = new File(PATH_NAMES);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                names.add(new SoftReference<>(line));
                line = reader.readLine();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
        for (SoftReference<String> name : names) {
            System.out.println(name.get());
        }
        System.gc();
        System.out.println();
        for (SoftReference<String> name : names) {
            System.out.println(name.get());
        }
    }

   private static void example2() {
       List<WeakReference<String>> names = new ArrayList<>();
       try {
           File file = new File(PATH_NAMES);
           FileReader fr = new FileReader(file);
           BufferedReader reader = new BufferedReader(fr);
           String line = reader.readLine();
           while (line != null) {
               names.add(new WeakReference<>(line));
               line = reader.readLine();
           }
       }  catch (IOException e) {
           e.printStackTrace();
       }
       for (WeakReference<String> name : names) {
           System.out.println(name.get());
       }
       System.gc();
       System.out.println();
       for (WeakReference<String> name : names) {
           System.out.println(name.get());
       }
   }
}
