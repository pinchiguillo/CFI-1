package org.example.sistemaAlerta;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SistemaAlertaModelTest {

    @Test
    public void testDefaultThresholds() {
        SistemaAlertaModel model = new SistemaAlertaModel();
        assertEquals(100.0, model.getUmbralRadiacion(), 0.0001);
        assertEquals(-20.0, model.getUmbralTemperaturaMin(), 0.0001);
        assertEquals(50.0, model.getUmbralTemperaturaMax(), 0.0001);
        assertEquals(90.0, model.getUmbralPresionMin(), 0.0001);
        assertEquals(110.0, model.getUmbralPresionMax(), 0.0001);
    }
}
