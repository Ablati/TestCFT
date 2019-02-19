package Sorting;

import java.util.ArrayList;

/**
 * Created by serik on 18.02.2019.
 */
public class InsertionSortString implements Sorter {

    private ArrayList<ArrayList<String>> listInData = new ArrayList<ArrayList<String>>();
    private ArrayList<String> listInsertion = new ArrayList<String>();


    public ArrayList<String> sort(ArrayList<ArrayList<String>> listInData, byte srtmd, ArrayList<Integer> notSortInputFiles) {

        this.listInData = listInData;
        int i, j, k;
        String buf;
        if (srtmd == 0) {
            for (i = 0; i < notSortInputFiles.size(); i++) {
                this.listInsertion = listInData.get(notSortInputFiles.get(i));


                for (j = 0; j < this.listInsertion.size(); j++) {
                    buf = this.listInsertion.get(j);
                    for (k = j - 1; (k >= 0) && (buf.compareTo(this.listInsertion.get(k))) < 0; k--) {
                        this.listInsertion.set(k + 1, this.listInsertion.get(k));
                    }
                    this.listInsertion.set(k + 1, buf);
                }
                this.listInData.set(notSortInputFiles.get(i),listInsertion);

            }


        } else if (srtmd == 1) {
            for (i = 0; i < notSortInputFiles.size(); i++) {
                this.listInsertion = listInData.get(notSortInputFiles.get(i));
                for (j = this.listInsertion.size() - 1; j >= 0; j--) {
                    buf = this.listInsertion.get(j);
                    for (k = j + 1; (k <= this.listInsertion.size() - 1) && (buf.compareTo(this.listInsertion.get(k))) <= 0; k++) {
                        this.listInsertion.set(k - 1, this.listInsertion.get(k));

                    }
                    this.listInsertion.set(k - 1, buf);

                }
                this.listInData.set(notSortInputFiles.get(i),listInsertion);

            }

        }


        return null;
    }

    public ArrayList<ArrayList<String>> getListInData() {
        return this.listInData;
    }
}


