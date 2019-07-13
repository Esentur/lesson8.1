package com.company.players;

import com.company.boss.Boss;
import com.company.game.Ability;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, Ability.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        boss.setHealth(boss.getHealth() - boss.getDamage());
        System.out.println("Воин наносит боссу свой урон+полученный урон от босса.");
    }
}
