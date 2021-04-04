package Example;

public class Fish extends Animal {
    @Override
    public void move() {
        System.out.println("鱼在水里游");
    }

    @Override
    public void eat() {
        System.out.println("鱼吃蚯蚓");
    }
}
