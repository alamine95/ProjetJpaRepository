package sn.esmt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
		//triDecroissantSalaire();
		//paginer();
		//paginerParametriquement();
		//nomIdentiques();
		//nomEtPrenomIdentique();
		salaireIdentiques();
		
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
	
	private void paginer() 
	{
		Page<Employee> page = repo.findAll(PageRequest.of(0, 2));
		System.out.println("Nombre d'enrg: "+page.getTotalElements());
		System.out.println("Nombre de page: "+page.getTotalPages());
		for (Employee x: page.getContent())
		{
			System.out.println("Id :"+x.getId()+" "+x.getNom()+" "+x.getSalbase());
		}
	}
	
	private void paginerParametriquement()
	{
		Page<Employee> page = repo.findAll(PageRequest.of(0, 2));
		int nombre_pages = page.getTotalPages();
		for (int i=0;i<nombre_pages;i++)
		{
			System.out.println("_____________________Page"+i+"___________");
			Page<Employee> page2 = repo.findAll(PageRequest.of(i, 2));
			for (Employee x: page2.getContent())
			{
				System.out.println("Id :"+x.getId()+" "+x.getSalbase());
			}
			System.out.println("_____________________________");
		}
	}
	
	private void nomIdentiques()
	{
		List<Employee> liste = repo.getByNom("Sow");
		for (Employee x: liste)
		{
			System.out.println("Id:"+x.getId()+" "+x.getNom());
		}
	}
	
	private void nomEtPrenomIdentique()
	{
		List<Employee> liste = repo.getByNomAndPrenom("Sow","Lamda");
		for (Employee x: liste)
		{
			System.out.println("Id:"+x.getId()+" "+x.getNom());
		}
	}
	
	private void salaireIdentiques()
	{
		List<Employee> liste = repo.getBySalbase(350000);
		for (Employee x: liste)
		{
			System.out.println("Id:"+x.getId()+" "+x.getNom()+" "+x.getNom());
		}
	}

}
