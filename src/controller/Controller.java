package controller;

import model.BackTrackModel;
import model.Model;

public class Controller implements Runnable
{
    public Controller(Model m)
    {
        model = m;
    }
    
    public void run()
    {
        try
        {
            Thread.sleep(100);
            model.solve();
        }
        catch(Exception e){}
    }
    
    private Model model;
}
