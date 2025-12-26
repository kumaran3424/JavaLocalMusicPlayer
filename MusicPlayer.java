import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MusicPlayer {

    public static void main(String[] args){

        // How to PLAY AUDIO with Java (.wav , .au , .aiff)

        String filepath = "C:\\Users\\KUMARAN\\Downloads\\Oorum_Blood.wav";
        File file = new File(filepath);

        try(  Scanner sc = new Scanner(System.in);
              AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){

            System.out.println("""
            Bootify Music Player(P or Q or N or S) 
            Play
            Quit
            Next
            Stop """);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            String response = "";
            while(!response.equals("q")) {
                System.out.print("Enter your Choice: ");
                response = sc.nextLine().toLowerCase();
                switch (response) {
                    case "p" -> clip.start();
                    case "s" -> clip.stop();
                    case "q" -> clip.close();
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        catch(UnsupportedOperationException e){
            System.out.println("Audio file is not supported.");
        }catch(UnsupportedAudioFileException e){
            System.out.println("File type not Supported.");
        }catch(LineUnavailableException e){
            System.out.println("File or Line is Unavailable ");
        }
        catch(IOException e){
            System.out.println("Something went wrong");
        }finally {
            System.out.println("Bye");

        }
    }
}
