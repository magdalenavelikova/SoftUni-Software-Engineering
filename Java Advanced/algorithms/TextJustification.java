package algorithms;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    //Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
    //
    //You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
    //
    //Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
    //
    //For the last line of text, it should be left-justified, and no extra space is inserted between words.

    //A word is defined as a character sequence consisting of non-space characters only.
    //Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
    //The input array words contains at least one word.


    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> strings = fullJustify(words, maxWidth);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justifiedResult = new ArrayList<>();
        List<String> current = new ArrayList<>();
        int num_of_letters = 0;
        for (String word : words) {
            if (word.length() + num_of_letters + current.size() > maxWidth) {

                for (int i = 0; i < maxWidth - num_of_letters; i++) {
                    current.set(i % (current.size() - 1 > 0 ? current.size() - 1 : 1), current.get(i % (current.size() - 1 > 0 ? current.size() - 1 : 1)) + " ");
                }
                 for (int i = 0; i < maxWidth - num_of_letters; i++) {
                     int index=-1;
                     if(current.size-1 > 0){
                         index = i% (current.size()-1);
                     }else{
                         index = i % 1;//0
                     }

                     current.set(i % (current.size() - 1 > 0 ? current.size() - 1 : 1), current.get(i % (current.size() - 1 > 0 ? current.size() - 1 : 1)) + " ");
                }

//                

                StringBuilder sb = new StringBuilder();
                current.forEach(sb::append);
                justifiedResult.add(sb.toString());
                current.clear();
                num_of_letters = 0;
            }
            current.add(word);
            num_of_letters += word.length();
        }

        justifiedResult.forEach(j -> System.out.println(j.length()));
        StringBuilder lastLine = new StringBuilder();
        for (int i = 0; i < current.size(); i++) {
            lastLine.append(current.get(i));
            if (i != current.size() - 1) lastLine.append(" ");
        }
        while (lastLine.length() < maxWidth) lastLine.append(" ");
        justifiedResult.add(lastLine.toString());

        return justifiedResult;
    }


}