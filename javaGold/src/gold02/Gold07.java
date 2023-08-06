package gold02;

import java.util.function.Predicate;

class Person07 {
    public enum Gender {
        MALE, FEMALE
    }
    private Gender gender;
    private int age;
    public Person07(Gender gender, int age) {
        super();
        this.gender = gender;
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
class OldSample {
    public static void main(String[] args) {
        Person07 sample = new Person07(Person07.Gender.MALE, 19);

        if (sample.getGender().equals(Person07.Gender.MALE)
                && sample.getAge() >= 20) {
            System.out.println("ok");
            return;
        }
        System.out.println("NG");
    }
}

class NewSample {
    public static void main(String[] args) {
        Predicate<Person07> isMale = p -> p.getGender().equals(Person07.Gender.MALE);
        Predicate<Person07> isFemale = p -> p.getGender().equals(Person07.Gender.FEMALE);
        Predicate<Person07> isAdult = p -> p.getAge() >= 20;

        Person07 sample = new Person07(Person07.Gender.MALE, 19);
        if (isMale.or(isFemale.and(isAdult)).test(sample)) {
            System.out.println("ok");
            return;
        }
        System.out.println("NG");
    }
}