import java.util.*;
import java.util.regex.*;
import java.time.*;

public class PatientManagement {
    private String patientId;
    private String patientName;
    private String patientGender;
    private String patientMobileno;
    private String patientAddress;
    private String patientAge;

    static ArrayList<ArrayList<String>> patientInfo = new ArrayList<>();
    static ArrayList<ArrayList<String>> patientVitalSigns = new ArrayList<>();
    static ArrayList<String> patientBloodPressureList = new ArrayList<>();
    static ArrayList<String> patientWeightList = new ArrayList<>();
    static ArrayList<String> patienttemperatureList = new ArrayList<>();
    static ArrayList<ArrayList<String>> patientAdmittedReasonList = new ArrayList<>();

    static {
        initializePatients();
    }

    private static void initializePatients() {
        patientInfo.add(new ArrayList<>(Arrays.asList("P1001","Ramesh Patel","Male","7980678907","Surya Patel","45")));
        patientInfo.add(new ArrayList<>(Arrays.asList("P1002","Sunita Sharma","Female","9087675667","Malavika Sharma","32")));
        patientInfo.add(new ArrayList<>(Arrays.asList("P1003","Vikram Desai","Male","8097675647","Suraj Desai","58")));
        patientInfo.add(new ArrayList<>(Arrays.asList("P1004","Anjali Mehta","Female","7896578760","Arjun Mehta","28")));
        patientInfo.add(new ArrayList<>(Arrays.asList("P1005","Prakash Josi","Male","6089745892","Pavitra Josi","65")));
        patientInfo.add(new ArrayList<>(Arrays.asList("P1006","Geeta Reddy","Female","7896754690","Arjun","50")));
        patientInfo.add(new ArrayList<>(Arrays.asList("P1007","Deepak Singh","Male","9087675690","Meena Singh","38")));
        patientInfo.add(new ArrayList<>(Arrays.asList("P1008","Nandini Iyer","Female","9087675678","Chandran Iyer","42")));
        patientInfo.add(new ArrayList<>(Arrays.asList("P1009","Arun Malhotra","Male","8907675647","Sujith Malhotra","55")));
        patientInfo.add(new ArrayList<>(Arrays.asList("P1010","Kavita Rajesh","Female","9089087589","Rajesh","60")));
        patientInfo.add(new ArrayList<>(Arrays.asList("P1011","Rahul Verma","Male","7809564590","Anjali verma","5")));
        patientInfo.add(new ArrayList<>(Arrays.asList("P1012","Priya darshini","Female","6708975689","VenuGopal","3")));
        patientInfo.add(new ArrayList<>(Arrays.asList("P1013","Meenakshi","Female","9870567690","Sudheer Goud","29")));
        patientInfo.add(new ArrayList<>(Arrays.asList("P1014","Sameer Khan","Male","6809456787","Suraj Khan","47")));
        patientInfo.add(new ArrayList<>(Arrays.asList("P1015","Neeta Srinivasan","Female","8097085067","Srinivasan","75")));
        patientVitalSigns.add(new ArrayList<>(Arrays.asList("P1001","37.5","80","175.32","70.34","130","80")));
        patientVitalSigns.add(new ArrayList<>(Arrays.asList("P1002","38.7","76","160.25","60.89","140","85")));
        patientVitalSigns.add(new ArrayList<>(Arrays.asList("P1003","36.8","90","177.30","75.34","135","89")));
        patientVitalSigns.add(new ArrayList<>(Arrays.asList("P1004","37.5","67","165.32","55.00","130","80")));
        patientVitalSigns.add(new ArrayList<>(Arrays.asList("P1005","38.0","75","178.32","75.34","140","90")));
        patientVitalSigns.add(new ArrayList<>(Arrays.asList("P1006","37.5","84","167.27","70.34","130","80")));
        patientVitalSigns.add(new ArrayList<>(Arrays.asList("P1007","39.7","88","179.00","50.34","130","80")));
        patientVitalSigns.add(new ArrayList<>(Arrays.asList("P1008","35.6","110","164.22","87.34","130","80")));
        patientVitalSigns.add(new ArrayList<>(Arrays.asList("P1009","35.0","89","180.32","98.34","130","80")));
        patientVitalSigns.add(new ArrayList<>(Arrays.asList("P1010","38.0","97","165.02","58.34","150","100")));
        patientVitalSigns.add(new ArrayList<>(Arrays.asList("P1011","33.0","55","100.08","30.7","110","70")));
        patientVitalSigns.add(new ArrayList<>(Arrays.asList("P1012","36.0","60","97.80","25.7","110","70")));
        patientVitalSigns.add(new ArrayList<>(Arrays.asList("P1013","37.5","90","165.00","56.09","130","80")));
        patientVitalSigns.add(new ArrayList<>(Arrays.asList("P1014","38.5","80","178.90","71.98","130","80")));
        patientVitalSigns.add(new ArrayList<>(Arrays.asList("P1015","39.5","80","159.32","68.45","150","95")));
        patientAdmittedReasonList.add(new ArrayList<>(Arrays.asList("P1001","Ramesh Patel","outpatient","Indigestion")));
        patientAdmittedReasonList.add(new ArrayList<>(Arrays.asList("P1002","Sunita Sharma","inpatient","High risk pregnency")));
        patientAdmittedReasonList.add(new ArrayList<>(Arrays.asList("P1003","Vikram Desai","outpatient","Neck Strain")));
        patientAdmittedReasonList.add(new ArrayList<>(Arrays.asList("P1004","Anjali Mehta","outpatient","hand cut")));
        patientAdmittedReasonList.add(new ArrayList<>(Arrays.asList("P1005","Prakash Joshi","outpatient","Fracture")));
        patientAdmittedReasonList.add(new ArrayList<>(Arrays.asList("P1006","Geeta Reddy","outpatient","Allergy")));
        patientAdmittedReasonList.add(new ArrayList<>(Arrays.asList("P1007","Deepak Singh","outpatient","broken finger")));
        patientAdmittedReasonList.add(new ArrayList<>(Arrays.asList("P1008","Nandini Iyer","outpatient","acidity")));
        patientAdmittedReasonList.add(new ArrayList<>(Arrays.asList("P1009","Arun Malhotra","inpatient","2nd degree burn")));
        patientAdmittedReasonList.add(new ArrayList<>(Arrays.asList("P1010","Kavita Rajesh","outpatient","minor burn")));
        patientAdmittedReasonList.add(new ArrayList<>(Arrays.asList("P1011","Rahul Verma","outpatient","Insect bite")));
        patientAdmittedReasonList.add(new ArrayList<>(Arrays.asList("P1012","Priya darshini","outpatient","finger cut")));
        patientAdmittedReasonList.add(new ArrayList<>(Arrays.asList("P1013","Meenakshi","outpatient","Pregnency")));
        patientAdmittedReasonList.add(new ArrayList<>(Arrays.asList("P1014","Sameer Khan","inpatient","Accident")));
        patientAdmittedReasonList.add(new ArrayList<>(Arrays.asList("P1015","Neeta Srinivasan","inpatient","Compound fracture")));
    }
    
