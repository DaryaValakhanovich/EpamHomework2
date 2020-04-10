package task2;

import task1.Person;

public class Employee extends Person {
    private int workExperienceInYears;

    public Employee(String name, int age, int workExperienceInYears) {
        super(name, age);
        this.workExperienceInYears = workExperienceInYears;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "workExperienceInYears=" + workExperienceInYears +
                '}';
    }
}
