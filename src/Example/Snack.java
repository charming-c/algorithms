package Example;

public class Snack extends Animal {
    @Override
    public void move() {
        System.out.println("蛇是爬行动物");
    }

    @Override
    public void eat() {
        System.out.println("蛇是吃老鼠的");
    }
}
