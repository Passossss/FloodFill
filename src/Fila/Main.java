package Fila;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


// Classe Main
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Coloração de Imagem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        Scanner scanner = new Scanner(System.in);
        BufferedImage imagem = null;

        try {
            // Carregar a imagem
            imagem = ImageIO.read(new File("C:\\Users\\gusap\\IdeaProjects\\FloodFill\\src\\Fila\\imagemJava.png"));
        } catch (IOException e) {
            System.out.println("Erro ao carregar a imagem: " + e.getMessage());
            return;
        }

        ImagePanel imagePanel = new ImagePanel(imagem);
        frame.add(imagePanel);
        frame.setVisible(true);

        // Solicitar ao usuário as coordenadas do pixel
        System.out.print("Informe a coordenada x do pixel: ");
        int x = scanner.nextInt();
        System.out.print("Informe a coordenada y do pixel: ");
        int y = scanner.nextInt();

        // Verificar se as coordenadas estão dentro dos limites da imagem
        if (x < 0 || x >= imagem.getWidth() || y < 0 || y >= imagem.getHeight()) {
            System.out.println("Coordenadas fora dos limites da imagem.");
            return;
        }

        Color novaCor = Color.RED; // Cor para colorir (vermelho)
        ColorirImagem colorirImagem = new ColorirImagem(imagem, novaCor);

        // Executar flood fill com Fila
        colorirImagem.floodFillComFila(x, y, imagePanel);

        System.out.println("Processo de coloração concluído.");
    }
}