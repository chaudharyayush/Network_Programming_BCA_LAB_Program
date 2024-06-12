package Chapter2;

public class SpamCheck {

    public static void main(String[] args) {
        //String message = "This is a spam message! Click here to claim your prize!";
        String message = "This is not a spam message! Hello";

        boolean isSpam = checkSpam(message);
        System.out.println("Is spam? \n" + isSpam);
    }

    public static boolean checkSpam(String message) {
        // Define a set of rules that specify what constitutes spam
        String[] spamWords = {"click here", "claim your prize", "free offer"};

        // Check if the message contains any of the spam words
        for (String spamWord : spamWords) {
            if (message.toLowerCase().contains(spamWord)) {
                return true;
            }
        }

        // If none of the spam words are found, assume the message is not spam
        return false;
    }

}