    public String getPatientId() {
        return this.patientId;
    }

    public String getPatientName() {
        return this.patientName;
    }

    public String getPatientGender() {
        return this.patientGender;
    }

    public String getPatientMobileno() {
        return this.patientMobileno;
    }

    public String getPatientAddress() {
        return this.patientAddress;
    }

    public String getPatientAge() {
        return this.patientAge;
    }

    public void setPatientName(String name) {
        this.patientName = name;
    }

    public void setPatientMobileno(String mobile) {
        this.patientMobileno = mobile;
    }
    public PatientManagement(String id, String name) {
        this.patientId = id;
        this.patientName = name;
    }

    public static void createPatient(String id,String name,String gender,String mobileno,String guardianname,String age) {
        ArrayList<String> details = new ArrayList<>();
        Pattern patternid = Pattern.compile("\\bP[1-9][0-9][0-9][0-9]");
        Matcher match = patternid.matcher(id);
        boolean isfoundid = match.matches();
        if(isfoundid) {
            if(checkById(id).equalsIgnoreCase("No patient found")) {
                details.add(id);
            }
            else {
                System.out.println("The id already exists!!");
                System.exit(0);
            }
        }
        else {
            System.out.println("Enter valid id...");
            System.exit(0);
        }
        details.add(name);
        details.add(gender);
        Pattern patternmobile = Pattern.compile("\\b[6-9]\\d{9}");
        Matcher match1 = patternmobile.matcher(mobileno);
        boolean isfoundmobile = match1.matches();
        if(isfoundmobile) {
            details.add(mobileno);
        }
        else {
            System.out.println("Enter valid phone number");
            System.exit(0);
        }
        details.add(guardianname);
        details.add(age);
        patientInfo.add(details);
        System.out.println("Successfully added");
    }

