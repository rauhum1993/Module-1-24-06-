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
        System.out.println("---Enter Properties Room ---");
        System.out.println("1. Enter name room (Enter the word): ");
        String nameRoom = scanner.nextLine();
        System.out.println("2. Enter area Use (Enter number): ");
        double areaUseRoom = Double.parseDouble(scanner.nextLine());
        System.out.println("3. Enter rental Cost (Enter number):");
        double rentalCostRoom = Double.parseDouble(scanner.nextLine());
        System.out.println("4. Enter Maximum People (Enter number):");
        int maximumPeopleRoom = Integer.parseInt(scanner.nextLine());
        System.out.println("5. Enter Type Of Rent (Enter the word):");
        String typeOfRentRoom = scanner.nextLine();
        System.out.println("6. Enter Id (Enter the word):");
        String idRoom = scanner.nextLine();
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
        System.out.println("---Enter Properties House ---");
        System.out.println("1. Enter name house (Enter the word): ");
        String nameHouse = scanner.nextLine();
        System.out.println("2. Enter area Use (Enter number): ");
        double areaUseHouse = Double.parseDouble(scanner.nextLine());
        System.out.println("3. Enter rental Cost (Enter number):");
        double rentalCostHoue = Double.parseDouble(scanner.nextLine());
        System.out.println("4. Enter Maximum People (Enter number):");
        int maximumPeopleHouse = Integer.parseInt(scanner.nextLine());
        System.out.println("5. Enter Type Of Rent (Enter the word):");
        String typeOfRentHouse = scanner.nextLine();
        System.out.println("6. Enter Id (Enter the word):");
        String idHouse = scanner.nextLine();
        System.out.println("7. Enter Room StanDard (Enter the word):");
        String roomStanDardHouse = scanner.nextLine();
        System.out.println("8. Enter Comfort Description (Enter the word):");
        String comfortDescriptionHouse = scanner.nextLine();
        System.out.println("9. Enter Number Of Floors (Enter number):");
        int numberOfFloorsHouse = Integer.parseInt(scanner.nextLine());

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
        System.out.println("1. Enter name villa (Enter the word): ");
        String nameVilla = scanner.nextLine();
        System.out.println("2. Enter area Use (Enter number): ");
        double areaUse = Double.parseDouble(scanner.nextLine());
        System.out.println("3. Enter rental Cost (Enter number):");
        double rentalCost = Double.parseDouble(scanner.nextLine());
        System.out.println("4. Enter Maximum People (Enter number):");
        int maximumPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("5. Enter Type Of Rent (Enter the word):");
        String typeOfRent = scanner.nextLine();


        System.out.println("6. Enter Id (Enter the word):");
        String id = scanner.nextLine();
        final String NAME_ID= "SVVL(-)[0-9]{4}";
        Pattern p = Pattern.compile("SVVL(-)[0-9]{4}");
        Matcher m = p.matcher(id);
        if (m.find()==false){
            System.out.println(" Enter the wrong format ");
        }



        System.out.println("7. Enter Room StanDard (Enter the word):");
        String roomStanDard = scanner.nextLine();
        System.out.println("8. Enter Comfort Description (Enter the word):");
        String comfortDescription = scanner.nextLine();
        System.out.println("9. Enter Pool Area (Enter number):");
        double poolArea = Double.parseDouble(scanner.nextLine());
        System.out.println("10. Enter Number Of Floors (Enter number):");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());

        Villa villa = new Villa(nameVilla, areaUse, rentalCost, maximumPeople, typeOfRent, id,
                roomStanDard, comfortDescription, poolArea, numberOfFloors);
        List<Villa> villas = new ArrayList<>();
        final String FILE_VILLA = "Name Villa,Area Use ,RentalCost, Maximum People, Type Of Rent, ID, " +
                "Room StanDard, Comfort Descriptiom, Pool Area, Number OF Floors";


        villas.add(villa);
        writerFilevilla(villa, villas, FILE_VILLA);

    }

    private static void writerFilevilla(Villa villa, List<Villa> villas, String FILE_VILLA) {
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
