package org.generation.jaita138.demo6.demo6;

import org.generation.jaita138.demo6.demo6.cli.CliManager;
import org.generation.jaita138.demo6.demo6.db.service.RoleService;
import org.generation.jaita138.demo6.demo6.db.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo6Application implements CommandLineRunner{


	@Autowired
	private UtenteService utenteService;

	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(Demo6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new CliManager(utenteService, roleService);
	}
	

}
