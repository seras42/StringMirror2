import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String replaceChar(String input, char oldChar, char newChar) {
        return input.replace(oldChar, '\0').replace(newChar, oldChar).replace('\0',newChar);
    }

    public static void main(String[] args) {
        System.out.println("Input the file path:");
        Scanner scannerWrite = new Scanner(System.in);
        String filepath = scannerWrite.nextLine();
        ArrayList<String> outputList = new ArrayList<>();
        int longestString = 0;
        File file = new File(filepath);
        int count = 0;

        try {
            //inputs the file to the arrayList
            Scanner fileScanner = new Scanner(file);
            //int count = 0;
            while (fileScanner.hasNext()) {
                outputList.add(fileScanner.nextLine());
                if (outputList.get(count).length() > longestString) {
                    longestString = outputList.get(count).length();
                }
                count++;

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        //iterates over whole array and mirrors certain parts
        count = 0;


        //Finds the longest String and sets every other String to the same length
        for (int i = 0; i < outputList.size(); i++) {
            if (outputList.get(i).length() < longestString) {
                while (outputList.get(i).length() < longestString) {
                    outputList.set(i,outputList.get(i)+" ");
                }
            }
            //outputs the code
            //.out.println(outputList.get(i) + " | " + outputList.get(i));
        }
        ArrayList<String> mirrorList = new ArrayList<>();

        for (int i = 0; i < outputList.size(); i++) {
            String input = outputList.get(i);
            input = replaceChar(input,'>', '<');
            input = replaceChar(input,'[',']');
            input = replaceChar(input,'{','{');
            input = replaceChar(input, '(',')');
            input = replaceChar(input, '/','\\');
            mirrorList.add(input);
        }
        ArrayList<String> outputListMirrored = new ArrayList<>();

        count = 0;
        for (String input : mirrorList) {
            StringBuilder replace = new StringBuilder(input);
            replace.reverse();
            outputListMirrored.add(String.valueOf(replace));
        }

        StringBuilder replace = new StringBuilder();

        for (int i = 0; i < outputList.size(); i++) {
            System.out.println(outputList.get(i) + " | " + outputListMirrored.get(i));
        }



    }


}
