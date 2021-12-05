import java.io.*;
import java.text.*;
import java.util.*;
//import java.util.concurrent.ArrayBlockingQueue;
public class StudentList {
    public static void main(String[] args) 
    {

        if(args.length !=1 )
        {
            System.out.println("Invalide ! There was no argument !");
        }
        //		Check arguments
        else if (args[0].equals("a"))
		{
            System.out.println("Loading data ...");
            try 
			{
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
                String linereader = reader.readLine();
                String names[] = linereader.split(",");
                for (String name: names) 
				{
                    System.out.println(name);
                }
            } catch (Exception e) 
			{

			}
            System.out.println("Data Loaded.");
        } 
		else if (args[0].equals("r")) 
		{
            System.out.println("Loading data ...");
            try 
			{
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
                String linereader = reader.readLine();
                String names[] = linereader.split(",");
                Random student = new Random();
                int size = names.length;
                int namesize = Math.abs(student.nextInt() % size);

                System.out.println(names[namesize]);
            } catch (Exception e) 
			{

			}
            System.out.println("Data Loaded.");
        } 
		else if (args[0].contains("+")) 
		{
            System.out.println("Loading data ...");
            try 
			{
                BufferedWriter reader = new BufferedWriter(new FileWriter("students.txt", true));
                String newname = args[0].substring(1);
                Date date = new Date();
                String dateformateheading = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(dateformateheading);
                String datetime = dateFormat.format(date);
                reader.write(", " + newname + "\nList last updated on " + datetime);
                reader.close();
            } catch (Exception e) 
			{

			}

            System.out.println("Data Loaded.");
        }
		else if (args[0].contains("?")) 
		{
            System.out.println("Loading data ...");
            try 
			{
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
                String linereader = reader.readLine();
                String names[] = linereader.split(", ");
                boolean done = false;
                String newname = args[0].substring(1);
                for (int idx = 0; idx < names.length && !done; idx++)
				{
                    if (names[idx].equals(newname)) 
					{
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            } catch (Exception e) 
			{

			}
            System.out.println("Data Loaded.");
        } 
		else if (args[0].contains("c")) 
		{
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
                String linereader = reader.readLine();
                char character[] = linereader.toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char c: character) {
                    if (c == ' ') {
                        if (!in_word)
                        {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + character.length);
            } catch (Exception e) 
            {
                
            }
            System.out.println("Data Loaded.");
        }
        else 
        {
            System.out.println("Wrong Argument ! Plese enter valied argument !!");
            System.out.println("Pass a || c || + || ? ");
        }
    }
}