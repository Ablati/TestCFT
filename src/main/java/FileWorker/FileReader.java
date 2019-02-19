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
    private int fileNumb = 0;
    private int exeptionNumb = 0;
    private String[] dat;
    byte quafile;

    public ArrayList<ArrayList<String>> read(String [] dat, byte quafile) {

            this.dat = dat;
            this.quafile = quafile;

            try {
                for (int i = 1 + quafile + this.fileNumb + this.exeptionNumb; i < dat.length-1; i++) {
                    this.listInData.add(new ArrayList<String>());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dat[i])));
                    String line = reader.readLine();

                    while (line != null){
                        this.listInData.get(this.fileNumb).add(line);
                        line = reader.readLine();
                    }
                    this.fileNumb++;
                }

            }
            catch (Exception e) {
                String s = "File " + fileNumb + " not found!";
                int select = JOptionPane.showConfirmDialog(null,"Continue?", s ,JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                if(select == JOptionPane.YES_OPTION){
                    this.exeptionNumb++;
                    read(this.dat, this.quafile);
                }else{
                    System.exit(0);
                }
            }

        return this.listInData;
    }

    public ArrayList<ArrayList<String>> getData() {
        return this.listInData;
    }
}
