package estructura.datos;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    private static String [] palabras = null;
    public static void main(String[] args) {
	// Arbol Binario Almacenado:
        ArbolBinario arbolBinario = new ArbolBinario();
        arbolBinario.insertar(4,"a");
        arbolBinario.insertar(5,"b");
        arbolBinario.insertar(3,"c");
        arbolBinario.insertar(2,"d");
        arbolBinario.insertar(6,"e");
        arbolBinario.insertar(8,"f");
        arbolBinario.insertar(1,"g");
        arbolBinario.insertar(10,"h");
        arbolBinario.insertar(9,"i");
        arbolBinario.insertar(7,"j");

       // System.out.println("\nSe recorre en orden de Mayor a Menor");
       // arbolBinario.viewMaxtoMin(arbolBinario.raiz); // Se recorre desde la Raiz

        //Se extraen las palabras del archivo
        try {
            palabras = readFile("C:\\UCOMPENSAR\\ArbolBinario\\recursos\\archivoFrase.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map datos =contadorPalabras(palabras);
        ArbolBinario arbolFrase = new ArbolBinario();

        Iterator it = datos.keySet().iterator();
        while(it.hasNext()){
            Object key = it.next();
            arbolFrase.insertar((Integer) datos.get(key),key);
            //System.out.println("Clave: " + key + " -> Valor: " + datos.get(key));
        }
        arbolFrase.viewMaxtoMin(arbolFrase.raiz);
    }


    private static Map contadorPalabras(String[] palabras) {
        int contador = 1;
        System.out.println("\nCantidad de palabras: "+palabras.length);
        Map keyAndWord = new HashMap<String, Integer>();
        for (int i = 0; i < palabras.length; i++) {
            for (int j = 0 ; j < palabras.length; j++){
                if(palabras[i].equals(palabras[j])){
                    contador++;
                }
                //contador = 0;
            }
            keyAndWord.put(palabras[i],contador);
            contador = 0;
        }
        return keyAndWord;
    }

    public static  String[] readFile(String path) throws IOException {
        File document = new File(path);
        String [] partes=null;
        try {
            BufferedReader obj = new BufferedReader(new FileReader(document));
            String linealeida;
            while((linealeida = obj.readLine()) !=null){
                partes = linealeida.split(" ");
            }
            return partes;
            /*for(String palabras:partes){
                System.out.println("palabras: "+palabras);
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return partes;
        }
    }
}
