package assignment.a2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Pizzeria implements IPizzeria {
    static int M = 10;
    ArrayList<Queue<Pizza>> pizzas;

    Pizzeria() {
        pizzas = new ArrayList<Queue<Pizza>>(M);
        for (int i = 0; i < M; i++) {
            pizzas.add(new ArrayDeque<>());
        }
        randomAddPizza();
    }

    void checkKind(int kind) {
        if (kind < 0 || kind >= M) {
            throw new IllegalArgumentException("Invalid kind");
        }
    }

    @Override
    public void addPizza(int kind) {
        checkKind(kind);
        pizzas.get(kind).add(new Pizza(kind, System.currentTimeMillis()));
    }

    @Override
    public Pizza getPizza(int kind) {
        if (pizzas.get(kind).isEmpty()) {
            return new Pizza(kind, System.currentTimeMillis());
        }
        return pizzas.get(kind).poll();
    }

    @Override
    public Pizza getSurprisePizza() {
        int oldKind = -1;
        long oldTime = Long.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            if (!pizzas.get(i).isEmpty()) {
                Pizza pizza = pizzas.get(i).peek();
                assert pizza != null;
                if (pizza.getTime() < oldTime) {
                    oldTime = pizza.getTime();
                    oldKind = i;
                }
            }
        }
        if (oldKind == -1) {
            return new Pizza((int) (Math.random() * M), System.currentTimeMillis());
        }
        return pizzas.get(oldKind).poll();
    }

    void randomAddPizza() {
        for (int i = 0; i < (int) (Math.random() * 100 + M); i++) {
            addPizza((int) (Math.random() * M));
        }
    }
}
