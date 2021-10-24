package by.epam.module4.simple.classes.objects.task6;
//Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
//изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
//недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
//заданное количество часов, минут и секунд.

public class Task6 {
    public static void main(String[] args) {
        ExactTime exactTime1 = new ExactTime(24, 60, 60);
        exactTime1.infoExactTime();
        exactTime1.setSeconds(100);
        exactTime1.infoExactTime();
        exactTime1.changeSeconds(50);
        exactTime1.infoExactTime();
        exactTime1.changeSeconds(20);
        exactTime1.infoExactTime();
        exactTime1.changeSeconds(-10);
        exactTime1.infoExactTime();
        exactTime1.changeHours(23);
        exactTime1.infoExactTime();
    }
}

class ExactTime {
    private int hours;
    private int minutes;
    private int seconds;

    public ExactTime(int hours, int minutes, int seconds) {
        this.hours = controlRange(hours, 24);
        this.minutes = controlRange(minutes, 60);
        this.seconds = controlRange(seconds, 60);
    }

    public void setHours(int hours) {
        this.hours = controlRange(hours, 24);
    }

    public void setMinutes(int minutes) {
        this.minutes = controlRange(minutes, 60);
    }

    public void setSeconds(int seconds) {
        this.seconds = controlRange(seconds, 60);
    }

    public void infoExactTime() {
        System.out.println("Now is the time: " + hours + ":" + minutes + ":" + seconds);
    }

    public void changeHours(int h) {
        hours = controlRange(hours +h,24);
    }

    public void changeMinutes(int m) {
        minutes = controlRange(minutes+m,60);
    }

    public void changeSeconds(int s) {
        seconds = controlRange(seconds + s, 60);
    }

    int controlRange(int input, int max) {
        int field = input;
        if (input >= max || input < 0) {
            field = 0;
        }
        return field;
    }
}