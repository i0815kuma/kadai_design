package design4;
import java.util.Scanner;
import java.util.ArrayList;

public class SingletonTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int j;
		int i;

		renban renban1 = renban.getInstance();
		renban renban2 = renban.getInstance();
		for(j=0;j<10000;) {
			System.out.println("製品名を入力してください");
		renban1.name();
		renban1.getNumber();
		renban1.add();
		renban2.print();
		}
	}

}
class  renban{
	private static renban num = new renban();
	private String name;
	private int i;
	private int j;
	private String code;
	private ArrayList<String> seihinName = new ArrayList<>();
	private ArrayList<String> seihinCode = new ArrayList<>();

	private renban() {
		this.j = 0;
	}
	public void name() {
		Scanner sc1 = new Scanner(System.in);
		this.name = sc1.nextLine();
		for(;this.name.length() == 0;) {
			System.out.println("エラー、もう一度入力してください");
			Scanner sc2 = new Scanner(System.in);
			this.name = sc2.nextLine();
		}
	}
	public static renban getInstance() {
		return num;
	}
	public String getNumber() {
		i += 1;
		this.code = String.format("%04d", i);
		return this.code;
	}
	public void add() {
		seihinName.add(name);
		seihinCode.add(code);
	}
	public void print() {
		for(i=0;i < seihinName.size();i++) {
			System.out.println("製品名:" + seihinName.get(i)+ "　製造番号:" + seihinCode.get(i));
		}
	}

}