/*
Author - Nirmit Agrawal - nagraw18@asu.edu
Course - SER 515

 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;

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
                System.out.println("Input is not in a formatted way - 1");
                return "Input is not in a formatted way - 1";
            }
        }
        input.add(line);
//        int cnt = counter(1);
        System.out.println("Given String is a good string");
        return "Given String is a good string";
    }
    public String openFile(String path)
    {

        try {
            File file = new File(path);
            if(file.exists() && file.length() == 0)
            {
                System.out.println("File is Empty -1");
                return "File is Empty -1";
            }
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                input.add(s.next());
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Exist -1");
            return "File not Exist -1";
        }
        System.out.println("File Exists");
        return "File Exists";
    }
    public String counter(int choice, String file)
    {
        ArrayList<Integer> cnt = new ArrayList<>();
        String line = "";
        String validation = "";
        if(choice == 1)
        {
            validation = getstring(file);
            if(!validation.equals("Given String is a good string"))
            {
                cnt.clear();
                input.clear();
                return validation;
            }
        }
        if(choice == 2)
        {
            validation = openFile(file);
            if(!validation.equals("File Exists"))
            {
                cnt.clear();
                input.clear();
                return validation;
            }
            else
            {
                int l = input.size();
                for(int i = 0;i<l;i++)
                {
                    String line1 = input.get(i);
                    validation = getstring(line1);
                    if(!validation.equals("Given String is a good string"))
                    {
                        input.set(i,"-1");
                    }
                }
            }
        }
        int length = input.size();
        for(int i = 0; i<length;i++)
        {
            int count = 0;

            line = input.get(i);
            int len = line.length();
            StringBuilder str = new StringBuilder(line);
            for(int j = 0;j< len; j++)
            {
                if(str.equals("-1"))
                    cnt.add(-1);
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
        {
            System.out.println("Free Urinals = "+ cnt);
            String ret = "" + cnt.get(0);
            cnt.clear();
            input.clear();
            return ret;
        }
        if(choice == 2)
        {
            while(true)
            {
                int random = 1;
                String sc = "\n"+"rule.txt";
                File f = new File(sc);
                try {
                    if(f.createNewFile())
                    {
                        FileWriter fw = new FileWriter(sc);

                        for(int i = 0;i<cnt.size();i++)
                        {
                            String write = "" + cnt.get(i);
                            fw.write(write);
                        }
                        fw.close();
                        cnt.clear();
                        input.clear();
                        return "File Created and updated";
                    }
                    else {
                        System.out.println("File already exists, Counter incrementing");
                        sc = sc.substring(0,3) + random +sc.substring(4);
                        random++;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }
        cnt.clear();
        input.clear();
        return "-1";
    }
    public static void main(String[] args)
    {
        System.out.println(System.getProperty("user.dir"));
            }
}
