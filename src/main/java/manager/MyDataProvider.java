package manager;

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
}
