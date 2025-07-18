import java.util.*;
import java.util.regex.*;

public class DoctorManagement {
    private String doctorId;
    private String doctorName;
    private String doctorGender;
    private String doctorMobileno;
    private String doctorSpecialization;
    private String doctorDepartment;
    private int doctorAge;

    public String getDoctorId() {
        return this.doctorId;
    }

    public String getDoctorName() {
        return this.doctorName;
    }

    public String getDoctorGender() {
        return this.doctorGender;
    }

    public String getDoctorMobileno() {
        return this.doctorMobileno;
    }

    public String getDoctorSpecialization() {
        return this.doctorSpecialization;
    }

    public String getDoctorDepartment() {
        return this.doctorDepartment;
    }

    public int getDoctorAge() {
        return this.doctorAge;
    }

    public void setDoctorName(String name) {
        doctorName = name;
    }

    public void setDoctorMobileno(String mobile) {
        doctorMobileno = mobile;
    }

    public void setDoctorSpecialization(String specialization) {
        doctorSpecialization = specialization;
    }

    public void setDoctorDepartment(String dept) {
        doctorDepartment = dept;
    }

    public void setDoctorAge(int age) {
        doctorAge = age;
    }
 
    static ArrayList<ArrayList<String>> doctorInfo = new ArrayList<>();
    static ArrayList<ArrayList<String>> doctorProfessionalList = new ArrayList<>();
    static ArrayList<ArrayList<String>> doctorDayAvailability = new ArrayList<>();
    static ArrayList<ArrayList<String>> doctorDateAndTimeAvailability = new ArrayList<>();

    public DoctorManagement(String id, String name) {
        this.doctorId = id;
        this.doctorName = name;
    }

    static {
        intializeDoctors();
    }

