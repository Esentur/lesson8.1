package com.company.players;

import com.company.boss.Boss;
import com.company.game.Ability;

import java.util.Random;

public class Thor extends Hero{
        public Thor(int health, int damage) {
            super(health, damage, Ability.THUNDER_HIT);
        }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        Random r = new Random();
        int randomNum = r.nextInt(2) ;
        if(randomNum!=0){
            System.out.println("Тор оглущает босса на 1 раунд");
            boss.setDamage(0);
        }else {
            boss.setDamage(30);
        }

    }
}
