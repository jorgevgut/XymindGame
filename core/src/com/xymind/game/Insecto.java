package com.xymind.game;

/*
 * Created by jorch on 7/29/15.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Insecto {


    public int x,y;
    private Animation animation;
    private float tiempo;
    private TextureRegion [] regionsMovimiento;
    private Texture imagen;
    private TextureRegion frameActual;

    public Insecto (int x, int y) {
        this.x = x;
        this.y = y;
        //cargar la imagen
        imagen = new Texture(Gdx.files.internal("chitiniac-move.png"));
        TextureRegion [][] tmp = TextureRegion.split(imagen,
                imagen.getWidth()/8,imagen.getHeight());

        regionsMovimiento = new TextureRegion[8];
        for (int i = 0; i < 8; i++) regionsMovimiento[i] = tmp[0][i];
        animation = new Animation(1/10f,regionsMovimiento);
        tiempo = 0f;

    }


    public void render(final SpriteBatch batch) {
        tiempo += Gdx.graphics.getDeltaTime(); //es el tiempo que paso desde el ultimo render
        frameActual = animation.getKeyFrame(tiempo,true);
        batch.draw(frameActual,x,y);
    }

}
