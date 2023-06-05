import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeDetailsAPI {

    private List<Employee> employees = new ArrayList<>();

    @PostMapping("/employees")
    public ResponseEntity<String> storeEmployeeDetails(@RequestBody Employee employee) {
        if (!validateEmployee(employee)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid employee data");
        }

        // Store the employee details
        employees.add(employee);
        return ResponseEntity.ok("Employee details stored successfully");
    }

    private boolean validateEmployee(Employee employee) {
        // Validate the employee fields here
        if (employee.getEmployeeId() == null || employee.getFirstName() == null || employee.getLastName() == null
                || employee.getEmail() == null || employee.getPhoneNumber() == null || employee.getDoj() == null
                || employee.getSalary() == null) {
            return false;
        }

        // Add additional validation rules if necessary

        return true;
    }
}
