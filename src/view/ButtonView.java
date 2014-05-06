package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.BackTrackModel;
import model.Model;

/**
 * Viewer
 * @author Naoki Nakatani
 *
 */
public class ButtonView extends JFrame implements ChangeListener
{
    /**
     * Initiate frame
     * @param model model which this view frame is listening to
     */
    public ButtonView(Model model, String title)
    {
        super();
        this.model = model;
        setSize(500, 500);
        setLayout(new GridLayout(9, 9));
        
        cell = new JButton[9][9];
        int[][] board = model.getBoard();
        for(int row = 0; row < 9; row++)
            for(int col = 0; col < 9; col++)
            {
                cell[row][col] = new JButton("" + board[row][col]);
                add(cell[row][col]);
                if(board[row][col] == 0)
                {
                    cell[row][col].setSelected(true);
                    cell[row][col].setText("");
                }
                else
                    cell[row][col].setForeground(Color.RED);
            }
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        this.setTitle(title);
    }

    public void stateChanged(ChangeEvent e)
    {
        //access data
        int[][] newBoard = model.getBoard();
        for(int row = 0; row < 9; row++)
            for(int col = 0; col < 9; col++)
            {
                cell[row][col].setText("" + newBoard[row][col]);
                if(newBoard[row][col] == 0)
                {
                    cell[row][col].setSelected(true);
                    cell[row][col].setText("");
                }
                else
                    cell[row][col].setSelected(false);
            }
    }
    
    private JButton[][] cell;
    private Model model;
}
