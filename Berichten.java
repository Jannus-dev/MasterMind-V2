package masterMind;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Berichten
{

    /**
     * @author JanHo
     */
    public static void WelkomBericht()
    {
	JOptionPane.showMessageDialog(null, "Welkom bij MasterMind!", "MasterMind", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * @author JanHo
     * @return
     */
    public static String GameModeSelector()
    {
	String[] GameModes =
	{ "Easy", "Hard", "Custom" };
	String GameModeSelectorInpute = (String) JOptionPane.showInputDialog(null, "Kies de game mode:", "MasterMind",
		JOptionPane.QUESTION_MESSAGE, null, // Use
						    // default
						    // icon
		GameModes, // Array of choices
		GameModes[0]); // Initial choice
	return GameModeSelectorInpute;
    }

    /**
     * @author JanHo
     * @return
     */
    public static String CustomModePlayers()
    {
	String[] CustomModePlayers =
	{ "1", "2" };
	String CustomModePlayersInpute = (String) JOptionPane.showInputDialog(null, "Hoe veel spelers?", "MasterMind",
		JOptionPane.QUESTION_MESSAGE, null, // Use
						    // default
						    // icon
		CustomModePlayers, // Array of choices
		CustomModePlayers[0]); // Initial choice
	return CustomModePlayersInpute;
    }

    /**
     * @author JanHo
     * @return
     */
    public static String CustomModeNakijk()
    {
	String[] CustomModeNakijk =
	{ "Easy", "Hard" };
	String CustomModeNakijkInpute = (String) JOptionPane.showInputDialog(null,
		"Wat is de moeilijkheid van het nakijken?", "MasterMind", JOptionPane.QUESTION_MESSAGE, null, // Use
													      // default
													      // icon
		CustomModeNakijk, // Array of choices
		CustomModeNakijk[0]); // Initial choice
	return CustomModeNakijkInpute;
    }

    /**
     * @author JanHo
     */
    public static void Speler1()
    {
	JOptionPane.showMessageDialog(null, "Speler 1", "MasterMind", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * @author JanHo
     */
    public static void Speler2()
    {
	JOptionPane.showMessageDialog(null, "Speler 2", "MasterMind", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * @author JanHo
     * @return
     */
    public static String CustomModeMultiePlayerCode()
    {
	String[] CustomModeMultiePlayerCode =
	{ "rood", "groen", "geel", "blauw", "paars", "oranje" };
	String CustomModeMultiePlayerCodeInpute = (String) JOptionPane.showInputDialog(null,
		"Kies een kleur voor je code:", "MasterMind", JOptionPane.QUESTION_MESSAGE, null, // Use
												  // default
												  // icon
		CustomModeMultiePlayerCode, // Array of choices
		CustomModeMultiePlayerCode[0]); // Initial choice
	return CustomModeMultiePlayerCodeInpute;
    }

    /**
     * @author JanHo
     * @return
     */
    public static int CustomModeRondes()
    {
	JOptionPane optionPane = new JOptionPane();
	JSlider slider = getSlider(optionPane);
	optionPane.setMessage(new Object[]
	{ "Kies hoe veel rondes:", slider });
	optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
	JDialog dialog = optionPane.createDialog(null, "My Slider");
	dialog.setVisible(true);
	int rondes = (int) optionPane.getInputValue();
	return rondes;
    }

    /**
     * @author JanHo
     * @param optionPane
     * @return
     */
    static JSlider getSlider(final JOptionPane optionPane)
    {
	JSlider slider = new JSlider();
	slider.setMajorTickSpacing(1);
	slider.setValue(10);
	slider.setMinimum(5);
	slider.setMaximum(15);
	slider.setPaintTicks(true);
	slider.setPaintLabels(true);
	ChangeListener changeListener = new ChangeListener()
	{
	    public void stateChanged(ChangeEvent changeEvent)
	    {
		JSlider theSlider = (JSlider) changeEvent.getSource();
		if (!theSlider.getValueIsAdjusting())
		{
		    optionPane.setInputValue(new Integer(theSlider.getValue()));
		}
	    }
	};
	slider.addChangeListener(changeListener);
	return slider;
    }

    /**
     * @author JanHo
     * @return
     */
    public static String CodeKraak()
    {
	String[] CodeKraak =
	{ "rood", "groen", "geel", "blauw", "paars", "oranje" };
	String CodeKraakInpute = (String) JOptionPane.showInputDialog(null, "Kies een kleur om de code te kraken:",
		"MasterMind", JOptionPane.QUESTION_MESSAGE, null, // Use
								  // default
								  // icon
		CodeKraak, // Array of choices
		CodeKraak[0]); // Initial choice
	return CodeKraakInpute;
    }

    /**
     * @author JanHo
     * @param code
     * @param makkelijkControle
     */
    public static boolean UitslagMakkelijk(String code[], String makkelijkControle[])
    {
	String[] controle = Functions.MakkelijkControle(code, makkelijkControle);
	JOptionPane.showMessageDialog(null, controle[0] + controle[1] + controle[2] + controle[3], "MasterMind",
		JOptionPane.INFORMATION_MESSAGE);
	return Functions.WinMakkelijk(controle);
    }

    /**
     * @author JanHo
     * @param code
     * @param HardControle
     */
    public static boolean UitslagHard(String code[], String HardControle[])
    {
	String[] controle = Functions.HardControle(code, HardControle);
	JOptionPane.showMessageDialog(null, controle[0] + controle[1] + controle[2] + controle[3], "MasterMind",
		JOptionPane.INFORMATION_MESSAGE);
	return Functions.WinMakkelijk(controle);
    }

    /**
     * @author JanHo
     * @param maxSets
     * @param ronde
     */
    public static void Ronde(int maxSets, int ronde)
    {
	JOptionPane.showMessageDialog(null, ronde + " / " + maxSets, "MasterMind", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * @author JanHo
     */
    public static void Verlies() {
	JOptionPane.showMessageDialog(null, "Helaas verloren =(", "MasterMind", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * 
     */
    public static void Win() {
	JOptionPane.showMessageDialog(null, AsciiArt.AsciiArt(), "MasterMind", JOptionPane.INFORMATION_MESSAGE);
	String url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";

        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
