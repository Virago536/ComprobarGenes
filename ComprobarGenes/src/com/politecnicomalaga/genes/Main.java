package com.politecnicomalaga.genes;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean loop = true;
        String resp;
        Kgen genCargado = null;
        Scanner sc = new Scanner(System.in);
        
        String fileName;
        int cont = 0;

        while (loop) {
            System.out.println("--------------------------------------");
        	System.out.println("Identificador de cadenas genéticas");
        	System.out.println("--------------------------------------");
            System.out.println("A. Introducir un fichero de genes");
            System.out.println("B. Ver coincidencias genéticas");
            System.out.println("C. Salir");
            System.out.println("--------------------------------------");

            resp = sc.nextLine();
            
            switch (resp) {
                case "A":
                    System.out.println("Introduzca el nombre del archivo FASTA:");
                    fileName = sc.nextLine();
                    if (!fileName.toLowerCase().endsWith(".fasta")) {
                        System.out.println("Hay que introducir un archivo fasta");
                        break;
                    }
                    genCargado = new Kgen(fileName);
                    genCargado.leerArchivo(fileName);
                    System.out.println("Fichero FASTA cargado correctamente");
                    break;
                case "B":
                    if (genCargado == null) {
                        System.out.println("No se ha agregado ningún archivo FASTA");
                        break;
                    }
                    System.out.println("Introduzca el tamaño de las cadenas genéticas:");
                    try {
                    	cont = Integer.valueOf(sc.nextLine());
                    }catch(NumberFormatException n) {
                    	System.out.println("Tamaño de cadena no válido");
                    	break;
                    }finally {
                    	if(cont<1) {
                    		System.out.println("Tamaño de cadena no válido");
                        	break;
                    	}
                    }
                    
                    
                    
                    Map<String, Integer> mapakgen = genCargado.getKgen(cont);
                    System.out.println("Mapa genes: ");
                    System.out.println("//");
                    for (Map.Entry<String, Integer> cadena : mapakgen.entrySet()) {
                        System.out.println(cadena.getKey() + ": " + cadena.getValue());
                    }
                    break;
                case "C":
                    System.out.println("Adios");
                    loop = false;
                    break;
            }
        }
    }
       
}

       
}

