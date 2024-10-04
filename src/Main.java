import Fila.ColoracaoFila;
import Util.Pixels;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual método quer usar? 1- Fila --- 2-Stack/Pilha");
        int resposta = scanner.nextInt();

        switch (resposta){
            case 1:
                ColoracaoFila.executar();
                break;
            case 2:
                ColoracaoStack.executar();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }

}
}
