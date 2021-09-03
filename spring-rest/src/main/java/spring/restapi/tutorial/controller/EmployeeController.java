package spring.restapi.tutorial.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.restapi.tutorial.domain.Employee;
import spring.restapi.tutorial.exception.EmployeeNotFoundException;
import spring.restapi.tutorial.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository repository;

    //Aggregate root
    //tag::get-aggregate-root[]
    @GetMapping("/employees")
    public List<Employee> all() {
        return repository.findAll();
    }
    //end::get-aggregate-root[]

    @PostMapping("employees")
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    //Single item

    @GetMapping("/employees/{id}")
    public Employee one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
