import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/* 機位:
   學號:411631327
   姓名:邱振營
*/

public class Fin3 {
    public static void main(String[] args) throws FileNotFoundException{
        String fileName = "scores.txt";
        int lineCount = 0;
        int wordCount = 0;
        
        String[] students = new String[100];
        String[] studentsInfo = new String[100];
        int studentCount = 0;
        
        try {
            File file = new File(fileName);
            Scanner file_input = new Scanner(file);
            
            while (file_input.hasNextLine()) {
                String line = file_input.nextLine();
                lineCount++;
                
                String[] words = line.split("\\s+");
                wordCount += words.length;
                
                if (words.length >= 4) {
                    students[studentCount] = words[1];
                    studentsInfo[studentCount] = words[0] + " " + words[2] + " " + words[3];
                    studentCount++;
                }
            }
            file_input.close();
            
            System.out.println("File " + fileName + " has " + lineCount + " lines " + wordCount + " words");
            /* */

            Scanner userInput = new Scanner(System.in);

            boolean found = false;
            while (!found) {
                System.out.println("please enter id: ");
                String studentId = userInput.nextLine();

                found = false;

                for(int i=0; i<studentCount; i++) {
                    if(students[i].equals(studentId)) {
                        System.out.println(studentsInfo[i]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("not in file, try again");
                }
            }

            userInput.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
} 