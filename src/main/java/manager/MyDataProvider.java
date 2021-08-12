package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider//должна быть такая анотация
    public Iterator<Object[] > validLoginDataClassDP(){
        List<Object[]> list= new ArrayList<>();
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[] > dataContactDP(){
        List<Object[]> list= new ArrayList<>();
        //Mona,Dow,9877776543,dow@gmail.com,Haifa Herzel3,university friend
        list.add(new Object[]{"Mona","Dow","9877776500","dow77@gmail.co","Haifa Herzel3","university friend"});
        list.add(new Object[]{"Mona","Dow","9817776500","dow78@gmail.co","Haifa Herzel3","university friend"});
        list.add(new Object[]{"Mona","Dow","9827776500","dow79@gmail.co","Haifa Herzel3","university friend"});


        return list.iterator();
    }

    @DataProvider//должна быть такая анотация
    public Iterator <Object[]> dataFileCSV() throws IOException {
        List<Object[]> list= new ArrayList<>();

        BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));//с помощью BufferedReader вычитываем данные в list из файла лежащего в: src/test/resources/data.csv
        String line = reader.readLine();//вычитываем из файла строку (линию)
        while (line!=null) {
            String[] split = line.split(";");//разбиваем по ";"
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});//строим нового юзера и добавляем его с его Email и Password
            line= reader.readLine();//если line!=null, то читаем следующую линию

        }
        return list.iterator();
    }

    @DataProvider//должна быть такая анотация
    public Iterator <Object[]> dataContactCSV() throws IOException {

        List<Object[]> list= new ArrayList<>();

        BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();//вычитываем из файла строку (линию)
        while (line!=null) {
            String[] split = line.split(",");//разбиваем по ","

            list.add(new Object[]{Contact.builder().name(split[0]).lastname(split[1])
                    .phone(split[2]).email(split[3]).address(split[4]).description(split[5]).build()});//строим нового юзера и добавляем его с его Email и Password
            line= reader.readLine();//если line!=null, то читаем следующую линию

        }
        return list.iterator();
    }
}
