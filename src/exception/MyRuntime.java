package exception;

public class MyRuntime extends RuntimeException {
    public MyRuntime(String mensaje){
        super(mensaje);
    }
}
