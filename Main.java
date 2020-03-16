import java.util.Scanner;
import java.util.ArrayList;

// A class used to the define the methods intiated upon initializaton
class Init {

    // Creates test data to be inserted into the database array list
    public static ArrayList<Patient> TestPatients() {

        ArrayList<Patient> data = new ArrayList<Patient>();

        String [] names = new String[] {"Skye Bradshaw" , "Jaylynn Pennington", "Chaya Short", "Lila Cisneros"};

        String [] dobs = new String[] {"27/03/2001", "29/10/1984", "14/06/2017", "13/03/1978"};

        String [] doAs = new String[] {"30/02/2004", "01/04/1999", "23/06/2017", "30/01/1995"};

        String [] address = new String[] {"70 Purcell Place EIGHTEEN MILE", "82 Plug Street ASHFORD", "42 Nandewar Street BROOKLANA", "38 Jacabina Court MOUNT SAINT THOMAS"};

        String [] phoneNumbers = new String[] {"0491570156", "0491570157", "0491570158", "0491570159"};

        String [] emails = new String[] {"skye@gmail.com", "jaylynn@hotmail.com", "chay@gmail.com", "lila@outlook.com"};

        String[] id = new String[] { "EM8976", "EM3456", "EM1243", "EM8977" };

        String [] docName = new String[] {"Dr. Potter", "Dr. Walker", "Dr. Hunt", "Dr. Munoz"};

        String [] procCode = new String[] {"AC2567", "OO5323", "AC2567", "EF3452"};

        String [] medicareNumbers = new String[] {"6200846221", "3133807101", "5882003591", "4938265721"};

        String [] docMedicare = new String[] {"47997374", "32983400", "18646489", "21185977"};
        double [] bills = new double[] {120.50, 466, 1300.46, 0.00};

        int patientNum = names.length; //amount of patients intially 


        data = genPatients(patientNum, id, names, dobs, doAs, address, phoneNumbers, emails, docName, procCode, medicareNumbers, docMedicare, bills);

        return (data); // returns the finished database
    }

    // Creates init patients using methods defined in the Patient class
    public static ArrayList<Patient> genPatients(int n, String[] id, String[] names, String[] dobs, String[] doAs, String[] address, String[] phone, String[] emails, String[] doc, String[] proc, String[] medNums, String[] docNum, double[] bills) {

        ArrayList<Patient> data = new ArrayList<Patient>();

        // Loops for the amount of patients
        for (int i = 0; i < n; i++) { 
            // Creates a new patient for each loop
            Patient patient = new Patient(id[i], names[i], dobs[i], address[i], emails[i], doc[i], proc[i], doAs[i], phone[i], medNums[i], docNum[i], bills[i]);
            data.add(patient); // adds the patient to the database array list
        }

        return(data); // returns the database array list
    }

}

// Class that defines the patient object and methods of inserting data into said patient object
class Patient {

    String name, dob, address, email, id, docName, procedureCode, doA, phone, medicareNumber, docMedicare;
    double bill;

    // Methods

    // General Constructor for creating a patient given all information
    public Patient(String id, String name, String dob, String address, String email, String doc, String proc, String doA, String phone, String medNum, String docMed, double bills) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.docName = doc;
        this.procedureCode = proc;
        this.doA = doA;
        this.phone = phone;
        this.medicareNumber = medNum;
        this.docMedicare = docMed;
        this.bill = bills;
    }

    //Prints all of a patients data, aside from their bills
    public void PrintAll() {
        System.out.println("-------------------------------"); // styling
        System.out.println(""); // styling
        System.out.println("Printing Patient Data"); //styling
        System.out.println(""); // styling
        System.out.println("-------------------------------"); //styling
        System.out.println("Patient Number: " + this.id);
        System.out.println("Procedure Code: " + this.procedureCode);
        System.out.println("Name: " + this.name);
        System.out.println("Date of Birth: " + this.dob);
        System.out.println("Date of Admission: " + this.doA);
        System.out.println("Address: " + this.address);
        System.out.println("Email: " + this.email);
        System.out.println("Medicare Number: " + this.medicareNumber);
        System.out.println("Phone Number: " + this.phone);
        System.out.println("Doctor Name: " + this.docName);
        System.out.println("Doctor Medicare Number: " + this.docMedicare);
    }

}

