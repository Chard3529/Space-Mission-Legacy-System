package no.loopacademy;
import java.io.FileWriter;

public class FileWrite implements Writer {

    @Override
    public void write(String str) {
        try (FileWriter fw = new FileWriter(Config.logFile, true)) {
            fw.write(str);
             
        } catch (Exception e) {
            e.printStackTrace();
             
        }
    }
}
