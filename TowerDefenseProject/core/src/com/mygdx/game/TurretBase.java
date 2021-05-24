package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class TurretBase extends GameObject
{

    float rotation, rotation2;
    int turretType;

    public TurretBase(float x, float y, float width, float height, String tag)
    {
        super(x,y,width,height,tag);
        this.rotation = MathUtils.random(360);
        this.rotation2 = 0;
        this.turretType = 0;
    }

    @Override
    public void lookAt(Vector2 targetPosition) {

    }

    @Override
    public void update(float delta)
    {

    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(AssetManager.getInstance().getTRByEnum(AssetManager.TEXTURES.BASE),
                position.x, position.y, dimension.x/2, dimension.y/2,
                dimension.x, dimension.y,1,1, rotation);
    }
}
