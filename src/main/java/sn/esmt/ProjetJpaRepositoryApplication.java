package sn.esmt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import sn.esmt.domaine.Employee;
import sn.esmt.repository.*;

@SpringBootApplication
public class ProjetJpaRepositoryApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(ProjetJpaRepositoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		//afficherTout();
		//triCroissantNom();
		//triDecroissantNom();
		triDecroissantSalaire();
		
	}
	
	private void afficherTout()
	{
		List<Employee> liste = repo.findAll();
		for (Employee x:liste)
			System.out.println(x.getId()+" "+x.getNom()+" "+x.getSalbase());
	}
	
	private void triCroissantNom()
	{
		List<Employee> liste = repo.findAll(Sort.by("nom"));
		for (Employee x:liste)
			System.out.println(x.getId()+" "+x.getNom()+" "+x.getSalbase());
	}
	
	private void triDecroissantNom()
	{
		List<Employee> liste = repo.findAll(Sort.by("nom").descending());
		for (Employee x:liste)
			System.out.println(x.getId()+" "+x.getNom()+" "+x.getSalbase());
	}
	
	private void triDecroissantSalaire()
	{
		List<Employee> liste = repo.findAll(Sort.by("salbase").descending());
		for (Employee x:liste)
			System.out.println(x.getId()+" "+x.getNom()+" "+x.getSalbase());
	}

}
