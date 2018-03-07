package pl.beataryczek.weather.views;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MainMenu {

    private Scanner scanner;
    private int numberMenu;

    public MainMenu(){
        scanner = new Scanner(System.in);
    }

    public void printMenu(){
        System.out.println("=-------------------------=");
        System.out.println("=---Witaj w Pogodynce---=");
        System.out.println("=---1 Aktualna Pogoda---=");
        System.out.println("=--2 Pogoda na przyszle 5 dni--=");
        do{
            numberMenu = Integer.parseInt(scanner.nextLine());
        }while(!Pattern.matches("[012]", Integer.toString(numberMenu)));

    }

    public String getCityFromUser(){
        System.out.println("=---Podaj miasto: ");
        String city = scanner.nextLine();
        while(!Pattern.matches("[a-zA-Z]{1,}", city)){
            city = scanner.nextLine();
        }
        return city;
    }

    public void cleanConsole(int lines){
        for(int i =0; i<lines; i++){
            System.out.println();
        }
    }public void sendMassageToConsole(String message){
        System.out.println(message);
    }
    public int getNumberMenu(){
        return numberMenu;
    }

}
