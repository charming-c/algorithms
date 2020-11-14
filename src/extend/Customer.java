package extend;

public class Customer implements CallBack {

    public void orderWakeUp(Hotel hotel){
        System.out.println("顾客订购叫醒服务！");
        hotel.goToWakeUp(this);
    }

    @Override
    public void wakeUp() {
        System.out.println("顾客被叫醒了！");
    }
}
