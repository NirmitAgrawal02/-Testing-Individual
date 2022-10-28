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
        if(length == 0) {
            System.out.println("Given String does not contain any urinals");
            return "Given String does not contain any urinals";
        }
        else if(length > 20)
        {
            System.out.println("Length of the given string exceeds the constraints");
            return "Length of the given string exceeds the constraints";
        }
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
                System.out.println("Given String is not a good string");
                return "Given String is not a good string";
            }
            else
            {
                System.out.println("Input is not in a formatted way" + -1);
            }
        }
        input.add(line);
//        int cnt = count(1);
        System.out.println("Given String is a good string");
        return "Given String is a good string";
    }
    public void openFile()
    {

    }
    public int count(int choice)
    {
        ArrayList<Integer> cnt = new ArrayList<>();
        int length = input.size();
        String line = "";
        for(int i = 0; i<length;i++)
        {
            int count = 0;
            line = input.get(i);
            int len = line.length();
            StringBuilder str = new StringBuilder(line);
            for(int j = 0;j< len; j++)
            {
                char ch = str.charAt(j);
                if(j == 0)
                {
                    char next = str.charAt(j+1);
                    if(ch == '0' && next == '0')
                    {
                        count++;
                        str.setCharAt(j,'1');
                    }
                }
                 else if (j > 0 && j<len-1) {
                    char next = str.charAt(j + 1);
                    char prev = str.charAt(j - 1);
                    if (ch == '0' && prev == '0' && next == '0') {
                        count++;
                        str.setCharAt(j, '1');
                    }
                }
                 else
                {
                    char prev = str.charAt(j - 1);
                    if(ch == '0' && prev == '0')
                    {
                        count++;
                        str.setCharAt(j,'1');
                    }


                }
            }
            cnt.add(count);
        }
        if(choice == 1)
            System.out.println(cnt);
            return -1;
    }
}
