import java.util.*;
import java.util.regex.*;

public class PharamacyAndBillRecords{

    static ArrayList<ArrayList<String>> tablets = new ArrayList<>();
    static ArrayList<ArrayList<String>> injuries = new ArrayList<>();
    static ArrayList<ArrayList<String>> billRecordList = new ArrayList<>();

    static {
        initializeBillRecordList();
        initializetablets();
        initializeInjuriesTreatment();
    }

    private static void initializeBillRecordList() {
        billRecordList.add(new ArrayList<>(Arrays.asList("B1001","Ramesh Patel","Indigestion","₹2120","Ranitidine(6)")));
        billRecordList.add(new ArrayList<>(Arrays.asList("B1002","Sunita Sharma","High risk pregnency","₹30000","surgery")));
    }

    private static void initializetablets() {
        tablets.add(new ArrayList<>(Arrays.asList("Paracetamol 500mg", "₹8.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Aspirin 75mg", "₹12.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Naproxen 250mg", "₹24.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Amoxicillin 500mg", "₹40.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Ciprofloxacin 500mg", "₹64.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Metronidazole 400mg", "₹32.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Amlodipine 5mg", "₹24.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Hydrochlorothiazide 25mg", "₹16.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Ranitidine 150mg", "₹20.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Cetirizine 10mg", "₹20.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Vitamin C 500mg", "₹8.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Vitamin D 1000IUmg", "₹12.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Calcium 600mg", "₹16.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Iron 65mg", "₹20.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Multivitamin", "₹24.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Neosporin", "₹91.00")));
        tablets.add(new ArrayList<>(Arrays.asList("Ibuprofen 400mg", "₹16.00")));
    }

    private static void initializeInjuriesTreatment() {
        injuries.add(new ArrayList<>(Arrays.asList("Sprain","₹4072","X-Ray,bandage,Aspirin(6)","outpatient","Dr Kavita Rao")));
        injuries.add(new ArrayList<>(Arrays.asList("Cut","₹5000","Cleaning,dressing,bandage","outpatient","Dr Divya Iyer")));
        injuries.add(new ArrayList<>(Arrays.asList("burn or 1st degree","₹3000","Ointment,dressing,bandage","outpatient","Dr Divya Iyer")));
        injuries.add(new ArrayList<>(Arrays.asList("broken","4572","Splint,X-ray,Aspirin(6)","outpatient","Dr Kavita Rao")));
        injuries.add(new ArrayList<>(Arrays.asList("Insect Bite or Small Allergy","₹1000","cetirizine,Observation","outpatient","Dr Ajay Kapoor")));
        injuries.add(new ArrayList<>(Arrays.asList("Dislocated","₹6500","Manual repoisitiong,sling","outpatient","Dr Kavita Rao")));
        injuries.add(new ArrayList<>(Arrays.asList("Dental Injury","₹4500","Boarding,filling","outpatient","Dr Suresh")));
        injuries.add(new ArrayList<>(Arrays.asList("Neck Strain","₹6072","X-ray,Aspirin(6)","outpatient","Dr Kavita Rao")));
        injuries.add(new ArrayList<>(Arrays.asList("Minor fracture","₹40000","ORIF surgery","outpatient","Dr Kavitha Rao")));
        injuries.add(new ArrayList<>(Arrays.asList("Head Injury","₹1500000","Surgery","inpatient","Dr Sameer Khan")));
        injuries.add(new ArrayList<>(Arrays.asList("Major burn or 2nd degree or 3rd degree","₹100000","Skin grafts","inpatient","Dr Divya Iyer")));
        injuries.add(new ArrayList<>(Arrays.asList("GunShot or stab","₹50000","Surgery","inpatient","Dr Vikram Singh")));
        injuries.add(new ArrayList<>(Arrays.asList("Spinal cord Injury","₹2000000","surgery","inpatient","Dr Sameer Khan")));
        injuries.add(new ArrayList<>(Arrays.asList("Compound fracture","₹75000","surgery","inpatient","Dr Kavita Rao")));
        injuries.add(new ArrayList<>(Arrays.asList("Accident","₹2500000","surgery","inpatient","Dr Arjun Sarkar")));
        injuries.add(new ArrayList<>(Arrays.asList("Organ damage","₹3000000","Surgery","inpatient","Dr Priya Sharma")));
        injuries.add(new ArrayList<>(Arrays.asList("heart attack","₹3500000","Angioplasty","inpatient","Dr Rajesh Kumar")));
        injuries.add(new ArrayList<>(Arrays.asList("chest burn or heart burn or acidity or Indigestion","₹2120","Ranitidine(6)","outpatient","Dr Amit Patel")));
        injuries.add(new ArrayList<>(Arrays.asList("Pregnency or PCOD or abortion","₹5000","General checkup","outpatient","Dr Ritu Khanna")));
        injuries.add(new ArrayList<>(Arrays.asList("high risk pregnency or delivery","₹30000","surgery","inpatient","Dr Ritu Khanna")));
        injuries.add(new ArrayList<>(Arrays.asList("headache","₹172","paracetamol(9)","outpatient","Dr Sanjay Varma")));
        injuries.add(new ArrayList<>(Arrays.asList("cold or cough","₹420","Amoxicilline(3),cetrizine(9)","outpatient","Dr Ananya Das")));
        injuries.add(new ArrayList<>(Arrays.asList("fever(cholera,dengue,malaria)","₹500","bloodtest,saline","inpatient","Dr Sanjay Varma")));
        injuries.add(new ArrayList<>(Arrays.asList("Normal fever","₹272","paracetamol(9)","outpatient","Dr Ananya Das")));        
    }

