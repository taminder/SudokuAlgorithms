package main;

import javax.swing.JFrame;

import controller.Controller;
import view.ButtonView;
import model.BackTrackModel;

/**
 * Client
 * @author Naoki Nakatani
 *
 */
public class SudokuTester
{
    public static void main(String[] args)
    {
        BackTrackModel model = new BackTrackModel();
        ButtonView frame = new ButtonView(model);
        model.addListener(frame);
        
        Runnable r = new Controller(model);
        Thread t = new Thread(r);
        t.start();
    }
}
