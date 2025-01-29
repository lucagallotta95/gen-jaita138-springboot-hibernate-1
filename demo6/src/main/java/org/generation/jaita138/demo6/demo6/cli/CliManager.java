package org.generation.jaita138.demo6.demo6.cli;

import java.util.List;
import java.util.Scanner;

import org.generation.jaita138.demo6.demo6.db.entity.Utente;
import org.generation.jaita138.demo6.demo6.db.service.UtenteService;

public class CliManager {


    private Scanner sc;
    private UtenteService utenteService;

    public CliManager(UtenteService utenteService) {

        sc = new Scanner(System.in);
        this.utenteService = utenteService;

        printOptions();
    
    }

    private void printOptions() {

        System.out.println("Operazioni:");
        System.out.println("1. Leggi tutta la tabella");
        System.out.println("2. Inserisci nuovo record");
        System.out.println("3. Modifica record");
        System.out.println("4. Elimina record");
        System.out.println("5.Trova i nomi che iniziano per A");
        System.out.println("6. Esci");
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

    private void insert() {

        Utente u = new Utente();

        System.out.println("nome:");
        String nome = sc.nextLine();
        u.setNome(nome);

        System.out.println("cognome:");
        String cognome = sc.nextLine();
        u.setCognome(cognome);

        System.out.println("username:");
        String username = sc.nextLine();
        u.setUsername(username);

        System.out.println("password:");
        String password = sc.nextLine();
        u.setPassword(password);

        System.out.println("credito:");
        int credito = sc.nextInt();
        u.setCredito(credito * 100);

        utenteService.save(u);
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

        System.out.println("nome: (" + u.getNome() + ")");
        String nome = sc.nextLine();
        u.setNome(nome);

        System.out.println("cognome: (" + u.getCognome() + ")");
        String cognome = sc.nextLine();
        u.setCognome(cognome);

        System.out.println("username: (" + u.getUsername() + ")");
        String username = sc.nextLine();
        u.setUsername(username);

        System.out.println("password: (" + u.getPassword() + ")");
        String password = sc.nextLine();
        u.setPassword(password);

        System.out.println("virtuale: (" + u.getCredito() + ")");
        String strCredito = sc.nextLine();
        int credito = Integer.parseInt(strCredito);
        u.setCredito(credito * 100);

        utenteService.save(u);
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
