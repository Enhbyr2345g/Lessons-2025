package id.group;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.IOException;

public class ReadFile {

    public static boolean exists(Path filePath) {
        return Files.exists(filePath);
    }

    public static boolean notEmpty(Path filePath) {
        try {
            return Files.size(filePath) > 0;
        } catch (IOException e) {
            System.out.println("Fileiin hemjeenii aldaa: " + e.getMessage());
            return false;
        }
    }

    public static String readAsString(Path filePath) throws IOException {
        return Files.readString(filePath);
    }

    public static void printFileContent(Path filePath) {
        if (!exists(filePath)) {
            System.out.println("File alga: " + filePath.toAbsolutePath());
            return;
        }

        if (!notEmpty(filePath)) {
            System.out.println("File hooson: " + filePath.toAbsolutePath());
            return;
        }

        try {
            String content = readAsString(filePath);
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("File unshih aldaa: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("File path: ");
        String inputPath = scan.nextLine();
        Path filePath = Path.of(inputPath);

        printFileContent(filePath);
    }
}
