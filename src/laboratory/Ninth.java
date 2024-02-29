package laboratory;

import java.util.ArrayList;

public class Ninth {
    public static void main(String[] args) {
        //Написати програму, яка вводить масив записів про студентів (Прізвище, ім'я, рік народження, група,
        //рейтинг, стать). Програма повинна знайти і вивести на екран прізвища та ініціали студентів у яких рейтинг менший 50 балів.

        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Molodeth", "Super", "Janaury",5 ,51, "male"));
        list.add(new Student("Molodeth", "Super", "Janaury",5 ,50, "female"));
        list.add(new Student("Super", "Super", "Janaury",5 ,49, "male"));
        list.add(new Student("Ktoto", "Super", "Janaury",5 ,48, "female"));

        for(Student student: list){
            if(student.getRange() < 50){
                System.out.println(student.getFirstname() + " " + student.getLastname() + " " + student.getData() + " " + student.getGroup() + " " + student.getRange() + " " + student.getSex());
            }
        }
    }

    public static class Student{
        private String firstname;
        private String lastname;
        private String data;
        private int group;
        private int range;
        private String sex;

        public Student(String firstname, String lastname, String data, int group, int range, String sex) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.data = data;
            this.group = group;
            this.range = range;
            this.sex = sex;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public String getData() {
            return data;
        }

        public int getGroup() {
            return group;
        }

        public int getRange() {
            return range;
        }

        public String getSex() {
            return sex;
        }
    }
}
