package converter;

import java.math.BigDecimal;

public class Farengaite implements Converter {

    @Override
    public BigDecimal convert(double calvins) {
        BigDecimal farengaite = new BigDecimal((calvins - 273.15) * 9 / 5 + 32);
        farengaite = farengaite.setScale(2, BigDecimal.ROUND_CEILING);
        return farengaite;
    }
}
