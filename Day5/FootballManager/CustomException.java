package FootballManager;

public class CustomException extends RuntimeException {

  public CustomException() {
    super();
  }

  public CustomException(String message) {
    super(message);
  }

  public CustomException(String... args) {
    super(String.format("Invalid %s with value %s", args));
  }
}