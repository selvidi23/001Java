import java.io.*;

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
                System.out.println("1");
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
                    filereader.close();
                    inputstream.close();
                }
                    catch (IOException e) {
                    e.printStackTrace();
                }



            }
            case 1:
            {

            }


        }


    }




}
