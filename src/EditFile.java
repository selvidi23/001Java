import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EditFile
{

    private String readpath ="C:\\Users\\Hubert\\Desktop\\test1.txt";
    private String writepath = "C:\\Users\\Hubert\\Desktop\\test2.txt";

    public int choose(){
        int chooseselect = 0;
        System.out.println("podaj rodzaj edycji");
        Scanner scanint = new Scanner(System.in);
        chooseselect = scanint.nextInt();
        return chooseselect;
    }

//---------------------------------------------------------------------------

    public void edit(int selectedit)
    {

        OpenFile tmpOpeFileC = new OpenFile();
        if(selectedit!=0 || selectedit!=1 || selectedit!=2 || selectedit!=3 || selectedit!=4 || selectedit!=256)
        {
            selectedit = choose();

        }

        BufferedReader filereader = null;
        FileWriter inputstream = null;


//---------------------------------------------------------------------------

        try
        {
            System.out.println("podaj sciezke odczytu");
            readpath= tmpOpeFileC.readpath();
            filereader = new BufferedReader(new FileReader(readpath));
        }
        catch (FileNotFoundException e) {
            System.out.println("nie istnieje taki plik");
            e.printStackTrace();
            edit(selectedit);
        }


//---------------------------------------------------------------------------

        try
        {
            System.out.println("podaj sciezke zapisu");
            writepath = tmpOpeFileC.readpath();
            inputstream = new FileWriter(writepath);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


//---------------------------------------------------------------------------

        switch (selectedit)
        {

            case 0: {
                System.out.println("0.0");
                String line = null;
                int i = 0;
                try {
                    while ((line = filereader.readLine()) != null)
                    {
                        i++;

                        if (i % 2 == 0) {
                            inputstream.write(tmpOpeFileC.SwapToAnagram(line));
                            inputstream.write("\n");
                        } else {
                            inputstream.write(line);
                            inputstream.write("\n");
                        }

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {

                    filereader.close();
                    inputstream.close();


                    if(selectedit==256)
                    {
                        System.exit(0);
                    }
                    else
                    {
                        edit(selectedit);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }



                break;

            }
            case 1: {
                System.out.println("1.0");
                String line = null;
                char oldchar = 'a';
                char newchar = '@';
                Scanner scann = new Scanner(System.in);


                try {
                    System.out.println("Podaj stary znak");
                    oldchar = scann.next(".").charAt(0);
                    System.out.println("Podaj nowy znak");
                    newchar = scann.next(".").charAt(0);
                    while ((line = filereader.readLine()) != null)
                    {
                        String tmpline = null;
                        tmpline = tmpOpeFileC.SwapCharOnString(line, oldchar, newchar);
                        inputstream.write(tmpline);
                        inputstream.write("\n");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


                try {

                    filereader.close();
                    inputstream.close();


                    if(selectedit==256)
                    {
                        System.exit(0);
                    }
                    else
                    {
                        edit(selectedit);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                break;


            }
            case 2: {
                System.out.println("2.0");
                int NumberVerse = 0;
                String line = null;

                try {
                    while ((line = filereader.readLine()) != null)
                    {
                        if (!line.isEmpty()) {
                            NumberVerse++;
                            System.out.println("liczba znakow w lini " + NumberVerse + " " + line.length());
                            System.out.println("liczba słow w lini " + NumberVerse + " " + tmpOpeFileC.NumberWordsInLine(line));
                        }
                    }
                    System.out.println("liczba wers " + NumberVerse);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {

                    filereader.close();
                    inputstream.close();


                    if(selectedit==256)
                    {
                        System.exit(0);
                    }
                    else
                    {
                        edit(selectedit);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                break;

            }
            case 3:
            {
                System.out.println("3.0");
                List<String> tmpListString = new ArrayList<String>();

                String line = null;

                do
                {
                    try
                    {
                        line = filereader.readLine();
                        tmpListString.add(line);
                    }
                        catch (IOException e) {
                        e.printStackTrace();
                    }


                } while (line != null);

                for(int i=tmpListString.size()-1; i>=0; i--)
                {

                    try {

                        String tmp2 = tmpListString.get(i);
                        if(tmp2==null)
                        {
                            inputstream.write("");
                        }
                        else
                        {
                            inputstream.write(tmp2);
                            inputstream.write("\n");
                        }
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }

                try
                {
                    filereader.close();
                    inputstream.close();


                    if(selectedit==256)
                    {
                        System.exit(0);
                    }
                    else
                    {
                        edit(selectedit);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                break;

            }
            case 4:
            {
                System.out.println("4.0");
                String line = null;

                try
                {
                    while ((line = filereader.readLine()) != null)
                    {

                        String stringtab[]= tmpOpeFileC.WordFromLine(line, 'a', "terk");

                        for(int i=0;i<tmpOpeFileC.NumberWordsInLine(line);i++)
                        {
                            inputstream.write(stringtab[i]);


                        }
                        inputstream.write('\n');

                    }
                }
                    catch (IOException e) {
                    e.printStackTrace();
                }

                try
                {
                    filereader.close();
                    inputstream.close();


                    if(selectedit==256)
                    {
                        System.exit(0);
                    }
                    else
                    {
                        edit(selectedit);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            }
            default:
            {
                try {

                    filereader.close();
                    inputstream.close();


                    if(selectedit==256)
                    {
                        System.exit(0);
                    }
                    else
                    {
                        edit(selectedit);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }



        }
    }

}