package main;

import javax.swing.JFrame;

import controller.Controller;
import view.ButtonView;
import model.BackTrackModel;
import model.Model;
import model.RuleBasedModel;

/**
 * Client
 * @author Naoki Nakatani
 *
 */
public class SudokuTester
{
    public static void main(String[] args)
    {
    	Model ruleModel = new RuleBasedModel();
        ButtonView ruleFrame = new ButtonView(ruleModel, "Rule Based");
        ruleModel.addListener(ruleFrame);
        Runnable ruleR = new Controller(ruleModel);
        Thread ruleT = new Thread(ruleR);
        
        Model backModel = new BackTrackModel();
        ButtonView backFrame = new ButtonView(backModel, "Backtrack");
        backModel.addListener(backFrame);
        Runnable backR = new Controller(backModel);
        Thread backT = new Thread(backR);
        
        ruleT.start();
        backT.start();
    }
}
