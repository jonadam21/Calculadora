/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica2 {

    public static Scanner sc = new Scanner(System.in);
       
    public static void main(String[] args) {
        

        double res = 0;
        String operacion = "";
        boolean comprobar = true;
   
        do {
                        
            MenuPrincipal(comprobar);
                     
            DemanarImostrarDades(comprobar, operacion, res);
            
            sortirOcontinuar();
                
            
            
            //Surtir o continuar      
            do {
                comprobar = true;
                operacion = sc.nextLine();
                System.out.println("----------------------------");

                switch (operacion) {
                    case "s":
                    case "S":
                    case "n":
                    case "N":
                        break;
                    default:
                        System.err.println("\nError, posa un valor vàlid. \n");
                        comprobar = false;
                }
            } while (comprobar != true);      
        } while (operacion.equals("s") || operacion.equals("S"));
    
    }
    
    
     
      
       public static void MenuPrincipal(boolean comprobar){
       
            System.out.println("Calculadora " 
                        + "\n------------");
            System.out.print("Sumar (+)"
                        + "\nRestar (-)"
                        + "\nMultiplicació (x) "
                        + "\nDivicio (/)"
                        + "\nElevar primer num al segon num (*)"
                        + "\nResidu (%)\n"
                        + "\nSelecciona una operació(Indica el signe): ");
            
        }    
    
        


        public static void DemanarImostrarDades(boolean comprobar, String operacion, double res){
                          
            operacion = sc.nextLine();
            if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x")
                    || operacion.equals("/") || operacion.equals("*")
                    || operacion.equals("%")) {
                comprobar = true;
            } else {
                comprobar = false;
            }
                
                 String numero1, numero2;
            do {
                System.out.println("----------------------------");
                System.out.print("Introdueix el primer número: ");
                numero1 = sc.nextLine();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume1 = Double.parseDouble(numero1);
            double n1 = new Double(numero1);
            
            do {
                System.out.print("\nIntrodueix el segon número: ");
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume2 = Double.parseDouble(numero2);
            double n2 = new Double(numero2);
           
            
            do {
                comprobar = true;
                switch (operacion) {
                    case "+":
                        res = n1 + n2;
                        break;
                    case "-":
                        res = n1 - n2;
                        break;
                    case "x":
                    case "X":
                        res = n1 * n2;
                        break;
                    case "/":
                        while (n2 == 0) {
                            do {
                                System.err.println("Al denominador hi ha un zero"
                                        + "\nper a evitar errors coloca un altre valor.");
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                            nume2 = Double.parseDouble(numero2);
                            n2 = new Double(numero2);
                        }
                        res = n1 / n2;
                        break;
                    case "*":
                        res = Math.pow(n1, n2);
                        break;
                    case "%":
                        while (n2 == 0) {
                            do {
                                System.err.println("Al denominador hi ha un zero"
                                        + "\nper a evitar errors coloca un altre valor.");
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                            nume2 = Double.parseDouble(numero2);
                            n2 = new Double(numero2);
                        }
                        res = n1 % n2;
                        break;
                        }
            } while (comprobar != true);
               
            System.out.println("\nResultat: (" + numero1 + " " + " " +operacion + " " + numero2 + ")" + " = " + res);
            System.out.println("----------------------------");
               
        }
        
        
        
        
        public static void sortirOcontinuar(){
            
            System.out.println("\nVols continuar operant?");
            System.out.println("\nIntrodueix: [s/n]");
             
        }
}
