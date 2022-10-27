/*
Author - Nirmit Agrawal - nagraw18@asu.edu
Course - SER 515

 */

import java.util.ArrayList;
import java.util.Scanner;

public class urinals {
    ArrayList<String> input = new ArrayList<>();
    public String getstring(String line)
    {
        int length = line.length();
        for(int i = 0;i < length-1 ; i++)
        {
            char ch = line.charAt(i);
            char next = line.charAt(i+1);
            if((ch =='0'&& (next == '0' || next == '1') )|| (ch=='1' && next == '0'))
            {
                continue;
            }
            else if(!((ch == '0'|| ch == '1') && (next == '0' || next == '1' )))
            {
                return "Given String is not a good string";
            }
            else
            {
                System.out.println("Input is not in a formatted way" + -1);
            }
        }
        input.add(line);
        return "Given String is a good string";
    }
    public void openFile()
    {

    }
    public int count()
    {
        int count = 0;
        return count;

    }
}
