package com.company.game;

import com.company.boss.Boss;
import com.company.players.*;

public class RpgGame {
    public static void startGame() {
        Boss boss = new Boss(400, 30);
        Hero[] heroes = getHeroesArray();
        while (!isFinished(heroes, boss)) {
            showStatistics(heroes, boss);
            round(heroes, boss);
        }
    }

    private static boolean isFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDied = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDied = false;
                break;
            }
        }
        if (allHeroesDied) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDied;
    }

    private static void round(Hero[] heroes, Boss boss) {
        bossHit(heroes, boss);
        heroesHit(heroes, boss);
        showStatistics(heroes, boss);
    }

    private static void bossHit(Hero[] heroes, Boss boss) {
        for (Hero hero : heroes) {
            int damageOfBoss = boss.getDamage();
            hero.setHealth(hero.getHealth() - damageOfBoss);
        }
    }

    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                int damageOfHero = hero.getDamage();
                boss.setHealth(boss.getHealth() - damageOfHero);
                hero.useAbility(heroes, boss);
            }
        }
    }

    private static void showStatistics(Hero[] heroes, Boss boss) {
        System.out.println("___________________________");
        System.out.println("Boss health = " + boss.getHealth());
        for (Hero hero : heroes) {
            System.out.println("Hero " + hero.getClass().getSimpleName() + " health = " + hero.getHealth());
        }
    }

    private static Hero[] getHeroesArray() {
        Hero[] heroes = {
                new Magical(100, 12),
                new Warrior(100, 10),
                new Hunter(100, 10),
                new Medical(100, 10)
        };
        return heroes;
    }

}
