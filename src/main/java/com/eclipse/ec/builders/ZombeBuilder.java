package com.eclipse.ec.builders;

import com.eclipse.ec.repository.Zombe;

public class ZombeBuilder {
    private Zombe zombe = new Zombe();

    public ZombeBuilder withRegenerator(int regenerate) {
        zombe.setRegeneration(regenerate);
        return this;
    }

    public ZombeBuilder withHitPoints(int hitPoints) {
        zombe.setHitPoints(hitPoints);
        return this;
    }

    public Zombe build() {
        return zombe;
    }

}
