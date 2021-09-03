package spring.restapi.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.restapi.tutorial.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
