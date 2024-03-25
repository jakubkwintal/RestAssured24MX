package restassured24mx;

import java.util.LinkedHashMap;
import java.util.Map;

public class Utils {

    static String[] endpointsCode200 = { "orders", "products", "stores", "promotions",
            "giftcards", "piercelocalizations", "baskets", "wishlists", "suggest" };

    static String[] brandsA_canonicalNames = { "A9 Racing Oils", "ABUS", "AFAM", "AGV", "AIR Racing",
            "AMSOIL", "APE", "ARC", "AXO", "Acerbis", "Adventure Menu", "AirMousse", "Airhawk", "Airoh",
            "Akrapovic", "Alias", "All Balls", "Alpina", "Alpine", "Alpinestars", "Altimate", "Amped",
            "Anno32", "Answer Racing", "Aquajam", "Arctic Cat", "Ariete", "Arlen Ness", "Armor All",
            "Arrow", "Artago", "Arva Equipment", "Asterisk", "Astone Helmets", "Athena", "Atlas", "Avid Products",
            "Axio" };

    static Map<Integer, String> suzuki2023Models() {
        Map<Integer, String> suzuki2023ModelsMap = new LinkedHashMap<>();
        suzuki2023ModelsMap.put(243755, "Suzuki DR-Z 125 2023");
        suzuki2023ModelsMap.put(243803, "Suzuki DR-Z 50 2023");
        suzuki2023ModelsMap.put(243753, "Suzuki RM 85 2023");
        suzuki2023ModelsMap.put(73103, "Suzuki RM-Z 250 2023");
        suzuki2023ModelsMap.put(73102, "Suzuki RM-Z 450 2023");

        return suzuki2023ModelsMap;
    }
}
