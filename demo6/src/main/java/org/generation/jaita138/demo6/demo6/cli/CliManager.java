package org.generation.jaita138.demo6.demo6.cli;

import java.util.List;
import java.util.Scanner;

import org.generation.jaita138.demo6.demo6.db.entity.Utente;
import org.generation.jaita138.demo6.demo6.db.entity.Role;
import org.generation.jaita138.demo6.demo6.db.service.RoleService;
import org.generation.jaita138.demo6.demo6.db.service.UtenteService;

public class CliManager {

    private Scanner sc;
    private UtenteService utenteService;
    private RoleService roleService;

    //costruttore
    public CliManager(UtenteService utenteService, RoleService roleService) {

        sc = new Scanner(System.in);
        this.utenteService = utenteService;
        this.roleService = roleService;

        printOptions();
    
    }

    private void printOptions() {

        System.out.println("Operazioni:");
        System.out.println("1. Leggi tutta la tabella");
        System.out.println("2. Inserisci nuovo record");
        System.out.println("3. Modifica record");
        System.out.println("4. Elimina record");
        System.out.println("5.Trova i nomi che iniziano per A");
        System.out.println("6. Trova utenti che iniziano con per a");
        System.out.println("7. Trovare gli utenti con credito maggiore di 10");
        System.out.println("8. Trovare gli utenti con nome o cognome null");
        System.out.println("9. trovare gli utenti con credito positivo ma inferiore a 10");
        System.out.println("10. Esci");
        System.out.println("");

        String strValue = sc.nextLine();
        int value = Integer.parseInt(strValue);

        switch (value) {

            case 1:
                readAll();
                break;
            case 2:
                insert();
                break;
            case 3:
                edit();
                break;
            case 4:
                delete();
                break;
            case 5:
                findByNomeStartingWith();
                break;
            case 6: 
                findByCognomeNullOrNomeNull();
                break;
            case 7:
                findByCreditoGreaterThan();
                break;
            case 8:
                findByCreditoBetween();
                break;
            case 9:
                return;

            default:
                System.out.println("Operazione non valida");
                break;
        }

        printOptions();
    }

    private void readAll() {

        List<Utente> utenti = utenteService.findAll();
        System.out.println("Utenti:");
        System.out.println(utenti);
        System.out.println("-------------------------------------");
    }

    private void salva(Utente u){

        boolean isEdit = u.getId() != null;

        System.out.println("nome: " + (isEdit ? "(" + u.getNome() + ")" : ""));
        String nome = sc.nextLine();
        u.setNome(nome);

        System.out.println("cognome: " + (isEdit ? "(" + u.getCognome() + ")" : "") );
        String cognome = sc.nextLine();
        u.setCognome(cognome);

        System.out.println("username: " + (isEdit ? "(" + u.getUsername() + ")" : ""));
        String username = sc.nextLine();
        u.setUsername(username);

        System.out.println("password: " + (isEdit ? "(" + u.getPassword() + ")" : ""));
        String password = sc.nextLine();
        u.setPassword(password);

        System.out.println("credito: " + (isEdit ? "(" + u.getCredito() + ")" : ""));
        int credito = sc.nextInt();
        sc.nextLine();
        u.setCredito(credito * 100);

        System.out.println("ruoli:");
        List<Role> roles = roleService.findAll();
        System.out.println(roles);
        System.out.println("ruolo id: " + (isEdit ? "(" + u.getRole().getId() + ")" : ""));
        String strRoleId = sc.nextLine();
        Long roleId = Long.parseLong(strRoleId);
        Role role = roleService.findById(roleId);
        System.out.println(role);

        utenteService.save(u);

    }

    private void insert() {

        Utente u = new Utente();

        salva(u);
    }

    private void edit() {

        System.out.println("edit id:");
        String strId = sc.nextLine();
        Long id = Long.parseLong(strId);
        Utente u = utenteService.findById(id);

        if (u == null) {

            System.out.println("Utente non trovato");
            return;
        }

        salva(u);
    }

    private void delete() {

        System.out.println("delete id:");
        String strId = sc.nextLine();
        Long id = Long.parseLong(strId);
        Utente u = utenteService.findById(id);

        if (u != null) {
            utenteService.delete(u);
            System.out.println("Utente " + strId + " eliminato");
        } else
            System.out.println("Utente non trovato");
    }

    private void findByNomeStartingWith() {

        List <Utente> u = utenteService.findByNomeStartingWith("A");
        System.out.println(u);
    }

    private void findByCreditoGreaterThan() {
        List <Utente> u = utenteService.findByCreditoGreaterThan(10);
        System.out.println(u);
 }

    private void findByCognomeNullOrNomeNull() {
        List <Utente> u = utenteService.findByCognomeNullOrNomeNull();
        System.out.println(u);
    }

    private void findByCreditoBetween() {
        
        List <Utente> u = utenteService.findByCreditoBetween(0, 10);
        System.out.println(u);
    }



}
