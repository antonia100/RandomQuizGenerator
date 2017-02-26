package quiz;

import quiz.questions.Question;
import quiz.questions.QuestionManager;

import java.io.File;
import java.util.ArrayList;

public class QuizGenerator {

    private Handler handler;
    private QuestionManager questionManager;
    private ArrayList<File> files;

    public QuizGenerator(Handler handler, QuestionManager questionManager) {
        this.handler = handler;
        this.questionManager = questionManager;
    }

    private void generateFiles() {
        files = new ArrayList<>();
        String pathArt = "src/resources/subjects/art.txt";
        String pathBiology = "src/resources/subjects/biology.txt";
        String pathChemistry = "src/resources/subjects/chemistry.txt";
        String pathGeography = "src/resources/subjects/geography.txt";
        String pathHistory = "src/resources/subjects/history.txt";
        String pathLiterature = "src/resources/subjects/literature.txt";
        String pathBMath = "src/resources/subjects/math.txt";
        String pathPhysics = "src/resources/subjects//physics.txt";

        File artFile = new File(pathArt);
        File biologyFile = new File(pathBiology);
        File chemistryFile = new File(pathChemistry);
        File geographyFile = new File(pathGeography);
        File historyFile = new File(pathHistory);
        File literatureFile = new File(pathLiterature);
        File mathFile = new File(pathBMath);
        File physicsFile = new File(pathPhysics);

        files.add(artFile);
        files.add(biologyFile);
        files.add(chemistryFile);
        files.add(geographyFile);
        files.add(historyFile);
        files.add(literatureFile);
        files.add(mathFile);
        files.add(physicsFile);
    }

    public ArrayList<Question> generateQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        generateFiles();

        for (File file : files) {
            //add one question from a file


//            Random random = new Random();
//
//            while(generatedQuestion == null){
//                try {
//                    int randomIndex = random.nextInt(10);
//                    generatedQuestion = questionManager.generateRandQuestion(file.getPath(), randomIndex);
//                    questions.add(generatedQuestion);
//                } catch (NullPointerException e){
//                    System.out.println(e);
//                }
//            }
//
//            generatedQuestion = null;


            int random = (int) Math.ceil(Math.random() * 10);
            Question generatedQuestion = questionManager.generateRandQuestion(file.getPath(), random);

            if(generatedQuestion!=null){
                questions.add(generatedQuestion);
            }

        }

        return questions;
    }

}
