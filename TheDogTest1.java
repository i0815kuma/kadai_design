package design04;

public class TheDogTest1 {

	public static void main(String[] args) {
		Dog pochi = new Dog();

		pochi.print();

		pochi.roudou();
		pochi.print();

		pochi.roudou();
		pochi.print();

		pochi.roudou();
		pochi.print();

		pochi.shokuji();
		pochi.print();

		pochi.shokuji();
		pochi.print();
	}
}

	class Dog {
		private DogState myState;

		public Dog() {
			myState = TanoshiiState.getInstance();
		}

		public void roudou() {
			myState.tukareta(this);
		}

		public void shokuji() {
			myState.tabeta(this);
		}

		public void changeState(DogState d) {
			myState = d;
		}

		public void print(){
			System.out.print("現在、わたしは「");
			System.out.print( myState.toString() );
			System.out.println("」です。");
		}
	}

	abstract class DogState {
		public abstract void tukareta(Dog yobidashimoto);
		public abstract void tabeta(Dog yobidashimoto);
	}

	class TanoshiiState extends DogState {
		private static TanoshiiState s = new TanoshiiState();
		private TanoshiiState() {}

		public static DogState getInstance(){
			return s;
		}

		public void tukareta(Dog moto){
			moto.changeState(FutsuuState.getInstance());
		}

		public void tabeta(Dog moto) { }

		public String toString() {
			return "楽しい状態";
		}
	}

	class FutsuuState extends DogState {
		private static FutsuuState s = new FutsuuState();
		private FutsuuState() {}

		public static DogState getInstance() {
			return s;
		}

		public void tukareta(Dog moto) {
			moto.changeState(IrairaState.getInstance());
		}

		public void tabeta(Dog moto) {
			moto.changeState(TanoshiiState.getInstance());
		}

 		public String toString() {
			return "普通状態";
		}
	}

	class IrairaState extends DogState {
		private static IrairaState s = new IrairaState();
		private IrairaState() {}

		public static DogState getInstance() {
			return s;
		}

		public void tukareta(Dog moto) {
			moto.changeState(ByoukiState.getInstance());
		}

		public void tabeta(Dog moto) {
			moto.changeState(TanoshiiState.getInstance());
		}

		public String toString() {
			return "いらいら状態";
		}
	}

	class ByoukiState extends DogState {
		private static ByoukiState s = new ByoukiState();
		private ByoukiState() {}

		public static DogState getInstance() {
			return s;
		}

		public void tukareta(Dog moto) { }

		public void tabeta(Dog moto) {
			moto.changeState(FutsuuState.getInstance());
		}

		public String toString() {
			return "病気状態";
		}
	}