package com.apasoft;

public class CardProcessor {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java CardProcessor <VISA card number>");
            return;
        }

        String cardNumber = args[0];

        // Validate if the card number is a VISA type (must start with '4' and be 16 digits long)
        if (!cardNumber.matches("^4[0-9]{15}$")) {
            System.out.println("Invalid VISA card number.");
            return;
        }

        // Split the card number into blocks of 4 digits
        String formattedCardNumber = formatCardNumber(cardNumber);
        System.out.println("Processed VISA card number: " + formattedCardNumber);
    }

    // Function to format the card number into blocks of 4 digits
    public static String formatCardNumber(String cardNumber) {
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < cardNumber.length(); i++) {
            if (i > 0 && i % 4 == 0) {
                formatted.append(" ");
            }
            formatted.append(cardNumber.charAt(i));
        }
        return formatted.toString();
    }
}

