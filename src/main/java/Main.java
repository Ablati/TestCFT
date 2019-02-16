import FileWorker.FileReader;
import FileWorker.Reader;

import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;

/**
 * Created by serik on 14.02.2019.
 */
public class Main {
    private static byte kiver , srtmd , quafile ;
    private static String[] dat;

    public static void main(String[] args){


        dat = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            dat[i]=args[i];
        }


        if (dat[0].equals("-i")){
            kiver = 0;


        }else if (dat[0].equals("-s")){
            kiver = 1;
        }else{
            System.out.println("Неверно введен аргумент типа содержимого");
        }


        if (dat[1].equals("-a")){
            quafile = 1;
            srtmd = 0;


        }else if (dat[0].equals("-d")) {
            quafile = 1;
            srtmd = 1;
        }else{
            quafile = 0;
            srtmd = 0;
        }

        for (int s = 0; s < dat.length; s++){
            System.out.println("Main" + dat[s]);
        }


        System.out.println("Main " + kiver);
        System.out.println("Main " + quafile);
        System.out.println("Main " + srtmd);

        Reader  fileReader = new FileReader();
        fileReader.readeFiles(dat, quafile);
        ArrayList<ArrayList<String>> lists = fileReader.getData();

        for (int a = 0; a < lists.size(); a++ ){
            for (int i = 0; i <lists.get(a).size(); i++ ){
                System.out.println("Main " + lists.get(a).get(i));
            }
        }


    }

}
