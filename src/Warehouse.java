
import java.util.Arrays;
import java.util.Scanner;

public class Warehouse {
    public static final int COUNT = 0;
    public static final int ITEM_NAME = 2;
    public static final int EXPIRE_DATE = 4;
    public static final int DATE_OF_ENTRY = 6;
    public static final int MANUFACTURE_NAME = 8;
    public static final int ITEM_UNIT = 10;
    public static final int ITEM_QUANTITY = 12;
    public static final int COMMENTS = 14;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int optional;
        int count = 1;
        String[] warehouseArray = {" ", "\t\t", " ", "\t\t", " ", "\t\t", "  ", "\t\t", "  ", "\t\t", "  ", "\t\t", " ", "\t\t", " "};
        String[][] warehouseMatrix = {
                {"No Place: ", "\t\t", "Name of item", "\t\t", "Date of expire", "\t\t", "Date of entry ", "\t\t", "Manufacture's Name", "\t\t\t", "Item unit", "\t\t\t", "Quantity", "\t\t\t", "Comments"},
                {" ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " ", "\t\t\t\t", " "},
                {" ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " ", "\t\t\t\t", " "},
                {" ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " ", "\t\t\t\t", " "},
                {" ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " ", "\t\t\t\t", " "},
                {" ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " ", "\t\t\t\t", " "},
        };

        do {
            menu();
            optional = input.nextInt();
            switch (optional) {
                case 1:
                    warehouseArray[COUNT] = Integer.toString(count);
                    warehouseArray[ITEM_NAME] = addItemName();
                    warehouseArray[EXPIRE_DATE] = addExpireDate();
                    warehouseArray[DATE_OF_ENTRY] = addDateOfEntry();
                    warehouseArray[MANUFACTURE_NAME] = addManufactureName();
                    warehouseArray[ITEM_UNIT] = addItemUnit();
                    warehouseArray[ITEM_QUANTITY] = addItemQuantity();
                    warehouseArray[COMMENTS] = addComments();

                    printArray(warehouseArray);
                    System.out.println();

                    if (!checkExistingItemName(warehouseMatrix, warehouseArray, count) || !checkExpireDate(warehouseMatrix, warehouseArray, count)) {
                        warehouseMatrix[count][Warehouse.COUNT] = warehouseArray[Warehouse.COUNT];
                        warehouseMatrix[count][ITEM_NAME] = warehouseArray[ITEM_NAME];
                        warehouseMatrix[count][EXPIRE_DATE] = warehouseArray[EXPIRE_DATE];
                        warehouseMatrix[count][DATE_OF_ENTRY] = warehouseArray[DATE_OF_ENTRY];
                        warehouseMatrix[count][MANUFACTURE_NAME] = warehouseArray[MANUFACTURE_NAME];
                        warehouseMatrix[count][ITEM_UNIT] = warehouseArray[ITEM_UNIT];
                        warehouseMatrix[count][ITEM_QUANTITY] = warehouseArray[ITEM_QUANTITY];
                        warehouseMatrix[count][COMMENTS] = warehouseArray[COMMENTS];
                    } else {
                        checkExistingItem(warehouseMatrix, warehouseArray, count);
                        count--;
                    }

                    printMatrix(warehouseMatrix, warehouseArray);
                    count++;

                    if (count == warehouseMatrix.length) {
                        System.out.println("Warehouse is full");
                    }
                    break;
                case 2:
                    printReferenceByDate(warehouseMatrix, warehouseArray);
                    break;
                default:
                    break;
            }
        } while ((optional != 0) || (count < warehouseMatrix.length));
    }

    public static void menu() {
        System.out.println();
        System.out.println("1 - Add new Item: ");
        System.out.println("2 - Reference for availability in a given period");
        System.out.println("0 - Exit");
    }

    public static void printMatrix(String[][] warehouseMatrix, String[] warehouseArray) {
        for (int i = 0; i < warehouseMatrix.length; i++) {
            for (int j = 0; j < warehouseArray.length; j++) {
                System.out.print(warehouseMatrix[i][j]);
            }
            System.out.println();
        }
    }

    private static String checkExistingItem(String[][] warehouseMatrix, String[] warehouseArray, int count) {
        for (int i = 1; i < count; i++) {
            if ((warehouseArray[2].equalsIgnoreCase(warehouseMatrix[i][2])) && (warehouseArray[4].equalsIgnoreCase(warehouseMatrix[i][4]))) {
                int quantityMatrix = Integer.parseInt(warehouseMatrix[i][12]);
                int quantityArray = Integer.parseInt(warehouseArray[12]);
//                if ((quantityArray + quantityMatrix) > 100) {
//                    throw new IndexOutOfBoundsException("Not enough space.");
//                }
                String sumQuantity = Integer.toString(quantityArray + quantityMatrix);
                warehouseMatrix[i][12] = sumQuantity;
                return sumQuantity;
            }
        }
        return warehouseMatrix[count][12] = warehouseArray[12];
    }

    public static boolean checkExistingItemName(String[][] warehouseMatrix, String[] warehouseArray, int count) {
        for (int i = 1; i < count; i++) {
            if (warehouseArray[2].equalsIgnoreCase(warehouseMatrix[i][2])) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkExpireDate(String[][] warehouseMatrix, String[] warehouseArray, int count) {
        for (int i = 1; i < count; i++) {
            if (warehouseArray[4].equalsIgnoreCase(warehouseMatrix[i][4])) {
                return true;
            }
        }
        return false;
    }

    public static void printArray(String[] warehouseArray) {
        System.out.println(Arrays.toString(warehouseArray));

    }

    public static String addDetails() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static String addItemName() {
        System.out.println("Enter item name:");
        String name = addDetails();
        return name;
    }

    public static String addExpireDate() {
        System.out.println("Enter expire date: ");
        String date = addDetails();
        return date;
    }

    public static String addDateOfEntry() {
        System.out.println("Enter date of entry: ");
        String date = addDetails();
        return date;
    }

    public static String addManufactureName() {
        System.out.println("Enter Manufacture Name: ");
        String nameOfManufacture = addDetails();
        return nameOfManufacture;
    }

    public static String addItemUnit() {
        System.out.println("Enter item unit: ");
        String itemUnit = addDetails();
        return itemUnit;
    }

    public static String addItemQuantity() {
        System.out.println("Enter item quantity: ");
        String itemQuantity = addDetails();
        return itemQuantity;
    }

    private static String addComments() {
        System.out.println("Enter comments: ");
        String comments = addDetails();
        return comments;
    }

    private static void printReferenceByDate(String[][] warehouseMatrix, String[] warehouseArray) {
        for (int i = 1; i < warehouseMatrix.length; i++) {
            if (enterStartDate().equalsIgnoreCase(warehouseMatrix[i][6])) {
                String endDate = enterEndDate();
                while (!endDate.equalsIgnoreCase(warehouseMatrix[i][6])) {
                    for (int j = 0; j < warehouseArray.length; j++) {
                        System.out.print(warehouseMatrix[i][j]);
                    }
                    System.out.println();
                    i++;
                }
            }
        }
    }

    public static String enterStartDate() {
        System.out.println("Enter start date for reference: ");
        String startDate = addDetails();
        return startDate;
    }

    public static String enterEndDate() {
        System.out.println("Enter end date for reference: ");
        String endDate = addDetails();
        return endDate;
    }

}

