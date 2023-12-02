import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MenuItem {
    String name;
    double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    static int orderNumberCounter = 1;
    int orderNumber;
    Queue<MenuItem> items;

    public Order() {
        this.orderNumber = orderNumberCounter++;
        this.items = new LinkedList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}

class Restaurant {
    LinkedList<MenuItem> menu;
    Queue<Order> orderQueue;
    Stack<Order> preparationStack;

    public Restaurant() {
        this.menu = new LinkedList<>();
        this.orderQueue = new LinkedList<>();
        this.preparationStack = new Stack<>();
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void removeMenuItem(MenuItem item) {
        menu.remove(item);
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (MenuItem item : menu) {
            System.out.println(item.name + " - $" + item.price);
        }
    }

    public void takeOrder(Order order) {
        orderQueue.add(order);
        System.out.println("Order #" + order.getOrderNumber() + " taken.");
    }

    public void prepareOrders() {
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            System.out.println("Preparing order #" + order.getOrderNumber());
            preparationStack.push(order);
        }
    }

    public void displayOrderStatus() {
        System.out.println("Orders in Queue:");
        for (Order order : orderQueue) {
            System.out.println("Order #" + order.getOrderNumber());
        }

        System.out.println("Orders being Prepared:");
        for (Order order : preparationStack) {
            System.out.println("Order #" + order.getOrderNumber());
        }
    }

}

public class RestaurantOrderManagementSystem {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        MenuItem item1 = new MenuItem("Burger", 5.99);
        MenuItem item2 = new MenuItem("Pizza", 8.99);

        restaurant.addMenuItem(item1);
        restaurant.addMenuItem(item2);

        restaurant.displayMenu();

        Order order1 = new Order();
        order1.addItem(item1);
        order1.addItem(item2);

        Order order2 = new Order();
        order2.addItem(item1);

        restaurant.takeOrder(order1);
        restaurant.takeOrder(order2);

        restaurant.displayOrderStatus();

        restaurant.prepareOrders();

        restaurant.displayOrderStatus();
    }
}
