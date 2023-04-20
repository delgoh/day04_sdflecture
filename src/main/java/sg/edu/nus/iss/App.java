package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        if (args.length != 2) {
            System.out.println("Please enter 2 arguments (<path> <name>).");
            System.exit(0);
        }

        String filePath = args[0];
        String fileName = args[1];
        String filePathName = filePath + File.separator + fileName;

        File newPath = new File(filePath);
        if (newPath.exists()) {
            System.out.println("Path " + filePath + " already exists.");
        } else {
            newPath.mkdir();
            System.out.println("New path created.");
        }

        File newFile = new File(filePathName);
        if (!newFile.exists()) {
            System.out.println("File " + fileName + " does not exists.");
            System.exit(0);
        }

        FileReader fr = new FileReader(new File(filePathName));
        BufferedReader br = new BufferedReader(fr);
        StringBuilder sbFullDataStr = new StringBuilder();
        // String fullDataStr = "";
        String dataLine = "";
        while ((dataLine = br.readLine()) != null) {
            // fullDataStr = fullDataStr.concat(dataLine);
            // fullDataStr += dataLine;
            sbFullDataStr.append(dataLine);
        }
        br.close();
        fr.close();

        System.out.println(sbFullDataStr);
        String fullDataStr = sbFullDataStr.toString().toUpperCase();
        System.out.println(fullDataStr.toUpperCase());

        fullDataStr = fullDataStr.replace(',', ' ');
        fullDataStr = fullDataStr.replace('.', ' ');
        fullDataStr = fullDataStr.replace('(', ' ');
        fullDataStr = fullDataStr.replace(')', ' ');
        fullDataStr = fullDataStr.replace('[', ' ');
        fullDataStr = fullDataStr.replace(']', ' ');
        fullDataStr = fullDataStr.replace('"', ' ');
        fullDataStr = fullDataStr.replace('?', ' ');
        fullDataStr = fullDataStr.replace('!', ' ');
        fullDataStr = fullDataStr.replace('\'', ' ');

        String[] strArr = fullDataStr.split(" ");

        Map<String, Integer> words = new HashMap<>();
        for (String word : strArr) {
            Integer wordCount = words.get(word);

            if (wordCount == null) {
                words.put(word, 1);
            } else {
                words.put(word, wordCount + 1);
            }
        }

        System.out.println(words);
    }
}