    public static void patientVitalsigns(String id, double temp, double pulseRate, double height, double weight, int systolic, int diastolic) {
        ArrayList<String> vitalSigns = new ArrayList<>();
        vitalSigns.add(id);
        vitalSigns.add(Double.toString(temp));
        vitalSigns.add(Double.toString(pulseRate));
        vitalSigns.add(Double.toString(height)); 
        vitalSigns.add(Double.toString(weight));
        vitalSigns.add(Integer.toString(systolic));
        vitalSigns.add(Integer.toString(diastolic));
        patientVitalSigns.add(vitalSigns);  
        System.out.println("Successfully added");     
    }

    public static void patientAdmittedReason(String id, String name, String patient_status, String reason) {
        ArrayList<String> list = new ArrayList<>();
        list.add(id);
        list.add(name);
        list.add(patient_status);
        list.add(reason);
        list.add(LocalDate.now().toString());
        list.add(LocalTime.now().toString());
        patientAdmittedReasonList.add(list);
        System.out.println("Successfully added");
    }

    public static void displayInfo(ArrayList<ArrayList<String>> list) {
        for(ArrayList<String> item : list) {
            for(String it : item) {
                System.out.print(it+"  ");
            }
            System.out.println();
        }
    }

    public static void displayVitalSigns(ArrayList<ArrayList<String>> list) {
        for(ArrayList<String> item : list) {
            for(String it : item) {
                System.out.print(it+"  ");
            }
            System.out.println();
        }
    }

    public static String checkByName(String name) {
        for(ArrayList<String> list : patientInfo) {
            for(String it : list) {
                if(name.equalsIgnoreCase(it)) {
                    return it;
                }
            }
        }
        return "No patient found";
    }

    public static String checkById(String id) {
        for(ArrayList<String> list : patientInfo) {
            for(String it : list) {
                if(id.equals(it)) {
                    return it;
                }
            }
        }
        return "No patient found";
    }

    public static ArrayList<String> displaySpecificPatientInfo(String name) {
        ArrayList<String> foundrecord = null;
        for(ArrayList<String> list : patientInfo) {
            if(list.get(1).equalsIgnoreCase(name)) {
                foundrecord = list;
            }
        }
        return foundrecord;
    }

    public static ArrayList<String> displayPatientVitalSigns(String id) {
        ArrayList<String> foundRecord = null;
        for(ArrayList<String> list : patientVitalSigns) {
            if(list.get(0).equalsIgnoreCase(id)) {
                foundRecord = list;
            }
        }
        return foundRecord;
    }

    public static void updateMobileNo(String name, String mobile) {
        for(ArrayList<String> list : patientInfo) {
            if(list.get(1).equalsIgnoreCase(name)) {
                list.set(3,mobile);
            }
        }
    }

    public static void updateName(String name, String upname) {
        for(ArrayList<String> list : patientInfo) {
            if(list.get(1).equalsIgnoreCase(name)) {
                list.set(1,upname);
            }
        }
    }

