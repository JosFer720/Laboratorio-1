//POO
//Sección 10
//Fernando Ruíz

import java.util.Scanner;

public class Raul {

    public static void main(String[] args) {
        Player player1 = new Player("Jugador 1");
        Player player2 = new Player("Jugador 2");

        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;
        Player currentPlayer = player1;

        while (!gameOver) {
            System.out.println(currentPlayer.getName() + ", presione '1' para lanzar el dado o '2' para pasar de turno");
            String opcion = sc.nextLine();

            if (opcion.equalsIgnoreCase("1")) {
                int pointsPlayer1 = rollDice();
                int pointsPlayer2 = rollDice();

                System.out.println(currentPlayer.getName() + " dado 1: " + pointsPlayer1 + " puntos.");
                System.out.println(currentPlayer.getName() + " dado 2: " + pointsPlayer2 + " puntos.");

                int totalPoints = pointsPlayer1 + pointsPlayer2;

                if (pointsPlayer1 == 1 || pointsPlayer2 == 1) {
                    currentPlayer.resetScore();
                    System.out.println(currentPlayer.getName() + " sacó un 1 en uno de los dados, pierde todos sus puntos, pasa el otro jugador.");
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;

                } else {
                    currentPlayer.addToScore(totalPoints);
                    System.out.println(currentPlayer.getName() + " obtuvo " + totalPoints + " puntos.");
                    System.out.println("Puntos acumulados: " + currentPlayer.getScore());

                    if (currentPlayer.getScore() >= 100) {
                        gameOver = true;
                    } else if (currentPlayer.getScore() >= 20) {
                        System.out.println(currentPlayer.getName() + " ha llegado a los 20 puntos o más, pasa turno");
                        currentPlayer = (currentPlayer == player1) ? player2 : player1;
                    }
                }
            } else if (opcion.equalsIgnoreCase("2")) {
                System.out.println("Pasa turno");
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } else {
                System.out.println("Opción inválida");
                break;
            }
        }

        System.out.println(currentPlayer.getName() + " gana con " + currentPlayer.getScore() + " puntos");
    }

    public static int rollDice() {
        int numberOfFaces = 6;
        return (int) (Math.random() * numberOfFaces) + 1;
    }
}