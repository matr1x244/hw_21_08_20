/*
1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
при подаче массива другого размера необходимо бросить исключение MyArraySizeException.

2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.

3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.
 */

public class Main {

    public static void main(String[] args) {

        int result = 0; // рузультат нулевой

        String[][] array1 = {{"1","31","13","1"},{"1","1","1","1"}};
        String[][] array2 = {{"1","2","5","113","1"},{"1","2","4","4"}};
        String[][] array3 = {{"1","1","3","4",},{"1","2","аа3","4"}};

        System.out.println("Нормальный массив 4х4");
        try { // попробуй
            result = 0;
            result = list(array1); // массив 1
        } catch(MySizeArrayException e){ // поймай ошибку
            System.out.println(e.getMessage()); // вывести что за ошибка
        } catch(MyArrayDataException e){ // поймай ошибку
            System.out.println(e.getMessage()); // вывести что за ошибка
        } finally { // всё равно выполни код далее
            System.out.println("Результат элементов массива: "+String.valueOf(result));
        }

        System.out.println("не правильный массив более 4х4");
        try {
            result = 0;
            result = list(array2); // массив 2
        } catch(MySizeArrayException e){
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Результат элементов массива: "+String.valueOf(result));
        }

        System.out.println("не правильный массив попались буквы");
        try {
            //result = 0;
            result = list(array3); // массив 3
        } catch(MySizeArrayException e){
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Результат элементов массива: "+String.valueOf(result));
        }

    }

    public static int list (String[][] array) throws MySizeArrayException, MyArrayDataException {

        int summ = 0;
        int value = 0;
        int row = 0;
        int cell = 0;

        if(array.length != 2 || array[0].length != 4 || array[1].length != 4) {
            throw new MySizeArrayException(); // создать ошибку
        }

        for(int i = 1; i < 3; i++){
            row = i;
            for(int j = 1; j < 5; j++){
                cell = j;
                try{
                    value = Integer.parseInt(array[i-1][j-1]); // преобразовать в цифры
                    summ += value;
                } catch (IllegalArgumentException e){
                    String message = "в "+String.valueOf(row)+" ряду, "+String.valueOf(cell)+" ячейке"; // найти где ошибка и вывести
                    throw new MyArrayDataException(message); // создать ошибку вывести сообщение
                }
            }
        }

        return summ;
    }
}
