package pe.edu.cibertec.api_rest_ventas.exception;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(String mensaje){

        super(mensaje);

    }
}
