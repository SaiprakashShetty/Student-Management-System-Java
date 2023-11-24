import java.io.*;
import java.util.*;

// Student class
class Student {
    private String name;
    private int rollNumber;
    private double marks;

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Method to calculate grade
    public String calculateGrade() {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 80) {
            return "B";
        } else if (marks >= 70) {
            return "C";
        } else if (marks >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continueEntry = "Y";
        while (continueEntry.equalsIgnoreCase("Y")) {
            System.out.println("Enter student details:");
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Roll Number: ");
            int rollNumber = sc.nextInt();
            System.out.print("Marks: ");
            double marks = sc.nextDouble();

            Student student = new Student();
            student.setName(name);
            student.setRollNumber(rollNumber);
            student.setMarks(marks);

            try {
                FileWriter writer = new FileWriter("student.txt", true);
                writer.write("Name: " + student.getName() + "\n");
                writer.write("Roll Number: " + student.getRollNumber() + "\n");
                writer.write("Marks: " + student.getMarks() + "\n");
                writer.write("Grade: " + student.calculateGrade() + "\n\n");
                writer.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            System.out.print("Do you want to continue entering student details? (Y/N): ");
            continueEntry = sc.next();
        }

        System.out.println("Student Details from File:");
        try {
            File file = new File("student.txt");
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
