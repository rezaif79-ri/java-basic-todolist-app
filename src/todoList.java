public class todoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    static String readInput(){
        String data = scanner.nextLine();
        return data;
    }

    public static void main(String[] args) {
        boolean exit = false;
        do{
            exit = mainTodoList();
        }while(!exit);
    }

    static boolean mainTodoList() {
        System.out.println("======= Menu =======");
        System.out.println("1. Lihat ToDo List");
        System.out.println("2. Tambah ToDo");
        System.out.println("3. Hapus ToDo");
        System.out.print("Pilihan (x to exit): ");
        var input = readInput();

        System.out.println("input: " + input + "\n");

        boolean exit = switch (input) {
            case "1" -> {viewTodoList(); yield false;}
            case "x", "X" -> { yield true;}
            default -> {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Input salah \n");
                yield false;
            }
        };

        return exit;
    }

    static void viewTodoList(){
        System.out.println("view todolist");
    }
}
