package org.springframework.samples.petclinic;

import io.rollout.configuration.RoxContainer;
import io.rollout.flags.*;

public class Flags implements RoxContainer {

	public RoxFlag enableTutorial = new RoxFlag(false);

	public final RoxString titleColors = new RoxString("White", new String[] { "White", "Blue", "Green", "Yellow" });

	public final RoxString shozabColors = new RoxString("White", new String[] { "White", "Blue", "Green", "Yellow" });

	public final RoxInt titleSize = new RoxInt(14, new int[] { 14, 18, 24 });

	public final RoxDouble specialNumber = new RoxDouble(3.14, new double[] { 2.71, 0.577 });

	public final RoxEnum<Color> titleColorsEnum = new RoxEnum<>(Color.WHITE);

	public enum Color {

		WHITE, BLUE, GREEN, YELLOW

	}

}
