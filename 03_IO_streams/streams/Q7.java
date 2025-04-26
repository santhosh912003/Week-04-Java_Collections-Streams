import java.io.*;
import java.util.Scanner;

public class Q7 {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            System.out.print("Enter number of students: ");
            int count = scanner.nextInt();
            scanner.nextLine(); 
            
            for (int i = 0; i < count; i++) {
                System.out.println("Enter details for student " + (i + 1) + ":");
                System.out.print("Roll Number: ");
                int roll = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("GPA: ");
                float gpa = scanner.nextFloat();
                scanner.nextLine();
                dos.writeInt(roll);
                dos.writeUTF(name);
                dos.writeFloat(gpa);
            }

            System.out.println("\nStudent data saved to '" + FILE_NAME + "'.");

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("\nReading student data from file:");
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            while (true) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                float gpa = dis.readFloat();

                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (EOFException e) {
          
            System.out.println("\nAll student data read successfully.");
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        scanner.close();
    }
}