    public static double buyTablets(String tabletName, int n) {
        double cost = 0.00;
        Pattern pattern = Pattern.compile(tabletName,Pattern.CASE_INSENSITIVE);
        for(ArrayList<String> li : tablets) {
            Matcher match = pattern.matcher(li.get(0));
            boolean found = match.find();
            if(found) {
                String numericValue = li.get(1).replace("₹","").trim();
                cost = Double.parseDouble(numericValue);  
                return (n * cost);        
            }
        }
        return 0.00;
    }

    public static ArrayList<String> amountAndTreatment(String reason) {
        ArrayList<String> list = new ArrayList<>();
        for(ArrayList<String> li : injuries) {
            Pattern pattern = Pattern.compile(li.get(0),Pattern.CASE_INSENSITIVE);
            Matcher match = pattern.matcher(reason);
            boolean found = match.find();
            if(found) {
                return new ArrayList<>(Arrays.asList(li.get(1),li.get(2)));
            }
        }
        return list;
    }
    
    public static String patient_status(String reason) {
        Pattern pattern = Pattern.compile(reason,Pattern.CASE_INSENSITIVE);
        for(ArrayList<String> li : injuries) {            
            Matcher match = pattern.matcher(li.get(0));
            boolean find = match.find();
            if(find) {
                return li.get(3);
            }
        }
        return "outpatient";     
    } 

    public static String doctor(String reason) {
        String doctor = "";
        Pattern pattern = Pattern.compile(reason);
        for(ArrayList<String> li : injuries) {
            Matcher match = pattern.matcher(li.get(0));
            boolean find = match.find();
            if(find) {
                doctor = li.get(4);
            }
        }
        return doctor;
    }

    public static void displayBillRecords() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How can I help you?");
        System.out.println("Enter a number as mentioned below:");
        System.out.println("1.New Bill record\n2.Display Bill record\n3.Tablets");
        int n = sc.nextInt();
        sc.nextLine();
        switch(n) {
            case 1:
                ArrayList<String> li = new ArrayList<>();
                System.out.println("Enter the following details:");
                System.out.println("Enter bill id format(B[1-9][0-9][0-9][0-9]):");
                String id = sc.nextLine();
                Pattern pattern = Pattern.compile("\\bB[1-9][0-9][0-9][0-9]");
                Matcher match = pattern.matcher(id);
                boolean found = match.matches();
                if(found) {
                    if(getName(id).equalsIgnoreCase("No patient found")) {
                        li.add(id);
                    }
                    else {
                        System.out.println("The id already exists!!");
                        System.exit(0);
                    }
                }                
                System.out.println("Enter patient name:");
                String name = sc.nextLine();
                li.add(name);
                String reason = null;
                for(ArrayList<String> list : PatientManagement.patientAdmittedReasonList) {
                    if(list.get(1).equalsIgnoreCase(name)) {
                        li.add(list.get(3));
                        reason = list.get(3);
                        break;
                    }
                }
                if(reason == null || reason.isEmpty()) {
                    System.out.println("No patient found");
                }
                else {
                    ArrayList<String> list = amountAndTreatment(reason);
                    if(list.isEmpty() || list == null) {
                        System.out.println("No record available");
                    }
                    else {
                        li.add(list.get(0));
                        li.add(list.get(1));
                    }
                }
                billRecordList.add(li);
                System.out.println("Record added successfully");
                break;
            case 2:
                System.out.println("Enter patient name:");
                String pname = sc.nextLine().trim();
                String billId = "";
                for(ArrayList<String> list : billRecordList) {
                    if(list.get(1).equalsIgnoreCase(pname)) {
                        billId = list.get(0);
                        break;
                    }
                    else {
                        billId = null;
                    }
                }
                if(billId == null || billId.isEmpty()) {
                    System.out.println("No patient found");
                }
                else {
                    displayBillReceipt(billId);
                }
                break;
            case 3:
                System.out.println("Enter 'quit' to leave:");
                System.out.println("Enter tablet name");
                String tablet = sc.nextLine();
                int n1 = sc.nextInt();
                double cost = 0.00;
                sc.nextLine();
                while(!tablet.equalsIgnoreCase("quit")){
                    cost += buyTablets(tablet, n1);
                    System.out.println("Enter tablet name:");
                    tablet = sc.nextLine();
                    if(tablet.equalsIgnoreCase("quit")) {
                        break;
                    }
                    n1 = sc.nextInt();
                    sc.nextLine();
                }
                System.out.println("You have to pay: "+cost);
                break;
            default:
                System.out.println("Enter a valid number");
        }
    }

    public static String getName(String billId) {
        for(ArrayList<String> li : billRecordList) {
            if(li.get(0).equalsIgnoreCase(billId)) {
                return li.get(1);
            }
        }
        return "No patient found";
    }

    public static void displayBillReceipt(String billId) {
        for(ArrayList<String> li : billRecordList) {
            if(li.get(0).equalsIgnoreCase(billId)) {
                System.out.println("   ABC HOSPITALS   ");
                System.out.println("Bill number: " + billId);
                if(getName(billId).equalsIgnoreCase("no patient found")) {
                    System.out.println("No name found!!!Exiting");
                    System.exit(0);
                }
                else {
                    System.out.println("Name of the recipient: " + getName(billId));
                }
                System.out.println("Admitted Reason: " + li.get(2));
                System.out.println("Medication received: " + li.get(4));
                System.out.println("Amount paid: " + li.get(3));
                System.out.println("Payment status: " + "Paid");
                System.out.println("Thank you!!");
            }
        }
    }
}