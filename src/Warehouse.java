import java.util.Scanner;

public class Warehouse {

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

        int optional;
        Scanner input = new Scanner(System.in);
        do {
            menu();
            optional = input.nextInt();
            switch (optional) {
                case 1:
                    for (int i = 2; i < warehouseMatrix.length; i++) {
                            warehouseMatrix[i][2] = enterItemName(warehouseMatrix);
                            warehouseMatrix[i][4] = addExpireDate(warehouseMatrix);
                            warehouseMatrix[i][6] = addDateOfEntry(warehouseMatrix);
                            warehouseMatrix[i][8] = addManufactureName(warehouseMatrix);
                            warehouseMatrix[i][10] = addItemUnit(warehouseMatrix);
                            warehouseMatrix[i][12] = addItemQuantity(warehouseMatrix);
                            printMatrix(warehouseMatrix);

//                        addItemQuantity(quantity);

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

    public static String enterItemName(String[][] warehouseMatrix) {
        System.out.println("Enter item name:");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        return name;
    }

    private static void checkExistingItemName(String[][] warehouseMatrix) {
        for (int i = 2; i < warehouseMatrix.length; i++) {
            for (int j = 2; true; j++) {
                if (!warehouseMatrix[i][j].equalsIgnoreCase(warehouseMatrix[i][2])) {
                    return;
                } else {
                    checkExpiryDate(warehouseMatrix);
                }
                return;
            }
        }
    }

    public static String addExpireDate(String[][] warehouseMatrix) {
        System.out.println("Enter expire date: ");
        Scanner input = new Scanner(System.in);
        String date = input.nextLine();
        return date;
    }

    public static void checkExpiryDate(String[][] warehouseMatrix) {
        for (int i = 1; i < warehouseMatrix.length; i++) {
            for (int j = 1; j < warehouseMatrix[i].length; j++) {
                if (warehouseMatrix[i][4].equalsIgnoreCase(warehouseMatrix[i][j])) {
                    int sum = 0;
                    int quantity = Integer.parseInt(warehouseMatrix[i][j]);
                    sum += quantity;
                }else{
                    return;
                }
            }
        }
    }

    public static String addDateOfEntry(String[][] warehouseMatrix) {
        checkExistingItemName(warehouseMatrix);
        checkExpiryDate(warehouseMatrix);
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
        String quantityItem = input.nextLine();

        return quantityItem;
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

