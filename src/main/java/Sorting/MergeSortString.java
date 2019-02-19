package Sorting;

import java.util.ArrayList;

/**
 * Created by serik on 15.02.2019.
 */
public class MergeSortString implements Sorter {

    private ArrayList<String> listOutData = new ArrayList<String>();


    public ArrayList<String> sort(ArrayList<ArrayList<String>> listInData, byte srtmd, ArrayList<Integer> notSortInputFiles) {

        if (srtmd == 0){
            if (listInData.size()< 2){
                this.listOutData = listInData.get(0);
            }else {
                int k = 2;
                int a = 0, b = 0;
                for (int i = 0;  i < listInData.size(); i = i+1+k){
                    ArrayList<String> list = new ArrayList<String>();
                    if (k == 2){
                        for (int j  = 0; j < ((listInData.get(i).size()+listInData.get(i+1).size())); j++){
                            if (a > (listInData.get(i).size()-1)){
                                list.add(listInData.get(i+1).get(b));
                                b++;
                            }else if(b > (listInData.get(i+1).size()-1)){
                                list.add(listInData.get(i).get(a));
                                a++;
                            }else if(listInData.get(i).get(a).compareTo(listInData.get(i+1).get(b)) < 0 ){
                                list.add(listInData.get(i).get(a));
                                a++;

                            }else{
                                list.add(listInData.get(i+1).get(b));
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
                                list.add(listInData.get(i).get(b));
                                b++;
                            }else if(b > (listInData.get(i).size()-1)){
                                list.add(this.listOutData.get(a));
                                a++;
                            }else if(this.listOutData.get(a).compareTo(listInData.get(i).get(b)) < 0 ){
                                list.add(this.listOutData.get(a));
                                a++;

                            }else{
                                list.add(listInData.get(i).get(b));
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
                this.listOutData = listInData.get(0);
            }else {
                int k = 2;
                int a = 0, b = 0;
                for (int i = 0;  i < listInData.size(); i = i+1+k){
                    ArrayList<String> list = new ArrayList<String>();
                    if (k == 2){
                        for (int j  = 0; j < ((listInData.get(i).size()+listInData.get(i+1).size())); j++){
                            if (a > (listInData.get(i).size()-1)){
                                list.add(listInData.get(i+1).get(b));
                                b++;
                            }else if(b > (listInData.get(i+1).size()-1)){
                                list.add(listInData.get(i).get(a));
                                a++;
                            }else if(listInData.get(i).get(a).compareTo(listInData.get(i+1).get(b)) > 0 ){
                                list.add(listInData.get(i).get(a));
                                a++;

                            }else{
                                list.add(listInData.get(i+1).get(b));
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
                                list.add(listInData.get(i).get(b));
                                b++;
                            }else if(b > (listInData.get(i).size()-1)){
                                list.add(this.listOutData.get(a));
                                a++;
                            }else if(this.listOutData.get(a).compareTo(listInData.get(i).get(b)) > 0 ){
                                list.add(this.listOutData.get(a));
                                a++;

                            }else{
                                list.add(listInData.get(i).get(b));
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



        return this.listOutData;
    }

}
