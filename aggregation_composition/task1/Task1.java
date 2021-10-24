package by.epam.module4.aggregation_composition.task1;
//Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
//консоль текст, заголовок текста.

//Создать объект класса Текст
//        Методы класса текст:
//        - void append(String text). Добавляет строку в конец текста
//        - String toString(). Возвращает строку, представляющую текст
//        - String header(). Возвращает первый абзац текста
//
//        Внутреннее состояние объекта Текст состоит из объектов Предложение.
//        Внутреннее состояние объекта Предложение состоит из объектов Слово.
//
//        Пример использования:
//        Text text = new Text();
//        text.append(“Hello, world!”);
//        System.out.println(text); // печатает “Hello, world!”

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {

        Word word = new Word("Since");
        Word word1 = new Word("1993");
        PunctuationMarks punctuationMarks = new PunctuationMarks(",");
        PunctuationMarks punctuationMarks1 = new PunctuationMarks(" ");
        Sentence sentence1 = new Sentence("EPAMs History.");
        Sentence sentence2 = new Sentence("We’ve relied on our Engineering DNA to underpin our work with clients.");
        Sentence sentence3 = new Sentence("Leading to major innovations.");
        Sentence sentence4 = new Sentence("Digital transformations and business results.");
        Sentence sentence5;
        ArrayList<Sentence> list = new ArrayList<>();
        list.add(sentence2);
        list.add(sentence3);
        list.add(sentence4);
        Text text = new Text(list, sentence1);
//     System.out.println(text);
        int a =list.indexOf(sentence2);
        System.out.println(a);

//        text.printHeader();
//        text.printText();
    }
}

class Text {
    private final ArrayList<Sentence> list;
    private final Sentence header;

    public Text(ArrayList<Sentence> list, Sentence header) {
        this.list = list;
        this.header = header;
    }

    public ArrayList<Sentence> getList() {
        return list;
    }

    public Sentence getHeader() {
        return header;
    }

    @Override
    public String toString() {
        return "                                              " +
                "" + header + "\n" + list;
    }

    public void printHeader() {
        System.out.println("                                             " +
                " " + header);
    }

    public void printText() {
        for (Sentence s : list) {
            System.out.print(s);
        }
    }
}


class Sentence {
    private  String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }
    public Sentence(){

    }

    @Override
    public String toString() {
        return sentence;
    }
//    public Sentence createSentence(Word...sss){
//
//        Sentence sentence1= new Sentence();
//        sentence1 = ;
//        return sentence1;
//    }
}

class Word {
    private final String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }


    @Override
    public String toString() {
        return word;
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

    @Override
    public String toString() {
        return punctuationMark;
    }
}