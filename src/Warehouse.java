import java.util.Scanner;

public class Warehouse {

    public static final int ITEM_NAME = 2;
    public static final int EXPIRE_DATE = 4;
    public static final int DATE_OF_ENTRY = 6;
    public static final int MANUFACTURE_NAME = 8;
    public static final int ITEM_UNIT = 10;
    public static final int ITEM_QUANTITY = 12;


    public static void main(String[] args) {

        String[][] warehouseMatrix = {
                {"No Place: ", "\t\t", "Name of item", "\t\t", "Date of expire", "\t\t", "Date of entry ", "\t\t", "Manufacture's Name", "\t\t\t", "Item unit", "\t\t\t", "Quantity"},
                {"--------", "\t\t\t", "--------", "\t\t\t", " DD/MM/YEAR", "\t\t\t", "DD/MM/YEAR", "\t\t\t", "--------", "\t\t\t\t", "--------", "\t\t\t", "--------"},
                {"1. ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " "},
                {"2. ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " "},
                {"3. ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " "},
                {"4. ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " "},
                {"5. ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " "},
        };
        printMatrix(warehouseMatrix);

        String[] warehouseArray = new String[13];

        int optional;
        Scanner input = new Scanner(System.in);
        int countAddedItem = 0;
        do {
            menu();
            optional = input.nextInt();
            switch (optional) {
                case 1:
                    for (int i = 2; i < warehouseMatrix.length; i++) {
                        warehouseMatrix[i][ITEM_NAME] = addItemName(warehouseMatrix);
                        warehouseMatrix[i][EXPIRE_DATE] = addExpireDate(warehouseMatrix);
                        warehouseMatrix[i][DATE_OF_ENTRY] = addDateOfEntry(warehouseMatrix);
                        warehouseMatrix[i][MANUFACTURE_NAME] = addManufactureName(warehouseMatrix);
                        warehouseMatrix[i][ITEM_UNIT] = addItemUnit(warehouseMatrix);
                        warehouseMatrix[i][ITEM_QUANTITY] = addItemQuantity(warehouseMatrix);
                        printMatrix(warehouseMatrix);
                        countAddedItem++;
                    }
                    System.out.println("Warehouse is full");
                    break;
                case 2:

//                    referenceItemByDate(warehouseMatrix);
                    break;
                default:
                    break;
            }
        } while (optional != 0);

    }

    public static void menu() {
        System.out.println();
        System.out.println("1 - Add new Item");
        System.out.println("2 - Reference for availability in a given period");
        System.out.println("0 - Exit");

    }

    public static void printMatrix(String[][] warehouseMatrix) {
        for (int i = 0; i < warehouseMatrix.length; i++) {
            for (int j = 0; j < warehouseMatrix[i].length; j++) {
                System.out.print(warehouseMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public static String addItemName(String[][] warehouseMatrix) {
        System.out.println("Enter item name:");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        return name;
    }

    private static boolean checkExistingItemName(String[][] warehouseMatrix) {
        for (int i = 2; i < warehouseMatrix.length ; i++) {
            if (warehouseMatrix[i][2].equalsIgnoreCase(warehouseMatrix[i - 1][2])) {
                return true;
            }
        }
        return false;
    }

    public static String addExpireDate(String[][] warehouseMatrix) {
        System.out.println("Enter expire date: ");
        Scanner input = new Scanner(System.in);
        String date = input.nextLine();
        return date;
    }

    public static boolean checkExpiryDate(String[][] warehouseMatrix) {
        for (int i = 2; i < warehouseMatrix.length; i++) {
            if (warehouseMatrix[i][4].equals(warehouseMatrix[i - 1][4])) {
                return true;
            }
        }
        return false;
    }

    public static String addDateOfEntry(String[][] warehouseMatrix) {

        System.out.println("Enter date of entry: ");
        Scanner input = new Scanner(System.in);
        String date = input.nextLine();
        return date;

    }

    public static String addManufactureName(String[][] warehouseMatrix) {
        System.out.println("Enter Manufacture Name: ");
        Scanner input = new Scanner(System.in);
        String nameOfManufacture = input.nextLine();

        return nameOfManufacture;

    }

    public static String addItemUnit(String[][] warehouseMatrix) {
        System.out.println("Enter item unit: ");
        Scanner input = new Scanner(System.in);
        String itemUnit = input.nextLine();
        return itemUnit;
    }

    public static String addItemQuantity(String[][] warehouseMatrix) {
        System.out.println("Enter item quantity: ");
        Scanner input = new Scanner(System.in);
        String scan = input.nextLine();
        checkExistingItemName(warehouseMatrix);
        checkExpiryDate(warehouseMatrix);

        if (checkExistingItemName(warehouseMatrix) && checkExpiryDate(warehouseMatrix)) {
            int sum = 0;
            int quantityItem = Integer.parseInt(scan);
            sum += quantityItem;
            scan = Integer.toString(sum);
        }
        return scan;
    }
//
//    public static void referenceItemByDate(String[][] warehouseMatrix) {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter start date: ");
//        String firstData = input.nextLine();
//
//        System.out.println("Enter end data: ");
//        String endData = input.nextLine();
//
//
//    }

}

