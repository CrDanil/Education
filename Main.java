import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите числа и операторы через пробелы");
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine(); // Ввод

        if (spaces(in) == 2) { // Проверяем количество пробелов во входной строке (через метод spaces считаем пробелы
            String result = calc(in);
            System.out.println(result); // Вывод
        } else {    // Бросаем исключение, если количество пробелов больше или меньше 2
            throw new IOException("Введено неверное количество пробелов. Должно быть 2.");
        }
    }
    public static String calc(String input) throws IOException, IllegalArgumentException {

        String[] arrInp = input.split("\\s+"); // Разбиваем ввод по пробелам и добавляем в массив arrInp
        try { // Обрабатываем код на ошибку ввода (вместо цифры - буква, символ и т.д.)
            // исключение бросит при ошибке Integer.parseInt(arrInp[0] или [2])
            int operand1 = Integer.parseInt(arrInp[0]);  // Преобразовываем строку с индексом 0 в число
            String operator = arrInp[1];    // Оставляем символ с индексом 1 строковым
            int operand2 = Integer.parseInt(arrInp[2]); // Преобразовываем строку с индексом 2 в число

            String[] arrSymb = {"+", "-", "*", "/"}; // Массив для сравнения
            boolean Operator = false;
            for (String num : arrSymb) {
                if (num.equals(operator)) {
                    Operator = true;
                } // Ищем в массиве введённый символ оператора
            }

            if (!Operator) {
                throw new IOException("Введён неверный оператор");
            } // Бросаем исключение при операторе отличном от того, что есть в массиве
            if (operand1 > 10 || operand2 > 10) {
                throw new IOException("Введено число более 10");
            }
            if (operand1 < 1 || operand2 < 1) {
                throw new IOException("Введено число менее 1");
            } // Бросаем исключение при операндах отличных от требуемых заданием


            // Если все значения удовлетворяют, то запускаем нужную операцию
            int res = 0;
            if (Operator) {
                switch (operator) {
                    case "+" -> res = operand1 + operand2;
                    case "-" -> res = operand1 - operand2;
                    case "*" -> res = operand1 * operand2;
                    case "/" -> res = operand1 / operand2;
                }
            }
            return String.valueOf(res); // Возвращаем строку в метод main
        } catch (NumberFormatException e) {
            throw new IOException("Вместо цифры введен символ");
            // Обрабатываем код на ошибку ввода (вместо цифры - буква, символ и т.д.)
            // исключение бросит при ошибке Integer.parseInt(arrInp[0] или [2])
        }
    }
    public static int spaces(String input) {
        int count = 0;
        for (char c : input.toCharArray()) {  // Проход по каждому символу строки
            if (c == ' ') {  // Проверка, является ли символ пробелом
                count++;  // Увеличение счетчика, если символ - пробел
            }
        }
        return count;  // Возврат общего количества пробелов в строке
    }
}