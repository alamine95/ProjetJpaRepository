package sn.esmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.esmt.domaine.*;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
