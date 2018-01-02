import java.io.*;
import java.util.Scanner;

public class OpenFile {


//---------------------------------------------------------------------------
    public String readpath()
    {
        String path;
        System.out.println("Podaj sciezke do pliku odzczytu");
        Scanner scannerpath = new Scanner(System.in);
        path = scannerpath.nextLine();
        return path;
    }

//---------------------------------------------------------------------------

    public void openfileandread(String path)
    {
        try
        {
            BufferedReader filereader = new BufferedReader(new FileReader(path));

             while(filereader.readLine() != null)
             {
                 System.out.println(filereader.readLine());
             }

        }
            catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            catch (IOException e) {
            e.printStackTrace();
        }

    }
//---------------------------------------------------------------------------
    public String SwapToAnagram(String line)
    {

        StringBuilder AnagramLinebuild = new StringBuilder("");
        String AnagramLine = null;
        char tmp = 'p';
        for(int i = line.length()-1; i>=0; i--)
        {

            tmp = line.charAt(i);
            AnagramLinebuild.append(tmp);

        }

        AnagramLine=AnagramLinebuild.toString();


        return AnagramLine;
    }

//---------------------------------------------------------------------------

    public String SwapCharOnString(String line , char oldchar, char newchar )
    {
        String endString = null;
        StringBuilder tmpStringbuilder = new StringBuilder("");
        char tmp = 'p';
        for(int i =0 ;i<=line.length()-1;i++)
        {
            tmp = line.charAt(i);
            if(tmp == oldchar)
            {
                tmpStringbuilder.append(newchar);
            }
            else
            {
                tmpStringbuilder.append(tmp);
            }
        }
        endString = tmpStringbuilder.toString();
        return endString;
    }

//---------------------------------------------------------------------------

    public int NumberWordsInLine(String line)
    {
        char tmp = 'p';
        int wynik=0;
        for(int i =0 ;i<=line.length()-1;i++)
        {
            tmp = line.charAt(i);

            if(tmp == ' ' || tmp == '\n' )
            {
                wynik++;
            }

        }
        return wynik;
    }

//---------------------------------------------------------------------------

    public int NumberLine(String path) {
        BufferedReader filereader = null;
        String line;
        int Nv=0;
        try
        {
            filereader = new BufferedReader(new FileReader(path));
        }
            catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            while ((line = filereader.readLine()) != null)
            {
                if(line.isEmpty())
                {
                    Nv++;
                }
            }
        }
            catch (IOException e) {
            e.printStackTrace();
        }
        return Nv;
    }

//---------------------------------------------------------------------------

    public String[] WordFromLine(String line,char oldchar ,String newendstring)
    {
        String wordtab[] = new String[(NumberWordsInLine(line))+1] ;
        StringBuilder tmpStringbuilder = new StringBuilder("");
        char tmp = 'p';
        int j=0;
        for(int i =0 ;i<=line.length()-1;i++)
        {
            tmp = line.charAt(i);
            if(tmp == ' ' || tmp == '\n' )
            {
                if(line.charAt(i-1)==oldchar && i>0)
                {

                    tmpStringbuilder.append(newendstring);
                    tmpStringbuilder.append(' ');
                    wordtab[j]=tmpStringbuilder.toString();
                    tmpStringbuilder.delete(0, tmpStringbuilder.length());


                    j++;
                }
                else
                {
                    tmpStringbuilder.append(tmp);
                    wordtab[j] = tmpStringbuilder.toString();
                    tmpStringbuilder.delete(0, tmpStringbuilder.length());
                    j++;
                }

            }
            else
            {
                tmpStringbuilder.append(tmp);
                tmpStringbuilder.toString();

            }
        }
        return wordtab;
    }
}
