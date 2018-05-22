/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf1120_tp2;

import java.util.Scanner;

/**
 *
 * @author ze6ulon
 */
public class INF1120_tp2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int year;
        char choice = '0';
        
        System.out.println("This software allows us to play PICO FERMI BAGELS and a TIC TAC TOE\n");

        do{
            System.out.println("\n----");
            System.out.println( "MENU");
            System.out.println("----");
            System.out.println("1. PICO FERMI BAGELS");
            System.out.println("2. TIC TAC TOE");
            System.out.println("3. EXIT");
            do{
                System.out.print("\nEnter your choice: ");
                choice = scan.next().charAt(0);
                switch(choice){
                    case '1':
                        System.out.println("Choice entered is 1 --> PICO FERMI BAGELS");
                        
                        break;
                    case '2':
                        System.out.println("Choice entered is 2 --> TIC TAC TOE");
                       
                        break; 
                    case '3':
                        System.out.println("Choice entered is 3 --> EXIT");
                        
                        break;
                    default:
                        System.out.print("\nMenu invalide. Please enter a value between 1 and 3... Please try it again !");
                }
            }while(choice < '1' || choice > '3' );
        }while(choice != '3');
    }
    
}
