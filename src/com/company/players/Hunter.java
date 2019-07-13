package com.company.players;

import com.company.boss.Boss;
import com.company.game.Ability;

import java.util.Random;

public class Hunter extends Hero {
    public Hunter(int health, int damage) {
        super(health, damage, Ability.CRITICAL_DAMAGE);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        boss.setHealth(boss.getHealth() + heroes[2].getDamage());
        Random r = new Random();
        int randomNum = r.nextInt(2) + 2;

        boss.setHealth(boss.getHealth() - (heroes[2].getDamage() * randomNum));
        System.out.println("Охотник бьет критический удар x" + randomNum + ".");
    }
}
