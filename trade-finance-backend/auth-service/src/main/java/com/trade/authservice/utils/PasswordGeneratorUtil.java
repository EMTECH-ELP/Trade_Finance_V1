package com.trade.authservice.utils;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class PasswordGeneratorUtil {
    public static String generatePassayPassword() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(2);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(2);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() {
                return "ERROR_CODE";
            }

            public String getCharacters() {
                return "!@#$%^&*()_+";
            }
        };
        CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(2);

        String password = passwordGenerator.generatePassword(10, splCharRule, lowerCaseRule,
                upperCaseRule, digitRule);
        return password;
    }
}







//package com.trade.authservice.utils;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import java.security.SecureRandom;
//
//import static com.sun.tools.classfile.Module_attribute.ProvidesEntry.length;
//
//
//@Component
//@Slf4j
//public class PasswordGenerator {
//    private static final SecureRandom random = new SecureRandom();
//    private static final String CHARACTERS = "!@#$%&*ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//
//    /**
//     * Generates a random password using a specified length.
//     *
//     * @return A random password as a String.
//     */
//    public static String generateRandomPassword() {
//        StringBuilder password = new StringBuilder(length);
//        for (int i = 0; i < length; i++) {
//            password.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
//        }
//        log.info("Password generated successfully:" + password);
//        return password.toString();
//    }
//}
//
