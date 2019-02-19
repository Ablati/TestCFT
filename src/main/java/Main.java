import FileWorker.FileReader;
import FileWorker.FileWrite;
import FileWorker.Reader;
import FileWorker.Writer;
import Sorting.InserionSortInteger;
import Sorting.InsertionSortString;
import Sorting.MergeSortInteger;
import Sorting.MergeSortString;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * Created by serik on 14.02.2019.
 */
public class Main {

    public static void main(String[] args){
        Service service =  new Service(args);
        Reader  fileReader = new FileReader();
        ArrayList<ArrayList<String>> listInData = fileReader.read(args, service.getQuafile());
        CheckInputData checkInputData = new CheckInputData(listInData, service.getSrtmd(),service.getKiver());
        ArrayList<Integer> notSortInputFiles = checkInputData.getNotSortInputFiles();

        if(checkInputData.getOtherSort() == 1) {
            if (checkInputData.getKiver() == 0) {
                InserionSortInteger inserionSortInteger = new InserionSortInteger();
                inserionSortInteger.sort(listInData, service.getSrtmd(), notSortInputFiles);
                listInData = inserionSortInteger.getListInData();
            } else {
                InsertionSortString insertionSortString = new InsertionSortString();
                insertionSortString.sort(listInData, service.getSrtmd(), notSortInputFiles);
                listInData = insertionSortString.getListInData();
            }

        }
        ArrayList<String> outList = new ArrayList<String>();
        if (checkInputData.getKiver() == 0) {
            MergeSortInteger mergeSortInteger = new MergeSortInteger();
            outList = mergeSortInteger.sort(listInData, service.getSrtmd(), notSortInputFiles);
        } else {
            MergeSortString mergeSortString = new MergeSortString();
            outList = mergeSortString.sort(listInData, service.getSrtmd(), notSortInputFiles);
        }
        Writer fileWrite = new FileWrite();
        fileWrite.write(outList, service.getPath());


    }



}
