import java.util.*;

public class Laptop {
    private String model;
    private int ram;
    private int hddSize;
    private String operatingSystem;
    private String color;

    public Laptop(String model, int ram, int hddSize, String operatingSystem, String color) {
        this.model = model;
        this.ram = ram;
        this.hddSize = hddSize;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getHddSize() {
        return hddSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        List<Laptop> Laptop = new ArrayList<>();

        Laptop.add(new Laptop("Lenovo", 8, 512, "Windows", "Black"));
        Laptop.add(new Laptop("MacBook", 16, 1024, "MacOS", "Silver"));
        Laptop.add(new Laptop("Acer", 16, 256, "Windows", "Blue"));
        Laptop.add(new Laptop("HUAWEI MateBook", 8, 256, "Windows", "Space Gray"));

        filterLaptop(Laptop);
    }

    public static void filterLaptop(List<Laptop> Laptop) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите критерии фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("5 - Поиск");

        Set<Laptop> filteredLaptop = new HashSet<>(Laptop);
        int choice;
        while ((choice = scanner.nextInt()) != 5) {
            switch (choice) {
                case 1:
                    System.out.println("Введите минимальный объем ОЗУ:");
                    int minRam = scanner.nextInt();
                    filteredLaptop.removeIf(laptop -> laptop.getRam() < minRam);
                    break;
                case 2:
                    System.out.println("Введите минимальный объем ЖД:");
                    int minHddSize = scanner.nextInt();
                    filteredLaptop.removeIf(laptop -> laptop.getHddSize() < minHddSize);
                    break;
                case 3:
                    System.out.println("Введите операционную систему:");
                    String operatingSystem = scanner.next();
                    filteredLaptop.removeIf(laptop -> !laptop.getOperatingSystem().equalsIgnoreCase(operatingSystem));
                    break;
                case 4:
                    System.out.println("Введите цвет:");
                    String color = scanner.next();
                    filteredLaptop.removeIf(laptop -> !laptop.getColor().equalsIgnoreCase(color));
                    break;
                default:
                    System.out.println("Неправильный выбор.");
            }
        }
        System.out.println("Найденные ноутбуки для вас:");
        for (Laptop laptop : filteredLaptop) {
            System.out.println(laptop.getModel());
        }
    }
}