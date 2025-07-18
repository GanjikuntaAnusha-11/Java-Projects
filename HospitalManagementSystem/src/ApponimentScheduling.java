import java.util.*;
import java.util.regex.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class ApponimentScheduling {

    static ArrayList<ArrayList<String>> appointmentdetails = new ArrayList<>();

    static {
        initializeAppoinmentDetails();
    }

    private static void initializeAppoinmentDetails() {
        appointmentdetails.add(new ArrayList<>(Arrays.asList("APID1001","Ramesh Patel","Dr Amit Patel","2025-05-07","09:30","success")));
        appointmentdetails.add(new ArrayList<>(Arrays.asList("APID1002","Sunita Sharma","Dr Ritu Khanna","2025-05-10","11:00","success")));
        appointmentdetails.add(new ArrayList<>(Arrays.asList("APID1003","Vikram Desai","Dr Sunita Reddy","2025-05-10","11:00","success")));
        appointmentdetails.add(new ArrayList<>(Arrays.asList("APID1004","Anjali Mehta","Dr Divya Iyer","2025-05-13","18:00","success")));
        appointmentdetails.add(new ArrayList<>(Arrays.asList("APID1005","Prakash Joshi","Dr Kavita Rao","2025-05-15","10:30","success")));
        appointmentdetails.add(new ArrayList<>(Arrays.asList("APID1006","Geeta Reddy","Dr Ajay Kapoor","2025-05-16","10:30","success")));
        appointmentdetails.add(new ArrayList<>(Arrays.asList("APID1007","Deepak Singh","Dr Kavita Rao","2025-05-22","10:30","success")));
        appointmentdetails.add(new ArrayList<>(Arrays.asList("APID1008","Nandini Iyer","Dr Amit Patel","2025-05-23","10:00","success")));
        appointmentdetails.add(new ArrayList<>(Arrays.asList("APID1009","Arun Malhotra","Dr Vikram Singh","2025-05-26","10:00","success")));
        appointmentdetails.add(new ArrayList<>(Arrays.asList("APID1010","Kavita Rajesh","Dr Divya Iyer","2025-05-27","09:00","success")));
        appointmentdetails.add(new ArrayList<>(Arrays.asList("APID1011","Rahul Verma","Dr Sanjay Varma","2025-05-29","10:00","success")));
        appointmentdetails.add(new ArrayList<>(Arrays.asList("APID1012","Priya darshini","Dr Ananya Das","2025-05-29","11:00","success")));
        appointmentdetails.add(new ArrayList<>(Arrays.asList("APID1013","Meenakshi","Dr Ritu Khanna","2025-05-30","14:00","success")));
        appointmentdetails.add(new ArrayList<>(Arrays.asList("APID1014","Sameer Khan","Dr Arjun Sarkar","2025-06-02","14:00","success")));
        appointmentdetails.add(new ArrayList<>(Arrays.asList("APID1015","Neeta Srinivasan","Dr Kavita Rao","2025-06-05","15:00","success")));
    }
    public static boolean appointmentSchedule(String patientName, String doctorName, LocalDate date) {
        boolean flag = false;
        for(ArrayList<String> list : DoctorManagement.doctorDayAvailability) {
            if(list.get(0).equalsIgnoreCase(doctorName) && list.get(1).equalsIgnoreCase(date.getDayOfWeek().toString())) {
                flag = true;
            }
        }
        return flag;
    }

    public static void appointmentDetails(String appointmentid, String patientName, String doctorName, LocalDate date, LocalTime time, String status) {
        ArrayList<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\bAPID[1-9][0-9][0-9][0-9]");
        Matcher match = pattern.matcher(appointmentid);
        boolean found = match.matches();
        if(found) {
            if(checkById(appointmentid).equalsIgnoreCase("No id found")) {
                list.add(appointmentid);
            }
            else {
                System.out.println("The id already exists!!");
                System.exit(0);
            }
        }
        list.add(patientName);
        list.add(doctorName);
        list.add(date.toString());
        list.add(time.toString());
        list.add(status);
        appointmentdetails.add(list);
    }

    public static String checkById(String id){
        for(ArrayList<String> list : appointmentdetails) {
            for(String it : list) {
                if(id.equalsIgnoreCase(it)) {
                    return id;
                }
            }
        }
        return "No id found";
    }

    public static boolean appointmentUpdate(String patientName, LocalDate date, LocalTime time) {
        boolean flag = false;
        for(ArrayList<String> list : appointmentdetails) {
            if(list.get(1).equalsIgnoreCase(patientName)) {
                list.set(3,date.toString());
                list.set(4,time.toString());
                flag = true;
            }
        }
        return flag;
    }

    public static boolean appointmentDeletion(String patientName) {
        for(ArrayList<String> list : appointmentdetails) {
            if(list.get(1).equalsIgnoreCase(patientName)) {
                appointmentdetails.remove(list);
                return true;
            }
        }
        return false;
    }

    public static void appointmentDisplay() {
        for(ArrayList<String> list : appointmentdetails) {
            for(String li : list) {
                System.out.print(li + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<String>> appointmentDisplayOfDoctors(String doctorName) {
        ArrayList<ArrayList<String>> doctorsAppointmentList = new ArrayList<>();
        ArrayList<String> details = new ArrayList<>();
        for(ArrayList<String> list : appointmentdetails) {
            if(list.get(2).equalsIgnoreCase(doctorName)) {
                details.add(list.get(1));
                details.add(list.get(3));
                details.add(list.get(4));                
            }
            
        }
        doctorsAppointmentList.add(details);
        return doctorsAppointmentList;
    }

    public static ArrayList<ArrayList<String>> appointmentDisplayOfPatients(String patientName) {
        ArrayList<ArrayList<String>> patientAppointmentList = new ArrayList<>();
        ArrayList<String> details = new ArrayList<>();
        for(ArrayList<String> list : appointmentdetails) {
            if(list.get(1).equalsIgnoreCase(patientName)){
                details.add(list.get(2));
                details.add(list.get(3));
                details.add(list.get(4));
            }
        }
        patientAppointmentList.add(details);
        return patientAppointmentList;
    }

    public static int noOfPatientsAssignedToDoctor(String doctorname) {
        int noOfPatientsAssignedToDoctor = 0;
        for(ArrayList<String> list : appointmentdetails) {
            if(list.get(1).equalsIgnoreCase(doctorname)) {
                noOfPatientsAssignedToDoctor++;
            }
        }
        return noOfPatientsAssignedToDoctor;
    }

    public static HashMap<String, Integer> noOfPatientsAssignedToeachDoctor() {
        HashMap<String, Integer> noOfPatientsAssignedToEachDoctor = new HashMap<>();
        for(ArrayList<String> list : appointmentdetails) {
            noOfPatientsAssignedToEachDoctor.put(list.get(1),noOfPatientsAssignedToEachDoctor.getOrDefault(list.get(1), 0)+1);
        }
        return noOfPatientsAssignedToEachDoctor;
    }

    public static HashMap<String, Integer> noOfappointmentsbasedOnDate() {
        HashMap<String, Integer> map = new HashMap<>();
        for(ArrayList<String> list : appointmentdetails) {
            map.put(list.get(3),map.getOrDefault(list.get(3), 0)+1);
        }
        return map;
    }

    public static HashMap<String, Integer> noOfappointmentbasedonTime() {
        HashMap<String, Integer> map = new HashMap<>();
        for(ArrayList<String> list : appointmentdetails) {
            map.put(list.get(4),map.getOrDefault(list.get(4),0)+1);
        }
        return map;
    }

    public static void appointmentStatistics() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number as mentioned below");
        System.out.println("1.Assigned to Doctor\n2.Appointments based on date\n3.Appointments based on time");
        int n2 = sc.nextInt();
        switch(n2) {
            case 1:
                HashMap<String, Integer> map = noOfPatientsAssignedToeachDoctor();
                if(map.isEmpty()) {
                    System.out.println("No records to display");
                }
                else {
                    for(String i : map.keySet()) {
                        System.out.println(i + " " + map.get(i));
                    }
                }
                break;
            case 2:
                HashMap<String, Integer> map1 = noOfappointmentsbasedOnDate();
                if(map1.isEmpty()) {
                    System.out.println("No records to display");
                }
                else {
                    for(String i : map1.keySet()) {
                        System.out.println(i + " " + map1.get(i));
                    }
                }
                break;
            case 3:
                HashMap<String, Integer> map2 = noOfappointmentbasedonTime();
                if(map2.isEmpty()) {
                    System.out.println("No records to display");
                }
                else {
                    for(String i : map2.keySet()) {
                        System.out.println(i + " " + map2.get(i));
                    }
                }
                break;
            default:
                System.out.println("Enter a valid number");
        }
    }

    public static void displayAppointMentScheduling() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tell me what would you like to do?");
        System.out.println("Enter a number below as mentioned");
        System.out.println("1.Appointment booking\n2.Rescheduling the appointment\n3.Deletion of appointment");
        int n = sc.nextInt();
        sc.nextLine();
        if(n == 1) {
            System.out.println("Enter the following details:");
            System.out.println("Enter appointment id of format(APID[1-9][0-9][0-9][0-9])");
            String id = sc.nextLine();
            System.out.println("Enter name of the patient:");
            String patientName = sc.nextLine();
            System.out.println("Enter name of the doctor:");
            String doctorname = sc.nextLine();
            System.out.println("Enter date of schedule:");
            String date = sc.nextLine();
            LocalDate date1 = LocalDate.parse(date);
            System.out.println("Enter time of schedule");
            String time = sc.nextLine();
            LocalTime time1 = LocalTime.parse(time);
            String status = "";
            if(appointmentSchedule(patientName, doctorname, date1)) {
                if(date1.isBefore(LocalDate.now())) {
                    status = "failed";
                    System.out.println("The Booking date is not available");
                }
                else if(date1.isEqual(LocalDate.now())) {
                    if(time1.isBefore(LocalTime.now())) {
                        status = "failed";
                        System.out.println("The booking time is not available");
                    }
                    else {
                        status = "success";
                        System.out.println("The booking is confirmed");
                    }
                }
                else {
                    status = "success";
                    System.out.println("The appointment is successful");
                }
            }
            else {
                status = "failed";
                System.out.println("The doctor is not available.");
            }
            appointmentDetails(id, patientName, doctorname, date1, time1, status);
        }
        else if(n == 2) {
            System.out.println("Enter the following details:");
            System.out.println("Patient Name:");
            String name = sc.nextLine();
            System.out.println("Enter date: ");
            String date = sc.nextLine();
            LocalDate date1 = LocalDate.parse(date);
            System.out.println("Enter time: ");
            String time = sc.nextLine();
            LocalTime time1 = LocalTime.parse(time);
            if(appointmentUpdate(name, date1, time1)) {
                System.out.println("The updation was successful");
            }
            else {
                System.out.println("The schedule is not possible for the provided date and time");
            }
        }
        else if(n == 3) {
            System.out.println("Enter name of the patient");
            String name = sc.nextLine();
            if(appointmentDeletion(name)) {
                System.out.println("The deletion was successful");
            }
            else {
                System.out.println("Try again later");
            }
        }
        else {
            System.out.println("Enter a valid number");
        }
    }
}
