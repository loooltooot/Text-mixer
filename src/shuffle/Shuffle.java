package shuffle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Shuffle {
    public static void main(String[] args) {
        System.out.println();
        String file = "0_Programming/Java/Directory of all txt files/testShuffle.txt";
        
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder outStringBuilder = new StringBuilder();
            String line;
            
            while((line = reader.readLine()) != null) {
                List<String> splitLine = new ArrayList<>(Arrays.asList(line.split(" ")));
                
                for(String word : splitLine) {
                    char[] charArray = word.toCharArray();
                    int lastIndex = charArray.length - 1;
                    
                    if(word.length() > 3) {
                        for(int i = 0; i < word.length() - 1; i++) {
                            if((charArray[lastIndex] == '"' && charArray[0] == '"') && i > 1 && i < (word.length() - 2)) {
                                
                                int randomIndex = (int) (Math.random() * (word.length() - 3) + 1);
                                char buffer = charArray[i];
                                
                                charArray[i] = charArray[randomIndex];
                                charArray[randomIndex] = buffer;
                                
                            }
                            
                            else if((charArray[lastIndex] == ',' || charArray[lastIndex] == '.' || charArray[lastIndex] == ':'
                                                || charArray[lastIndex] == '!') && i != 0 && i < (word.length() - 2)) {
                                
                                int randomIndex = (int) (Math.random() * (word.length() - 3) + 1);
                                char buffer = charArray[i];
                                
                                charArray[i] = charArray[randomIndex];
                                charArray[randomIndex] = buffer;
                                
                            } 
                            
                            else if((charArray[lastIndex] != ',' && charArray[lastIndex] != '.' && charArray[lastIndex] != ':'
                                                && charArray[lastIndex] != '!') && i != 0) {
                                
//                              System.out.printf("==[LOG]:%d== ", i);
                                int randomIndex = (int) (Math.random() * (word.length() - 2) + 1);
                                char buffer = charArray[i];
                                
                                charArray[i] = charArray[randomIndex];
                                charArray[randomIndex] = buffer;
                                
                            }

                        }
                        for(char let : charArray) {
                            outStringBuilder.append(let);
                        }
                        outStringBuilder.append(" ");
    
                    } else {
                        outStringBuilder.append(word).append(" ");
                    }   
                    
                }
                outStringBuilder.append("\n");
            }
            System.out.println(outStringBuilder);
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}
