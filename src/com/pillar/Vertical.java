package com.pillar;

import java.util.List;

public class Vertical extends Keyword  {

		public Vertical() {
			super();
		}

		public Vertical(String word, List<PotentialStartCoordinates> potentialStartCoordinates) {
			super();
			this.word = word;
			this.potentialStartCoordinates = potentialStartCoordinates;
		}


		@Override
		public String toString() {
			return "Vertical";
		}
	
}
