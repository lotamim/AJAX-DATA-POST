package jquey.demo.repositories;

import jquey.demo.models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @Query(value = "SELECT emp.id,emp.emp_first_name, emp.emp_last_name,\n" +
                    "dept.dept_name FROM employee emp,department as dept\n" +
                    "WHERE dept.id = emp.department_id\n" +
                    "order by id ASC ", nativeQuery = true)
    List<Map<String, String>> getEmployeeAll();


    @Query(value = "SELECT emp.id,emp.emp_first_name, emp.emp_last_name,\n" +
                    "dept.dept_name,dept.id AS dept_id FROM employee as emp,department as dept\n" +
                    "WHERE emp.id = :empId \n" +
                    "AND dept.id = emp.department_id\n" +
                    "order by id ASC ", nativeQuery = true)
    Map<String,String> getEmployeeById(@Param("empId") int empId);


}
