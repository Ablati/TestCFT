/**
 * Created by serik on 17.02.2019.
 */
public class Service {
    private byte kiver , srtmd , quafile ;
    private String[] dat;
    private String path;

    public Service(String[] dat){

        this.dat = new String[dat.length];

        for (int i = 0; i < dat.length; i++) {
            this.dat[i] = dat[i];
        }


        if (dat[0].equals("-i")){
            this.kiver = 0;  // целлые числа


        }else if (dat[0].equals("-s")){
            this.kiver = 1; // строки
        }else{
            System.out.println("Неверно введен аргумент типа содержимого");
        }


        // quafile проверка отсутствия в аргуметах режима сортировки
        // srtmd режим сортировки
        if (dat[1].equals("-a")){
            this.quafile = 1;
            this.srtmd = 0;  // сортировка по возрастанию

        }else if (dat[1].equals("-d")) {
            this.quafile = 1;  // сортирировка по убыванию
            this.srtmd = 1;
        }else{
            this.quafile = 0;
            this.srtmd = 0;  // сортировка по возрастанию
            System.out.println("Не введен аргумент сортировки, производиться сортировка по возрастанию");
        }
        this.path = dat[dat.length-1];
        System.out.println(this.path);

    }

    public String getPath(){return this.path;}

    public byte getKiver() {
        return this.kiver;
    }

    public byte getSrtmd() {
        return this.srtmd;
    }

    public  byte getQuafile() {
        return this.quafile;
    }

    public  String[] getDat() {
        return this.dat;
    }
}
