package masterMind;

import java.util.Random;

public class MasterMindTheGame
{

    /**
     * @author JanHo
     * @param args
     */
    public static void main(String[] args)
    {
	Berichten.WelkomBericht();
	boolean game = true;
	boolean easy = false;
	boolean hard = false;
	int maxSets = 0;

	while (game = true)
	{
	    String gameMode = Berichten.GameModeSelector();

	    String[] code = Functions.Code();
	    if (gameMode == null)
	    {
		game = false;
		break;
	    } else if (gameMode == "Custom")
	    {
		String customModePlayers = Berichten.CustomModePlayers();
		String customModeNakijk = Berichten.CustomModeNakijk();
		if (customModeNakijk == "Easy")
		{
		    easy = true;
		    hard = false;
		} else if(customModeNakijk == "Hard")
		{
		    hard = true;
		    easy = false;
		}
		else {
		    game = false;
			break;
		}

		if (customModePlayers == "1")
		{
		    maxSets = Berichten.CustomModeRondes();

		} else if (customModePlayers == "2")
		{
		    Berichten.Speler1();

		    code[0] = Berichten.CustomModeMultiePlayerCode();
		    code[1] = Berichten.CustomModeMultiePlayerCode();
		    code[2] = Berichten.CustomModeMultiePlayerCode();
		    code[3] = Berichten.CustomModeMultiePlayerCode();

		    Berichten.Speler2();
		}

	    } else
	    {
		code = Functions.Code();
		maxSets = 10;
	    }

	    if (gameMode == "Easy")
	    {
		easy = true;
		hard = false;
	    } else if (gameMode == "Hard")
	    {
		hard = true;
		easy = false;
	    }
	    int ronde = 0;
	    boolean win = false;
	    while (win == false && ronde <= maxSets && game == true)
	    {
		ronde++;
		Berichten.Ronde(maxSets, ronde);
		String[] codeKraak =
		{ Berichten.CodeKraak(), Berichten.CodeKraak(), Berichten.CodeKraak(), Berichten.CodeKraak() };
		if (easy == true)
		{
		    win = Berichten.UitslagMakkelijk(code, codeKraak);
		} else if (hard == true)
		{
		    Berichten.UitslagHard(code, codeKraak);
		}
		if (win == true) {
		    Berichten.Win();
		    game = false;
		}
		if (win == false && ronde == maxSets) {
		    Berichten.Verlies();
		    game = false;
		}
	    }
	    game = false;
	}

    }
}
