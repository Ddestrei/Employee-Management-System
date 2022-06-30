package ddestrei.lol.EmployeeManegmentSystemThymeLeaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployee());
        return "homePage";
    }

    @GetMapping("/showAddEmployee")
    public String showEmployeePage(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "addEmployeePage";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/getEmployee/{id}")
    public String getEmployee(@PathVariable( value = "id") Long id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "update_employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
