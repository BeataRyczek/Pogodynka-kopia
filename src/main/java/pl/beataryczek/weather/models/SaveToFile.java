package pl.beataryczek.weather.models;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class SaveToFile {
    LocalDateTime localDateTime = LocalDateTime.now();

    public void saveToFile(String string, String city){
        File file =new File("file.txt");

        String toPrint = "\r\n" + localDateTime.toString() + "     " +  string;

        try {
            Files.write(file.toPath(), toPrint.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
