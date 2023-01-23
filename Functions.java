package masterMind;

import java.util.Random;

import javax.swing.JOptionPane;

public class Functions
{
    /**
     * @author JanHo
     * @return
     */
    public static String[] Code()
    {
	String[] color =
	{ "rood", "groen", "geel", "blauw", "paars", "oranje" };
	Random r = new Random();
	int randomCode = r.nextInt(color.length);

	String code[] =
	{ color[r.nextInt(color.length)], color[r.nextInt(color.length)], color[r.nextInt(color.length)],
		color[r.nextInt(color.length)] };

	return code;
    }

    /**
     * @author JanHo
     * @return
     */
    public static String[] KraakCode()
    {
	String[] kraakCode =
	{ Berichten.CodeKraak(), Berichten.CodeKraak(), Berichten.CodeKraak(), Berichten.CodeKraak() };
	return kraakCode;
    }

    /**
     * @author JanHo
     * @param code
     * @param kraakCode
     * @return
     */
    public static String[] MakkelijkControle(String code[], String kraakCode[])
    {
	String makkelijkControle[] = new String[4];

	for (int i = 0; i < 4; i++)
	{
	    makkelijkControle[i] = ControleerEenWaarde(code, kraakCode, i);
	}

	return makkelijkControle;
    }

    /**
     * @author JanHo
     * @param makkelijkControle
     * @return
     */
    public static boolean WinMakkelijk(String[] makkelijkControle)
    {
	if (makkelijkControle[0].equalsIgnoreCase("●") && makkelijkControle[1].equalsIgnoreCase("●")
		&& makkelijkControle[2].equalsIgnoreCase("●") && makkelijkControle[3].equalsIgnoreCase("●"))
	{
	    return true;
	}

	return false;
    }

    /**
     * @author JanHo
     * @param code
     * @param kraakCode
     * @param positie
     * @return
     */
    public static String ControleerEenWaarde(String[] code, String[] kraakCode, int positie)
    {
	if (code[positie].equalsIgnoreCase(kraakCode[positie]))
	{
	    return "●";
	}
	if (code[1].equalsIgnoreCase(kraakCode[positie]) || code[2].equalsIgnoreCase(kraakCode[positie])
		|| code[3].equalsIgnoreCase(kraakCode[positie]))
	{
	    return "○";
	}
	return "x";

    }

    /**
     * @author JanHo
     * @param code
     * @param kraakCode
     * @return
     */
    public static String[] HardControle(String code[], String kraakCode[])
    {
	String hardControle[] = new String[4];

	for (int i = 0; i < 4; i++)
	{
	    hardControle[i] = ControleerEenWaardeHard(code, kraakCode, i);
	}

	return hardControle;
    }

    /**
     * @author JanHo
     * @param code
     * @param kraakCode
     * @param positie
     * @return
     */
    public static String ControleerEenWaardeHard(String[] code, String[] kraakCode, int positie)
    {
	if (code[positie].equalsIgnoreCase(kraakCode[positie]))
	{
	    return "○";
	} else if (code[1].equalsIgnoreCase(kraakCode[positie]) || code[2].equalsIgnoreCase(kraakCode[positie])
		|| code[3].equalsIgnoreCase(kraakCode[positie]))
	{
	    return "●";
	}
	return "";
    }
}
