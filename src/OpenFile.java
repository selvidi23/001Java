import java.io.*;
import java.util.Scanner;

public class OpenFile {
    protected String path = "C:\\Users\\Hubert\\Desktop\\test1.txt";
    protected String path2 = "C:\\Users\\Hubert\\Desktop\\test2.txt";

//---------------------------------------------------------------------------
    public void readpath()
    {
        String path;
        System.out.println("Podaj sciezke");
        Scanner scannerpath = new Scanner(System.in);
        path = scannerpath.nextLine();
        this.path = path;

    }

//---------------------------------------------------------------------------

    public int choose(){
        int chooseselect = 0;
        System.out.println("podaj rodzaj edycji");
        Scanner scanint = new Scanner(System.in);
        chooseselect = scanint.nextInt();
        return chooseselect;
    }

//---------------------------------------------------------------------------

    public void openfileandread()
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

    public String SwapToAnagram(String line)
    {
        char[] tmp;
        StringBuilder AnagramLinebuild = new StringBuilder("");
        tmp = line.toCharArray();
        String AnagramLine = null;
        char a = 'p';
        for(int i = line.length()-1; i>=0; i--)
        {

            a = line.charAt(i);
            AnagramLinebuild.append(a);

        }

        AnagramLine=AnagramLinebuild.toString();


        return AnagramLine;
    }

//---------------------------------------------------------------------------


}
