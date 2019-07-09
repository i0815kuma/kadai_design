package design6;

import java.util.*;

public class kadai_observer {
    public static void main(String[] args) {
        Suuchi s = new Suuchi();
        Observer o1 = new NishinHyouji();
        Observer o2 = new JyuurokushinHyouji();

        s.attach(o1);
        s.attach(o2);
        s.detach(o2);
        int i = 0;
        while (i < 100) {
            s.putValue(i);
            i += (int)(Math.random() * 30) - 10;
        }
    }
}

abstract class Subject {
    public ArrayList<Observer> observers;

    Subject() {
        observers = new ArrayList<Observer>();
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void tsuuchi() {
        for (Observer observer: observers) {
            observer.update(this);
        }
    }
}

class Suuchi extends Subject {
    int suuchiState;
    int atai;

    public int getState() {
        return suuchiState;
    }

    public void putValue(int atai) {
        if (atai > this.atai) {
            this.atai = atai;
            this.tsuuchi();
        }
        else { // 本来ここから3行は不要となる行です。
             System.out.println("確認用メッセージ:更新してません");
        }
    }

    public int getValue() {
        return atai;
    }
}

interface Observer {
    public void update(Subject s);
}
class NishinHyouji implements Observer {
    public void update(Subject s) {
        print(((Suuchi)s).getValue());
    }

    private void print(int n) {
        System.out.println(n + "を 2 進数で表示します");
	final String a = Integer.toBinaryString(n);
	System.out.println(a);
    }
}
class JyuurokushinHyouji implements Observer {
    public void update(Subject s) {
        print(((Suuchi)s).getValue());
    }

    private void print(int n) {
        System.out.println(n + "を 16 進数で表示します");
	final String b = Integer.toHexString(n);
	System.out.println(b);
    }
}
