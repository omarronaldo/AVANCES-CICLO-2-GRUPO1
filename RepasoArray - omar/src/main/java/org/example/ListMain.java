package org.example;

import java.util.ArrayList;
import java.util.List;

public class ListMain {
    //Puntos: Pastor Lovon (2), Bonnier(1),
    public static void main(String[] args) {
        List<Persona> per=new ArrayList<>();
        per.add(new Persona("Pablito", "P", 'F'));
        per.add(new Persona("Pablito", "P", 'F'));
        per.add(new Persona("Pedro", "P", 'F'));
        System.out.println(per.get(2).getNombre());


        ArrayList<Persona> p=new ArrayList<>();
        p.add(new Persona("Pablito", "P", 'F'));
        System.out.println(p.get(0).getNombre());;

        Persona[] pp=new Persona[10];
        pp[0]=new Persona("Pablito", "P", 'F');
        System.out.println(pp[0].getNombre());
    }


}
