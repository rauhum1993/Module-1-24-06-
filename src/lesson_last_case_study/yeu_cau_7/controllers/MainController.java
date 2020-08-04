package lesson_last_case_study.yeu_cau_7.controllers;

import lesson_last_case_study.yeu_cau_7.commos.ReadWriteFile;
import lesson_last_case_study.yeu_cau_7.exception.*;
import lesson_last_case_study.yeu_cau_7.models.Customer;
import lesson_last_case_study.yeu_cau_7.models.House;
import lesson_last_case_study.yeu_cau_7.models.Room;
import lesson_last_case_study.yeu_cau_7.models.Villa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {


    public static final String FILE_VILLA = "src/lesson_last_case_study/yeu_cau_7/data/Villa.csv";
    public static final String FILE_ROOM = "src/lesson_last_case_study/yeu_cau_7/data/Room.csv";
    public static final String FILE_HOUSE = "src/lesson_last_case_study/yeu_cau_7/data/House.csv";
    public static final String FILE_CUSTOMER = "src/lesson_last_case_study/yeu_cau_7/data/Customer.csv";

//    ----------------------------------------------------------------------------------------------------------


    public static List<Room> rooms = new ArrayList<>();
    public static List<Villa> villas = new ArrayList<>();
    public static List<House> houses = new ArrayList<>();
    public static List<Customer> customers = new ArrayList<>();

    //------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        displayMainMenu(scanner);


    }

    static void displayMainMenu(Scanner scanner) {

        System.out.println("--------------MENU---------------" + "\n" +
                "1. Add New Services " + "\n" +
                "2.	Show Services" + "\n" +
                "3.	Add New Customer" + "\n" +
                "4.	Show Information of Customer" + "\n" +
                "5.	Add New Booking" + "\n" +
                "6.	Show Information of Employee" + "\n" +
                "7. Exit");
        System.out.println("Please select an item: ");
        int choose = Integer.parseInt(scanner.nextLine());
        while (choose != 0) {
            switch (choose) {
                case 1:
                    addNewServie(scanner);
                    break;
                case 2:
                    showServices(scanner);
                    break;
                case 3:
                    addNewCustomer();
                    displayMainMenu(scanner);
                    break;
                case 4:
                    showInformCustomer();
                    displayMainMenu(scanner);
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                    break;


            }


        }
    }
    private static void addNewBooking() {
        Scanner scanner=new Scanner(System.in);
        ReadWriteFile.readerFile(FILE_CUSTOMER);
        System.out.print("1.\tBooking Villa\n" +
                "2.\tBooking House\n" +
                "3.\tBooking Room\n");
        System.out.println("Please Input choose booking: ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                bookingVilla();
                break;
            case 2:
                bookingHouse();
                break;
            case 3:
                bookingRoom();
                break;
            default:
                System.err.println("The selection is not in the selection list");
        }
    }
    private static void bookingRoom() {
       ReadWriteFile.readerFile(FILE_ROOM);
        for (Room room : rooms) {
            System.out.println(room.toString());
        }

    }

    private static void bookingHouse() {
        ReadWriteFile.readerFile(FILE_HOUSE);
        for (House house : houses) {
            System.out.println(house.toString());
        }
    }

    private static void bookingVilla() {
        Scanner scanner=new Scanner(System.in);

        showInformCustomer();
        System.out.print("Enter choose customer to booking: ");
        int iCustomer = scanner.nextInt();
        showAllVilla();
        System.out.print("Enter Choose Villa to booking: ");
        int iVilla=scanner.nextInt();
        Customer customer = customers.get(iCustomer-1);
//        customer.setUserService(villas.get(iVilla-1));
//        writerFile(customer.toString(),FILE_BOOKING);
    }
    private static void showAllVilla() {
       ReadWriteFile.readerFile(FILE_VILLA);
        Villa villa = null;
        for (int i = 0; i < villas.size(); i++) {
            villa = villas.get(i);
            System.out.print((i + 1) + ". ");
            villa.showInfor();
        }

    }

    private static void showInformCustomer() {
        ReadWriteFile.readerFile(FILE_CUSTOMER);
        Customer customer = null;
        Collections.sort(customers);
        for (int i = 0; i < customers.size(); i++) {
            customer = customers.get(i);
            System.out.print((i + 1) + ". ");
            System.out.print(customer.showInformationCustomers());
            System.out.println("\n");
            ;
        }
    }


    private static void showServices(Scanner scanner) {
        System.out.println("---SHOW SERVICES----" + "\n" +
                "1.\tShow all Villa\n" +
                "2.\tShow all House\n" +
                "3.\tShow all Room\n" +
                "4.\tShow All Name Villa Not Duplicate\n" +
                "5.\tShow All Name House Not Duplicate\n" +
                "6.\tShow All Name Name Not Duplicate\n" +
                "7.\tBack to menu\n" +
                "8.\tExit\n");
        System.out.println("Please select an item: ");
        int chooseShowServices = Integer.parseInt(scanner.nextLine());
        while (chooseShowServices != 0) {
            switch (chooseShowServices) {
                case 1:
                    ReadWriteFile.readerFile(FILE_VILLA);
                    for (Villa villa : villas) {
                        System.out.println(villa.showInfor());
                    }
//                    ReadWriteFile.readerFile(FILE_VILLA);
//                    Villa villa = null;
//                    for (int i = 0; i < villas.size(); i++) {
//                        villa = villas.get(i);
//                        System.out.print((i + 1) + ". ");
//                        System.out.print(villa.showInfor());
//                        System.out.println("\n");
//                        ;
//                    }
                    showServices(scanner);
                    break;
                case 2:
                    ReadWriteFile.readerFile(FILE_HOUSE);
                    for (House house : houses) {
                        System.out.println(house.showInfor());
                    }
                    showServices(scanner);
                    break;
                case 3:
                    ReadWriteFile.readerFile(FILE_ROOM);
                    for (Room room : rooms) {
                        System.out.println(room.showInfor());
                    }

                    showServices(scanner);
                    break;
                case 4:

                    showServices(scanner);
                    break;
                case 5:

                    showServices(scanner);
                    break;
                case 6:

                    showServices(scanner);
                    break;
                case 7:
                    displayMainMenu(scanner);
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void addNewServie(Scanner scanner) {
        System.out.println("----------ADD NEW VILLA---------" + "\n" +
                "1.\tAdd New Villa\n" +
                "2.\tAdd New House\n" +
                "3.\tAdd New Room\n" +
                "4.\tBack to menu\n" +
                "5.\tExit\n");
        System.out.println("Please select an item: ");
        int chooseAdd = Integer.parseInt(scanner.nextLine());
        while (chooseAdd != 0) {
            switch (chooseAdd) {
                case 1:
                    addFileVilla(scanner);


                    addNewServie(scanner);
                    break;
                case 2:
                    addFileHouse(scanner);
                    addNewServie(scanner);
                    break;
                case 3:
                    addFileRoom(scanner);
                    addNewServie(scanner);
                    break;
                case 4:
                    displayMainMenu(scanner);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void addFileRoom(Scanner scanner) {

        boolean check = false;
        System.out.println("---Enter Properties Room ---");


        String idRoom;
        do {
            System.out.println("1. Enter Id (Enter the word):");
            idRoom = scanner.nextLine();
            Pattern p = Pattern.compile("SVRO(-)[0-9]{4}");
            Matcher m = p.matcher(idRoom);
            if (m.find() == false) {
                System.out.println("Enter the wrong ID format ");
                check = false;
            } else {
                System.out.println(" Enter successful ID");
                check = true;
            }
        } while (!check);
        String nameRoom;
        do {
            System.out.println("2. Enter Name Room (Enter the word ):");
            nameRoom = scanner.nextLine();
            Pattern p = Pattern.compile("^(([A-Z][a-z]*((\\s)))+[A-Z][a-z]*)|([A-Z]([a-z]*))$");
            Matcher m = p.matcher(nameRoom);
            if (!m.matches()) {
                System.out.println("Enter the wrong name room format ");
                check = false;
            } else {
                System.out.println(" Enter successful name room");
                check = true;
            }
        } while (!check);


        double areaUseRoom = 0;
        check = false;
        do {
            try {
                System.out.println("3. Enter area Use (Enter number bigger than 30 square meters): ");
                areaUseRoom = Double.parseDouble(scanner.nextLine());
                if (areaUseRoom >= 30) {

                    System.out.println("Enter successful the area use");
                    check = true;
                } else {
                    System.out.println("Enter the wrong the area use format");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Enter is not a number ");
                check = false;
            }
        } while (!check);


        double rentalCostRoom = 0;
        check = false;
        do {
            try {
                System.out.println("4. Enter Rental Cost (Enter number is greater than 0):");
                rentalCostRoom = Double.parseDouble(scanner.nextLine());
                if (rentalCostRoom > 0) {
                    System.out.println("Enter successful the rental costs    ");
                    check = true;
                } else {
                    System.out.println("Enter the wrong the rental costs format");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Enter is not a number ");
                check = false;
            }
        } while (!check);


        int maximumPeopleRoom = 0;
        check = false;
        do {
            try {
                System.out.println("5. Enter Maximum People (Enter numbers greater than 0 and less than 20):");
                maximumPeopleRoom = Integer.parseInt(scanner.nextLine());
                if (maximumPeopleRoom <= 0 || maximumPeopleRoom > 20) {
                    System.out.println("Enter the wrong the maximum people format");
                    check = false;
                } else {
                    System.out.println("Enter successful the maximum people");
                    check = true;
                }
            } catch (Exception e) {
                System.out.println("Enter is not a number ");
                check = false;
            }
        } while (!check);


        String typeOfRentRoom;

        check = false;
        do {
            System.out.println("6. Enter Type Of Rent (Enter the word ):");
            typeOfRentRoom = scanner.nextLine();
            Pattern p = Pattern.compile("^(([A-Z][a-z]*((\\s)))+[A-Z][a-z]*)|([A-Z]([a-z]*))$");
            Matcher m = p.matcher(typeOfRentRoom);
            if (!m.matches()) {
                System.out.println("Enter the wrong type of rent format ");
                check = false;
            } else {
                System.out.println(" Enter successful type of rent");
                check = true;
            }
        } while (!check);


        System.out.println("7. Enter free Service Included (Enter the word): ");
        String freeServiceIncluded = scanner.nextLine();


        rooms.add(new Room(idRoom, nameRoom, areaUseRoom, rentalCostRoom,
                maximumPeopleRoom, typeOfRentRoom, freeServiceIncluded));

        ReadWriteFile.writerFile(rooms.get(0).getId() + ",", FILE_ROOM);
        ReadWriteFile.writerFile(rooms.get(0).getNameServices() + ",", FILE_ROOM);
        ReadWriteFile.writerFile(rooms.get(0).getAreaUse() + ",", FILE_ROOM);
        ReadWriteFile.writerFile(rooms.get(0).getRentalCost() + ",", FILE_ROOM);
        ReadWriteFile.writerFile(rooms.get(0).getMaximumPeople() + ",", FILE_ROOM);
        ReadWriteFile.writerFile(rooms.get(0).getTypeOfRent() + ",", FILE_ROOM);
        ReadWriteFile.writerFile(rooms.get(0).getFreeServiceIncluded(), FILE_ROOM);
        ReadWriteFile.writerFile("\n", FILE_ROOM);
        rooms.clear();
    }


    private static void addFileHouse(Scanner scanner) {
        boolean check = false;
        System.out.println("---Enter Properties House ---");

        String idHouse;
        do {
            System.out.println("1. Enter Id (Enter the word):");
            idHouse = scanner.nextLine();
            Pattern p = Pattern.compile("SVHO(-)[0-9]{4}");
            Matcher m = p.matcher(idHouse);
            if (m.find() == false) {
                System.out.println("Enter the wrong ID format ");
                check = false;
            } else {
                System.out.println(" Enter successful ID");
                check = true;
            }
        } while (!check);

        String nameHouse;
        do {
            System.out.println("2. Enter Name House (Enter the word ):");
            nameHouse = scanner.nextLine();
            Pattern p = Pattern.compile("^(([A-Z][a-z]*((\\s)))+[A-Z][a-z]*)|([A-Z]([a-z]*))$");
            Matcher m = p.matcher(nameHouse);
            if (!m.matches()) {
                System.out.println("Enter the wrong name house format ");
                check = false;
            } else {
                System.out.println(" Enter successful name house");
                check = true;
            }
        } while (!check);


        double areaUseHouse = 0;
        check = false;
        do {
            try {
                System.out.println("3. Enter area Use (Enter number bigger than 30 square meters): ");
                areaUseHouse = Double.parseDouble(scanner.nextLine());
                if (areaUseHouse >= 30) {

                    System.out.println("Enter successful the area use");
                    check = true;
                } else {
                    System.out.println("Enter the wrong the area use format");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Enter is not a number ");
                check = false;
            }
        } while (!check);


        double rentalCostHoue = 0;
        check = false;
        do {
            try {
                System.out.println("4. Enter Rental Cost (Enter number is greater than 0):");
                rentalCostHoue = Double.parseDouble(scanner.nextLine());
                if (rentalCostHoue > 0) {
                    System.out.println("Enter successful the rental costs    ");
                    check = true;
                } else {
                    System.out.println("Enter the wrong the rental costs format");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Enter is not a number ");
                check = false;
            }
        } while (!check);


        int maximumPeopleHouse = 0;
        check = false;
        do {
            try {
                System.out.println("5. Enter Maximum People (Enter numbers greater than 0 and less than 20):");
                maximumPeopleHouse = Integer.parseInt(scanner.nextLine());
                if (maximumPeopleHouse <= 0 || maximumPeopleHouse > 20) {
                    System.out.println("Enter the wrong the maximum people format");
                    check = false;
                } else {
                    System.out.println("Enter successful the maximum people");
                    check = true;
                }
            } catch (Exception e) {
                System.out.println("Enter is not a number ");
                check = false;
            }
        } while (!check);


        String typeOfRentHouse;
        check = false;
        do {
            System.out.println("6. Enter Type Of Rent (Enter the word ):");
            typeOfRentHouse = scanner.nextLine();
            Pattern p = Pattern.compile("^(([A-Z][a-z]*((\\s)))+[A-Z][a-z]*)|([A-Z]([a-z]*))$");
            Matcher m = p.matcher(typeOfRentHouse);
            if (!m.matches()) {
                System.out.println("Enter the wrong type of rent format ");
                check = false;
            } else {
                System.out.println(" Enter successful type of rent");
                check = true;
            }
        } while (!check);


        String roomStanDardHouse;

        check = false;
        do {
            System.out.println("7. Enter Room StanDard (Enter the word ):");
            roomStanDardHouse = scanner.nextLine();
            Pattern p = Pattern.compile("^(([A-Z][a-z]*((\\s)))+[A-Z][a-z]*)|([A-Z]([a-z]*))$");
            Matcher m = p.matcher(roomStanDardHouse);
            if (!m.matches()) {
                System.out.println("Enter the wrong room standard format ");
                check = false;
            } else {
                System.out.println(" Enter successful room standaed ");
                check = true;
            }
        } while (!check);


        System.out.println("8. Enter Comfort Description (Enter the word):");
        String comfortDescriptionHouse = scanner.nextLine();


        int numberOfFloorsHouse = 0;
        check = false;
        do {
            try {
                System.out.println("9. Enter Number Of Floors (Enter numbers greater than 0 ):");
                numberOfFloorsHouse = Integer.parseInt(scanner.nextLine());
                if (numberOfFloorsHouse < 0) {
                    System.out.println("Enter the wrong the maximum people format");
                    check = false;
                } else {
                    System.out.println("Enter successful the maximum people");
                    check = true;

                }
            } catch (Exception e) {
                System.out.println("Enter is not a number ");
                check = false;
            }
        } while (!check);


        houses.add(new House(idHouse, nameHouse, areaUseHouse, rentalCostHoue, maximumPeopleHouse, typeOfRentHouse,
                roomStanDardHouse, comfortDescriptionHouse, numberOfFloorsHouse));

        ReadWriteFile.writerFile(houses.get(0).getId() + ",", FILE_ROOM);
        ReadWriteFile.writerFile(houses.get(0).getNameServices() + ",", FILE_ROOM);
        ReadWriteFile.writerFile(houses.get(0).getAreaUse() + ",", FILE_ROOM);
        ReadWriteFile.writerFile(houses.get(0).getRentalCost() + ",", FILE_ROOM);
        ReadWriteFile.writerFile(houses.get(0).getMaximumPeople() + ",", FILE_ROOM);
        ReadWriteFile.writerFile(houses.get(0).getTypeOfRent() + ",", FILE_ROOM);
        ReadWriteFile.writerFile(houses.get(0).getRoomStanDard() + ",", FILE_ROOM);
        ReadWriteFile.writerFile(houses.get(0).getComfortDescription() + ",", FILE_ROOM);
        ReadWriteFile.writerFile(houses.get(0).getNumberOfFloors() + "", FILE_ROOM);
        ReadWriteFile.writerFile("\n", FILE_ROOM);
        houses.clear();


    }


    private static void addFileVilla(Scanner scanner) {
        System.out.println("---Enter Properties Villa ---");
        boolean check = false;
        String idVilla;
        do {
            System.out.println("1. Enter Id (Enter the word of the form:  SVXX-YYYY):");
            idVilla = scanner.nextLine();
            Pattern p = Pattern.compile("SVVL(-)[0-9]{4}");
            Matcher m = p.matcher(idVilla);
            if (m.find() == false) {
                System.out.println("Enter the wrong ID format ");
                check = false;
            } else {
                System.out.println(" Enter successful ID");
                check = true;
            }
        } while (!check);


        check = false;
        String nameVilla;
        do {
            System.out.println("2. Enter Name Villa (Enter the word ):");
            nameVilla = scanner.nextLine();
            Pattern p = Pattern.compile("^(([A-Z][a-z]*((\\s)))+[A-Z][a-z]*)|([A-Z]([a-z]*))$");
            Matcher m = p.matcher(nameVilla);
            if (!m.matches()) {
                System.out.println("Enter the wrong name villa format ");
                check = false;
            } else {
                System.out.println(" Enter successful name villa");
                check = true;
            }
        } while (!check);

        check = false;
        double areaUse = 0;
        do {
            try {
                System.out.println("3. Enter area Use (Enter number bigger than 30 square meters): ");
                areaUse = Double.parseDouble(scanner.nextLine());
                if (areaUse >= 30) {

                    System.out.println("Enter successful the area use");
                    check = true;
                } else {
                    System.out.println("Enter the wrong the area use format");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Enter is not a number ");
                check = false;
            }
        } while (!check);


        check = false;
        double rentalCost = 0;
        do {
            try {
                System.out.println("4. Enter Rental Cost (Enter number is greater than 0):");
                rentalCost = Double.parseDouble(scanner.nextLine());
                if (rentalCost > 0) {
                    System.out.println("Enter successful the rental costs    ");
                    check = true;
                } else {
                    System.out.println("Enter the wrong the rental costs format");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Enter is not a number ");
                check = false;
            }
        } while (!check);


        check = false;
        int maximumPeople = 0;
        do {
            try {
                System.out.println("5. Enter Maximum People (Enter numbers greater than 0 and less than 20):");
                maximumPeople = Integer.parseInt(scanner.nextLine());
                if (maximumPeople <= 0 || maximumPeople > 20) {
                    System.out.println("Enter the wrong the maximum people format");
                    check = false;
                } else {
                    System.out.println("Enter successful the maximum people");
                    check = true;

                }
            } catch (Exception e) {
                System.out.println("Enter is not a number ");
                check = false;
            }
        } while (!check);


        String typeOfRent;
        check = false;
        do {
            System.out.println("6. Enter Type Of Rent (Enter the word ):");
            typeOfRent = scanner.nextLine();
            Pattern p = Pattern.compile("^(([A-Z][a-z]*((\\s)))+[A-Z][a-z]*)|([A-Z]([a-z]*))$");
            Matcher m = p.matcher(typeOfRent);
            if (!m.matches()) {
                System.out.println("Enter the wrong type of rent format ");
                check = false;
            } else {
                System.out.println(" Enter successful type of rent");
                check = true;
            }
        } while (!check);

//---------------------------------------------------------------------------------------------------------
        String roomStanDard;
        check = false;
        do {
            System.out.println("7. Enter Room StanDard (Enter the word ):");
            roomStanDard = scanner.nextLine();
            Pattern p = Pattern.compile("^(([A-Z][a-z]*((\\s)))+[A-Z][a-z]*)|([A-Z]([a-z]*))$");
            Matcher m = p.matcher(roomStanDard);
            if (!m.matches()) {
                System.out.println("Enter the wrong room standard format ");
                check = false;
            } else {
                System.out.println(" Enter successful room standaed ");
                check = true;
            }
        } while (!check);

//----------------------------------------------------------------------------------------------------
        System.out.println("8. Enter Comfort Description (Enter the word):");
        String comfortDescription = scanner.nextLine();


//        Enter the pool Area-------------------------------------------------
        check = false;
        double poolArea = 0;
        do {
            try {
                System.out.println("9. Enter Pool Area (Enter number bigger than 30 square meters):");
                poolArea = Double.parseDouble(scanner.nextLine());
                if (poolArea < 30) {
                    System.out.println("Enter the wrong the pool area  format");
                    check = false;
                } else {
                    System.out.println("Enter successful the pool area ");
                    check = true;
                }
            } catch (Exception e) {
                System.out.println("Enter is not a number");
                check = false;
            }
        } while (!check);

//-------------------------------------------------------------------------------------------------------
        int numberOfFloors = 0;
        do {
            try {
                System.out.println("10. Enter Number Of Floors (Enter numbers greater than 0 ):");
                numberOfFloors = Integer.parseInt(scanner.nextLine());
                if (numberOfFloors < 0) {
                    System.out.println("Enter the wrong the maximum people format");
                    check = false;
                } else {
                    System.out.println("Enter successful the maximum people");
                    check = true;

                }
            } catch (Exception e) {
                System.out.println("Enter is not a number ");
                check = false;
            }
        } while (!check);

        villas.add(new Villa(idVilla, nameVilla, areaUse, rentalCost, maximumPeople, typeOfRent,
                roomStanDard, comfortDescription, poolArea, numberOfFloors));

        ReadWriteFile.writerFile(villas.get(0).getId() + ",", FILE_VILLA);
        ReadWriteFile.writerFile(villas.get(0).getNameServices() + ",", FILE_VILLA);
        ReadWriteFile.writerFile(villas.get(0).getAreaUse() + ",", FILE_VILLA);
        ReadWriteFile.writerFile(villas.get(0).getRentalCost() + ",", FILE_VILLA);
        ReadWriteFile.writerFile(villas.get(0).getMaximumPeople() + ",", FILE_VILLA);
        ReadWriteFile.writerFile(villas.get(0).getTypeOfRent() + ",", FILE_VILLA);
        ReadWriteFile.writerFile(villas.get(0).getRoomStanDard() + ",", FILE_VILLA);
        ReadWriteFile.writerFile(villas.get(0).getComfortDescription() + ",", FILE_VILLA);
        ReadWriteFile.writerFile(villas.get(0).getPoolArea() + ",", FILE_VILLA);
        ReadWriteFile.writerFile(villas.get(0).getNumberOfFloors() + "", FILE_VILLA);
        ReadWriteFile.writerFile("\n", FILE_VILLA);
        villas.clear();


    }


    public static void addNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        String nameCustomer = null;
        do {


            System.out.print("Name Customer: ");
            nameCustomer = scanner.nextLine();
            if (nameCustomer == null || !nameCustomer.matches("^(([A-Z][a-z]*((\\s)))+[A-Z][a-z]*)|([A-Z]([a-z]*))$")) {
                try {
                    throw new NameException();
                } catch (NameException e) {
                    System.out.println("Enter wrong name customer . Retype: ");
                    check = false;
                }
            } else {
                check = true;
            }


        } while (!check);

//-----------------------------------------------------------------------------------------------------------
        String birthdayCustomer = null;
        do {

            System.out.print("Input birthday customer: ");
            birthdayCustomer = scanner.nextLine();
            if (birthdayCustomer == null || !birthdayCustomer.matches(
                    "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.]((19\\d{2})|(200[12]))$")) {
                try {
                    throw new BirthdayException();
                } catch (BirthdayException e) {
                    System.out.println("Enter wrong birthday customer. Eptype: ");
                    check = false;
                }
            } else {
                check = true;
            }

        } while (!check);

//  ---------------------------------------------------------- --------------------------------------------------
        String sexCustomer=null;
        String str;
        String str1;
        do {
            try {
                System.out.print("Input gender customer: ");
                sexCustomer = scanner.nextLine();
                if (sexCustomer == null) {
                    throw new GenderException();
                } else {
                    str1 = sexCustomer.trim();
                    str = str1.toLowerCase();
                    sexCustomer = (String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1));
                    if (!sexCustomer.matches("^((Fem|M)ale)|(Unknow)$")) {
                      throw  new GenderException();
                    } else {
                        check = true;
                    }
                }
            }catch (GenderException e){
                System.out.println("Enter wrong Gender customer . Eptype: ");
                check=false;
            }
        } while (!check);

//---------------------------------------------------------------------------------------------------------------------
        String idCard = null;

        check = false;

        do {
            try {
                System.out.print("Input id customer: ");
                idCard = scanner.nextLine();
                if (idCard.matches("\\d{9}")) {
                    check = true;
                    for (int i = 0; i < customers.size(); i++) {
                        if (idCard.equals(customers.get(i).getIdCard())) {
                            throw new IdCardException();
                        } else {
                            check = true;
                        }
                    }
                } else {
                    throw new IdCardException();
                }
            }catch (IdCardException e){
                System.out.println("Enter wrong ID customer.");
                check = false;
            }


        } while (!check);


//  ---------------------------------------------------------------------------------------------------------------


        String phoneNumber;
        check = false;
        do {
            System.out.print("Input Phone number customer: ");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.matches("0\\d{8,10}")) {
                check = true;

            } else {
                check = false;
                System.err.println("Invalid Phone number!");
            }
        } while (!check);
//        ------------------------------------------------------------------------------------------------------------
        String email=null;
        do {
            try {
                System.out.print("Input email customer: ");
                email = scanner.nextLine();
                if (email == null || !email.matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$")) {
                  throw new EmailException();
                } else {
                    check = true;
                }
            } catch (EmailException e){
                System.out.println("Enter wrong Email . Entype: ");
                check=false;
            }
        } while (!check);
//        -------------------------------------------------------------------------------------------------------------
        System.out.print("Input Kind Of Guests customer: ");
        String guestType = scanner.nextLine();
        System.out.print("Input address customer: ");
        String address = scanner.nextLine();


        customers.add(new Customer(nameCustomer, birthdayCustomer, sexCustomer, idCard,
                phoneNumber, email, guestType, address));
        ReadWriteFile.writerFile(customers.get(0).getName() + ",", FILE_CUSTOMER);
        ReadWriteFile.writerFile(customers.get(0).getBirthday() + ",", FILE_CUSTOMER);
        ReadWriteFile.writerFile(customers.get(0).getSex() + ",", FILE_CUSTOMER);
        ReadWriteFile.writerFile(customers.get(0).getIdCard() + ",", FILE_CUSTOMER);
        ReadWriteFile.writerFile(customers.get(0).getPhoneNumber() + ",", FILE_CUSTOMER);
        ReadWriteFile.writerFile(customers.get(0).getEmail() + ",", FILE_CUSTOMER);
        ReadWriteFile.writerFile(customers.get(0).getGuestType() + ",", FILE_CUSTOMER);
        ReadWriteFile.writerFile(customers.get(0).getAddRess() + "", FILE_CUSTOMER);
        ReadWriteFile.writerFile("\n", FILE_CUSTOMER);
//        ReadWriteFile.writerFile(customers.get(0).getServices() + ",", FILE_CUSTOMER);


    }


}
