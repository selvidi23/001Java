import java.io.*;
import java.util.Scanner;

public class EditFile extends OpenFile
{

//---------------------------------------------------------------------------

    public void edit()
    {

        int selectedit = choose();
        BufferedReader filereader = null;
        FileWriter inputstream = null;


//---------------------------------------------------------------------------

        try
        {
            inputstream = new FileWriter(path2);
        }
            catch (IOException e) {
            e.printStackTrace();
        }


//---------------------------------------------------------------------------

        try
        {
            filereader = new BufferedReader(new FileReader(path));
        }
            catch (FileNotFoundException e) {
            e.printStackTrace();
        }


//---------------------------------------------------------------------------

        switch (selectedit)
        {

            case 0:
            {
                System.out.println("0");
                String line = null;
                int i =0;
                try
                {
                    while((line = filereader.readLine())!= null)
                    {

                        i++;

                        if(i%2==0)
                        {
                            inputstream.write(SwapToAnagram(line));
                            inputstream.write("\n");
                        }
                        else
                        {
                            inputstream.write(line);
                            inputstream.write("\n");
                        }



                    }

                }
                    catch (IOException e) {
                    e.printStackTrace();
                }



            }
            case 1:
            {
                System.out.println("1");
                String line = null;
                char oldchar='a';
                char newchar='@';

               /* System.out.println("podaj stary znak");                   dokończyc wczytwyanie char
                Scanner scannerpath = new Scanner(System.in);
                oldchar = scannerpath.;
                */

                try
                {
                    while((line = filereader.readLine())!=null)
                    {

                        String tmpline = null;
                        tmpline=SwapCharOnString(line,oldchar,newchar);
                        inputstream.write(tmpline);
                        inputstream.write("\n");
                    }

                }
                    catch (IOException e) {
                    e.printStackTrace();
                }



            }
            case 2:
            {
                System.out.println("2");
                int NumberVerse = 0;
                String line = null;

                try
                {
                    while((line = filereader.readLine())!=null)
                    {
                        if(!line.isEmpty())
                        {
                            NumberVerse++;
                            System.out.println("liczba znakow w lini "+NumberVerse+" "+line.length());
                            System.out.println("liczba słow w lini "+NumberVerse+" "+NumberWordsInLine(line));
                        }
                    }
                    System.out.println("liczba wers "+NumberVerse);

                }
                    catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }
        try
        {
            filereader.close();
            inputstream.close();
        }
            catch (IOException e) {
            e.printStackTrace();
        }



    }




}