    public static HashMap<String, Integer> noOfPatientsDividedByGender() {
        HashMap<String, Integer> noOfPatients = new HashMap<>();
        for(ArrayList<String> list : patientInfo) {
            noOfPatients.put(list.get(2),noOfPatients.getOrDefault(list.get(2),0)+1);
        }
        return noOfPatients;
    }

    public String temperature() {
        for(ArrayList<String> list : patientVitalSigns) {
            Double temperature = Double.parseDouble(list.get(1));
            if(temperature > 38.00) {
                patienttemperatureList.add("Fever");
                return "Fever";
            }
            else if(temperature < 35.00) {
                patienttemperatureList.add("Very little temperature");
                return "Very little temperature";
            }
        }
        patienttemperatureList.add("Normal temperature");
        return "Normal temperature";
    }

    public String bmiCalculator() {
        for(ArrayList<String> list : patientVitalSigns) {
            Double height = Double.parseDouble(list.get(3));
            Double weight = Double.parseDouble(list.get(4));
            Double result = (weight)/(height*height);
            if(result < 18.5) {
                patientWeightList.add("Underweight");
                return "Underweight";
            }
            else if(result >= 25 && result <= 29.9) {
                patientWeightList.add("Overweight");
                return "Overweight";
            }
            else if(result >= 30) {
                patientWeightList.add("Obese");
                return "Obese";
            }
        }
        patientWeightList.add("Normal");
        return "Normal";
    }

    public String bpChecker() {
        for(ArrayList<String> list : patientVitalSigns) {
            Integer sys = Integer.parseInt(list.get(5));
            Integer dia = Integer.parseInt(list.get(6));
            if(sys <= 90 && dia <= 60) {
                patientBloodPressureList.add("Low Blood Pressure");
                return "Low Blood Pressure";
            }
            else if(sys >=120 && sys <= 129 && dia <=80) {
                patientBloodPressureList.add("Elevated Blood Pressure");
                return "Elevated Blood Pressure";
            }
            else if(sys >= 130 && sys <= 139 && dia > 80 && dia <= 89) {
                patientBloodPressureList.add("Stage I hypertension");
                return "Stage I hypertension";
            }
            else if(sys >= 140 && sys <= 180 && dia >= 90 && dia <= 120) {
                patientBloodPressureList.add("Stage II hypertension");
                return "Stage II hypertension";
            }
            else if(sys > 180 && dia > 120) {
                patientBloodPressureList.add("Hypertension crisis");                
                return "Hypertension crisis";
            }
        }
        patientBloodPressureList.add("Healthy blood Pressure");
        return "Healthy blood Pressure";
    }

    public static HashMap<String, Integer> noOfPatientsbloodpressurewise() {
        HashMap<String, Integer> map = new HashMap<>();
        for(String list : patientBloodPressureList) {
            map.put(list,map.getOrDefault(list,0)+1);
        }
        return map;
    }

    public static HashMap<String, Integer> noOfPatientsweightwise() {
        HashMap<String, Integer> map = new HashMap<>();
        for(String list : patientWeightList) {
            map.put(list,map.getOrDefault(list,0)+1);
        }
        return map;
    }

    public static HashMap<String, Integer> noOfPatientstemperaturewise() {
        HashMap<String, Integer> map = new HashMap<>();
        for(String list : patienttemperatureList) {
            map.put(list,map.getOrDefault(list,0)+1);
        }
        return map;
    }

    public static HashMap<String, Integer> noOfPatientsreasonwise() {
        HashMap<String, Integer> map = new HashMap<>();
        for(ArrayList<String> list : patientAdmittedReasonList) {
            String one = list.get(2).toLowerCase();
            map.put(one,map.getOrDefault(one, 0)+1);
        }
        return map;
    }

