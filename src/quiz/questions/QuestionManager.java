package quiz.questions;

import quiz.Handler;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class QuestionManager {
    private Handler handler;

    public QuestionManager(Handler handler){
        this.handler = handler;
    }

    private static String generateRandString(String fileSourcePath, int randomLine){
        File file = new File(fileSourcePath);
        String line = new String();

        try(InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(isr)) {

            for(int i = 0; i<randomLine; i++){
                if(i==randomLine-1){
                    line = reader.readLine();
                }
                reader.readLine();
            }

        }  catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }


    public Question generateRandQuestion(String fileSourcePath, int randomLine){
        String line = generateRandString(fileSourcePath, randomLine);
        String [] tokens = line.split("\\|");
        String [] randOptions = Arrays.copyOfRange(tokens, 1, 5);

        try {
            int answer = Integer.valueOf(tokens[tokens.length - 1]);
            return new Question(randomLine,
                    tokens[0],
                    randOptions,
                    answer);
        } catch (NumberFormatException e){
            System.out.println(e);

            return null;
        }


    }

}
