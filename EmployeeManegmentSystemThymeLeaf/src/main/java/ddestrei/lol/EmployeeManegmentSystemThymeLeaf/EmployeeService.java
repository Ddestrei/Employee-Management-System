package ddestrei.lol.EmployeeManegmentSystemThymeLeaf;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    void save(Employee employee);

    public Employee getEmployeeById(Long id);

    public void deleteEmployee(Long id);
}
