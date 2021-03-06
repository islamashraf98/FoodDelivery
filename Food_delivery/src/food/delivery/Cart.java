/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.delivery;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Cart {

    private static ArrayList<Dish> dishes = new ArrayList();

    public void add(int index) {
        Database db = Database.getInstance();
        dishes.add(db.dishes.get(index));
    }

    public void remove(int index) {
        Database db = Database.getInstance();
        dishes.remove(db.dishes.get(index));
    }

    public void checkout() {
        Order o = new Order();
        o.setDishes(this.dishes);
        OrderManager.getInstance().addOrder(o);
        emptyCart();
    }
    
    public void emptyCart(){
        dishes.removeAll(dishes);
    }
}
