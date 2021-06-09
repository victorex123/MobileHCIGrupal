package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;


public class FightPanel
{
    MonsterManager enemiesEncounters;
    Texture panelInformation;
    BitmapFont title;
    ButtonClosePanelLook buttonClose;
    Boolean fighting = false;

    Vector2 position;
    Vector2 dimension;

    private final float textY;
    private final float textX;
    String text;
    GlyphLayout glyphLayout;
    Rectangle bounds;

    public FightPanel(String text,float x,float y,float width,float height,ButtonClosePanelLook closeButton)
    {
        this.text = text;
        this.dimension = new Vector2(width,height);
        this.position = new Vector2(x,y);
        glyphLayout = new GlyphLayout(AssetManager.getInstance().font, text);
        textX = position.x + (dimension.x-glyphLayout.width)/2;
        textY = position.y + dimension.y - (dimension.y-glyphLayout.height)/2;
        bounds = new Rectangle(position.x,position.y,dimension.x,dimension.y);
        enemiesEncounters = new MonsterManager();
        buttonClose = closeButton;
    }

    public void render(SpriteBatch batch)
    {
        if(fighting)
        {
            batch.draw(AssetManager.getInstance().button,position.x,position.y,dimension.x,dimension.y);
            batch.setColor(Color.WHITE);
            AssetManager.getInstance().font.draw(batch,text,textX,textY);
        }
    }

    public void startFight()
    {
        int randomEnemy = MathUtils.random(5,11);
        Monster enemy = enemiesEncounters.getMonsterByID(randomEnemy);
        setText("You have found a " + enemy.getName() +".");
        fighting = true;
    }

    public void setText(String newText)
    {
        text = newText;
    }
}
