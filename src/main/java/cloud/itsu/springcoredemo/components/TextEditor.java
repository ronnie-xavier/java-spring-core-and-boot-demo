package cloud.itsu.springcoredemo.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {
    @Autowired
    private SpellChecker spellChecker1;

//    @Autowired
//    public void setSpellChecker1(SpellChecker spellChecker1) {
//        this.spellChecker1 = spellChecker1;
//    }

    public void spellCheck() {
        System.out.println(" Calling spellCheck from Text Editor");
        spellChecker1.spellCheck();
    }


//    public TextEditor(SpellChecker spellChecker) {
//        System.out.println(" Constructor: Text Editor ");
//        this.spellChecker1 = spellChecker;
//    }



}
