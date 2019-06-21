package design3;

public class IteratorSample1 {
	public static void main(String[] args) {
		BookListAggregate bookListAggregate = new BookListAggregate();
		Iterator iterator = bookListAggregate.createIterator();
		bookListAggregate.add(new Book("羅生門", "芥川龍之介"));
		bookListAggregate.add(new Book("少年の日の思い出", "ヘルマン・ヘッセ"));
		bookListAggregate.add(new Book("モチモチの木", "斎藤隆介"));
		bookListAggregate.add(new Book("走れメロス", "太宰治"));
		iterator.first();
		while ( ! iterator.isDone() ) {
			Book book = (Book)iterator.getItem();
			System.out.println(book.getName());
			iterator.next();
		}
	}
}

	class Book {
		private String name; // 名称
		private String author; // 著者

		public Book(String name, String author) { // コンストラクタ
			this.name= name;
			this.author = author;
		}

		public String getName() { // 名称を取得
			return name;
		}

		public String getAuthor() { // 著者を取得
			return author;
		}
	}

	interface Iterator {
		public void first(); // 取り出し位置を最初の要素へ変える
		public void next(); // 取り出し位置を次の要素へ変える
		public boolean isDone(); // 取り出し位置が最後を超えたか？
		public Object getItem(); // 現在の取り出し位置から取り出す
	}

	class BookListIterator implements Iterator {
		private BookListAggregate aggregate;
		private int current;
		public BookListIterator(BookListAggregate aggregate) {
			this.aggregate = aggregate;
		}

		@Override
		public void first() {
			current = 0;
		}

		@Override
		public void next() {
			current += 1;
		}

		@Override
		public boolean isDone() {
			if (current >= aggregate.getNumberOfStock()) {
				return true;
			}else {
				return false;
			}
		}

		@Override
		public Object getItem() {
			return aggregate.getAt(current);
		}
	}

	interface Aggregate {
		public Iterator createIterator();
	}

	class BookListAggregate implements Aggregate {
		private Book[] list = new Book[20];
		private int numberOfStock;

		@Override
		public Iterator createIterator() {
			return new BookListIterator(this);
		}

		public void add(Book book) {
			list[numberOfStock] = book;
			numberOfStock += 1;
		}

		public Object getAt(int number) {
			return list[number];
		}

		public int getNumberOfStock() {
			return numberOfStock;
		}
	}