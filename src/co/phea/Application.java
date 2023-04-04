package co.phea;

import co.phea.connectionDB.JdbcImp;
import co.phea.model.Employee;
import co.phea.view.WelcomeView;
import java.util.Scanner;

public class Application {
    private static JdbcImp jdbc = new JdbcImp();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Employee employee = new Employee();
        WelcomeView welcomeView = new WelcomeView();
        do {
            System.out.println("=================================");
            System.out.println("\t Option Database ");
            System.out.println("=================================");
            System.out.println("1-> Select records");
            System.out.println("2-> Select a record by ID ");
            System.out.println("3-> Select a record by Name ");
            System.out.println("4-> Insert a record");
            System.out.println("5-> Update a record");
            System.out.println("6-> Delete a record");
            System.out.print("Choose one options : ");
            int options = scanner.nextInt();
            switch (options){
                case 1 ->{
                    System.out.println("========= Select Record ==========");
                    welcomeView.viewSelect();
                }
                case 2->{
                    System.out.println("========= Select Record by Id ==========");
                    welcomeView.viewSelectById();
                }
                case 3 ->{
                    System.out.println("========= Select Record By Name ==========");
                    welcomeView.viewSelectByName();
                }
                case 4->{
                    System.out.println("========= Insert Record ==========");
                    welcomeView.viewInsert(employee);
                }
                case 5->{
                    System.out.println("========= Update Record ==========");
                    welcomeView.viewUpdate();
                }
                case 6->{
                    System.out.println("========= Delete Record ==========");
                    welcomeView.viewDeleteByID();
                }
                case 7->{
                    System.out.println("========== Exit DataBase ==========");
                    System.exit(0);
                }
            }
        }while(true);

    }
}
