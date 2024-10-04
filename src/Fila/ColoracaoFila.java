package Fila;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ColoracaoFila {
    public static void executar() {
        JFrame frame = new JFrame("Coloração de Imagem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        Scanner scanner = new Scanner(System.in);
        BufferedImage imagem = null;

        try {
            imagem = ImageIO.read(new File("C:\\Users\\gusap\\IdeaProjects\\FloodFill\\src\\Fila\\imagemJava.png"));
        } catch (IOException e) {
            System.out.println("Erro ao carregar a imagem: " + e.getMessage());
            return;
        }

        ImagePanel imagePanel = new ImagePanel(imagem);
        frame.add(imagePanel);
        frame.setVisible(true);

        System.out.print("Informe a coordenada x do pixel: ");
        int x = scanner.nextInt();
        System.out.print("Informe a coordenada y do pixel: ");
        int y = scanner.nextInt();

        if (x < 0 || x >= imagem.getWidth() || y < 0 || y >= imagem.getHeight()) {
            System.out.println("Coordenadas fora dos limites da imagem.");
            return;
        }

        Color novaCor = Color.RED;
        ColorirImagem colorirImagem = new ColorirImagem(imagem, novaCor);

        colorirImagem.floodFillComFila(x, y, imagePanel);

        System.out.println("Processo de coloração concluído.");
    }
}