package acc.accountservice.util;

import java.util.Random;

public class AccountUtils {
    public static final String ACCOUNT_EXISTS_CODE = "001";
    public static final String ACCOUNT_EXISTS_MESSAGE = "Applicant already has an account";
    public static final String ACCOUNT_CREATION_SUCCESS = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = "Account has been successfully created";
    public static final String ACCOUNT_NOT_EXIST_CODE= "003";
    public static final String ACCOUNT_NOT_EXIST_MESSAGE= "Applicant with the provided Account Number not exist";
    public static final String ACCOUNT_FOUND_CODE= "004";
    public static final String ACCOUNT_FOUND_SUCCESS= "Applicant Account Found";
    public static final String ACCOUNT_CREDITED_SUCCESS= "005";
    public static final String ACCOUNT_CREDITED_SUCCESS_MESSAGE= "Account was credited successfully";
    public static final String INSUFFICIENT_BALANCE_CODE = "006";
    public static final String INSUFFICIENT_BALANCE_MESSAGE = "Insufficient Balance";
    public static final String ACCOUNT_DEBITED_SUCCESS = "007";
    public static final String ACCOUNT_DEBITED_MESSAGE = "Account has been successfully debited";
    public static final String TRANSFER_SUCCESSFUL_CODE= "008";
    public static final String TRANSFER_SUCCESSFUL_MESSAGE= "Transfer Successful";
    public static final String  SAVINGS = "Savings";
    public static final String  ADDRESS = "123 Main Street, New York";


    public static String generateAccountNumber() {

        Random random = new Random();
        // Generate a random number between 0 and 999999999999 (13 digits)
        long randomNumber = random.nextLong() % 1000000000000L;
        if (randomNumber < 0) {
            // Ensure the number is positive
            randomNumber *= -1;
        }
        // Concatenate "777" with the random number
        return "777" + String.format("%010d", randomNumber);
    }


    public static String generateCifId() {
        Random random = new Random();
        // Generate a random number between 0 and 99999 (5 digits)
        int randomNumber = random.nextInt(100000);
        // Concatenate "54" with the random number
        String cifId = "54" + String.format("%05d", randomNumber);
        // Convert the concatenated string to a UUID
        return cifId;
    }
//

    public static void main(String[] args) {
        // Example usage
        String accountNumber = generateAccountNumber();
        String cifId = generateCifId();
        System.out.println("Generated Account Number: " + accountNumber);
        System.out.println("Generated CIFID: " + cifId);
    }

}


