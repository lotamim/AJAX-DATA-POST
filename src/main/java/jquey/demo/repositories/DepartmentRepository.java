package jquey.demo.repositories;

import jquey.demo.models.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository  extends CrudRepository<Department,Integer> {
}
