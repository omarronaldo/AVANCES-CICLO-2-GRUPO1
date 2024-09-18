package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RegistroAsistencia {

   static List<Persona> p= new ArrayList<>();
   static ArrayList<Persona> pp= new ArrayList<>();

    public static void main(String[] args) {
        registrarAsistencia();
        mostrarAsistencia();
    }

    public static void registrarAsistencia(){
        Scanner cs=new Scanner(System.in);
        String exisAlumnos="";
        System.out.println("Registrar Asistencia a Curso POO");
        do{
            System.out.print("Ingres nombre Est:");
            String nombre=cs.nextLine();
            System.out.print("\n");
            System.out.print("Ingrese P=Presente, F=Falta:");
            String estado=cs.nextLine();
            System.out.print("\n");
            p.add(new Persona(nombre, estado, new Date()));
            pp.add(new Persona(nombre, estado, new Date()));
            System.out.println("Existe mas Alumnos? S=SI, N=NO");
            exisAlumnos=cs.nextLine();
        }while(exisAlumnos.toUpperCase().equals("S"));
    }

    public static void mostrarAsistencia(){
        System.out.println("Alamcenado en un LIST:");
        for(Persona p:p){
            System.out.println(p.toString());
        }
        System.out.println("Alamcenado en un ArraList:");
        for(Persona p:pp){
            System.out.println(p.toString());
        }
    }


}