    private static void intializeDoctors(){
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1001","Dr Rajesh Kumar","Male","9867453431","Cardiologist","Internal Medicine")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1002","Dr Priya Sharma","female","9976875621","Endocrinologist","Internal Medicine")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1003","Dr Amit Patel","Male","7645324512","Gastroenterologist","Internal Medicine")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1004","Dr Neha Gupta","Female","8675435432","Nephrologist","Internal Medicine")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1005","Dr Anil Desai","Male","6789564798","Pulmonologist","Internal Medicine")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1006","Dr Sunita Reddy","Female","8087457625","Rheumatologist","Internal Medicine")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1007","Dr Vikram Singh","Male","6098756403","General Surgeon","Surgery")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1008","Dr Meena Joshi","Female","7989564323","Cardiothoracic Surgeon","Surgery")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1009","Dr Arjun Malhotra","Male","8879064563","Neurosurgeon","Surgery")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1010","Dr Kavita Rao","Female","6509783456","Orthopedic Surgeon","Surgery")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1011","Dr Sanjay Varma","Male","6547893424","Pediatrician","Children")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1012","Dr Ananya Das","Female","7856344535","Neonatologist","Children")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1013","Dr Ritu Khanna","Female","6587904567","Gynecologist","Obstetrics")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1014","Dr Sameer Khan","Male","7906574637","Neurologist","Internal Medicine")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1015","Dr Pooja Mehta","Female","9076854510","Psychiatrist","Psychiatry")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1016","Dr Rohit Nair","Male","7896546709","Oncologist","Oncology")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1017","Dr Divya Iyer","Female","9087564587","Dermatologist","Dermatology")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1018","Dr Ajay Kapoor","Male","6098675097","ENT specialist","Otolaryngology")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1019","Dr Swati Choudhary","Female","8907675698","Opthalmologist","Opthamology")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1020","Dr Rahul Saxena","Male","9087675678","Anesthesiologist","Surgery")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1021","Dr Arjun Sarkar","Male","8956743423","Emergency Medicine","Emergency Medicine")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1022","Dr Meenakshi","Female","6709842345","Radiologist","Radiology")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1023","Dr Karthik","Male","7896584567","Physiatrist","Rehabilitation")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1024","Dr BhagyaLakshmi","Female","9786564542","Pathologist","Pathalogy")));
        doctorInfo.add(new ArrayList<>(Arrays.asList("D1025","Dr Suresh","Male","978606472","Dentist","Dentistry")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1001","MD(Cardiology)","12")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1002","MD(Endocrinology)","8")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1003","MD(Gastroenterology)","10")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1004","MD(Nephrology)","9")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1005","MD(Pulmonology)","11")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1006","MD(Rheumatology)","7")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1007","MD(Surgery)","15")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1008","MD(Surgery)","14")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1009","MD(Surgery)","16")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1010","MD(Orthopedics)","13")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1011","MD(Pediatrics)","10")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1012","MD(Pediatrics)","9")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1013","MD(Gynecology)","12")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1014","MD(Neurology)","11")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1015","MD(Psychiatry)","8")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1016","MD(Oncology)","10")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1017","MD(Dermatalogy)","7")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1018","MD(Otolaryngology)","9")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1019","MD(Opthalmology)","8")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1020","MD(Anesthesiology)","6")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1021","MD(Emergency Medicine)","5")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1022","MD(Radiology)","7")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1023","MD(Physiatry)","11")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1024","MD(Pathalogy)","12")));
        doctorProfessionalList.add(new ArrayList<>(Arrays.asList("D1025","MD(Dentistry)","10")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Rajesh Kumar","Monday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Rajesh Kumar","Friday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Priya Sharma","Tuesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Priya Sharma","Thursday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Amit Patel","Wednesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Amit Patel","Friday"))); 
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Neha Gupta","Wednesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Neha Gupta","Monday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Anil Desai","Tuesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Anil Desai","Thursday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Sunita Reddy","Friday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Sunita Reddy","Saturday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Vikram Singh","Monday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Vikram Singh","Tuesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Vikram Singh","Wednesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Vikram Singh","Thursday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Vikram Singh","Friday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Meena Joshi","Monday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Meena Joshi","Friday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Arjun Malhotra","Tuesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Kavita Rao","Thursday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Sanjay Verma","Monday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Sanjay Verma","Wednesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Sanjay Verma","Thursday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Sanjay Verma","Friday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Sanjay Verma","Saturday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Ananya Das","Wednesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Ananya Das","Thursday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Ananya Das","Friday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Ritu Khanna","Friday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Ritu Khanna","Saturday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Ritu Khanna","Monday")));  
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Sameer Khan","Thursday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Pooja Mehta","Friday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Rohit Nair","Friday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Rohit Nair","Wednesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Divya Iyer","Tuesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Ajay Kapoor","Friday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Ajay Kapoor","Saturday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Swati Choudhary","Friday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Swati Choudhary","Tuesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Rahul Saxena","Monday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Rahul Saxena","Tueday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Rahul Saxena","Wednesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Rahul Saxena","Thursday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Rahul Saxena","Friday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Rahul Saxena","Saturday")));    
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Arjun Sarkar","Monday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Arjun Sarkar","Wednesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Meenakshi","Monday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Meenakshi","Tuesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Meenakshi","Wednesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Meenakshi","Thursday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Meenakshi","Friday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Karthik","Tuesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Karthik","Saturday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr BhagyaLakshmi","Monday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr BhagyaLakshmi","Tuesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr BhagyaLakshmi","Wednesday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr BhagyaLakshmi","Thursday")));
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr BhagyaLakshmi","Friday"))); 
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Suresh","Sunday"))); 
        doctorDayAvailability.add(new ArrayList<>(Arrays.asList("Dr Suresh","Friday")));         
    }

    public static void createDoctor(String id, String name, String gender, String mobile, String special, String dept) {
        ArrayList<String> details = new ArrayList<>();
        Pattern patternId = Pattern.compile("\\bD[1-9][0-9][0-9][0-9]");
        Matcher matchId = patternId.matcher(id);
        boolean foundid = matchId.matches();
        if(foundid) {
            if(checkById(id).equalsIgnoreCase("No doctor found")) {
                details.add(id);
            }
            else {
                System.out.println("The id already exists!!");
                System.exit(0);
            }            
        }
        else {
            System.out.println("enter a valid id");
            System.exit(0);
        }
        details.add(name);
        details.add(gender);
        Pattern patternMobile = Pattern.compile("\\b[6-9]\\d{9}");
        Matcher matchMobile = patternMobile.matcher(mobile);
        boolean foundmobile = matchMobile.matches();
        if(foundmobile) {
            details.add(mobile);
        }
        else {
            System.out.println("Enter a valid mobile number");
            System.exit(0);
        }
        details.add(special);
        details.add(dept);
        doctorInfo.add(details);
    }

    public static void displayDoctors(ArrayList<ArrayList<String>> list) {
        for(ArrayList<String> li : list) {
            for(String it : li) {
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }

    public static void displayProfessionaldetails(ArrayList<ArrayList<String>> list) {
        for(ArrayList<String> li : list) {
            for(String it : li) {
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }
 
    public static ArrayList<String> displayById(String id) {
        ArrayList<String> foundId = new ArrayList<>();
        for(ArrayList<String> list : doctorInfo) {
            if(list.get(0).equalsIgnoreCase(id)) {
                foundId = list;
            }
        }
        return foundId;
    }

    public static ArrayList<String> displayByName(String name) {
        ArrayList<String> foundName = new ArrayList<>();
        for(ArrayList<String> list : doctorInfo) {
            if(list.get(1).equalsIgnoreCase(name)) {
                foundName = list;
            }
        }
        return foundName;
    }

    public static ArrayList<ArrayList<String>> displayBySpecialization(String special) {
        ArrayList<ArrayList<String>> specilzationList = new ArrayList<>();
        for(ArrayList<String> list : doctorInfo) {
            if(list.get(4).equalsIgnoreCase(special)) {
                specilzationList.add(list);
            }
        }
        return specilzationList;
    }

    public static ArrayList<ArrayList<String>> displayByDepartment(String dept) {
        ArrayList<ArrayList<String>> deptList = new ArrayList<>();
        for(ArrayList<String> list : doctorInfo) {
            if(list.get(5).equalsIgnoreCase(dept)) {
                deptList.add(list);
            }
        }
        return deptList;
    }

    public static void doctorFamilyandProfessionalDetails(String id,String specialization, String experience) {
        ArrayList<String> proList = new ArrayList<>();
        proList.add(id);
        proList.add(specialization);
        proList.add(experience);
        doctorProfessionalList.add(proList);

    }

    public static void createDoctorAvailability(String name, String day) {
        ArrayList<String> avail = new ArrayList<>();
        avail.add(name);
        avail.add(day);
        doctorDayAvailability.add(avail);
    }

    public static ArrayList<String> weeklyAvailabilityOfDoctor(String name) {
        ArrayList<String> weekly = new ArrayList<>();
        for(ArrayList<String> list : doctorDayAvailability) {
            if(list.get(0).equalsIgnoreCase(name)) {
                weekly.add(list.get(1));
            }
        }
        return weekly;
    }

    public static ArrayList<String> dayAvailabilityOfDoctor(String day) {
        ArrayList<String> day1 = new ArrayList<>();
        for(ArrayList<String> list : doctorDayAvailability) {
            if(list.get(1).equalsIgnoreCase(day)) {
                day1.add(list.get(0));
            }
        }
        return day1;
    }

    public static HashMap<String, Integer> noOfDoctorsDepartmentWise() {
        HashMap<String, Integer> noOfDoctors = new HashMap<>();
        for(ArrayList<String> list : doctorInfo) {
            noOfDoctors.put(list.get(5),noOfDoctors.getOrDefault(list.get(5), 0)+1);
        }
        return noOfDoctors;
    }

    public static HashMap<String, Integer> noOfDoctorsSpecializationWise() {
        HashMap<String, Integer> noOfDoctors = new HashMap<>();
        for(ArrayList<String> list : doctorInfo) {
            noOfDoctors.put(list.get(4),noOfDoctors.getOrDefault(list.get(4), 0)+1);
        }
        return noOfDoctors;
    }

    public static HashMap<String, Integer> noOfDoctorsCollegeWise() {
        HashMap<String, Integer> noOfDoctors = new HashMap<>();
        for(ArrayList<String> list : doctorProfessionalList) {
            noOfDoctors.put(list.get(3),noOfDoctors.getOrDefault(list.get(3), 0)+1);
        }
        return noOfDoctors;
    }

    public static void nameUpdation(String name, String upname) {
        for(ArrayList<String> list : doctorInfo) {
            if(list.get(1).equalsIgnoreCase(name)) {
                list.set(1,upname);
            }
        }
    }

    public static void mobileUpdation(String name, String mobile) {
        for(ArrayList<String> list : doctorInfo) {
            if(list.get(1).equalsIgnoreCase(name)) {
                list.set(3,mobile);
            }
        }
    }

    public static void deptUpdation(String name, String dept) {
        for(ArrayList<String> list : doctorInfo) {
            if(list.get(1).equalsIgnoreCase(name)) {
                list.set(5,dept);
            }
        }
    }

    public static void displayAllDoctorDetails(String name) {
        String id = "";
        for(ArrayList<String> list : doctorInfo) {
            if(list.get(1).equalsIgnoreCase(name)) {
                id = list.get(0);
                System.out.println("   Doctor details   ");
                System.out.println("Doctor id: " + list.get(0));
                System.out.println("Name of the Doctor: "+list.get(1));
                System.out.println("Gender of the Doctor: "+list.get(2));
                System.out.println("Mobile number of the Doctor: "+list.get(3));
                System.out.println("Specialization of the Doctor: "+list.get(4));
                System.out.println("Department of the Doctor: "+list.get(5));
            }
        }
        for(ArrayList<String> list : doctorProfessionalList){
            if(list.get(0).equalsIgnoreCase(id)) {
                System.out.println("Specialization: "+list.get(1));
                System.out.println("Experience in years: "+list.get(2));
            }
        }
    }

    public static String checkByName(String name) {
        for(ArrayList<String> list : doctorInfo) {
            for(String it : list) {
                if(name.equalsIgnoreCase(it)) {
                    return it;
                }
            }
        }
        return "No doctor found";
    }

    public static String checkById(String id) {
        for(ArrayList<String> list : doctorInfo) {
            for(String it : list) {
                if(id.equalsIgnoreCase(it)) {
                    return it;
                }
            }
        }
        return "No doctor found";
    }


    public static void doctorStatistics() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number as mentioned below:");
        System.out.println("1.Doctors\n2.Department\n3.Specialization\n4.weekly schedule of a doctor\n5.Doctors availblity on given days");
        int n2 = sc.nextInt();
        switch (n2) {
            case 1:
                displayDoctors(doctorInfo);
                break;
            case 2:
                HashMap<String, Integer> map = noOfDoctorsDepartmentWise();
                if(map.isEmpty()) {
                    System.out.println("No records to display");
                }
                else {
                    for(String i : map.keySet()) {
                        System.out.println(i + " " + map.get(i));
                    }
                }
                break;
            case 3:
                HashMap<String, Integer> map1 = noOfDoctorsSpecializationWise();
                if(map1.isEmpty()) {
                    System.out.println("No records to display");
                }
                else {
                    for(String i : map1.keySet()) {
                        System.out.println(i + " " + map1.get(i));
                    }
                }
                break;
            case 4:
                System.out.println("Enter the name of doctor");
                sc.nextLine();
                String name = sc.nextLine().trim();
                ArrayList<String> list = weeklyAvailabilityOfDoctor(name);
                if(list.isEmpty()) {
                    System.out.println("No doctor name found");
                }
                else {
                    for(String li : list) {
                        System.out.println(li);
                    }
                }
                break;
            case 5:
                System.out.println("Enter the day");
                sc.nextLine();
                String day = sc.nextLine();
                ArrayList<String> li = dayAvailabilityOfDoctor(day);
                if(li.isEmpty()) {
                    System.out.println("No doctor found");
                }
                else {
                    for(String li1 : li) {
                        System.out.println(li1);
                    }
                }
                break;
            default:
                System.out.println("Enter a valid number");
            }
    }

    public static void doctorManagementDisplay() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number as mentioned below");
        System.out.println("1.New Doctor\n2.Doctor Details\n3.Details updation");
        int n = sc.nextInt();
        sc.nextLine();
        if(n == 1) {
            System.out.println("Enter the following details:");
            System.out.println("Enter the id in the format (D[1-9][0-9][0-9][0-9])");
            String id = sc.nextLine();
            System.out.println("Enter the name");
            String name = sc.nextLine();
            System.out.println("Enter the gender");
            String gender = sc.nextLine();
            System.out.println("Enter mobile number:");
            String mobile = sc.nextLine();
            System.out.println("Enter the specialization");
            String special = sc.nextLine();
            System.out.println("Enter the department");
            String dept = sc.nextLine();
            createDoctor(id, name, gender, mobile, special, dept);
            System.out.println("Enter the following details:");
            System.out.println("course,experience");
            String user = sc.nextLine().trim();
            String[] parts = user.split(" ");
            String course = parts[0];
            String experience = parts[1];
            doctorFamilyandProfessionalDetails(id,course,experience);
            System.out.println("Details entered Successfully");
        }
        else if(n == 2) {
            System.out.println("Enter doctor name: ");
            String name = sc.nextLine().trim();
            if(checkByName(name).equalsIgnoreCase("No doctor found")) {
                System.out.println("No doctor found");
            }
            else {
                displayAllDoctorDetails(name);
            }
        }
        else if(n == 3) {
            System.out.println("Enter a number as mentioned below:");
            System.out.println("1.Name\n2.Department\n3.Mobile");
            int n2 = sc.nextInt();
            sc.nextLine();
            switch(n2) {
                case 1:
                    System.out.println("Enter your name:");
                    String s = sc.nextLine();
                    ArrayList<String> list = displayByName(s);
                    if(list.isEmpty()) {
                        System.out.println("No record to update");
                    }
                    else {
                        System.out.println("Enter name to updated:");
                        String name = sc.nextLine();
                        nameUpdation(s, name);
                        System.out.println("Successfully updated");
                        System.out.println(list);
                    }
                    break;
                case 2:
                    System.out.println("Enter your name:");
                    String s1 = sc.nextLine();
                    ArrayList<String> li = displayByName(s1);
                    if(li.isEmpty()) {
                        System.out.println("No record to update");
                    }
                    else {
                        System.out.println("Enter department name:");
                        String dept = sc.nextLine();
                        deptUpdation(s1, dept);
                        System.out.println("Successfully updated");
                        System.out.println(li);
                    }
                    break;
                case 3:
                    System.out.println("Enter your name:");
                    String s2 = sc.nextLine();
                    ArrayList<String> li1 = displayByName(s2);
                    if(li1.isEmpty()) {
                        System.out.println("No record to update");
                    }
                    else {
                        System.out.println("Enter mobile no:");
                        String mobile = sc.nextLine();
                        mobileUpdation(s2, mobile);
                        System.out.println("Successfully updated");
                        System.out.println(li1);
                    }
                    break;
                default:
                    System.out.println("Enter a valid number");
            }
        }
        else {
            System.out.println("Enter a valid number");
        }
    }
}
