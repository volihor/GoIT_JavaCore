package mod_10_IOStreams;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserToJson {
    public static void main(String[] args){
        ArrayList<User> arrUsers = new ArrayList<>();
        try{
            FileReader fr = new FileReader("./src/main/java/mod_10_IOStreams/fileUsers.txt");
            FileWriter fw = new FileWriter("./src/main/java/mod_10_IOStreams/fileUsers.json");

            Scanner scanner = new Scanner(fr);
            Pattern pattern = Pattern.compile("[a-z]+ [a-z]+");
            try{
                scanner.skip(pattern);
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }

            scanner.nextLine();    // to sckipping the header of the file
            while(scanner.hasNextLine()){
                String[] s = scanner.nextLine().split(" ");
                try{
                    arrUsers.add(new User(s[0], Integer.parseInt(s[1])));
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
            scanner.close();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(arrUsers);
            fw.write(json);
            fw.close();
            System.out.println(json);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class User{
    private String name;
    private int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name: " + getName() + "\tage: " + getAge();
    }
}