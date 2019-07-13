package com.company.players;

import com.company.boss.Boss;
import com.company.game.Ability;
import com.company.game.GameEntity;

public abstract class Hero extends GameEntity implements HavingAbility {
    private Ability ability;

    public Ability getAbility() {
        return ability;
    }

    public Hero(int health, int damage, Ability ability) {
        super(health, damage);
        this.ability = ability;
    }


}
