package chaos;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Utils {
	
	public static List<Color> colors;
	
	public static void init() {
		colors = new ArrayList<Color>();
		for (int r=0; r<100; r++) colors.add(new Color(r*255/100,       255,         0));
		for (int g=100; g>0; g--) colors.add(new Color(      255, g*255/100,         0));
		for (int b=0; b<100; b++) colors.add(new Color(      255,         0, b*255/100));
		for (int r=100; r>0; r--) colors.add(new Color(r*255/100,         0,       255));
		for (int g=0; g<100; g++) colors.add(new Color(        0, g*255/100,       255));
		for (int b=100; b>0; b--) colors.add(new Color(        0,       255, b*255/100));
		                          colors.add(new Color(        0,       255,         0));
	}

}
