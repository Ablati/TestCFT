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
            //���������� ����
            File file = new File(path);
            //���������, ��� ���� ���� �� ���������� �� ������� ���
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter ��������� ����������� ������ � ����
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //���������� ����� � ����
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
                //����� ���� �� ������ ������� ����
                //����� ���� �� ���������
                out.close();
            }
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }

    }
}