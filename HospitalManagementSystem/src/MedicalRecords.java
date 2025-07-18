import java.util.*;

public class MedicalRecords {

    public static void displayMedicalRecords(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number as mentioned below:");
        System.out.println("1.Patient details\n2.Doctor details\n3.Appointment details\n4.Statistics");
        int n1 = sc.nextInt();
        if(n1 == 1) {
            System.out.println("Tell me what would you like to see?");
            System.out.println("Enter a number as mentioned below:");
            System.out.println("1.Patient Info\n2.Medical Info");
            int n2 = sc.nextInt();
            if(n2 == 1) {
                PatientManagement.displayInfo(PatientManagement.patientInfo);
                
            }
            else if(n2 == 2) {
                PatientManagement.displayVitalSigns(PatientManagement.patientVitalSigns);
            }
            else {
                System.out.println("Enter a valid number");
            }
        }
        else if(n1 == 2) {
            System.out.println("Tell me what would you like to see?");
            System.out.println("Enter a number as mentioned below:");
            System.out.println("1.Doctor Info\n2.Doctor professional details");
            int n2 = sc.nextInt();
            if(n2 == 1) {
                DoctorManagement.displayDoctors(DoctorManagement.doctorInfo);
            }
            else if(n2 == 2) {
                DoctorManagement.displayProfessionaldetails(DoctorManagement.doctorProfessionalList);
            }
            else {
                System.out.println("Enter a valid number");
            }
        }
        else if(n1 == 3) {
            System.out.println("Tell me what would you like to see?");
            System.out.println("Enter a number as mentioned below:");
            System.out.println("1.Appointment of Doctors\n2.Appointment of Patients\n3.Total Appointments");
            int n = sc.nextInt();
            sc.nextLine();
            if(n == 1) {
                System.out.println("Enter doctorname:");
                String doctor = sc.nextLine();
                ArrayList<ArrayList<String>> list = ApponimentScheduling.appointmentDisplayOfDoctors(doctor);
                if(list.isEmpty()) {
                    System.out.println("No appointments are available");
                }
                else {
                    for(ArrayList<String> li : list) {
                        for(String it : li) {
                            System.out.print(it+" ");
                        }
                        System.out.println();
                    }
                }
            }
            else if(n == 2) {
                System.out.println("Enter patient name:");
                String patient = sc.nextLine();
                ArrayList<ArrayList<String>> list = ApponimentScheduling.appointmentDisplayOfPatients(patient);
                if(list.isEmpty()) {
                    System.out.println("No appointments are available");
                }
                else {
                    for(ArrayList<String> li : list) {
                        for(String it : li) {
                            System.out.print(it+" ");
                        }
                        System.out.println();
                    }
                }
            }
            else if(n == 3) {
                ApponimentScheduling.appointmentDisplay();
            }
            else {
                System.out.println("Enter a valid number");
            }
        }
        else if(n1 == 4) {
            System.out.println("Tell me what statistics would you like to see");
            System.out.println("Enter a number as mentioned below:");
            System.out.println("1.Patients\n2.Doctors\n3.Appointment");
            int n = sc.nextInt();
            sc.nextLine();
            if(n == 1) {
                PatientManagement.patientStatistics();
            }
            else if(n == 2) {
                DoctorManagement.doctorStatistics();
            }
            else if(n == 3) {
                ApponimentScheduling.appointmentStatistics();
            }
            else {
                System.out.println("Enter a valid number");
            }
        }
        else {
            System.out.println("Enter a valid number");
        }
    }    
}
