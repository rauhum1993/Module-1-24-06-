package abstract_class_and_interface.thuc_hanh.animal_and_interface_edible;

public class Abstract_And_Interface_Tests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
             animal.makeSound();

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }

        Fruit[] fruits= new Fruit[2];
        fruits[0]=new Apple();
        fruits[1]=new Orange();
        for (Fruit fruit: fruits){
            System.out.println(fruit.howToEat());
        }



    }

}
