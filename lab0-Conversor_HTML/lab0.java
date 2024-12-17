package lab0;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class lab0 {
    public static void main(String[] args) {
        String texto = "", textoaux = "";
        boolean verificador = true, verificador2 = true;
        try {
            File arquivo = new File("entrada.txt");
            Scanner scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()) {
                texto += scanner.nextLine() + "\n";
            }
            scanner.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");

            return;
        }
        System.out.println(texto);

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == '*') {
                if (verificador) {
                    textoaux += "<b>";
                } else {
                    textoaux += "</b>";
                }
                verificador = !verificador;

            } else if (texto.charAt(i) == '_') {
                if (verificador2) {
                    textoaux += "<i>";
                } else {
                    textoaux += "</i>";
                }
                verificador2 = !verificador2;
            } else
                textoaux += texto.charAt(i);

        }
        System.out.println(" Seu texto convertido:\n\n\n");
        System.out.println(textoaux);

    }
}