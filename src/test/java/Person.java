public class Person {

    private String name;

    public Person(String name){

        this.name=name;
    }
    @Override
    public String toString(){

        return "Person " + name;
    }
    @Override
    public int hashCode(){

        return 10 * name.hashCode() + 20456;
    }
    private void ff(){

    };
}
