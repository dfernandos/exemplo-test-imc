import com.mapeando.CalculoIMC;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculoIMCTest {

    @Test
    void testCalcularIMC_PesoSaudavel() {
        double peso = 70.0;
        double altura = 1.75;
        String resultadoEsperado = "Peso saudável";
        String resultado = CalculoIMC.calcularIMC(peso, altura);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void testCalcularIMC_MagrezaGrave() {
        double peso = 40.0;
        double altura = 1.80;
        String resultadoEsperado = "Magreza grave";
        String resultado = CalculoIMC.calcularIMC(peso, altura);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void testCalcularIMC_AlturaInvalida() {
        double peso = 70.0;
        double altura = 0.0; // Altura inválida
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculoIMC.calcularIMC(peso, altura);
        });

        String mensagemEsperada = "A altura deve ser maior que zero.";
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @Test
    void testCalcularIMC_Sobrepeso() {
        double peso = 80.0;
        double altura = 1.75;
        String resultadoEsperado = "Sobrepeso";
        String resultado = CalculoIMC.calcularIMC(peso, altura);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void testCalcularIMC_ObesidadeGrauIII() {
        double peso = 120.0;
        double altura = 1.60;
        String resultadoEsperado = "Obesidade grau III";
        String resultado = CalculoIMC.calcularIMC(peso, altura);

        assertEquals(resultadoEsperado, resultado);
    }
}

