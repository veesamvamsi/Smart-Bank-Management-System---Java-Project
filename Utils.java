import java.util.UUID;


public class Utils {
public static String generateId(String prefix) {
return prefix + "-" + UUID.randomUUID().toString().split("-")[0];
}
}
