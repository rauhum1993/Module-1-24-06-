package lesson_last_case_study.yeu_cau_7.task2.controllers;

import lesson_last_case_study.yeu_cau_7.task1.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";


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
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                    break;


            }


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
                    readFileVilla();
                    showServices(scanner);
                    break;
                case 2:
                    readFileHouse();
                    showServices(scanner);
                    break;
                case 3:
                    readFileRoom();
                    showServices(scanner);
                    break;
                case 4:
                    displayName("src/lesson_last_case_study/yeu_cau_7/data/Villa.csv");
                    showServices(scanner);
                    break;
                case 5:
                    displayName("src/lesson_last_case_study/yeu_cau_7/data/House.csv");
                    showServices(scanner);
                    break;
                case 6:
                    displayName("src/lesson_last_case_study/yeu_cau_7/data/Room.csv");
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
                    addAndWriterFileVilla(scanner);
                    addNewServie(scanner);
                    break;
                case 2:
                    addAndWriterFileHouse(scanner);
                    addNewServie(scanner);
                    break;
                case 3:
                    addAndWriterFileRoom(scanner);
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

    private static void addAndWriterFileRoom(Scanner scanner) {

        boolean check = false;
        System.out.println("---Enter Properties Room ---");
        String nameRoom;
        do {
            System.out.println("1. Enter Name Room (Enter the word ):");
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
                System.out.println("2. Enter area Use (Enter number bigger than 30 square meters): ");
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
                System.out.println("3. Enter Rental Cost (Enter number is greater than 0):");
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
                System.out.println("4. Enter Maximum People (Enter numbers greater than 0 and less than 20):");
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



        String typeOfRentRoom ;

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


        check = false;
        String idRoom;
        do {
            System.out.println("6. Enter Id (Enter the word):");
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


        System.out.println("7. Enter free Service Included (Enter the word): ");
        String freeServiceIncluded = scanner.nextLine();

        Room room = new Room(nameRoom, areaUseRoom, rentalCostRoom, maximumPeopleRoom, typeOfRentRoom, idRoom, freeServiceIncluded);
        final String FILE_ROOM = "Name Room,Area Use ,RentalCost, Maximum People, Type Of Rent, ID, " +
                "FreeService Included";
        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        String fileNameRoom = "src/lesson_last_case_study/yeu_cau_7/data/Room.csv";
        FileWriter fileWriterRoom = null;

        try {
            fileWriterRoom = new FileWriter(fileNameRoom);

            // Write the CSV file header
            fileWriterRoom.append(FILE_ROOM);

            // Add a new line separator after the header
            fileWriterRoom.append(NEW_LINE_SEPARATOR);

            // Write a new Room object list to the CSV file
            for (Room room1 : rooms) {
                fileWriterRoom.append(String.valueOf(room.getNameServices()));
                fileWriterRoom.append(COMMA_DELIMITER);
                fileWriterRoom.append(String.valueOf(room.getAreaUse()));
                fileWriterRoom.append(COMMA_DELIMITER);
                fileWriterRoom.append(String.valueOf(room.getRentalCost()));
                fileWriterRoom.append(COMMA_DELIMITER);
                fileWriterRoom.append(String.valueOf(room.getMaximumPeople()));
                fileWriterRoom.append(COMMA_DELIMITER);
                fileWriterRoom.append(room.getTypeOfRent());
                fileWriterRoom.append(COMMA_DELIMITER);
                fileWriterRoom.append(String.valueOf(room.getId()));
                fileWriterRoom.append(COMMA_DELIMITER);
                fileWriterRoom.append(String.valueOf(room.getFreeServiceIncluded()));
                fileWriterRoom.append(NEW_LINE_SEPARATOR);

            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriterRoom.flush();
                fileWriterRoom.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriterVilla !!!");
                e.printStackTrace();
            }
        }
    }

    private static void readFileRoom() {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("src/lesson_last_case_study/yeu_cau_7/data/Room.csv"));

            // How to read file in java line by line?
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    private static void addAndWriterFileHouse(Scanner scanner) {
        boolean check = false;
        System.out.println("---Enter Properties House ---");

        String nameHouse;
        do {
            System.out.println("1. Enter Name House (Enter the word ):");
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
                System.out.println("2. Enter area Use (Enter number bigger than 30 square meters): ");
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
                System.out.println("3. Enter Rental Cost (Enter number is greater than 0):");
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
                System.out.println("4. Enter Maximum People (Enter numbers greater than 0 and less than 20):");
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
            System.out.println("5. Enter Type Of Rent (Enter the word ):");
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


        String idHouse;
        do {
            System.out.println("6. Enter Id (Enter the word):");
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

        House house = new House(nameHouse, areaUseHouse, rentalCostHoue, maximumPeopleHouse, typeOfRentHouse, idHouse,
                roomStanDardHouse, comfortDescriptionHouse, numberOfFloorsHouse);

        final String FILE_HOUSE = "Name House,Area Use ,RentalCost, Maximum People, Type Of Rent, ID, " +
                "Room StanDard, Comfort Descriptiom, Number OF Floors";

        List<House> houses = new ArrayList<>();
        houses.add(house);
        String fileNameHouse = "src/lesson_last_case_study/yeu_cau_7/data/House.csv";
        FileWriter fileWriterHouse = null;

        try {
            fileWriterHouse = new FileWriter(fileNameHouse);

            // Write the CSV file header
            fileWriterHouse.append(FILE_HOUSE);

            // Add a new line separator after the header
            fileWriterHouse.append(NEW_LINE_SEPARATOR);

            // Write a new House object list to the CSV file
            for (House house1 : houses) {
                fileWriterHouse.append(String.valueOf(house.getNameServices()));
                fileWriterHouse.append(COMMA_DELIMITER);
                fileWriterHouse.append(String.valueOf(house.getAreaUse()));
                fileWriterHouse.append(COMMA_DELIMITER);
                fileWriterHouse.append(String.valueOf(house.getRentalCost()));
                fileWriterHouse.append(COMMA_DELIMITER);
                fileWriterHouse.append(String.valueOf(house.getMaximumPeople()));
                fileWriterHouse.append(COMMA_DELIMITER);
                fileWriterHouse.append(house.getTypeOfRent());
                fileWriterHouse.append(COMMA_DELIMITER);
                fileWriterHouse.append(String.valueOf(house.getId()));
                fileWriterHouse.append(COMMA_DELIMITER);
                fileWriterHouse.append(String.valueOf(house.getRoomStanDard()));
                fileWriterHouse.append(COMMA_DELIMITER);
                fileWriterHouse.append(String.valueOf(house.getComfortDescription()));
                fileWriterHouse.append(COMMA_DELIMITER);
                fileWriterHouse.append(String.valueOf(house.getNumberOfFloors()));
                fileWriterHouse.append(NEW_LINE_SEPARATOR);


            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriterHouse.flush();
                fileWriterHouse.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriterVilla !!!");
                e.printStackTrace();
            }
        }


    }

    private static void displayName(String fileCsv) {
        try {
            File file;
            file = new File(fileCsv);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line = "";

            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] name = line.split(",");
                System.out.println("name " + (i + 1) + " is: \t" + name[0]);
                i++;
            }
            fileReader.close();
            br.close();

        } catch (Exception e) {
            System.out.println("Error");
        }

    }

    private static void readFileHouse() {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("src/lesson_last_case_study/yeu_cau_7/data/House.csv"));

            // How to read file in java line by line?
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    private static void addAndWriterFileVilla(Scanner scanner) {
        System.out.println("---Enter Properties Villa ---");
        boolean check = false;
        String nameVilla;
        do {
            System.out.println("1. Enter Name Villa (Enter the word ):");
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
                System.out.println("2. Enter area Use (Enter number bigger than 30 square meters): ");
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
                System.out.println("3. Enter Rental Cost (Enter number is greater than 0):");
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
                System.out.println("4. Enter Maximum People (Enter numbers greater than 0 and less than 20):");
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
            System.out.println("5. Enter Type Of Rent (Enter the word ):");
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


        check = false;
        String idVilla;
        do {
            System.out.println("6. Enter Id (Enter the word of the form:  SVXX-YYYY):");
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


        System.out.println("8. Enter Comfort Description (Enter the word):");
        String comfortDescription = scanner.nextLine();


//        Enter the pool Area
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


        Villa villa = new Villa(nameVilla, areaUse, rentalCost, maximumPeople, typeOfRent, idVilla,
                roomStanDard, comfortDescription, poolArea, numberOfFloors);
        List<Villa> villas = new ArrayList<>();
        final String FILE_VILLA = "Name Villa,Area Use ,RentalCost, Maximum People, Type Of Rent, ID, " +
                "Room StanDard, Comfort Descriptiom, Pool Area, Number OF Floors";


        villas.add(villa);
        writerFilevilla(villa, villas, FILE_VILLA);

    }

    public static void writerFilevilla(Villa villa, List<Villa> villas, String FILE_VILLA) {
        String fileName = "src/lesson_last_case_study/yeu_cau_7/data/Villa.csv";
        FileWriter fileWriterVilla = null;

        try {
            fileWriterVilla = new FileWriter(fileName);

            // Write the CSV file header
            fileWriterVilla.append(FILE_VILLA);

            // Add a new line separator after the header
            fileWriterVilla.append(NEW_LINE_SEPARATOR);

            // Write a new Villa object list to the CSV file
            for (Villa villa1 : villas) {
                fileWriterVilla.append(String.valueOf(villa1.getNameServices()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getAreaUse()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getRentalCost()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getMaximumPeople()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(villa.getTypeOfRent());
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getId()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getRoomStanDard()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getComfortDescription()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getPoolArea()));
                fileWriterVilla.append(COMMA_DELIMITER);
                fileWriterVilla.append(String.valueOf(villa.getNumberOfFloors()));
                fileWriterVilla.append(NEW_LINE_SEPARATOR);

            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriterVilla.flush();
                fileWriterVilla.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriterVilla !!!");
                e.printStackTrace();
            }
        }
    }

    private static void readFileVilla() {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("src/lesson_last_case_study/yeu_cau_7/data/Villa.csv"));

            // How to read file in java line by line?
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }


}