    public static HashMap<String, Integer> patient_status() {
        HashMap<String, Integer> map = new HashMap<>();
        for(ArrayList<String> list : patientAdmittedReasonList) {
            map.put(list.get(2),map.getOrDefault(list.get(2),0)+1);
        }
        return map;
    }

    public static HashMap<String, Integer> age() {
        HashMap<String, Integer> map = new HashMap<>();
        for(ArrayList<String> list : patientInfo) {
            map.put(list.get(list.size() - 1), map.getOrDefault(list.get(list.size() - 1),0) + 1);
        }
        return map;
    }

    public static String admittedReason(String name) {
        String reason = "No patient found";
        for(ArrayList<String> list : patientAdmittedReasonList) {
            if(list.get(1).equalsIgnoreCase(name)) {
                reason = list.get(3);
            }
        }
        return reason;
    }

    public static void displayAllPatientDetails(String name) {
        if(checkByName(name).equalsIgnoreCase("No patient found")) {
            System.out.println(checkByName(name));
        }
        else {
            String id = "";
            for(ArrayList<String> li : patientInfo) {
                if(li.get(1).equalsIgnoreCase(name)) {
                    System.out.println("   Patient Details");
                    id = li.get(0);
                    System.out.println("Patient Id: " + li.get(0));
                    System.out.println("Name of the Patient: " + li.get(1));
                    System.out.println("Gender of the Patient: " + li.get(2));
                    System.out.println("Age of the Patient: " + li.get(5));
                    System.out.println("Guardian of the Patient: " + li.get(4));
                    System.out.println("Mobile no of the Patient: " + li.get(3));
                }
            }
            for(ArrayList<String> li : patientVitalSigns) {
                if(li.get(0).equalsIgnoreCase(id)) {
                    System.out.println("Temperature: "+li.get(1)+"  "+"PulseRate: "+li.get(2));
                    System.out.println("Height: "+li.get(3)+"  "+"Weight: "+li.get(4));
                    System.out.println("Blood Pressure: "+li.get(5)+"/"+li.get(6));
                }
            }
            for(ArrayList<String> li : patientAdmittedReasonList) {
                if(li.get(0).equalsIgnoreCase(id)) {
                    System.out.println("Reason: "+li.get(3));
                    System.out.println("Status: "+li.get(2));
                }
            }
        }
    }

