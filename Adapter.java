package design7;

public class Adapter { //client
	public static void main(String[] args) {
		Dengen p = new AcAdapter(100);
		p.printDenatsu();  //電力を表示する
	}
}

interface Dengen { //Target
	public abstract void printDenatsu();  //電力を表示
}

class JapaneseConsent { //Adaptee
	private int denatsu;
	public JapaneseConsent(int denatsu) {
		this.denatsu = denatsu;
	}
	public int Kyuuden() {
		return (int) (this.denatsu * 0.16);
	}
}

class AcAdapter extends JapaneseConsent implements Dengen { //Adapter
	public AcAdapter(int denatsu) {
		super(denatsu);
	}
	public void printDenatsu() {
		System.out.println(this.Kyuuden() + "V で給電されています");
	}
}