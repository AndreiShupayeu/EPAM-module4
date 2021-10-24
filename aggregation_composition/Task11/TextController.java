package by.epam.module4.aggregation_composition.Task11;

public class TextController {
    private Text text;
    private boolean isHeaderFinished;

    public TextController(Text text) {
        this.text = text;
    }

    public void appendText(Sentence s) {
        text.addText(s);

    }


}
