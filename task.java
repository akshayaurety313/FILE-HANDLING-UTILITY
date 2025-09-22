import java.io.*;
import java.util.Scanner;

public class Task1 {   // Class name updated as requested

    // Method to write text into a file (creates file if it does not exist)
    public static void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println(" Error writing to file: " + e.getMessage());
        }
    }

    // Method to read text from a file and display it
    public static void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\n📖 File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(" File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to modify the file (overwrite with new content)
    public static void modifyFile(String fileName, String newContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(newContent);
            System.out.println(" File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "internship_task.txt";

        // Step 1: Write
        System.out.print("Enter text to write into file: ");
        String text = scanner.nextLine();
        writeToFile(fileName, text);

        // Step 2: Read
        readFromFile(fileName);

        // Step 3: Modify
        System.out.print("\nEnter new text to overwrite the file: ");
        String newText = scanner.nextLine();
        modifyFile(fileName, newText);

        // Step 4: Re-read to verify changes
        readFromFile(fileName);

        scanner.close();
    }
}
