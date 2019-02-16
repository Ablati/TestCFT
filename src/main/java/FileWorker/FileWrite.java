package FileWorker;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by serik on 16.02.2019.
 */
public class FileWrite implements Writer {

    public void writeFiles(String[] dat) {
        try {
            //Определяем файл
            File file = new File(dat[1]);
            //проверяем, что если файл не существует то создаем его
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст у файл
                for(int w = 0; w <length; w++){

                    if(w <= m.length-1){
                        out.print(m[w]);
                        out.append("\r\n");
                    }
                    else{
                        out.print(m[w]);
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
