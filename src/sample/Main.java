package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static sample.Notebook.getDate;


public class Main {



    public static void main(String[] args) {

        Scanner input;
        input = new Scanner(System.in);
        ArrayList<Notebook> notes = new ArrayList<>();
        try{
            BufferedReader in = new BufferedReader(new FileReader("note.txt"));
            String line = in.readLine();
            while(line != null){
                String[] s = line.split("\t");
                Notebook note = new Notebook();
                note.setTitle(s[0]);
                note.setDate(s[1]);
                note.setSubject(s[2]);
                note.setTxt(s[3]);
                notes.add(note);
                line = in.readLine();
            }

            in.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("1.New note");
            System.out.println("2.SearchBy Subject");
            System.out.println("3.searchBy txt");
            System.out.println("4.ListBy Subject");
            System.out.println("5.ListBy data");
            System.out.println("6.delete Note");
            System.out.println("7.exit");

            int i = input.nextInt();
            switch (i) {
                case 1:
                    Notebook newnote = new Notebook();
                    System.out.println("Enter title:");
                    String title = input.next();
                    newnote.setTitle(title);
                    System.out.println("Enter subject:");
                    String subject = input.next();
                    newnote.setSubject(subject);
                    System.out.println("Enter text:");
                    String text = input.next();
                    newnote.setTxt(text);
                    notes.add(newnote);
                    break;
                case 2:
                    //for(int i=0 ; i<sizeOf(array) ; i++)
                    boolean find = false;
                    System.out.println("Enter the Subject:");
                    String Word = input.next();
                    for (Notebook n : notes) {
                        if (n.getSubject().contains(Word)) {
                            System.out.println("Found the Note:");
                            System.out.println("Text : " + n.getTxt());
                            System.out.println("title : " + n.getTitle());
                            find = true;
                        }
                    }
                    if (!find)
                        System.out.println("Not Found");
                    break;
                case 3:

                    find = false;
                    System.out.println("Enter the text:");
                    Word = input.next();
                    for (Notebook n : notes) {
                        if (n.getTxt().contains(Word)) {
                            System.out.println("Found the Note:");

                            System.out.println("Text : " + n.getTxt());
                            System.out.println("title : " + n.getTitle());
                            find = true;
                        }
                    }
                    if (!find)
                        System.out.println("Not Found");
                    break;

                case 4:
                    find = false;
                    System.out.println("Enter the Subject:");
                    Word = input.next();
                    for (Notebook n : notes) {
                        if (n.getSubject().equals(Word)) {
                            System.out.println("Found the Note:");

                            System.out.println("Text : " + n.getTxt());
                            System.out.println("title : " + n.getTitle());
                            find = true;
                        }
                    }
                    if (!find)
                        System.out.println("Not Found");
                    break;
                case 5:
                    find = false;
                    System.out.println("Enter the Date:");
                    Word = input.next();
                    for (Notebook n : notes) {
                        if (getDate().equals(Word)) {
                            System.out.println("Found the Note:");

                            System.out.println("Text : " + n.getTxt());
                            System.out.println("title : " + n.getTitle());
                            find = true;
                        }
                    }
                    if (!find)
                        System.out.println("Not Found");
                    break;

                case 6 :
                    find = false;
                    System.out.println("Enter the title:");
                    Word = input.next();
                    int counter = 0 ;
                    for (Notebook n : notes) {
                        if (n.getTitle().equals(Word)) {
                            System.out.println("Found the Note:");
                            find = true;
                            break;
                        }
                        counter++;
                    }

                    if (!find)
                        System.out.println("Not Found");
                    else
                        notes.remove(counter);
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Enter a number between 1 and 7");
            }
        }
        try{
            PrintWriter out = new PrintWriter("note.txt");
            for(Notebook n : notes){
                out.print(n.getTitle());
                out.print("\t");
                out.print(getDate());
                out.print("\t");
                out.print(n.getSubject());
                out.print("\t");
                out.print(n.getTxt());
                out.print("\n");

            }
            out.close();
        }catch(FileNotFoundException ex){
            System.out.println("file not found");
        }
        }
}