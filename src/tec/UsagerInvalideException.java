package tec;
public class UsagerInvalideException extends Exception {
  public final Usager quelUsager;
  public final Transport quelTransport;
  UsagerInvalideException(String message) {
    this(message, null, null);
  }
  UsagerInvalideException(String message, Usager u, Transport t) {
      super(message);
      quelTransport = t;
      quelUsager = u;
  }
}

