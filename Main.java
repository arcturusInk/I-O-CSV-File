import com.opencsv.*;
import java.io.*;
import java.net.URL;

public class Main {
    //Java Strings are conceptually encoded as UTF-16, which is why greater than 127 was chosen
    //Returns false if hotel name does not include UTF-16 characters
    //@param: takes in a String that holds the hotel's name
    //@return: returns true/false depending on whether if name has UTF-16 characters
    private static boolean isAscii(String name) {
        for(int i = 0; i < name.length(); i++){
            if(name.charAt(i)>127){
                return false;
            }
        }
        return true;
    }
    // Returns false if rating is a negative number or not within the range of (exclusive) 0 to 6 (exclusive)
    //@param: takes in a String that holds the rating
    //@return: returns true/false depending on whether if num is positive/negative, or not within the correct range
    private static boolean isCorrectRatings(String ratings){
        int rating = Integer.parseInt(ratings);
        if(rating < 0 || !(rating > 0 && rating < 6)){
            return false;
        }
        return true;
    }

    // Returns true if url is valid. Note: used the java.net.URL class; definition of URL in the class is used to determine valid URL
    //@param: takes in a String that holds the URL
    //@return: returns true/false depending on whether if String is a valid URL
    private static boolean isValidURL(String url){
        // Try creating a valid URL
        try {
            new URL(url).toURI();
            return true;
        }
        // If there was an Exception
        // while creating URL object
        catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            //Reading in csv file with the help of opencsv library
            CSVReader reader = new CSVReader(new FileReader("hotels.csv"));
            String[] nextLine = reader.readNext();

            //Outputting in HTML
            PrintWriter pw = new PrintWriter(new FileWriter("outputHTML.html"));
            //Outputting the headers, nicely
            pw.println("<TABLE BORDER><TR><TH>"+nextLine[0]+"</TH><TH>"+nextLine[1]+"</TH><TH>"+nextLine[2]+"</TH><TH>"+nextLine[3]+"</TH><TH>"+nextLine[4]+"</TH><TH>"+nextLine[5]+"</TH></TR>");

            //Outputting everything in a simple HTML table
            while ((nextLine = reader.readNext()) != null) {
                if(isAscii(nextLine[0]) && isAscii(nextLine[1]) && isCorrectRatings(nextLine[2]) && isAscii(nextLine[3]) && isValidURL(nextLine[5])){
                    pw.println("<TR ALIGN=CENTER><TD>" + nextLine[0]  + "</TD><TD>"+ nextLine[1]+"</TD><TD>"+ nextLine[2]+"</TD><TD>"+ nextLine[3]+"</TD><TD>"+ nextLine[4]+"</TD><TD>"+ nextLine[5]+"</TD>");
                }
            }

            //Finished outputting in HTML
            pw.println("</TABLE>");
            pw.close();
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
}
