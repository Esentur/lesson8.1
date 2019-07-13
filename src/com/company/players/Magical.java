package com.company.players;

import com.company.boss.Boss;
import com.company.game.Ability;

public class Magical extends Hero {
    public Magical(int health, int damage) {
        super(health, damage, Ability.BOOST);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                hero.setDamage(hero.getDamage() + 2);
            }
        }
        System.out.println("Маг увеличивает урон героев на 2 ед. каждый раунд.");

    }
}
