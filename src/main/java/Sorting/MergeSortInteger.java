package Sorting;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

/**
 * Created by serik on 15.02.2019.
 */
public class MergeSortInteger implements Sorter{
    private ArrayList<ArrayList<Integer>>listsOfInt = new ArrayList<ArrayList<Integer>>();
    private ArrayList<String> listOutDataString = new ArrayList<String>();
    private ArrayList<Integer> listOutData = new ArrayList<Integer>();

    public ArrayList<String> sort(ArrayList<ArrayList<String>> listInData, byte srtmd, ArrayList<Integer> notSortInputFiles) {

        this.listsOfInt = converterToInteger(listInData);
        if (srtmd == 0){
            if (listInData.size()< 2){
                this.listOutDataString = listInData.get(0);
            }else {
                int k = 2;
                int a = 0, b = 0;
                for (int i = 0;  i < listsOfInt.size(); i = i+1+k){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    if (k == 2){
                        for (int j  = 0; j < ((listsOfInt.get(i).size()+listsOfInt.get(i+1).size())); j++){
                            if (a > (listsOfInt.get(i).size()-1)){
                                list.add(listsOfInt.get(i+1).get(b));
                                b++;
                            }else if(b > (listsOfInt.get(i+1).size()-1)){
                                list.add(listsOfInt.get(i).get(a));
                                a++;
                            }else if(listsOfInt.get(i).get(a) < listsOfInt.get(i+1).get(b)){
                                list.add(listsOfInt.get(i).get(a));
                                a++;

                            }else{
                                list.add(listsOfInt.get(i+1).get(b));
                                b++;
                            }
                        }
                        k = 1;
                        a = 0;
                        b = 0;
                        for (int v = 0; v < list.size();  v ++){
                            this.listOutData.add( list.get(v));

                        }
                        list.clear();

                    }else {
                        for (int j = 0; j < (this.listOutData.size() + listInData.get(i).size()); j++){
                            if (a > (this.listOutData.size()-1)){
                                list.add(listsOfInt.get(i).get(b));
                                b++;
                            }else if(b > (listInData.get(i).size()-1)){
                                list.add(this.listOutData.get(a));
                                a++;
                            }else if(this.listOutData.get(a) < listsOfInt.get(i).get(b)){
                                list.add(this.listOutData.get(a));
                                a++;

                            }else{
                                list.add(listsOfInt.get(i).get(b));
                                b++;
                            }
                        }
                        this.listOutData.clear();
                        for (int v = 0; v < list.size();  v ++){
                            this.listOutData.add(list.get(v));
                        }
                        list.clear();
                        a = 0;
                        b = 0;
                        k = 0;


                    }

                }
            }

        }else {
            if (listInData.size()< 2){
                this.listOutData = listsOfInt.get(0);
            }else {
                int k = 2;
                int a = 0, b = 0;
                for (int i = 0;  i < listsOfInt.size(); i = i+1+k){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    if (k == 2){
                        for (int j  = 0; j < ((listsOfInt.get(i).size()+listsOfInt.get(i+1).size())); j++){
                            if (a > (listsOfInt.get(i).size()-1)){
                                list.add(listsOfInt.get(i+1).get(b));
                                b++;
                            }else if(b > (listsOfInt.get(i+1).size()-1)){
                                list.add(listsOfInt.get(i).get(a));
                                a++;
                            }else if(listsOfInt.get(i).get(a) > listsOfInt.get(i+1).get(b)){
                                list.add(listsOfInt.get(i).get(a));
                                a++;

                            }else{
                                list.add(listsOfInt.get(i+1).get(b));
                                b++;
                            }
                        }
                        k = 1;
                        a = 0;
                        b = 0;
                        for (int v = 0; v < list.size();  v ++){
                            this.listOutData.add(list.get(v));
                        }
                        list.clear();
                    }else {
                        for (int j = 0; j < (this.listOutData.size() + listInData.get(i).size()); j++){
                            if (a > (this.listOutData.size()-1)){
                                list.add(listsOfInt.get(i).get(b));
                                b++;
                            }else if(b > (listsOfInt.get(i).size()-1)){
                                list.add(this.listOutData.get(a));
                                a++;
                            }else if(this.listOutData.get(a) > listsOfInt.get(i).get(b)){
                                list.add(this.listOutData.get(a));
                                a++;

                            }else{
                                list.add(listsOfInt.get(i).get(b));
                                b++;
                            }


                        }
                        this.listOutData.clear();
                        for (int v = 0; v < list.size();  v ++){
                            this.listOutData.add(list.get(v));
                        }
                        list.clear();
                        a = 0;
                        b = 0;
                        k = 0;


                    }

                }
            }


        }
        listOutDataString = converterToString(listOutData);
        return listOutDataString;
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

    private ArrayList<String> converterToString (ArrayList<Integer> listInData) {
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < listInData.size(); i++){
            list.add(valueOf(listInData.get(i)));
        }

        return list;
    }
}
