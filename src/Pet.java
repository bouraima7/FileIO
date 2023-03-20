public class Pet {
    //attributes of name, age, and type
    private String name;
    private int age;
    private String type;
    private static int count = 0; // static variable to keep track of number of objects created

    public Pet(String name, int age, String type) { //Overloaded Constructor
        this.name = name;
        this.age = age;
        this.type = type;
        count++;
    }


    //functions to return specific parts of objects
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    public static int getCount() {
        return count;
    }


}
