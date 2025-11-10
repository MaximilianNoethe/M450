public class PreisberechnungTest {

    static Preisberechnung calculator = new Preisberechnung();

    public static boolean test_calculate_price() {
        boolean test_ok = true;
        System.out.println("--- Starte Testtreiber für Preisberechnung ---");

        // Testfall 1: Weniger als 3 Extras (0% Zubehörrabatt)
        test_ok &= runTest(
            10000.0, 500.0, 2000.0, 2, 5.0, // Eingaben
            12000.0,                       // Erwarteter Wert
            "Kein Zubehörrabatt (2 Extras)"
        );

        // Testfall 2: Genau 3 Extras (10% Zubehörrabatt)
        test_ok &= runTest(
            10000.0, 500.0, 2000.0, 3, 5.0, // Eingaben
            11800.0,                       // Erwarteter Wert
            "10% Zubehörrabatt (3 Extras)"
        );

        // Testfall 3: Genau 5 Extras (15% Zubehörrabatt)
        // Dieser Test wird mit dem FEHLERHAFTEN Code fehlschlagen!
        test_ok &= runTest(
            10000.0, 500.0, 2000.0, 5, 5.0, // Eingaben
            11700.0,                       // Erwarteter Wert
            "15% Zubehörrabatt (5 Extras)"
        );
        
        System.out.println("----------------------------------------------");
        if (test_ok) {
            System.out.println("✅ Testergebnis: Alle Tests bestanden (Basierend auf der aktuellen Implementierung).");
        } else {
            System.out.println("❌ Testergebnis: Mindestens ein Testfall ist FEHLGESCHLAGEN.");
        }
        return test_ok;
    }

    private static boolean runTest(double bp, double sp, double ep, int e, double d, double expected, String description) {
        double actual = calculator.calculatePrice(bp, sp, ep, e, d);
        
        if (actual == expected) {
            System.out.printf("PASS: %s | Erwartet: %.2f | Tatsächlich: %.2f%n", description, expected, actual);
            return true;
        } else {
            System.out.printf("FAIL: %s | Erwartet: %.2f | Tatsächlich: %.2f | ABWEICHUNG!%n", description, expected, actual);
            return false;
        }
    }
    
    // Hauptmethode zum Ausführen des Testtreibers
    public static void main(String[] args) {
        test_calculate_price();
    }
}
