package hero;

public class UnequipItemFailedException extends Exception {
		protected String message;
		public UnequipItemFailedException(String message){
			this.message = message;
			System.out.println(this.message);
		}
	// you CAN add SerialVersionID if eclipse gives you warning
}
