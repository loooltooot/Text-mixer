package com.zakrewski.textmixer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Shuffle {
    public static void main(String[] args) {
        System.out.println();
        String file = "src/resources/testMixer.txt";
        
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
                            if((charArray[lastIndex] == '"' && charArray[0] == '"')
                                    && i > 1 && i < (word.length() - 2)) {

                                letterMixer(charArray, i, 3);

                            }

                            // words with dots, commas and other
                            else if((charArray[lastIndex] >= 33 && charArray[lastIndex] <= 64)
                                    && i != 0 && i < (word.length() - 2)) {

                                letterMixer(charArray, i, 3);

                            } 

                            // normal words
                            else if((charArray[lastIndex] < 33 || charArray[lastIndex] > 64) && i != 0) {

                                letterMixer(charArray, i, 2);

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

    public static void letterMixer(char[] charArray, int i, int indent) {
        int randomIndex = (int) (Math.random() * (charArray.length - indent) + 1);
        char buffer = charArray[i];

        charArray[i] = charArray[randomIndex];
        charArray[randomIndex] = buffer;
    }

}
