package design5;

public class FactoryMethod {
	public static void main(String[] args) {
		Koujyou koujyou1 = new TvKoujyou();
		Koujyou koujyou2 = new RadioKoujyou();

		Seihin[] array = new Seihin[3];
		array[0] = koujyou1.create();
		array[1] = koujyou2.create();
		array[2] = koujyou1.create();

		for (int i = 0; i < array.length; ++i) {
			array[i].print();
		}
	}
}

abstract class Koujyou {    //製作者についてを抽象化した抽象クラス
	public final Seihin create() {
		Seihin seihin = factoryMethod(); touroku(seihin);
		return seihin;
	}

	public abstract Seihin factoryMethod();
	public abstract void touroku(Seihin s);
}

class TvKoujyou extends Koujyou {   //具体的な製作者を表すクラス
	public Seihin factoryMethod() {
		return new Television();
	}

	public void touroku(Seihin s) {
		Television t = (Television) s;
		t.numberring();
		t.setDate(Date.today());
	}
}

class RadioKoujyou extends Koujyou {
	public Seihin factoryMethod() {
		return new Radio();
	}

	public void touroku(Seihin s) {
		Radio r = (Radio) s;
		r.numberring();
	}
}

abstract class Seihin {    //製品を表す抽象クラス
	public abstract void print();
}

class Television extends Seihin {    //具体的な製品を表すクラス
	private int tvSerialNumber;
	private String date;

	public void numberring() {
		tvSerialNumber = Counter.getTvNumber();
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void print() {
		System.out.println("このテレビに関する情報:");
		System.out.println(" 製造番号:" + tvSerialNumber);
		System.out.println(" 製造年月日:" + date);
	}
}

class Radio extends Seihin {
	private int radioSerialNumber;

	public void numberring() {
		radioSerialNumber = Counter.getRadioNumber();
	}

	public void print() {
		System.out.println("このラジオに関する情報:");
		System.out.println(" 製造番号:" + radioSerialNumber);
	}
}

class Date {   //その他のクラス
	public static String today() {
		return "2004/01/20";
	}
}

class Counter {
	private static int tvNum = 100;
	private static int radioNum = 76;

	public static int getTvNumber() {
		return tvNum++;
	}

	public static int getRadioNumber() {
		return radioNum++;
	}
}