// Class that defines all the methods that regard the insertion of data to the main database
class Insert {

    // Method that creates a new patient object using methods defined in the Patient class
    public static void NewPatient(ArrayList<Patient> db) {

        String patNum, name, procCode, dob, doa, address, email, phone, doc, medNum, docMed;

        Scanner inputObj = new Scanner(System.in);

        System.out.println("");

        System.out.println("Enter Patient Number: ");
        patNum = inputObj.nextLine();

        System.out.println("Enter Patient Name: ");
        name = inputObj.nextLine();

        System.out.println("Enter Procedure Code: ");
        procCode = inputObj.nextLine();

        System.out.println("Enter Date of Birth: ");
        dob = inputObj.nextLine();

        System.out.println("Enter Date of Admission: ");
        doa = inputObj.nextLine();

        System.out.println("Enter Address: ");
        address = inputObj.nextLine();

        System.out.println("Enter email: ");
        email = inputObj.nextLine();
            
        System.out.println("Enter medicare number: ");
        medNum = inputObj.nextLine();

        System.out.println("Enter phone number: ");
        phone = inputObj.nextLine();
        
        System.out.println("Enter doctor name: ");
        doc = inputObj.nextLine();

        System.out.println("Enter doctor medicare number: ");
        docMed = inputObj.nextLine();
        
        Patient patient = new Patient(patNum, name, dob, address, email, doc, procCode, doa, phone, medNum, docMed, 0); // creates a new patient object using the general patient method 

        db.add(patient); // Adds the patient to the database array list
        System.out.println("");
        System.out.println("-------------------------------"); // styling
        System.out.println("Patient succesfully added");
        System.out.println("-------------------------------"); // styling
    }
}

// Class that defines the methods that refer to the retrieval of data from the database array list
class Retrieve {

    public static void Interface(ArrayList<Patient> db) {

        String userIn;
        int size = db.size();
        boolean condition = true;

        Scanner retrieveObj = new Scanner(System.in);

        while (condition) {
            System.out.println(""); // styling
            System.out.println("How would you like to search for the patient?");
            System.out.println("0: Display All Patient Data"); // For Testing purposes
            System.out.println("1: Search by Patient Number");

            userIn = retrieveObj.nextLine();

            // Prints all patient objects in the database array List
            if (userIn.startsWith("0")) {
                for (int i = 0; i < size; i++) {
                    Patient patient = db.get(i);
                    patient.PrintAll();
                }
                condition = false; // Condition to break while loop
            } else if (userIn.startsWith("1")) {
                SearchById(db, size, true);
                condition = false; // breaks while loop
            } else {
                System.out.println("Please enter either 0 or 1");
            }                
        }
    }

    // Method that searches for a specific patient number, then prints all the details assinged to that patient object. Returns the location of the patient in the database array list
    public static int SearchById(ArrayList<Patient> db, int size, boolean print) {
        String id, foundId;

        int location = - 1;
        boolean condition = false;

        Scanner userObj = new Scanner(System.in);

        System.out.println("Enter patient number: ");
        
        id = userObj.nextLine();

        // Conducts a linear search of the entire database to find the patient, exteremly slow, a better searching method would be required for a full release
        for (int i = 0; i < size; i++) {
            foundId = db.get(i).id;

            if (foundId.startsWith(id)) {
                
                System.out.println("Found Patient Number: " + foundId);
                location = i;
                condition = true;   // sets condition = true indicating that the patient exists 
				break;
                
            }
        }

        if (!condition) {
            System.out.println("Patient does not exist."); 
        } else {
            // if print = false then data does not need to be printed so step is skipped
            if (print) {
                Patient patient = db.get(location);
                patient.PrintAll();
            }
        }

        return (location); // returns the location of the patient in the database array list
    }
}

