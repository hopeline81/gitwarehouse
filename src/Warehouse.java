import java.util.Scanner;

public class Warehouse {

    public static void main(String[] args) {

        String[][] warehouseMatrix = {
                {"No Place: ", "\t\t", "Name of item", "\t\t", "Date of expire", "\t\t", "Date of entry ","\t\t", "Manufacture's Name", "\t\t","Item unit", "\t\t", "Quantity"},
                {"--------","\t\t\t","--------","\t\t\t"," DD/MM/YEAR","\t\t\t","DD/MM/YEAR","\t\t\t","--------","\t\t\t\t","--------","\t\t","--------"},
                {"1. ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t", "  ", "\t\t\t", " "},
                {"2. ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t", "  ", "\t\t\t", " "},
                {"3. ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t", "  ", "\t\t\t", " "},
                {"4. ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t", "  ", "\t\t\t", " "},
                {"5. ", "\t\t\t\t", " ", "\t\t\t\t", " ", "\t\t\t\t", "  ", "\t\t\t\t", "  ", "\t\t\t", "  ", "\t\t\t", " "},
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
                        for (int j = 2; j < warehouseMatrix[i].length; j++) {
                            warehouseMatrix[i][2] = enterItemName(warehouseMatrix);
                            warehouseMatrix[i][4] = addExpireDate(warehouseMatrix);
                            warehouseMatrix[i][6] = addDateOfEntry(warehouseMatrix);
                            warehouseMatrix[i][8] = addManufactureName(warehouseMatrix);
                            warehouseMatrix[i][10] = addItemUnit(warehouseMatrix);
                            printMatrix(warehouseMatrix);

//                        addItemQuantity(quantity);
                        }
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
        checkExistingDate(warehouseMatrix);
        return name;
    }

    private static void checkExistingDate(String[][] warehouseMatrix) {
        for (int i = 2; i < warehouseMatrix.length; i++) {
            if(!warehouseMatrix[i][2].equalsIgnoreCase(warehouseMatrix[i][2] + 1)){
                return;
            }else{
                checkExpiryDate(warehouseMatrix);
            }
        }
    }

    public static String addExpireDate(String[][] warehouseMatrix) {
        System.out.println("Enter expire date: ");
        Scanner input = new Scanner(System.in);
        String date = input.nextLine();
        return date;
    }

    public static String checkExpiryDate(String[][] warehouseMatrix) {
        for (int i = 1; i < warehouseMatrix.length; i++) {
            for (int j = 1; j < warehouseMatrix[i].length; j++) {
                if (warehouseMatrix[i][4].equalsIgnoreCase(warehouseMatrix[i][j])) {
                    sumItemQuantity(int quantityItem);
                } else {
                warehouseMatrix[i][1] = date;
            }
        }
        return date;
    }

    public static String addDateOfEntry(String[][] warehouseMatrix) {
        System.out.println("Enter date of entry: ");
        Scanner input = new Scanner(System.in);
        String date = input.nextLine();
//        for (int i = 1; i < warehouseMatrix.length; i++) {
//            for (int j = 1; j < warehouseMatrix[1].length; j++) {
//                warehouseMatrix[i][1] = date;
//            }
//        }
        return date;

    }

    public static String addManufactureName(String[][] warehouseMatrix) {
        System.out.println("Enter Manufacture Name: ");
        Scanner input = new Scanner(System.in);
        String nameOfManufacture = input.nextLine();
//        for (int i = 1; i < warehouseMatrix.length; i++) {
//            for (int j = 1; j < warehouseMatrix[1].length; j++) {
//                warehouseMatrix[i][1] = nameOfManufacture;
//            }
//        }
        return nameOfManufacture;

    }

    public static String addItemUnit(String[][] warehouseMatrix) {
        System.out.println("Enter item unit: ");
        Scanner input = new Scanner(System.in);
        String itemUnit = input.nextLine();
        return itemUnit;
    }

    public static int addItemQuantity(int quantity) {
        System.out.println("Enter item quantity: ");
        Scanner input = new Scanner(System.in);
        int quantityItem = input.nextInt();

        return quantityItem;
    }

    public static int sumItemQuantity(int quantityItem) {
        int sum = 0;
        sum += quantityItem;
        return sum;
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

