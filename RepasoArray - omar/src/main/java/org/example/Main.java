package org.example;


import java.util.Date;
import java.util.Scanner;

public class Main { //Pastor Lovon 2+1, Bonnier 1, Alicia 1
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!\n");
        int nomVec1[] ={1,2,3,4,5,6,7,8,9,10};

        for (int dato:nomVec1){
            System.out.println(dato);
        }

        Persona nomVec2[]={new Persona("Juan", "",'M'),
                new Persona("Pabblito","",'M')};
        System.out.println("Registro de ASistencia");

        Scanner leer=new Scanner(System.in);

        for(Persona p:nomVec2){
            System.out.println("Esta presente "+p.nombre+":");
            //p.estadoAsis=leer.nextLine();
            p.fechaReg=new Date();
            p.setEstadoAsis(leer.nextLine());
        }

        System.out.println("Mostar Registro ASsistencia");
        for (Persona p:nomVec2){
            //System.out.println(p.nombre+ " - "+p.estadoAsis);
            System.out.println(p.getNombre()+ " - "+p.getEstadoAsis()+ " - "
            +p.fechaReg);
        }


    }



}