// Main class that handles the main method and what methods the user needs to use according on whether they are admin or public
public class Main {

    // Admin method that directs the user to either the retrieve or insert classes 
    public static void Admin(ArrayList<Patient> db) {

        String userIn;
        boolean main = true;

        while (main) {
            Scanner userObj = new Scanner(System.in);
            System.out.println(""); // Styling
            System.out.println("Input Number Command: ");
            System.out.println("0: Input New Patient Data");
            System.out.println("1: Retrieve Patient Data");
            System.out.println("2: EXIT");

            userIn = userObj.nextLine();
                
            if (userIn.startsWith("0")) { // using .startsWith method as the input seems to have a trailing character and doing so saves time from removing the character
                Insert.NewPatient(db); // Loads the Insert class' interface
            } else if (userIn.startsWith("1")) {
                Retrieve.Interface(db); // Loads the Retrieve class' interface
            } else if (userIn.startsWith("2")) {
                main = false; // Exits admin and ends program
            } else {
                System.out.println("Please enter a valid selection");
            }
        }
    }

    public static void Public(ArrayList<Patient> db) {
        Patient user;
        double payAmnt;
        int location, size;
        String cardNum, cardSec, medNum, refNum; // Might need to dump all values into an array to trick the compiler

        boolean billPayment = true; // Boolean to control the bill payment loop

        size = db.size();

        location = Retrieve.SearchById(db, size, false); // finds the patient in the database array list 

        user = db.get(location); // sets the users patient object as user for easy referal later on in the method

        System.out.println("Current bill: " + user.bill);

        if (user.bill <= 0) {
            System.out.println("You currently have no existing bills");
        } else {
            Scanner inputObj = new Scanner(System.in);

            while (billPayment) {
                System.out.println("Enter amount of money to be payed: ");
            
                try { // Trys to convert the input to an integer 
                    payAmnt = Double.parseDouble(inputObj.nextLine());
                    if (payAmnt <= user.bill) { // Ensures that the user pays only the amount they need to or less
                        
                        System.out.println("Enter credit card number: ");
                        cardNum = inputObj.nextLine();
                        System.out.println("Enter card secuirty code (3 digits on the back): ");
                        cardSec = inputObj.nextLine();
                        System.out.println("Enter medicare number: ");
                        medNum = inputObj.nextLine();
                        System.out.println("Enter reference number: ");
                        refNum = inputObj.nextLine();
                        
                        user.bill -= payAmnt;
    
                        System.out.println("Amount of money left on bill: " + user.bill);
    
                        billPayment = false; // ends the payment loop
                    } else {
                        System.out.println("Please enter an amount that is equal to or less than the required bill");
                    }
                } catch (ClassCastException e) { // catches error when trying to convert string to int then throws back in loop
                    System.out.println("Please enter a valid amount that does not include ($)");
                }
            }
        }
    }
    
    public static void main(String [] args) {
        String input, passwd;
        
        boolean mainLoop = true;

        passwd = "admin";

        ArrayList<Patient> db = new ArrayList<Patient>();
        db = Init.TestPatients();
        
        Scanner userIn = new Scanner(System.in);

        while (mainLoop) {
            System.out.println("Load Section:");
            System.out.println("0: Admin");
            System.out.println("1: Public Section");
            System.out.println("2: Exit");
    
            input = userIn.nextLine();
            
            // If user selects admin then the admin method is loaded 
            if (input.startsWith("0")) {
    
                System.out.println("Enter password: ");
                String userPass = userIn.nextLine();
                System.out.println(""); // Styling
    
                if (userPass.startsWith(passwd)) { // Checks that user is registered admin
                    Admin(db);
                    System.out.println("");
                } else {
                    System.out.println("Incorrect");
                }
    
            } else if (input.startsWith("1")) { // Else loads public method 
                Public(db);
                System.out.println("");
            } else if (input.startsWith("2")) {
                mainLoop = false;
            } else {
                System.out.println("Please select either 0 or 1");
            }
        }

        userIn.close();
        return; // Exits no exit message
    }
}