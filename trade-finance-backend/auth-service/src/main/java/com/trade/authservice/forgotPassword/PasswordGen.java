package com.trade.authservice.forgotPassword;

import org.passay.CharacterRule;

import java.io.IOException;
import java.nio.CharBuffer;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PasswordGen {
    private final Random random;

    public PasswordGen() {
        this(new SecureRandom());
    }

    public PasswordGen(Random r) {
        this.random = r;
    }

    public String generatePassword (int length, CharacterRule... rules) {
        return this.generatePassword(length, Arrays.asList(rules));
    }

    public String generatePassword(int length, List<CharacterRule> rules) {
        if (length <= 0) {
            throw new IllegalArgumentException("length must be greater than 0");
        } else {
            StringBuilder allChars = new StringBuilder();
            CharBuffer buffer = CharBuffer.allocate(length);
            if (rules != null) {

                for (CharacterRule rule : rules) {
                    this.fillRandomCharacters(rule.getValidCharacters(), rule.getNumberOfCharacters(), buffer);
                    allChars.append(rule.getValidCharacters());
                }
            }

            this.fillRandomCharacters(allChars, length - buffer.position(), buffer);
            buffer.flip();
            this.randomize(buffer);
            return buffer.toString();
        }
    }

    protected void fillRandomCharacters(CharSequence source, int count, Appendable target) {
        for(int i = 0; i < count; ++i) {
            try {
                target.append(source.charAt(this.random.nextInt(source.length())));
            } catch (IOException var6) {
                IOException e = var6;
                throw new RuntimeException("Error appending characters.", e);
            }
        }

    }

    protected void randomize(CharBuffer buffer) {
        for(int i = buffer.position(); i < buffer.limit(); ++i) {
            int n = this.random.nextInt(buffer.length());
            char c = buffer.get(n);
            buffer.put(n, buffer.get(i));
            buffer.put(i, c);
        }

    }
}
