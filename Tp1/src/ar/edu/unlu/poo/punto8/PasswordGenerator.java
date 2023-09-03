package ar.edu.unlu.poo.punto8;

import java.util.Random;

public class PasswordGenerator {
    private int length;
    private String password;
    private boolean strong = false;
    private String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public PasswordGenerator(int length) {
        if(length < 8){
            throw new IllegalArgumentException("La longitud de la contraseña debe ser de al menos 8 caracteres");
        }
        this.length = length;
        password = generateRandomPassword();
        if (isStrong()) strong = true;
    }
    public PasswordGenerator(){
        this(8);
    }

    public int getLength(){
        return length;
    }

    public String toString(){
        String parsePassword = "<" + password + ">";
        if(strong) return parsePassword + " - " + "Fuerte";
        return parsePassword + " - Debil";
    }

    public boolean isStrong(){
        int mayusCount = 0;
        int minusCount = 0;
        int numberCount = 0;
        char passCharAt;
        for (int i = 0; i < length; i++) {
            passCharAt = password.charAt(i);
            if(Character.isDigit(passCharAt)){
                numberCount++;
            } else {
                if (passCharAt == Character.toUpperCase(passCharAt)) {
                    mayusCount++;
                } else {
                    minusCount++;
                }
            }
        }
        if (mayusCount > 2 && minusCount > 1 && numberCount >= 2) return true;
        return false;
    }

    public void makeStrong(){
        if(!strong){
            char[] charArray = password.toCharArray();
            char randomChar;
            Random random = new Random();
            String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int i = 0; i < length; i++) {
                switch (i){
                    case 0, 1:
                        // Inserto 2 números
                        randomChar = (char) (random.nextInt(10) + '0') ;
                        charArray[i] = randomChar;
                        break;
                    case 2, 3, 4:
                        // Inserto 3 mayúsculas
                        randomChar = upper.charAt(random.nextInt(upper.length()));
                        charArray[i] = randomChar;
                        break;
                    case 5, 6:
                        // Inserto 2 minúsculas
                        randomChar = upper.toLowerCase().charAt(random.nextInt(upper.length()));
                        charArray[i] = randomChar;
                        break;
                    default:
                        break;
                }
            }
            strong = true;
            String newStrongPassword = new String (charArray);
            password = newStrongPassword;
        }
    }

    private String generateRandomPassword(){
        String pass = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            pass += chars.charAt(random.nextInt(chars.length()));
        }

        return pass;
    }

}
