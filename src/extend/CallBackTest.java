package extend;

public class CallBackTest {
    public static void main(String []args){
        Hotel hotel = new Hotel();
        Customer customer = new Customer();
        customer.orderWakeUp(hotel);
    }
}
