/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.delivery;

import food.delivery.Form;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Login extends Form {

    private Scanner cin = new Scanner(System.in);

    Login() {
        form();
    }

    @Override
    public void getInfo() {
        boolean s = true;
        while (s) {
            System.out.println(" ***************   Login Form *****************");
            System.out.println("Enter username");
            setUsername(cin.next());
            System.out.println("Enter password");
            setPassword(cin.next());
            if (commWithDb()) {
                s = false;
                System.out.println("Logged in successfully");
            } else {
                System.out.println("Wrong Username or Password");
            }
        }

    }

    @Override
    public boolean commWithDb() {
        for (int i = 0; i < Database.getInstance().users.size(); i++) {
            System.out.println(Database.getInstance().users.get(i).getUsername());
            System.out.println(Database.getInstance().users.get(i).getPassword());
            if (Database.getInstance().users.get(i).getUsername() == getUsername() && Database.getInstance().users.get(i).getPassword() == getPassword()) {
                Database.getInstance().setCurrentID(Database.getInstance().users.get(i).getID());
                return true;
            }
        }
        return false;
    }
}
