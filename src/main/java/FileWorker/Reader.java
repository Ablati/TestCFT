package FileWorker;

import java.util.ArrayList;

/**
 * Created by serik on 16.02.2019.
 */
public interface Reader {
    void readeFiles (String [] dat, byte quafile);
    ArrayList<ArrayList<String>> getData();
}
