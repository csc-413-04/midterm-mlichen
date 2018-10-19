package midterm2018;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String question1and2 = "GET /add?a=3&b=4 HTTP/1.1\n"
            + "Host: localhost:1298\n"
            + "Connection: keep-alive\n"
            + "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36\n"
            + "Accept: image/webp,image/apng,image/*,*/*;q=0.8\n"
            + "Referer: http://localhost:1298/\n"
            + "Accept-Encoding: gzip, deflate, br\n"
            + "Accept-Language: en-US,en;q=0.9,es;q=0.8\n";

        String question3 = "{\n"
            + "    task : inc,\n"
            + "    num : 3\n"
            + "}\n";

        String question4and5 = "To opt out, you’ll need to enter the Settings menu by clicking the three vertical dots, all the way in the upper right corner of the browser. From there, you’ll need to enter the Advanced settings at the very bottom and find the “Allow Chrome sign in” toggle, then turn it to off. Doing so lets you sign into Google services like Gmail and Maps without signing into the Chrome browser itself.";


        //System.out.println(question1and2);
        //System.out.println(question3);
        //System.out.println(question4and5);

        // print each answer at the end

        // Question 1
        // Return the Host
        String[] array = question1and2.split(" ");
        String answer1 = array[3].substring(0, 14);
        System.out.println("----------    Answer for question 1 is    ---------");
        System.out.println("The host is: " + answer1 +"\n");

        // Question 2
        // return sum of a and b
        String[] line = array[1].split("\\?");
        String[] variables = line[1].split("&");
        String a = variables[0].substring(2);
        String b = variables[1].substring(2);
        int sum = Integer.parseInt(a) + Integer.parseInt(b);
        System.out.println("----------    Answer for question 2 is    ---------");
        System.out.println("The sum is: " + sum);

        // Question 3
        // convert to java object, increment num, convert back to json and return

        Gson gson = new Gson();
        Info info = gson.fromJson(question3, Info.class);

        String newJson = gson.toJson(info);
        System.out.println("----------    Answer for question 3 is    ---------");
        System.out.println(newJson +"\n");


        // Question 4
        // return unique words
        String[] ar = question4and5.split(" ");
        HashMap<String, Integer> map= new HashMap<String, Integer>();
        int count=0;

        for(int i=0;i<ar.length;i++){
            count=0;

            for(int j=0;j<ar.length;j++){
                if(ar[i].equals(ar[j])){
                    count++;
                }
            }
            map.put(ar[i], count);
        }

        Integer min = Collections.min(map.values());

        //System.out.println(map);//map);

        if (map.containsValue(min)){
//            String key = map.keySet();
//            System.out.println("Key : " + key +" value :"+ min);
            //System.out.println("");
        }

        System.out.println("----------    Answer for question 4 is    ---------");
        System.out.println(" " + "\n");


        // Question 5
        // return 2nd most common word

        int highest = Integer.MIN_VALUE;
        String highestString = null;
        int secondHighest = Integer.MIN_VALUE;
        String secondHighestString = null;

        if (highest == Integer.MIN_VALUE){
            highestString = Collections.max(map.keySet());
            highest = map.get(highestString);
            map.remove(highest);
        }
        if (secondHighest == Integer.MIN_VALUE ){
            secondHighestString = Collections.max(map.keySet() );
            secondHighest = map.get(secondHighestString);
            map.remove(secondHighest);
        }

        //System.out.println(highest + highestString);
        //System.out.println(secondHighest + secondHighestString);

        System.out.println("----------    Answer for question 5 is    ---------");
        System.out.println(" " + "\n");


    }
}

class Info{
    String ta;
    int number;

    public void setTask(String ta) {
        this.ta = ta;
        System.out.println(ta);
    }

    public void setNum(int number) {
        this.number = number;
        System.out.println(number);
    }


}
