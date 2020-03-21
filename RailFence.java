

public class RailFence {
	
	
	public String encrypt(String text, int rails) {
		
		
		
		String original = text.replaceAll("[^a-zA-Z0-9]", "");
		if(rails > original.length()) rails = original.length()/2;
		char cipher[][] = new char[original.trim().length()][rails];
		String encrypted = "";
		int current_rail = 0;
		boolean downwards = true;
	
		for(int q = 0; q < original.trim().length(); q++) {
			
			/*
			 * we want your current_rail pointer to bounce between
			 * upper and lower "borders" of the cipher matrix array
			 */
			
			if(current_rail == rails) { 
				current_rail -= 2;
				downwards = false;
			}
			
			if(current_rail < 0) {
				current_rail += 2;
				downwards = true;
			}	
			cipher[q][current_rail] = original.charAt(q); 
			if(downwards) current_rail++; 
			else current_rail--;
			
			
		}
		
		//converting char matrix to String
		for(int k = 0; k<rails; k++) {
			int o = 0;
			while(o < original.length()) {
				if(cipher[o][k] != 0)
				encrypted += cipher[o][k];
				o++;
			}
			
		}
		
		
		return encrypted;
	}
	
	
	public String decrypt(String text, int rails) {
		String original = text.replaceAll("[^a-zA-Z0-9]", "");
		String decrypted = "";
		int len = original.length();
		char decipher[][] = new char[len][rails];
		int index = 0;
		
		//looping through every rail
		for(int k = 0; k<rails; k++) {
			int o = 0;
			//doing the same thing we did in the encryption
			int current_rail = 0;
			boolean downwards = true;
			while(o < original.length()) {
				
				if(current_rail == rails) { 
					current_rail -= 2;
					downwards = false;
				}
				
				if(current_rail < 0) {
					current_rail += 2;
					downwards = true;
				}	
				
				//inserting letters to proper rail and index
				if(current_rail == k) {
				decipher[o][current_rail] = original.charAt(index); 
				index++;
				}
				
				if(downwards) current_rail++; 
				else current_rail--;
				
				o++;
			}
			
		}
		
		//converting char matrix to string 
		for(int c = 0; c < decipher.length; c++) {
			for(int g = 0; g < decipher[c].length; g++) {
				if(decipher[c][g] != 0) {
					decrypted += decipher[c][g];
				}
			}
		}
		
		
		return decrypted;
	}
	
	
	
	
	
	

}
