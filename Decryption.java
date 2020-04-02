/**
 * Hier werden die Nachrichten ENTschlÃ¼sselt.
 *
 * @author Akeshan
 * @version 01.04.2020
 */
public class Decryption
{
    String encMsg;
    String key;
    String keyStream;
    int encMsgCode;
    int keyCode;
    int newCode;
    String message = "";

    char [] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
            'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'}; //0-25

    public void decrypt(){
        Enter pair = new Enter();
        pair.setEncryptedMsg();
        encMsg = pair.getEncryptedMsg();
        encMsg = encMsg.toUpperCase();
        pair.setKey();
        key = pair.getKey();
        pair.setKeyStream(encMsg,key);
        keyStream = pair.getKeyStream();
        keyStream = keyStream.toUpperCase();
        //System.out.println("Keystream: " + keyStream); // falls man sich den Keystream anzeigen lassen will

        for(int i = 0; i<encMsg.length(); i++){
            if(encMsg.codePointAt(i)==(char)32 && keyStream.codePointAt(i)==(char)32){
                message += (char)32;
            }
            else {
                encMsgCode = 0;
                encMsgCode = encMsg.codePointAt(i);
                encMsgCode -= 65;

                keyCode = 0;
                keyCode = keyStream.codePointAt(i);
                keyCode -= 65;

                if(keyCode>encMsgCode){
                    newCode = 26 - keyCode + encMsgCode;
                    message += alphabet[newCode];
                    newCode=0;
                    continue;
                }

                else if(keyCode==encMsgCode){
                    message += 'A';
                }

                else{
                    newCode = encMsgCode - keyCode;
                    message += alphabet[newCode];
                    newCode=0;
                    continue;
                }
            }
        }

        System.out.println("Decrypted Message: " + message);

    }
}