    public static void patientStatistics() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number as mentioned below:");
        System.out.println("1.Patient\n2.Gender\n3.Temperature\n4.Weight\n5.Blood Pressure\n6.Reason\n7.Patient status\n8.Age");
        int n2 = sc.nextInt();
        switch(n2) {
            case 1:
                displayInfo(patientInfo);
                break;
            case 2:
                HashMap<String, Integer> map = noOfPatientsDividedByGender();
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
                HashMap<String, Integer> map1 = noOfPatientstemperaturewise();
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
                HashMap<String, Integer> map2 = noOfPatientsweightwise();
                if(map2.isEmpty()) {
                    System.out.println("No records to display");
                }
                else {
                    for(String i : map2.keySet()) {
                        System.out.println(i + " " + map2.get(i));
                    }
                }
                break;
            case 5:
                HashMap<String, Integer> map3 = noOfPatientsbloodpressurewise();
                if(map3.isEmpty()) {
                    System.out.println("No records to display");
                }
                else {
                    for(String i : map3.keySet()) {
                        System.out.println(i + " " + map3.get(i));
                    }
                }
                break;
            case 6:
                HashMap<String, Integer> map4 = noOfPatientsreasonwise();
                if(map4.isEmpty()) {
                    System.out.println("No records to display");
                }
                else {
                    for(String i : map4.keySet()) {
                        System.out.println(i + " " + map4.get(i));
                    }
                }
                break;
            case 7:
                HashMap<String, Integer> map5 = patient_status();
                if(map5.isEmpty()) {
                    System.out.println("No records to display");
                }
                else {
                    for(String i : map5.keySet()) {
                        System.out.println(i + " " + map5.get(i));
                    }
                }
                break;
            case 8:
                HashMap<String, Integer> map6 = age();
                if(map6.isEmpty()) {
                    System.out.println("No records to display");
                }
                else {
                    for(String i : map6.keySet()) {
                        System.out.println(i + " " + map6.get(i));
                    }
                }
                break;
            default:
                System.out.println("Enter a valid number");
        }
    }

    public static void patientManagementDisplay() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number as mention below");
        System.out.println("1.Patient admission\n2.Patient Info\n3.Patient details updation");
        int n1 = sc.nextInt();
        sc.nextLine();
        if(n1 == 1) {
            System.out.println("Enter the following details");
            System.out.println("Enter patient details in order:");
            System.out.println("Enter id format(P[1-9][0-9][0-9][0-9]):");
            String id = sc.nextLine().trim();
            System.out.println("Enter name:");
            String name = sc.nextLine().trim();
            System.out.println("Enter gender:");
            String gender = sc.nextLine().trim();
            System.out.println("Enter mobile no:");
            String mobile = sc.nextLine().trim();
            System.out.println("Enter guardianName:");
            String guardianname = sc.nextLine().trim();
            System.out.println("Enter age:");
            String age = sc.nextLine();
            createPatient(id,name,gender,mobile,guardianname,age);
            System.out.println("Enter the temperature, pulseRate, height, weight, systolic, diastolic details of the patient");
            String userInput = sc.nextLine().trim();
            String parts[] = userInput.split(" ");
            Double temp = Double.parseDouble(parts[0]);
            Double pulse = Double.parseDouble(parts[1]);
            Double height = Double.parseDouble(parts[2]);
            Double weight = Double.parseDouble(parts[3]);
            Integer sys = Integer.parseInt(parts[4]);
            Integer dia = Integer.parseInt(parts[5]);
            patientVitalsigns(id, temp, pulse, height, weight, sys, dia);
            System.out.println("Enter admitted reason:");
            String reason = sc.nextLine();
            String status = PharamacyAndBillRecords.patient_status(reason);
            patientAdmittedReason(id, name, status, reason);
        }
        else if(n1 == 2) {
            System.out.println("Enter patient name");
            String n4 = sc.nextLine().trim();
            if(checkByName(n4).equalsIgnoreCase("No patient found")) {
                System.out.println(checkByName(n4));
            }
            else {
                displayAllPatientDetails(n4);
            }
        }
        else if(n1 == 3) {
            System.out.println("What would you like to update");
            System.out.println("1.Name\n2.Mobile");
            int n = sc.nextInt();
            sc.nextLine();
            switch(n) {
                case 1:
                System.out.println("Enter previous name:");
                String name = sc.nextLine();
                if(checkByName(name).equalsIgnoreCase("No patient found")) {
                    System.out.println("No patient name found");
                }
                else {
                    System.out.println("Enter the updation name:");
                    String s = sc.nextLine();
                    updateName(name, s);
                    ArrayList<String> list = displaySpecificPatientInfo(name);
                    System.out.println(list);
                    System.out.println("Updated successfully");
                }
                break;
                case 2:
                System.out.println("Enter patient name");
                String name1 = sc.nextLine();
                if(checkByName(name1).equalsIgnoreCase("No patient found")) {
                    System.out.println("No patient name found");
                }
                else {
                    System.out.println("Enter the mobile no:");
                    String mobile = sc.nextLine();
                    Pattern pat = Pattern.compile("\\b[6-9]\\d{9}");
                    Matcher match = pat.matcher(mobile);
                    boolean found = match.matches();
                    if(found) {
                        updateMobileNo(name1, mobile);
                        ArrayList<String> list = displaySpecificPatientInfo(name1);
                        System.out.println(list);
                        System.out.println("Updated successfully");
                    }
                    else {
                        System.out.println("Enter valid mobile no");
                        System.exit(0);
                    }
                }
                break;
                default:
                System.out.println("No other details will be updated");
            }
        }
        else {
            System.out.println("Enter a valid name");
        }             

    }
}
