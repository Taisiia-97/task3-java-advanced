package zadaniaDodatkowe;



public class Worker {
    private String name;
    private String surname;
    private int age;
    private Post post;
    private double salary;
    private  int mark;
    private double end_bonus;

    public Worker(String name, String surname, int age, Post post, double salary, int mark, double end_bonus) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.mark = mark;
        this.end_bonus = end_bonus;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Post getPost() {
        return post;
    }

    public double getSalary() {
        return salary;
    }

    public int getMark() {
        return mark;
    }

    public double getEnd_bonus() {
        return end_bonus;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", post=" + post +
                ", salary=" + salary +
                ", mark=" + mark +
                ", end_bonus=" + end_bonus +
                '}';
    }
}
