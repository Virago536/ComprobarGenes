package com.politecnicomalaga.genes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Kgen {
    private String data;
    private String fileName;

    public Kgen(String fileName) {
        this.fileName = fileName;
        this.data = data;
    }

    public void leerArchivo(String filePath) {
        String lineaCompleta = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String lineaGen;
            while ((lineaGen = br.readLine()) != null) {
                if (!lineaGen.startsWith(">")) {
                	lineaCompleta += lineaGen;
                }
            }
            br.close();
            br = null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        this.data = lineaCompleta;
    }

    public Map<String, Integer> getKgen(int cont) {
        Map<String, Integer> mapaGenes = new HashMap<>();
        for (int i = 0; i <= data.length() - cont; i++) {
            String adn = data.substring(i, i + cont);
            mapaGenes.put(adn, mapaGenes.getOrDefault(adn, 0) + 1);
            
        }
        return mapaGenes;
    }

    public String getData() {
        return data;
    }

    public String getFileName() {
        return fileName;
    }

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
    
}

	
	
