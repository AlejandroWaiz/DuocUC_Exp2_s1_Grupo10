/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exp2_s1_grupo10;

import java.util.Scanner;

/**
 *
 * @author Aleja
 */
public class Exp2_S1_Grupo10 {

    public static void main(String[] args) {
        
        //Variable initialization
        boolean ClientStillBuying = true;
        boolean ValidDiscountAnswer = false; 
        boolean FoundedSeat = false;
        boolean WannaStillBuyingIsValid = false;
        
        int SeatPrice = 5000;
        int SeatPriceWithDiscounts = 0;
        int TotalPurchaseValue = 0;
        
        String[] TeatherSits = {"A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"};
        String ChoosenSeatToBuy = "";
        
        //1 for student, 2 for senior citizens, 3 for both
        int ChoosenDiscountOption = 0;
        //1 for yes, 2 for no, other value is invalid
        int WannaStillBuyingInputOption = 0;
     
        Scanner scanner = new Scanner(System.in);
        
        //Start
        
        System.out.println("Bienvenidos a ticketpro!");
            
        System.out.println("Funciones disponibles: \n'Tiburón - 8pm' ");
        System.out.println("Precio entrada: $5000 ");
        System.out.println("!Tenemos descuentos disponibles\nEstudiantes: 10%\nAdultos mayores: 15%");
            
        while (ClientStillBuying){
            
            System.out.println("Asientos disponibles:\n");
            
            for (int i = 0; i < TeatherSits.length; i++) {
                System.out.print(TeatherSits[i]);
                if ((i + 1) % 3 == 0) {
                    System.out.println();
                } else {
                    System.out.print(" | ");
                }
            }
        
            System.out.println("¿Cual asiento desea comprar?");
            ChoosenSeatToBuy = scanner.next();
            
            //reset in case the user buys more than one seat
            ValidDiscountAnswer = false;

            for (int i = 0; i < TeatherSits.length; i++) {
                if (TeatherSits[i].toLowerCase().equals(ChoosenSeatToBuy.toLowerCase())) {
                    
                    while(!ValidDiscountAnswer) {
                        
                        System.out.println("Descuentos disponibles! Ingrese su edad:\n -Si es estudiante (menor de 27 años) tiene un 10%\n Si es adulto mayor tiene un 15%");
                        int UserAge = 0;
                        UserAge = scanner.nextInt();
                        
                        if(UserAge > 0 && UserAge <= 27){
                            SeatPriceWithDiscounts = 4500;
                            TotalPurchaseValue = TotalPurchaseValue + SeatPriceWithDiscounts;
                            ValidDiscountAnswer = true;
                             break;                    
                        }else if (UserAge > 65 && UserAge < 118){
                            SeatPriceWithDiscounts = 4250;
                            TotalPurchaseValue = TotalPurchaseValue + SeatPriceWithDiscounts;
                            ValidDiscountAnswer = true;
                            break;   
                        } else {
                            System.out.println("Por favor, elige una opcion válida");
                        }
                        
                        //Se que es un caso ficticio pero, hipoteticamente hablando, pueden haber adultos mayores estudiantes, asique escribi
                        //los dos codigos por si acaso, pero de todas formas dejé como lo pidió arriba y abajo comentado como sentía que tenia mas
                        //sentido
                        
                        /*System.out.println("!Descuentos disponibles! Si es estudiante escriba 1, si es adulto mayor escriba 2, si es ambas escriba 3 y si no es ninguna de las anteriores, escriba 4");
                        ChoosenDiscountOption = scanner.nextInt();
                        switch (ChoosenDiscountOption) {
                            case 1 -> {
                                SeatPriceWithDiscounts = 4500;
                                TotalPurchaseValue = TotalPurchaseValue + SeatPriceWithDiscounts;
                                ValidDiscountAnswer = true;
                                break;
                            }
                            case 2 -> {
                                SeatPriceWithDiscounts = 4250;
                                TotalPurchaseValue = TotalPurchaseValue + SeatPriceWithDiscounts;
                                ValidDiscountAnswer = true;
                                break;
                            }
                            case 3 -> {
                                SeatPriceWithDiscounts = 3750;
                                TotalPurchaseValue = TotalPurchaseValue + SeatPriceWithDiscounts;
                                ValidDiscountAnswer = true;
                                break;
                            }
                            case 4 -> {
                                //Discount of 0%
                                SeatPriceWithDiscounts = 5000;
                                TotalPurchaseValue = TotalPurchaseValue + SeatPriceWithDiscounts;
                                System.out.println("Gracias por su honestidad");
                                ValidDiscountAnswer = true;
                                break;
                            }
                            default -> System.out.println("Por favor, elige una opcion válida");
                        }                     
                        */                 
                    }
                   
                    TeatherSits[i] = "-";
                    FoundedSeat = true;
                    System.out.println("Asiento " + ChoosenSeatToBuy + " comprado con éxito por un valor de: $" + SeatPriceWithDiscounts + ".");
                    
                    break;
                }
            }
                     
            //If not founded or already selled
            if (!FoundedSeat) {
                System.out.println("Asiento no disponible o entrada inválida. Intente de nuevo.\n");
            }
            
            System.out.println("Si desea seguir comprando escriba 1, en caso contrario, 2:");
            
            WannaStillBuyingInputOption = scanner.nextInt();
           
            while(!WannaStillBuyingIsValid){
                
                switch (WannaStillBuyingInputOption) {
                case 1 -> {
                    WannaStillBuyingIsValid = true;
                    break;
                }               
                case 2 -> {
                    System.out.println("Entonces el total de su compra seria de: $" +TotalPurchaseValue+ "\n!Nos vemos a las 8pm!");
                    WannaStillBuyingIsValid = true;
                    ClientStillBuying = false;
                    break;
                }
                default -> {
                    System.out.println("Eliga una opción válida");
                }
              }               
            }
            
            WannaStillBuyingIsValid = false;
         }
     }
}
