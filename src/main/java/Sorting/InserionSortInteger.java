package Sorting;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

/**
 * Created by serik on 19.02.2019.
 */


public class InserionSortInteger implements Sorter{
    private ArrayList<ArrayList<String>> listInData = new ArrayList<ArrayList<String>>();
    private ArrayList<Integer> listInsertion = new ArrayList<Integer>();
    private ArrayList<ArrayList<Integer>>listsOfInt = new ArrayList<ArrayList<Integer>>();

    public ArrayList<String> sort(ArrayList<ArrayList<String>> listInData, byte srtmd, ArrayList<Integer> notSortInputFiles) {
        this.listsOfInt = converterToInteger(listInData);
        int i, j, k, buf;
        if (srtmd == 0){
            for (i = 0; i < notSortInputFiles.size(); i++) {
                this.listInsertion = listsOfInt.get(notSortInputFiles.get(i));
                for (j = 0; j < this.listInsertion.size(); j++) {
                    buf = this.listInsertion.get(j);
                    for (k = j - 1; (k >= 0) && (this.listInsertion.get(k) > buf); k--) {
                        this.listInsertion.set(k + 1, this.listInsertion.get(k));
                    }
                    this.listInsertion.set(k + 1, buf);

                }
                this.listsOfInt.set(notSortInputFiles.get(i), this.listInsertion);
            }

        }else if (srtmd == 1){
            for (i = 0; i < notSortInputFiles.size(); i++) {
                this.listInsertion = listsOfInt.get(notSortInputFiles.get(i));
                for (j = this.listInsertion.size()-1; j >=0; j--) {
                    buf = this.listInsertion.get(j);
                    for (k = j + 1;( k <= this.listInsertion.size()-1)&&( this.listInsertion.get(k) > buf); k++) {
                        this.listInsertion.set(k - 1, this.listInsertion.get(k));
                    }
                    this.listInsertion.set(k -1, buf);
                }
                this.listsOfInt.set(notSortInputFiles.get(i), this.listInsertion);
            }
        }


        this.listInData = converterToString(this.listsOfInt);


        return null;
    }

    private ArrayList<ArrayList<Integer>> converterToInteger (ArrayList<ArrayList<String>> listInData) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < listInData.size(); i++){
            list.add(new ArrayList<Integer>());
            for (int j = 0; j < listInData.get(i).size(); j++) {
               list.get(i).add(parseInt(listInData.get(i).get(j)));

            }


        }

        return list;
    }


    private ArrayList<ArrayList<String>> converterToString (ArrayList<ArrayList<Integer>> listInData) {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < listInData.size(); i++){
            list.add(new ArrayList<String>());
            for (int j = 0; j < listInData.get(i).size(); j++) {
               list.get(i).add(valueOf(listInData.get(i).get(j)));
            }
        }

        return list;
    }
    public ArrayList<ArrayList<String>> getListInData() {
        return this.listInData;
    }
}
