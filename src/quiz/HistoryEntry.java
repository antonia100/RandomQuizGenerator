package quiz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class HistoryEntry {

    private String date;
    private int points;
    private Handler handler;

    public HistoryEntry(String date, int points, Handler handler){
        this.date = date;
        this.points = points;
        this.handler = handler;

        writeEntry();
    }

    private void writeEntry(){
        String historyPath = "src/resources/userhistory.txt";
        File file = new File(historyPath);

        try(FileOutputStream fos = new FileOutputStream(file, true)){

            String entry = buildEntryString(date, points);

            byte[] contentBytes = entry.toString().getBytes();
            fos.write(contentBytes);

        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String buildEntryString(String date, int points){
        StringBuilder builder = new StringBuilder();
        builder.append("    Date: "  + date + " |       ");
        builder.append("Points: "  + points + "/8\n");

        return builder.toString();
    }

}
