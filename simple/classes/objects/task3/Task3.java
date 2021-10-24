package by.epam.module4.simple.classes.objects.task3;
//Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
//из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
//номеров групп студентов, имеющих оценки, равные только 9 или 10.

public class Task3 {
    public static void main(String[] args) {
        Student[] listStudents = new Student[10];
        listStudents[0] = new Student("Ivanov I.I.", 1, new int[]{5, 4, 6, 7, 4});
        listStudents[1] = new Student("Ivanov I.I.", 1, new int[]{5, 4, 6, 7, 4});
        listStudents[2] = new Student("Ivanova A.A.", 2, new int[]{5, 10, 9, 7, 8});
        listStudents[3] = new Student("Petrov I.I.", 1, new int[]{8, 8, 9, 7, 5});
        listStudents[4] = new Student("Petrov P.P.", 3, new int[]{10, 7, 6, 9, 9});
        listStudents[5] = new Student("Sergeev I.P.", 2, new int[]{5, 4, 10, 7, 4});
        listStudents[6] = new Student("Semenov I.S.", 5, new int[]{5, 4, 8, 7, 4});
        listStudents[7] = new Student("Tulkov A.V.", 4, new int[]{5, 3, 3, 7, 4});
        listStudents[8] = new Student("Mozalev N.I.", 2, new int[]{9, 10, 10, 10, 9});
        listStudents[9] = new Student("ShendiK P.I.", 1, new int[]{10, 10, 9, 9, 10});

        for (Student student : listStudents) {
            if (isStudentHasHighResults(student.getAcademicPerformance())) {
                System.out.println("Familia i initsialy: " + student.getSurnameAndInitials() + " nomer grupi: " +
                        student.getNumberGroup() + " imeet otsenki 9 ili 10.");
            }
        }
    }

    private static boolean isStudentHasHighResults(int[] academicPerformance) {
        boolean isStudentHasHighResults = true;
        for (int j : academicPerformance) {
            if (j < 9) {
                isStudentHasHighResults = false;
                break;
            }
        }
        return isStudentHasHighResults;
    }
}

class Student {
    private final String surnameAndInitials;
    private final int numberGroup;
    private final int[] academicPerformance;

    public Student(String surnameAndInitials, int numberGroup, int[] academicPerformance) {
        this.surnameAndInitials = surnameAndInitials;
        this.numberGroup = numberGroup;
        this.academicPerformance = academicPerformance;
    }

    public String getSurnameAndInitials() {
        return surnameAndInitials;
    }

    public int getNumberGroup() {
        return numberGroup;
    }

    public int[] getAcademicPerformance() {
        return academicPerformance;
    }
}