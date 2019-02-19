import javax.swing.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * Created by serik on 15.02.2019.
 */
public class CheckInputData {

    private ArrayList<Integer> notSortInputFiles = new ArrayList<Integer>();
    private ArrayList<ArrayList<String>> listInData;
    private byte srtmd;
    private  byte kiver;
    private int k = -1;
    private byte otherSort;
    private boolean q = false;

    public CheckInputData(ArrayList<ArrayList<String>> listInData, byte srtmd, byte kiver) {

        this.listInData = listInData;
        this.kiver = kiver;
        this.srtmd = srtmd;
        this.kiver = checkData( this.listInData, this.srtmd , this.kiver );

    }


    public byte checkData(ArrayList<ArrayList<String>> listInData, byte srtmd, byte kiver){
        for (int i = 0; i < listInData.size(); i++) {
            for (int j = 0; j < listInData.get(i).size() - 1; j++) {

                if (kiver == 0) {
                    try {
                        if (srtmd == 0 && parseInt(listInData.get(i).get(j)) > parseInt(listInData.get(i).get(j + 1))) {
                            if (this.k != i) {
                                this.k = i;
                                this.notSortInputFiles.add(this.k);
                                pickSort();

                            }
                        } else if (srtmd == 1 && parseInt(listInData.get(i).get(j))< parseInt(listInData.get(i).get(j + 1))) {
                            if (this.k != i) {
                                this.k = i;
                                this.notSortInputFiles.add(this.k);
                                pickSort();
                            }

                        }

                    } catch (Exception e) {
                        int select = JOptionPane.showConfirmDialog(null, "Продолжить сортировать виде строки? ", "Тип входных данных не соответствует аргументу", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (select == JOptionPane.YES_OPTION) {
                            this.kiver = 1;
                            return checkData(this.listInData,  this.srtmd, this.kiver);

                        } else {
                            System.exit(0);
                        }

                    }

                } else {
                    if (srtmd == 0 && listInData.get(i).get(j).compareTo(listInData.get(i).get(j + 1)) > 0) {
                        if (this.k != i) {
                            this.k = i;
                            this.notSortInputFiles.add(this.k);
                            pickSort();
                        }


                    } else if (srtmd == 1 && listInData.get(i).get(j).compareTo(listInData.get(i).get(j + 1)) < 0) {
                        if (this.k != i) {
                            this.k = i;
                            this.notSortInputFiles.add(this.k);
                            pickSort();
                        }

                    }
                }

            }
        }
        return this.kiver;
    }


    public void pickSort (){
        if (q == false){
            int select = JOptionPane.showConfirmDialog(null, "Подготовить данные для сортировки слиянием?", "Входные данные в файлах предварительно не отсортированы!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (select == JOptionPane.YES_OPTION) {
                this.otherSort = 1;

            } else {
                this.otherSort = 0;
            }
            q =true;
        }

    }

    public byte getOtherSort() {
        return this.otherSort;
    }

    public byte getKiver(){return this.kiver;}


    public ArrayList<Integer> getNotSortInputFiles() {
        return this.notSortInputFiles;
    }
}
