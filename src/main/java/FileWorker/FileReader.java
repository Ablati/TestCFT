package FileWorker;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by serik on 15.02.2019.
 */
public class FileReader implements Reader {

    private ArrayList<ArrayList<String>> listInData = new ArrayList<ArrayList<String>>();

    public void readeFiles(String [] dat, byte quafile) {


            try {
                for (int i = 1 + quafile; i < dat.length-1; i++) {

                    this.listInData.add(new ArrayList<String>());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dat[i])));
                    String line = reader.readLine();
                    System.out.println("file reader" + line);
                    while (line != null){
                        int a = 0;
                        this.listInData.get(a).add(line);
                        line = reader.readLine();
                        a++;
                        System.out.println("file reader" + line);
                        System.out.println("file reader" + a);
                    }
                }
            }
            catch (Exception e) {
                int select = JOptionPane.showConfirmDialog(null,"xxxx?","File not found!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                if(select == JOptionPane.YES_OPTION){


                }else{
                    System.exit(0);
                }
            }


    }

    public ArrayList<ArrayList<String>> getData() {
        return this.listInData;
    }
}
