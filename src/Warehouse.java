import java.util.Arrays;
import java.util.Scanner;

public class Warehouse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int optional;
        int count = 1;

        do {
            menu();
            optional = input.nextInt();
            switch (optional) {
                case 1:
                    fillMatrix(count);
                    count++;
                    break;
                case 2:
                    //   referenceItemByDate(warehouseMatrix);
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

    public static void fillMatrix(int count) {
        count = 1;
        String[][] warehouseMatrix = {
                {"No Place: ", "\t\t", "Name of item", "\t\t", "Date of expire", "\t\t", "Date of entry ", "\t\t", "Manufacture's Name", "\t\t\t", "Item unit", "\t\t\t", "Quantity"},
                {" ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " "},
                {" ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " "},
                {" ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " "},
                {" ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " "},
                {" ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " "},
        };

        for (int i = 0; i < warehouseMatrix.length; i++) {

            String[] warehouseArray = {" ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t\t", " "};
            warehouseArray[0] = Integer.toString(count);
            warehouseArray[2] = addItemName();
            warehouseArray[4] = addExpireDate();
            warehouseArray[6] = addDateOfEntry();
            warehouseArray[8] = addManufactureName();
            warehouseArray[10] = addItemUnit();
            warehouseArray[12] = addItemQuantity();

            printArray(warehouseArray);
            System.out.println();

            if (!checkExistingItemName(warehouseMatrix, warehouseArray, count) || !checkExpireDate(warehouseMatrix, warehouseArray, count)) {
                warehouseMatrix[count][0] = warehouseArray[0];
                warehouseMatrix[count][2] = warehouseArray[2];
                warehouseMatrix[count][4] = warehouseArray[4];
                warehouseMatrix[count][6] = warehouseArray[6];
                warehouseMatrix[count][8] = warehouseArray[8];
                warehouseMatrix[count][10] = warehouseArray[10];
                warehouseMatrix[count][12] = warehouseArray[12];
            } else {
                checkExistingItem(warehouseMatrix, warehouseArray, count);
            }

            printMatrix(warehouseMatrix, warehouseArray);
            count++;
        }
        System.out.println("Warehouse is full");
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

    public static String addItemName() {
        System.out.println("Enter item name:");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        return name;
    }

    public static String addExpireDate() {
        System.out.println("Enter expire date: ");
        Scanner input = new Scanner(System.in);
        String date = input.nextLine();
        return date;
    }

    public static String addDateOfEntry() {

        System.out.println("Enter date of entry: ");
        Scanner input = new Scanner(System.in);
        String date = input.nextLine();
        return date;

    }

    public static String addManufactureName() {
        System.out.println("Enter Manufacture Name: ");
        Scanner input = new Scanner(System.in);
        String nameOfManufacture = input.nextLine();

        return nameOfManufacture;

    }

    public static String addItemUnit() {
        System.out.println("Enter item unit: ");
        Scanner input = new Scanner(System.in);
        String itemUnit = input.nextLine();
        return itemUnit;
    }

    public static String addItemQuantity() {
        System.out.println("Enter item quantity: ");
        Scanner input = new Scanner(System.in);
        String itemQuantity = input.nextLine();
        return itemQuantity;
    }
}

