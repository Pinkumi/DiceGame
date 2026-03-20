package com.remonado.dicegame.GraphicComponents;

import com.remonado.dicegame.Tools.Dice;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
public class DiceUI extends Label {
    private final int EMOJI_DADO = 9855;
    private int xPosition, yPosition;
    private Dice dice;
    public DiceUI(Dice dice) {
        Font font = new Font("Arial", 90);
        String emoji = new String(Character.toChars(EMOJI_DADO+1));
        setText(emoji);
        setFont(font);
        this.dice = dice;
        changeEmoji(dice.getValue());
    }
    public void refresh(){
        changeEmoji(dice.getValue());
    }
    public void changeEmoji(int val) {
        String emoji = new String(Character.toChars(EMOJI_DADO+val));
        setText(emoji);
    }
}
