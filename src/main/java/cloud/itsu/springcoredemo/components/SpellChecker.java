package cloud.itsu.springcoredemo.components;

import org.springframework.stereotype.Component;

@Component
public class SpellChecker {
    public SpellChecker() {
        System.out.println(" Constructor - spell checker ");
    }

    public void spellCheck() {
        System.out.println(" Doing spellCheck! ");
    }

}
