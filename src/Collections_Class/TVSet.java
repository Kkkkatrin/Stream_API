package Collections_Class;

import java.util.*;
import java.util.stream.Collectors;

class TVSet {
    int ID;
    String name;
    String brand;
    int diagonal;
    int price;
    double mark;

    public int getID() { return ID; }

    public String getName() { return name; }

    public String getBrand() { return brand; }

    public int getDiagonal() { return diagonal; }

    public int getPrice() { return price; }

    public double getMark() { return mark; }

    public TVSet(int id, String name, String brand, int diagonal, int price, double mark) {
        this.ID = id;
        this.name = name;
        this.brand = brand;
        this.diagonal = diagonal;
        this.price = price;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return String.format("TV is %s, price is %d, ", getName(), getPrice());
    }

    public static void main(String[] args) {
        List<TVSet> list = List.of(
                new TVSet(1, "Shivaki STV-22LED26", "Shivaki", 22, 6899, 3.8),
                new TVSet(2, "DEXP F24D7200E", "DEXP", 24, 7499, 4.5),
                new TVSet(3, "Polarline 22PL12TC", "Polarline", 22, 8099, 4.3),
                new TVSet(4, "Prestigio Odyssey PTV32SN03Z", "Prestigio", 32, 8899, 4.8),
                new TVSet(5, "Hyundai H-LED32ET3001", "Hyundai", 32, 9499, 4.8),
                new TVSet(6, "Daewoo L32A650VBE", "Daewoo", 32, 10499, 4.4),
                new TVSet(7, "Kivi 32H600GR", "Kivi", 32, 10999, 4),
                new TVSet(8, "Philips 32PHS4132", "Philips", 32, 12999, 4.6),
                new TVSet(9, "LG 28TL510V-WZ", "LG", 28, 13899, 4.7),
                new TVSet(10, "BBK 39LEX-7289/TS2C", "BBK", 39, 14899, 4.5)
        );

        //1.	Отсортируйте телевизоры по наименованию.
        List <TVSet> sortedName = list.stream()
                .sorted(Comparator.comparing(TVSet::getName))
                .collect(Collectors.toList());
        System.out.println("1. Sorted list TV by name:\n" + sortedName);

        //2.	Отсортируйте телевизоры по цене.
        List <TVSet> sortedPrice = list.stream()
                .sorted(Comparator.comparing(TVSet::getPrice))
                .collect(Collectors.toList());
        System.out.println("\n2. Sorted list TV by price:\n" + sortedPrice);

        //3.	Найдите самый дорогой телевизор.
        OptionalInt maxPrice = list.stream()
                .mapToInt(TVSet::getPrice)
                .max();
        System.out.println("\n3.Expensive TV:\n" + maxPrice);

        //4.	Создайте коллекцию телевизоров с оценкой покупателей более 4,5.
        System.out.println("\n4. Buyers rating over 4.5:");
        list.stream()
                //.mapToDouble(TVSet::getMark)
                .filter(x -> x.getMark() > 4.5)
                .forEach(x -> System.out.println(x));

        //5.	Рассчитайте среднюю стоимость телевизоров, используя числовой стрим.
        OptionalDouble avgPrice = list.stream()
                .mapToInt(TVSet :: getPrice)
                .average();
        System.out.println("\n5. Average price TV: " + avgPrice.getAsDouble());

        /*//6.	Найдите самый дешёвый телевизор с диагональю 32 дюйма.
        OptionalInt cheapTV = list.stream()
                .mapToInt(TVSet::getPrice)
                .filter(x -> x == 32)
                .min();
        System.out.println("\n3.Cheapest TV:\n" + cheapTV.getAsInt());
         */

        //7.	Проверьте, у всех ли телевизоров оценка покупателей больше 4. (bool)
        boolean markByers = list.stream()
                .anyMatch(TVSet -> TVSet.getMark() <= 4);
        System.out.println("7. All TVs have a mark more than 4? - " + markByers);

        //8.	Проверьте, есть ли телевизор стоимостью более 30 тыс. руб.(bool)
        boolean pricePredicate = list.stream().anyMatch(TVSet -> TVSet.getPrice() >= 30000);
        System.out.println("8. Have TVs a price more than 30000? - " + pricePredicate);

        /*
        9.	Найдите самый дорогой телевизор, используя maxBy().
        10.	Разделите все телевизоры на 2 коллекции: с диагональю больше  и меньше 30 дюймов.
        11.	Сгруппируйте все телевизоры по маркам.
        12.	Для каждой марки посчитайте количество телевизоров и среднюю цену.
        13.	Сформируйте строку «Модели телевизоров стоимостью от 10 до 15 тыс. руб.: …, …, …. .».
         */



    }
}