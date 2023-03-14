package co.edu.uniquindio.parcial1.tests;

import java.time.LocalDate;

import co.edu.uniquindio.parcial1.model.*;

public class Test1 {
    public static void main(String[] args) {
        Library biblioteca = new Library("Biblioteca UQ", "Cra 23 # 23 - 50", "1232313");
        try {
            System.out.println(biblioteca.addEmployer("Pablo", 20000d, ""));
        } catch (LibraryException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(biblioteca.addEmployer("Pablo", 20000d, ""));
        } catch (LibraryException e) {
            System.out.println(e.getMessage());
        }

        biblioteca.addLending(LocalDate.now(), LocalDate.now().plusWeeks(1), "1000",
                new Employer("Pablo", 20000d, ""));
        try {
            Employer employer = biblioteca.getEmployerByISBNOfLendings("ISBN");
        } catch (LibraryException e) {
            System.out.println(e.getMessage());
        }
    }
}