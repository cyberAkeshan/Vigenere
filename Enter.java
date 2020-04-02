/**
 * Text und Schluessel Eingabe
 *
 * @author Akeshan
 * @version 27.03.2020 v1
 */

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.Scanner;


public class Enter
{
    Scanner scanner = new Scanner(System.in);
    String msg;
    String key;
    String keyStream = "";
    String encMsg;
    int x,y;

    char [] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
            'N','O','P','Q','R','S','T','U','V','W','X','Y','Z', //0-25
            'A','B','C','D','E','F','G','H','I','J','K','L','M', //26-50
            'N','O','P','Q','R','S','T','U','V','W','X','Y'};

    char [] [] vigenere = new char [26] [26]; //26x26

    public char vigenere(int x, int y){
        for(int j=0; j<=25; j++){
            for(int i=0; i<=25;i++){
                vigenere[i][j] = alphabet[i+j];
            }
        }
        this.x=x;
        this.x=y;
        return vigenere[x][y];
    }
    //i nach unten, j nach rechts
    public char getVigenere(int x, int y){
        this.x=x;
        this.x=y;
        return vigenere[x][y];
    }

    public void setMsg(){
        System.out.println("Enter your message");
        msg = scanner.nextLine();
    }

    public String getMsg(){
        return msg;
    }

    public void setKey(){
        System.out.println("Enter your key");
        key = scanner.nextLine();
    }

    public String getKey(){
        return key;
    }

    // Key auf Laenge der Nachricht bringen
    public void setKeyStream(String msg, String key){
        this.msg=msg;
        for(int i = 0, j = 0; i < msg.length(); i++){
            if(msg.charAt(i) == (char)32){
                keyStream += (char)32;
            }
            else {
                if(j < key.length()){
                    keyStream += key.charAt(j);
                    j++;
                }
                else {
                    j = 0;
                    keyStream += key.charAt(j);
                    j++;
                }
            }
        }
    }

    public String getKeyStream(){
        return keyStream;
    }

    public void setEncryptedMsg(){
        System.out.println("Enter your encrypted message");
        encMsg = scanner.nextLine();
    }

    public String getEncryptedMsg(){
        return encMsg;
    }

    public void clipBoard(String msg, String key){
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(msg + "   ----- key: " + key + " -----"), null);
    }
}
