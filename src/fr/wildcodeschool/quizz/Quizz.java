package fr.wildcodeschool.quizz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Quizz {

    private static String[] questions = {
            "Question 1",
            "Question 2",
            "Question 3"
    };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get("quizz.txt");

        System.out.println("\nQuizz Checkpoint 1 - Android/Java\n");
        System.out.println("Si tu te trompes sur une question, tu pourras éditer le fichier généré ensuite.\n");

        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
            for (int i = 0; i < questions.length; i++) {

                String question = (i + 1) + ". " + questions[i];
                System.out.println(question);
                System.out.println("Réponse : ");
                String answer = scanner.nextLine();
                System.out.println("\n");

                writer.write(question + "\n" + answer + "\n\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        System.out.println("Le fichier quizz.txt a été généré, tu peux l'éditer manuellement si tu souhaites le corriger.");
    }
}
