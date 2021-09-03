package spring.restapi.tutorial.exception;

public class EmployeeNotFoundException extends RuntimeException { //404
    public EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
