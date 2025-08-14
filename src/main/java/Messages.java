import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Messages {
  private static final Map<String, String> MESSAGES = loadMessages();

  private static Map<String, String> loadMessages() {
    InputStream stream = Messages.class.getResourceAsStream("/messages.json");
    if (stream == null) {
      throw new RuntimeException("messages.json not found.");
    }

    try (InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
      Type type = new TypeToken<Map<String, String>>() {}.getType();
      return new Gson().fromJson(reader, type);
    } catch (IOException e) {
      throw new RuntimeException("I/O error while reading messages.json", e);
    }
  }

  public static String getMessage(String key) {
    return MESSAGES.getOrDefault(key, "Message not found.");
  }
}
