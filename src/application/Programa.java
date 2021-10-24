package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programa {
    public static void main(String[] args) {

        // Covariância
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);

        List<? extends Number> lista2 = lista;
        Number x = lista2.get(0);
        //lista2.add(20); esta linha não é permitida, erro de compilação. GET = 0K, PUT = NOK

        // Contravariância
        List<Object> objetos = new ArrayList<>();
        objetos.add("Maria");
        objetos.add("João");

        List<? super Number> numeros = objetos;
        numeros.add(3.14);
        numeros.add(3.14 * 2);

        //x = numeros.get(0); esta linha não é permitida, erro de compilação. GET = N0K, PUT = OK

        List<Integer> inteiros = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> decimais = Arrays.asList(3.14, 3.14 * 2, 3.14 * 3);
        objetos = new ArrayList<>();

        copiar(inteiros, objetos);
        System.out.println("Lista de objetos pós cópia dos inteiros: ");
        imprimirLista(objetos);

        copiar(decimais, objetos);
        System.out.println("Lista de objetos pós cópia dos decimais: ");
        imprimirLista(objetos);
    }

    public static void copiar(List<? extends Number> origem, List<? super Number> destino){
        for (Number number : origem){
            destino.add(number);
        }
    }

    public static void imprimirLista (List<?> lista){
        for (Object objeto : lista){
            System.out.println(objeto + " ");
        }
    }
}
