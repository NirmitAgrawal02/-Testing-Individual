/*
Author - Nirmit Agrawal - nagraw18@asu.edu
Course - SER 515

 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

@SuppressWarnings("ALL")
public class urinals {
    static ArrayList<String> input = new ArrayList<>();

    public static String getstring(String line)
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
        System.out.println("Given String is a good string");
        return "Given String is a good string";
    }
    public static String openFile(String path)
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
    public static String counter(int choice, String file)
    {
        input.clear();
        int random = 0;
        ArrayList<Integer> cnt = new ArrayList<>();
        String line;
        String validation;
        if(choice == 1)
        {
            validation = getstring(file);
            if(!validation.equals("Given String is a good string"))
            {
                return validation;
            }
        }
        if(choice == 2)
        {
            validation = openFile(file);
            if(!validation.equals("File Exists"))
            {
                return validation;
            }
            else
            {

                int l = input.size();
                @SuppressWarnings("all")
                int j = l;
                for(int i = 0;i<l;i++)
                {
                    String line1 = input.get(i);
                    validation = getstring(line1);
                    input.remove(j);
                    if(!validation.equals("Given String is a good string"))
                    {
                        input.set(i,"-1");
                    }
                }
            }
        }
        for (String s : input) {
            int count = 0;
            line = s;
            int len = line.length();
            StringBuilder str = new StringBuilder(line);
            StringBuilder str1 = new StringBuilder("-1");
            for (int j = 0; j < len; j++) {
                if (str.equals(str1))
                    cnt.add(-1);
                char ch = str.charAt(j);
                if (j == 0) {
                    char next = str.charAt(j + 1);
                    if (ch == '0' && next == '0') {
                        count++;
                        str.setCharAt(j, '1');
                    }
                } else if (j < len - 1) {
                    char next = str.charAt(j + 1);
                    char prev = str.charAt(j - 1);
                    if (ch == '0' && prev == '0' && next == '0') {
                        count++;
                        str.setCharAt(j, '1');
                    }
                } else {
                    char prev = str.charAt(j - 1);
                    if (ch == '0' && prev == '0') {
                        count++;
                        str.setCharAt(j, '1');
                    }
                }

            }
            cnt.add(count);
            System.out.println(s);
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
            String sc = "rule.txt";
            while(true)
            {
                File f = new File(sc);
                try {
                    if(f.createNewFile())
                    {
                        FileWriter fw = new FileWriter(sc);

                        for (Integer integer : cnt) {
                            String write = "" + integer + "\n";
                            fw.write(write);
                        }
                        fw.close();
                        cnt.clear();
                        input.clear();
                        System.out.println("File Created and updated");
                        return "File Created and updated";
                    }
                    else {
                        System.out.println("File already exists, Counter incrementing");
                        random++;
                        sc = "rule"+ random + ".txt";

                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }
        return "-1";
    }
    public static void main(String[] args)
    {
        int choice;
        String line = "";
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter Your Choice");
        System.out.println("1. Enter String through Terminal");
        System.out.println("2. Enter File name");
        choice = sc.nextInt();
        if(choice == 1)
        {
            System.out.println("Enter String Name");
            line = sc2.nextLine();
        }
        else if(choice == 2)
        {
            System.out.println("Enter File Path");
            line = sc2.nextLine();
        }
        counter(choice,line);

            }
}
