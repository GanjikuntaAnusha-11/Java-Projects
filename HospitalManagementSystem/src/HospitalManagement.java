import java.util.*;

public class HospitalManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int user = 0;
        
        do {
            System.out.println(" ");
            System.out.println("WELCOME");
            System.out.println("1.Patient Management\n2.Doctor Management\n3.Appointment Scheduling\n4.Medical History\n5.Bill records");
            System.out.println("Enter '6' or 'above' to quit");
            
            try {
                user = sc.nextInt();
                sc.nextLine(); // Consume newline
                
                switch(user) {
                    case 1:
                        PatientManagement.patientManagementDisplay();
                        break;
                    case 2:
                        DoctorManagement.doctorManagementDisplay();
                        break;
                    case 3:
                        ApponimentScheduling.displayAppointMentScheduling();
                        break;
                    case 4:
                        MedicalRecords.displayMedicalRecords();
                        break;
                    case 5:
                        PharamacyAndBillRecords.displayBillRecords();
                        break;
                    default:
                        System.out.println("Exiting...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // Clear invalid input
            }
            
        } while (user >= 1 && user <= 5);
        
        sc.close();
    }
}