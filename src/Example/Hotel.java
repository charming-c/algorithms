package Example;

public class Hotel {
    public void goToWakeUp(CallBack callBack) {
        try {
            // 模拟时间过了一晚上
            Thread.sleep(3000);
            System.out.println("过了一会……");
            callBack.wakeUp();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}
