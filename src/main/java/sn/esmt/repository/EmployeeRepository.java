package sn.esmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.esmt.domaine.*;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> 
{
	// methodes de recherches préfixées par getByX ou x est attribut de la classe
	List<Employee> getByNom(String snom);
	List<Employee> getByPrenom(String snom);
	List<Employee> getBySalbase(int sal);
	List<Employee> getByNomAndPrenom(String n,String p);
}
