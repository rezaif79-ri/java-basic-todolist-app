public class todoList {

    public static String[] model = new String[0];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static String readInput() {
        String data = scanner.nextLine();
        return data;
    }

    public static void main(String[] args) {
        boolean exit = false;
        do {
            exit = mainTodoList();
        } while (!exit);
    }

    static boolean mainTodoList() {
        System.out.println("======= Menu =======");
        System.out.println("1. Lihat ToDo List");
        System.out.println("2. Tambah ToDo");
        System.out.println("3. Update ToDo");
        System.out.println("4. Hapus ToDo");
        System.out.print("Pilihan (x to exit): ");
        var input = readInput();

        System.out.println("input: " + input + "\n");

        boolean exit = switch (input) {
            case "1" -> {
                viewTodoList();
                yield false;
            }
            case "2" -> {
                insertTodoList();
                yield false;
            }
            case "3" -> {
                updateTodoList();
                yield false;
            }
            case "4" -> {
                deleteTodoList();
                yield false;
            }
            case "x", "X" -> {
                yield true;
            }
            default -> {
                clearConsole();
                System.out.println("Invalid input! \n");
                yield false;
            }
        };

        return exit;
    }

    static void viewTodoList() {
        clearConsole();
        System.out.println("=== ToDo List ===");

        if (model.length == 0) {
            clearConsole();
            System.out.println("List kosong \n");
        } else {
            for (var i = 0; i < model.length; i++) {
                System.out.println((i + 1) + ". " + model[i]);
            }
            System.out.println();
        }
    }

    static void insertTodoList() {
        clearConsole();
        System.out.println("===== TodoList =====");
        System.out.print("Todo: ");
        var input = readInput();

        var temp = model;
        model = new String[model.length + 1];
        for (var i = 0; i < temp.length; i++) {
            model[i] = temp[i];
        }
        model[model.length - 1] = input;
        System.out.println();
    }

    static void deleteTodoList() {
        clearConsole();
        viewTodoList();

        System.out.print("Hapus ToDo ID: ");
        var input = readInput();

        try {
            var number = Integer.valueOf(input);
            if (number < 0 || number > model.length) {
                System.out.println("ToDo ID tidak ditemukan");
                return;
            } else {
                var temp = model;
                model = new String[model.length - 1];
                for (int i = 0, k = 0; i < temp.length; i++) {
                    if (i == number - 1) {
                        continue;
                    }
                    model[k++] = temp[i];
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    static void updateTodoList() {
        clearConsole();
        viewTodoList();

        System.out.print("Update ToDo ID: ");
        var input = readInput();

        try {
            var number = Integer.valueOf(input);
            if (number < 0 || number > model.length) {
                System.out.println("ToDo ID tidak ditemukan");
                return;
            }
            System.out.print("Update ToDo: ");
            var input2 = readInput();

            model[number - 1] = input2;
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }

    }
}
