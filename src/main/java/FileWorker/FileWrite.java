package FileWorker;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by serik on 16.02.2019.
 */
public class FileWrite implements Writer {



    public void write(ArrayList<String> outList, String path) {
        try {
            //Определяем файл
            File file = new File(path);
            //проверяем, что если файл не существует то создаем его
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст у файл
                for(int i = 0; i < outList.size(); i++){

                    if(i <= outList.size()-1){
                        out.print(outList.get(i));
                        out.append("\r\n");
                    }
                    else{
                        out.print(outList.get(i));
                    }
                }

            }
            finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }

    }
}