public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(String message) {
        super("неправильные данные " + message);
    }
}
