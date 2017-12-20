import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EditFile extends OpenFile
{


//---------------------------------------------------------------------------

    public void edit(int selectedit)
    {

        if(selectedit!=0 || selectedit!=1 || selectedit!=2 || selectedit!=3 || selectedit!=4 || selectedit!=256)
        {
            selectedit = choose();

        }

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

            case 0: {
                System.out.println("0.0");
                String line = null;
                int i = 0;
                try {
                    while ((line = filereader.readLine()) != null)
                    {
                        i++;

                        if (i % 2 == 0) {
                            inputstream.write(SwapToAnagram(line));
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

               /* System.out.println("podaj stary znak");                   dokończyc wczytwyanie char
                Scanner scannerpath = new Scanner(System.in);
                oldchar = scannerpath.;
                */

                try {
                    while ((line = filereader.readLine()) != null)
                    {
                        String tmpline = null;
                        tmpline = SwapCharOnString(line, oldchar, newchar);
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
                            System.out.println("liczba słow w lini " + NumberVerse + " " + NumberWordsInLine(line));
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
                        //line = " Last Christmas \n I gave you my heart  ";
                        String stringtab[]=WordFromLine(line, 'a', "terk");

                        for(int i=0;i<NumberWordsInLine(line);i++)
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