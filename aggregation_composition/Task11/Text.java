package by.epam.module4.aggregation_composition.Task11;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private TextPart textHeader = new TextPart();
    private TextPart textBody = new TextPart();

    private List<Sentence> sentences = new ArrayList<>();


    public List<Sentence> getSentences() {
        return sentences;
    }

    public TextPart getTextHeader() {
        return textHeader;
    }

    public void addText(Sentence s) {
        StringBuilder stringBuilder = new StringBuilder((CharSequence) s);
        String first = null;
        if (sentences.isEmpty()) {
            first =s.getWords().get(0).getValue();
            Character.toUpperCase(first.charAt(0));
        }
        sentences.add(s);

    }

}

class TextPart {
    private List<Sentence> sentences = new ArrayList<>();

}

class Sentence {
    private List<Word> words = new ArrayList<>();

    public List<Word> getWords() {
        return words;
    }
}

class Word {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class PunctuationMarks {
    private final String punctuationMark;

    public PunctuationMarks(String punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    public String getPunctuationMark() {
        return punctuationMark;
    }

}