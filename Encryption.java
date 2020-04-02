import java.util.Scanner;

/**
 * Hier werden die Nachrichten VERschlÃ¼sselt.
 *
 * @author Akeshan
 * @version 27.03.2020 v1
 */

public class Encryption
{
    String msg;
    String key;
    String keyStream;
    String crypMessage = "";
    int newCode;
    int msgCode;
    int keyCode;
    Scanner scanner = new Scanner(System.in);

    char [] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
            'N','O','P','Q','R','S','T','U','V','W','X','Y','Z', //0-25
            'A','B','C','D','E','F','G','H','I','J','K','L','M', //26-50
            'N','O','P','Q','R','S','T','U','V','W','X','Y'};

    public void encrypt(){
        Enter pair = new Enter();
        pair.setMsg();
        msg = pair.getMsg();
        msg = msg.toUpperCase(); // alles auf GroÃŸbuchstaben
        pair.setKey();
        key = pair.getKey();
        pair.setKeyStream(msg,key);
        keyStream = pair.getKeyStream();
        keyStream = keyStream.toUpperCase();
        // falls man sich den Keystream anzeigen lassen will
        //System.out.println("keyStream: " + keyStream);

        for(int i = 0; i<msg.length(); i++){
            if(msg.codePointAt(i)==(char)32 && keyStream.codePointAt(i)==(char)32){
                crypMessage += (char)32;
            }
            else{
                msgCode = 0;
                msgCode = msg.codePointAt(i);
                msgCode -= 65;

                keyCode = 0;
                keyCode = keyStream.codePointAt(i);
                keyCode -= 65;

                crypMessage += pair.vigenere(keyCode,msgCode);
                //falls es nicht klappt
                //msgCode=0;
                //keyCode=0;
            }
        }

        System.out.println("Encrypted message:" + crypMessage);

        //Nachricht wird in der Zwischenablage gespeichert
        pair.clipBoard(crypMessage, key);

    }
}
